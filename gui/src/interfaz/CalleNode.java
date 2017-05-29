package interfaz;

import domain.Calle;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;

/**
 * Created by Juxtar on 28/05/2017.
 */
public class CalleNode extends HBox {

    private Text nombre;
    private SVGPath eliminarButton;
    private Calle calle;

    public CalleNode(Calle calle) {
        super(8);
        this.calle = calle;
        nombre = new Text(calle.toString());
        eliminarButton = new SVGPath();
        eliminarButton.setContent("M6 19c0 1.1.9 2 2 2h8c1.1 0 2-.9 2-2V7H6v12zM19 4h-3.5l-1-1h-5l-1 1H5v2h14V4z");
        eliminarButton.getStyleClass().add("boton-eliminar");
        Pane spacer = new Pane();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        this.getChildren().addAll(nombre, spacer, eliminarButton);
    }

    public void setOnEliminarHandler(EventHandler<? super MouseEvent> event){
        eliminarButton.setOnMouseClicked(event);
    }

    public String getNombre() {
        return calle.getNombre();
    }

    public int getAltura() {
        return calle.getAltura();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CalleNode)) {
            return false;
        }
        CalleNode nodeCalle = (CalleNode)object;
        return nodeCalle.getNombre().equals(getNombre()) && nodeCalle.getAltura() == getAltura();
    }
}
