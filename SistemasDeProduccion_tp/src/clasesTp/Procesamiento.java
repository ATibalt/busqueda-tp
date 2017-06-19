package clasesTp;

import com.sun.deploy.util.StringUtils;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Juxtar on 18/06/2017.
 */
public class Procesamiento {

    static String[][][] palabras = {
            {{"plata", "guita", "dinero"}, {"plata"}},
            {{"entregar", "entrego", "entregas", "entrega", "entregamos", "entregan", "entregas", "dar", "doy", "das", "da", "damos", "dan", "das", "ceder", "cedo", "cedes", "cede", "cedemos", "ceden", "cedés", "largar", "largo", "largas", "larga", "largamos", "largan", "largas"}, {"dar"}},
            {{"disparar", "disparo", "disparas", "dispara", "disparamos", "disparan", "disparas", "apuñalar", "apuñalo", "apuñalas", "apuñala", "apuñalamos", "apuñalan", "apuñalas"}, {"disparar"}},
            {{"matar", "mato", "matas", "mata", "matamos", "matan", "matas", "quemar", "quemo", "quemas", "quema", "quemamos", "queman", "quemas"}, {"matar"}},
            {{"amigo", "ameo", "guacho", "loco", "pibe"}, {"amigo"}},
            {{"dale", "andale"}, {"dale"}}
    };

    public static String[] start(String input) {
        String cleanInput = quitarTildes(input);
        cleanInput = quitarPuntuacion(cleanInput);
        cleanInput = cleanInput.toLowerCase();
        List<String> oracion = Arrays.asList(StringUtils.splitString(cleanInput, " "));
        List<String> resultado = new ArrayList<>();
        for(String palabra : oracion) {
            for (String[][] listaPalabras : palabras) {
                List<String> relacionadas = Arrays.asList(listaPalabras[0]);
                if (relacionadas.contains(palabra))
                    resultado.add(listaPalabras[1][0]);
            }
        }
        return resultado.toArray(new String[]{});
    }

    private static String quitarTildes(String input) {
        String resultado = "";
        for(int i=0; i < input.length(); i++)
        {
            switch(input.charAt(i))
            {
                case 'á': resultado = resultado.concat("a"); break;
                case 'é': resultado = resultado.concat("e"); break;
                case 'í': resultado = resultado.concat("i"); break;
                case 'ó': resultado = resultado.concat("o"); break;
                case 'ú': resultado = resultado.concat("u"); break;
                default: resultado = resultado.concat("" + input.charAt(i));
            }
        }
        return resultado;
    }

    private static String quitarPuntuacion(String input) {
        String resultado = "";
        for(int i=0; i < input.length(); i++)
        {
            switch(input.charAt(i))
            {
                case '.': break;
                case ',': break;
                case ';': break;
                case '¿': break;
                case '?': break;
                case '¡': break;
                case '!': break;
                case '(': break;
                case ')': break;
                case '"': break;
                case '-': break;
                case '_': break;
                case '\'': break;
                default: resultado = resultado.concat("" + input.charAt(i));
            }
        }
        return resultado;
    }
}
