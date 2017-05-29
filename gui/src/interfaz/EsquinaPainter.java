package interfaz;

import domain.Esquina;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import org.apache.commons.collections4.BidiMap;

/**
 * Created by Juxtar on 27/05/2017.
 */
public class EsquinaPainter {

    private Pane esquinasContainer;
    private BidiMap<String, Esquina> esquinas;

    public EsquinaPainter(Pane esquinasContainer, BidiMap<String, Esquina> esquinas) {
        this.esquinasContainer = esquinasContainer;
        this.esquinas = esquinas;
    }

    public void pintarEsquina(Esquina esquina, String tipo) {
        Esquina aux = null;
        for (Esquina e : esquinas.values()) {
            if (e.equals(esquina))
                aux = e;
        }
        if (aux == null)
            return;
        String keyEsquina = esquinas.getKey(aux);
        pintarEsquinaById(keyEsquina, tipo);
    }

    public void pintarEsquinaById(String id, String tipo) {
        Shape circuloEsquina = (Shape) esquinasContainer.lookup("#" + id);
        switch (tipo) {
            case "inicio":
                circuloEsquina.setFill(Color.YELLOWGREEN);
                break;
            case "fin":
                circuloEsquina.setFill(Color.PURPLE);
                break;
            case "medio":
                circuloEsquina.setFill(Color.GREEN);
                break;
            case "cortada":
                circuloEsquina.setFill(Color.RED);
                break;
            case "congestionada":
                circuloEsquina.setFill(Color.ORANGE);
                break;
            default:
                circuloEsquina.setFill(Color.DODGERBLUE);
                break;
        }
    }
}
