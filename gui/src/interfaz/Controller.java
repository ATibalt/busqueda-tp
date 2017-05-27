package interfaz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML private Pane esquinas;

    public void showIds(ActionEvent actionEvent) {
        List<Node> ids = new ArrayList<>();
        for (Node esq : esquinas.getChildren()) {
            Text txt = new Text();
            txt.setText(esq.getId());
            txt.setFont(new Font("Helvetica", 9));
            txt.setFill(Color.BLUEVIOLET);
            txt.setLayoutX(esq.getLayoutX());
            txt.setLayoutY(esq.getLayoutY());
            ids.add(txt);
        }
        esquinas.getChildren().addAll(ids);
    }

    public void chooseAgent(ActionEvent event) {
        for (Node esq : esquinas.getChildren()) {
            esq.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.printf("Clickeaste la esquina: %s %n", esq.getId());
                    for (Node e : esquinas.getChildren()) {
                        ((Shape)e).setFill(Color.DODGERBLUE);
                        e.setOnMouseClicked(null);
                    }
                }
            });
            ((Shape)esq).setFill(Color.RED);
        }
    }
}
