package interfaz;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.event.ChangeEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML ComboBox metodoCombo;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        metodoCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    switch (newValue) {
                        case "Amplitud":
                            Config.metodo = 2;
                            break;
                        case "Costo Uniforme":
                            Config.metodo = 3;
                            break;
                        case "A*":
                        default:
                            Config.metodo = 4;
                    }
                }
            }
        });
    }

    public void verLog(ActionEvent actionEvent) {
        Config.consoleOutput.setPrefHeight(450);
        Config.consoleOutput.setEditable(false);
        Button cleanConsole = new Button("Limpiar");
        cleanConsole.setOnAction((event -> Config.consoleOutput.clear()));
        cleanConsole.setLayoutX(755);
        cleanConsole.setLayoutY(0);
        Config.consoleOutput.setPrefWidth(810);
        Pane root = new Pane(Config.consoleOutput, cleanConsole);
        Stage stage = new Stage();
        stage.setTitle("Log");
        stage.setScene(new Scene(root, 800, 440));
        stage.setResizable(false);
        stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }
}
