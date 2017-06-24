package interfaz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        primaryStage.setTitle("Patrullero");
        Scene mainScene = new Scene(root, 730, 600);

        Button btnProcesar =  (Button)mainScene.lookup("#btnProcesar");
        btnProcesar.setOnAction(value -> {
            TextField inputField = (TextField) mainScene.lookup("#input");
            simulator.accept(inputField.getText());
        });

        TextArea salida = (TextArea)mainScene.lookup("#salida");
        Consumer<String> print = input -> {
            salida.appendText(input);
            salida.appendText("\n");
        };
        printAllSetter.accept(print);
        printThenSetter.accept(print);

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
