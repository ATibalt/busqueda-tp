package interfaz;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

/**
 * Created by Juxtar on 24/06/2017.
 */
public class InterfazChat extends Application {
    public static final CountDownLatch latch = new CountDownLatch(1);
    public static InterfazChat mainInterfaz = null;
    private Consumer<String> simulator;
    private Consumer<Consumer<String>> printThenSetter;
    private Consumer<Consumer<String>> printAllSetter;
    private String consoleAll;
    private String consoleThen;
    private String ultimaFrase;

    public static InterfazChat waitForMainInterfaz() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mainInterfaz;
    }

    public static void setMainInterfaz(InterfazChat mainInterfaz0) {
        mainInterfaz = mainInterfaz0;
        latch.countDown();
    }

    public InterfazChat() {
        setMainInterfaz(this);
        consoleAll = "";
        consoleThen = "";
        ultimaFrase = "";
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainchat.fxml"));
        primaryStage.setTitle("Patrullero");
        Scene mainScene = new Scene(root, 730, 600);

        TextArea salida = (TextArea)mainScene.lookup("#salida");
        CheckBox mostrarTodo = (CheckBox)mainScene.lookup("#simulador");
        mostrarTodo.setOnAction(value -> {
            salida.clear();
            if (mostrarTodo.isSelected())
                salida.appendText(consoleAll);
            else
                salida.appendText(consoleThen);
        });
        Consumer<String> printAll = input -> {
            consoleAll += input;
            consoleAll += "\n";
            if (mostrarTodo.isSelected()) {
                Platform.runLater(() -> {
                    salida.appendText(input);
                    salida.appendText("\n");
                });
            }
        };
        Consumer<String> printThen = input -> {
            consoleThen += input;
            consoleThen += "\n";
            consoleAll += input;
            consoleAll += "\n";

            Platform.runLater(() -> {
                salida.appendText(input);
                salida.appendText("\n");
            });
        };
        printAllSetter.accept(printAll);
        printThenSetter.accept(printThen);

        Button btnProcesar =  (Button)mainScene.lookup("#btnProcesar");
        TextField inputField = (TextField) mainScene.lookup("#input");
        EventHandler<ActionEvent> onProcesar = value -> {
            printThen.accept("Frase ingresada: " + inputField.getText());
            simulator.accept(inputField.getText());
            ultimaFrase = inputField.getText();
            inputField.clear();

        };
        btnProcesar.setOnAction(onProcesar);
        inputField.setOnAction(onProcesar);
        inputField.setOnKeyReleased(value -> {
            if(value.getCode() == KeyCode.UP)
                inputField.setText(ultimaFrase);
            else if(value.getCode() == KeyCode.DOWN)
                inputField.clear();
        });

        Button btnLimpiar = (Button)mainScene.lookup("#btnLimpiar");
        btnLimpiar.setOnAction(value -> {
            salida.clear();
            consoleAll = "";
            consoleThen = "";
        });

        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void setSimulator(Consumer<String> simulator) {
        this.simulator = simulator;
    }

    public void setPrintAllSetter(Consumer<Consumer<String>> printAllSetter) {
        this.printAllSetter = printAllSetter;
    }

    public void setPrintThenSetter(Consumer<Consumer<String>> printThenSetter) {
        this.printThenSetter = printThenSetter;
    }
}
