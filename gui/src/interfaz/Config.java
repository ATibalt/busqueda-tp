package interfaz;

import domain.Esquina;
import javafx.scene.control.TextArea;

/**
 * Created by Juxtar on 27/05/2017.
 */
public class Config {
    public static TextArea consoleOutput = new TextArea();
    public static Console console = new Console(consoleOutput);
    public static int metodo = 4;
    public static EsquinaPainter painter;
}
