package interfaz;

import domain.Calle;
import domain.Esquina;
import domain.Mapa;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

public class MainInterfaz extends Application {
    public static final CountDownLatch latch = new CountDownLatch(1);
    public static MainInterfaz mainInterfaz = null;
    Runnable startSimulator;
    Mapa mapa;

    private BidiMap<String, Esquina> esquinas;
    private Pane esquinasContainer;
    private String idInicio = null;
    private String idFin = null;

    public static MainInterfaz waitForMainInterfaz() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mainInterfaz;
    }

    public static void setMainInterfaz(MainInterfaz mainInterfaz0) {
        mainInterfaz = mainInterfaz0;
        latch.countDown();
    }

    public MainInterfaz() {
        setMainInterfaz(this);
        inicializarEsquinas();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        PrintStream ps = new PrintStream(Config.console, true);
        System.setOut(ps);
        System.setErr(ps);

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        primaryStage.setTitle("Patrullero");
        Scene mainScene = new Scene(root, 805, 590);

        // Buscamos botón iniciar para arrancar la simulación
        Button btnIniciar = (Button)mainScene.lookup("#btnIniciar");
        btnIniciar.setOnAction((e) -> {
            Platform.runLater(() -> {
                        for (Node esq : esquinasContainer.getChildren()) {
                            repintarEsquina(esq);
                        }
                    });
            Thread thread = new Thread(startSimulator);
            thread.setDaemon(true);
            if (idInicio != null && idFin != null)
                thread.start();
        });

        esquinasContainer = (Pane)mainScene.lookup("#esquinas");
        Config.painter = new EsquinaPainter(esquinasContainer, esquinas);

        Button btnPosicionAgente = (Button)mainScene.lookup("#btnPosicionAgente");
        Text posicionAgente = (Text)mainScene.lookup("#posicionAgente");
        btnPosicionAgente.setOnAction((evt) -> {
            for (Node esq : esquinasContainer.getChildren()) {
                esq.setOnMouseClicked(event -> {
                    idInicio = esq.getId();
                    Esquina e = getEsquinaById(esq.getId());
                    mapa.setPosicionAgente(e);
                    posicionAgente.setText(e.toString());
                    for (Node e1 : esquinasContainer.getChildren()) {
                        repintarEsquina(e1);
                        e1.setOnMouseClicked(null);
                    }

                });
                ((Shape)esq).setFill(Color.RED);
            }
        });

        Button btnPosicionAlarma = (Button)mainScene.lookup("#btnPosicionAlarma");
        Text posicionAlarma = (Text)mainScene.lookup("#posicionAlarma");
        btnPosicionAlarma.setOnAction((evt) -> {
            for (Node esq : esquinasContainer.getChildren()) {
                esq.setOnMouseClicked(event -> {
                    idFin = esq.getId();
                    Esquina e = getEsquinaById(esq.getId());
                    mapa.setPosicionAlerta(e);
                    posicionAlarma.setText(e.toString());
                    for (Node e1 : esquinasContainer.getChildren()) {
                        repintarEsquina(e1);
                        e1.setOnMouseClicked(null);
                    }
                });
                ((Shape)esq).setFill(Color.RED);
            }
        });

        Button callesCortadas = (Button)mainScene.lookup("#callesCortadas");
        callesCortadas.setOnAction(evt -> {
            openPopupCalles(evt, true);
        });

        Button callesCongestionadas = (Button)mainScene.lookup("#callesCongestionadas");
        callesCongestionadas.setOnAction(evt -> {
            openPopupCalles(evt, false);
        });

        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void init(Runnable startSimulator, Mapa mapa) {
        this.startSimulator = startSimulator;
        this.mapa = mapa;
    }

    public void runRandom(){
        String[] claves = esquinas.keySet().toArray(new String[]{});
        String claveInicio = claves[ThreadLocalRandom.current().nextInt(claves.length)];
        String claveFin = claves[ThreadLocalRandom.current().nextInt(claves.length)];
        mapa.setPosicionAgente(esquinas.get(claveInicio));
        mapa.setPosicionAlerta(esquinas.get(claveFin));
        Thread thread = new Thread(startSimulator);
        thread.setDaemon(true);
        thread.start();
    }

    private Esquina getEsquinaById(String id) {
        Esquina e1 = new Esquina("General Paz", "Obispo Boneo");

        Esquina esquina = esquinas.getOrDefault(id, e1);
        return mapa.getEsquinaExistente(esquina);
    }

    private String getIdByEsquina(Esquina e) {
        return esquinas.getKey(e);
    }

    private void repintarEsquina(Node esquina) {
        if (esquina.getId().equals(idInicio))
            ((Shape) esquina).setFill(Color.YELLOWGREEN);
        else if (esquina.getId().equals(idFin))
            ((Shape) esquina).setFill(Color.PURPLE);
        else
            ((Shape) esquina).setFill(Color.DODGERBLUE);
        for (Calle calle : mapa.getCallesCortadas())
            mapa.getEsquinasDeCalle(calle).forEach(esquina1 -> Config.painter.pintarEsquina(esquina1, "cortada"));
        for (Calle calle : mapa.getCallesCongestionadas())
            mapa.getEsquinasDeCalle(calle).forEach(esquina1 -> Config.painter.pintarEsquina(esquina1, "congestionada"));
    }

    private void inicializarEsquinas(){
        esquinas = new DualHashBidiMap<>();
        esquinas.put("e512", new Esquina("Pasaje Arzamendia", "Lavaisse"));
        esquinas.put("e1", new Esquina("General Paz", "Obispo Boneo"));
        esquinas.put("e2", new Esquina("Tacuari", "Obispo Boneo"));
        esquinas.put("e3", new Esquina("Obispo Boneo", "Piedras"));
        esquinas.put("e4", new Esquina("A Godoy", "Obispo Boneo"));
        esquinas.put("e5", new Esquina("Cullen", "Obispo Boneo"));
        esquinas.put("e6", new Esquina("Obispo Boneo", "Echague"));
        esquinas.put("e7", new Esquina("Talcahuano", "Obispo Boneo"));
        esquinas.put("e8", new Esquina("Obispo Boneo", "Defensa"));
        esquinas.put("e9", new Esquina("Obispo Boneo", "Riobamba"));
        esquinas.put("e522", new Esquina("Gorostiaga", "Tacuari"));
        esquinas.put("e11", new Esquina("General Paz", "Estanislao Zeballos"));
        esquinas.put("e12", new Esquina("Velez Sarsfield", "Estanislao Zeballos"));
        esquinas.put("e13", new Esquina("Tacuari", "Estanislao Zeballos"));
        esquinas.put("e14", new Esquina("Estanislao Zeballos", "Piedras"));
        esquinas.put("e15", new Esquina("A Godoy", "Estanislao Zeballos"));
        esquinas.put("e16", new Esquina("Cullen", "Estanislao Zeballos"));
        esquinas.put("e17", new Esquina("Estanislao Zeballos", "Echague"));
        esquinas.put("e18", new Esquina("Talcahuano", "Estanislao Zeballos"));
        esquinas.put("e19", new Esquina("Estanislao Zeballos", "Defensa"));
        esquinas.put("e20", new Esquina("Estanislao Zeballos", "Riobamba"));
        esquinas.put("e21", new Esquina("Estanislao Zeballos", "Almirante Brown"));
        esquinas.put("e22", new Esquina("General Paz", "Juan Castelli"));
        esquinas.put("e23", new Esquina("Velez Sarsfield", "Juan Castelli"));
        esquinas.put("e24", new Esquina("Tacuari", "Juan Castelli"));
        esquinas.put("e25", new Esquina("Juan Castelli", "Piedras"));
        esquinas.put("e26", new Esquina("A Godoy", "Juan Castelli"));
        esquinas.put("e27", new Esquina("Cullen", "Juan Castelli"));
        esquinas.put("e28", new Esquina("Juan Castelli", "Echague"));
        esquinas.put("e29", new Esquina("Talcahuano", "Juan Castelli"));
        esquinas.put("e30", new Esquina("Juan Castelli", "Defensa"));
        esquinas.put("e31", new Esquina("Juan Castelli", "Riobamba"));
        esquinas.put("e32", new Esquina("Juan Castelli", "Almirante Brown"));
        esquinas.put("e33", new Esquina("General Paz", "Calle Hernandarias"));
        esquinas.put("e34", new Esquina("Velez Sarsfield", "Calle Hernandarias"));
        esquinas.put("e35", new Esquina("Tacuari", "Calle Hernandarias"));
        esquinas.put("e36", new Esquina("Piedras", "Calle Hernandarias"));
        esquinas.put("e37", new Esquina("A Godoy", "Calle Hernandarias"));
        esquinas.put("e38", new Esquina("Cullen", "Calle Hernandarias"));
        esquinas.put("e39", new Esquina("Echague", "Calle Hernandarias"));
        esquinas.put("e40", new Esquina("Talcahuano", "Calle Hernandarias"));
        esquinas.put("e41", new Esquina("Defensa", "Calle Hernandarias"));
        esquinas.put("e42", new Esquina("Riobamba", "Almirante Brown", "Calle Hernandarias"));
        esquinas.put("e519", new Esquina("Gorostiaga", "Lavaisse"));
        esquinas.put("e44", new Esquina("Velez Sarsfield", "JP Lopez"));
        esquinas.put("e45", new Esquina("Tacuari", "JP Lopez"));
        esquinas.put("e46", new Esquina("JP Lopez", "Piedras"));
        esquinas.put("e47", new Esquina("A Godoy", "JP Lopez"));
        esquinas.put("e48", new Esquina("Cullen", "JP Lopez"));
        esquinas.put("e49", new Esquina("Echague", "JP Lopez"));
        esquinas.put("e50", new Esquina("Talcahuano", "JP Lopez"));
        esquinas.put("e51", new Esquina("Almirante Brown", "JP Lopez", "Defensa"));
        esquinas.put("e52", new Esquina("Angel Cassanello", "General Paz"));
        esquinas.put("e53", new Esquina("Dorrego", "Angel Cassanello"));
        esquinas.put("e54", new Esquina("Angel Cassanello", "Velez Sarsfield"));
        esquinas.put("e521", new Esquina("Gorostiaga", "Piedras"));
        esquinas.put("e56", new Esquina("Angel Cassanello", "Piedras"));
        esquinas.put("e57", new Esquina("Angel Cassanello", "A Godoy"));
        esquinas.put("e58", new Esquina("Angel Cassanello", "Cullen"));
        esquinas.put("e59", new Esquina("Angel Cassanello", "Echague"));
        esquinas.put("e60", new Esquina("Angel Cassanello", "Talcahuano"));
        esquinas.put("e10", new Esquina("Obispo Boneo", "Almirante Brown"));
        esquinas.put("e62", new Esquina("General Paz", "Ricardo Aldao"));
        esquinas.put("e63", new Esquina("Dorrego", "Ricardo Aldao"));
        esquinas.put("e64", new Esquina("Velez Sarsfield", "Ricardo Aldao"));
        esquinas.put("e65", new Esquina("Tacuari", "Ricardo Aldao"));
        esquinas.put("e66", new Esquina("Ricardo Aldao", "Piedras"));
        esquinas.put("e67", new Esquina("A Godoy", "Ricardo Aldao"));
        esquinas.put("e68", new Esquina("Cullen", "Ricardo Aldao"));
        esquinas.put("e69", new Esquina("Ricardo Aldao", "Echague"));
        esquinas.put("e70", new Esquina("Ricardo Aldao", "Almirante Brown"));
        esquinas.put("e71", new Esquina("General Paz", "Pedro de Vega"));
        esquinas.put("e72", new Esquina("Dorrego", "Pedro de Vega"));
        esquinas.put("e73", new Esquina("Velez Sarsfield", "Pedro de Vega"));
        esquinas.put("e74", new Esquina("Tacuari", "Pedro de Vega"));
        esquinas.put("e75", new Esquina("Piedras", "Pedro de Vega"));
        esquinas.put("e76", new Esquina("A Godoy", "Pedro de Vega"));
        esquinas.put("e77", new Esquina("Cullen", "Pedro de Vega"));
        esquinas.put("e78", new Esquina("Echague", "Pedro de Vega"));
        esquinas.put("e79", new Esquina("Almirante Brown", "Pedro de Vega"));
        esquinas.put("e80", new Esquina("General Paz", "Lavaisse"));
        esquinas.put("e81", new Esquina("Avellaneda", "Lavaisse"));
        esquinas.put("e514", new Esquina("D Huergo", "Pasaje Arzamendia"));
        esquinas.put("e83", new Esquina("Velez Sarsfield", "Lavaisse"));
        esquinas.put("e84", new Esquina("Tacuari", "Lavaisse"));
        esquinas.put("e526", new Esquina("Calle Pizzorino", "Gorostiaga"));
        esquinas.put("e86", new Esquina("A Godoy", "Lavaisse"));
        esquinas.put("e87", new Esquina("Cullen", "Almirante Brown"));
        esquinas.put("e88", new Esquina("General Paz", "Llerena"));
        esquinas.put("e89", new Esquina("Avellaneda", "Llerena"));
        esquinas.put("e90", new Esquina("Dorrego", "Llerena"));
        esquinas.put("e91", new Esquina("Velez Sarsfield", "Llerena"));
        esquinas.put("e92", new Esquina("Tacuari", "Llerena"));
        esquinas.put("e93", new Esquina("Llerena", "Piedras"));
        esquinas.put("e94", new Esquina("A Godoy", "Llerena"));
        esquinas.put("e95", new Esquina("Almirante Brown", "Llerena"));
        esquinas.put("e96", new Esquina("D Huergo", "General Paz"));
        esquinas.put("e97", new Esquina("D Huergo", "Guemes"));
        esquinas.put("e98", new Esquina("D Huergo", "Avellaneda"));
        esquinas.put("e99", new Esquina("Dorrego", "D Huergo"));
        esquinas.put("e100", new Esquina("Pasaje Pizzorino", "D Huergo", "Llerena"));
        esquinas.put("e101", new Esquina("D Huergo", "Velez Sarsfield"));
        esquinas.put("e102", new Esquina("D Huergo", "Tacuari"));
        esquinas.put("e103", new Esquina("D Huergo", "Piedras"));
        esquinas.put("e104", new Esquina("D Huergo", "Almirante Brown"));
        esquinas.put("e105", new Esquina("General Paz", "Ruperto Godoy"));
        esquinas.put("e106", new Esquina("Guemes", "Ruperto Godoy"));
        esquinas.put("e107", new Esquina("Avellaneda", "Ruperto Godoy"));
        esquinas.put("e108", new Esquina("Dorrego", "Ruperto Godoy"));
        esquinas.put("e109", new Esquina("Pasaje Pizzorino", "Ruperto Godoy"));
        esquinas.put("e110", new Esquina("Velez Sarsfield", "Ruperto Godoy"));
        esquinas.put("e111", new Esquina("Tacuari", "Ruperto Godoy"));
        esquinas.put("e515", new Esquina("General Paz", "Mosquera"));
        esquinas.put("e113", new Esquina("General Paz", "Santiago Derqui"));
        esquinas.put("e114", new Esquina("Lavalle", "Santiago Derqui"));
        esquinas.put("e115", new Esquina("Guemes", "Santiago Derqui"));
        esquinas.put("e116", new Esquina("Avellaneda", "Santiago Derqui"));
        esquinas.put("e117", new Esquina("Dorrego", "Santiago Derqui"));
        esquinas.put("e118", new Esquina("Pasaje Pizzorino", "Santiago Derqui"));
        esquinas.put("e119", new Esquina("Velez Sarsfield", "Santiago Derqui"));
        esquinas.put("e120", new Esquina("Tacuari", "Santiago Derqui"));
        esquinas.put("e121", new Esquina("Santiago Derqui", "Almirante Brown"));
        esquinas.put("e123", new Esquina("General Paz", "Jose Maria Zuviria"));
        esquinas.put("e124", new Esquina("Lavalle", "Jose Maria Zuviria"));
        esquinas.put("e125", new Esquina("Guemes", "Jose Maria Zuviria"));
        esquinas.put("e126", new Esquina("Avellaneda", "Jose Maria Zuviria"));
        esquinas.put("e127", new Esquina("Dorrego", "Jose Maria Zuviria"));
        esquinas.put("e128", new Esquina("Pasaje Pizzorino", "Jose Maria Zuviria"));
        esquinas.put("e129", new Esquina("Velez Sarsfield", "Jose Maria Zuviria"));
        esquinas.put("e130", new Esquina("Tacuari", "Jose Maria Zuviria"));
        esquinas.put("e131", new Esquina("General Paz", "Salvador del Carril"));
        esquinas.put("e132", new Esquina("Lavalle", "Salvador del Carril"));
        esquinas.put("e133", new Esquina("Guemes", "Salvador del Carril"));
        esquinas.put("e134", new Esquina("Avellaneda", "Salvador del Carril"));
        esquinas.put("e135", new Esquina("Dorrego", "Salvador del Carril"));
        esquinas.put("e136", new Esquina("Pasaje Pizzorino", "Velez Sarsfield", "Salvador del Carril"));
        esquinas.put("e137", new Esquina("Tacuari", "Salvador del Carril"));
        esquinas.put("e138", new Esquina("Almirante Brown", "Salvador del Carril"));
        esquinas.put("e516", new Esquina("Mosquera"));
        esquinas.put("e112", new Esquina("Ruperto Godoy", "Almirante Brown", "Piedras"));
        esquinas.put("e517", new Esquina("Dorrego", "Mosquera"));
        esquinas.put("e518", new Esquina("Gorostiaga", "Avellaneda"));
        esquinas.put("e43", new Esquina("General Paz"));
        esquinas.put("e513", new Esquina("Pasaje Arzamendia", "Llerena"));
        esquinas.put("e520", new Esquina("Gorostiaga", "A Godoy"));
        esquinas.put("e55", new Esquina("Angel Cassanello", "Tacuari"));
        esquinas.put("e523", new Esquina("Gorostiaga", "Velez Sarsfield"));
        esquinas.put("e61", new Esquina("Angel Cassanello", "Almirante Brown"));
        esquinas.put("e524", new Esquina("Calle Pizzorino", "Pedro de Vega"));
        esquinas.put("e525", new Esquina("Dorrego", "Gorostiaga"));
        esquinas.put("e527", new Esquina("Gorostiaga", "General Paz"));
        esquinas.put("e507", new Esquina("Pujato", "Echague"));
        esquinas.put("e82", new Esquina("Dorrego", "Lavaisse"));
        esquinas.put("e500", new Esquina("A Godoy", "Marco Sastre"));
        esquinas.put("e501", new Esquina("Marco Sastre", "Piedras"));
        esquinas.put("e502", new Esquina("Tacuari", "Marco Sastre"));
        esquinas.put("e503", new Esquina("Velez Sarsfield", "Marco Sastre"));
        esquinas.put("e504", new Esquina("Pasaje Iturri", "Piedras"));
        esquinas.put("e505", new Esquina("Pasaje Iturri", "A Godoy"));
        esquinas.put("e506", new Esquina("Pasaje Iturri", "Tacuari"));
        esquinas.put("e511", new Esquina("Tacuari", "Pujato"));
        esquinas.put("e508", new Esquina("Cullen", "Pujato"));
        esquinas.put("e509", new Esquina("Pujato", "A Godoy"));
        esquinas.put("e510", new Esquina("Pujato", "Piedras"));
        esquinas.put("e85", new Esquina("Lavaisse", "Piedras"));
    }

    private void openPopupCalles(ActionEvent actionEvent, boolean cortadas) {
        Callback<Class<?>, Object> controllerFactory = type -> {
            if (type == CalleController.class) {
                return new CalleController(mapa, cortadas);
            } else {
                try {
                    return type.newInstance() ; // default behavior - invoke no-arg construtor
                } catch (Exception exc) {
                    System.err.println("Could not create controller for "+type.getName());
                    throw new RuntimeException(exc);
                }
            }
        };

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/popupCalles.fxml"));
            loader.setControllerFactory(controllerFactory);
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Seleccionar Calles " + (cortadas ? "Cortadas" : "Congestionadas"));
            stage.setScene(new Scene(root, 410, 240));
            stage.setResizable(false);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
