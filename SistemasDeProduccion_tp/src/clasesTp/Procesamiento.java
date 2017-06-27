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
            {{"plata", "guita", "dinero"},{"plata"}},
            {{"entregar", "entrego", "entregas", "entrega", "entregamos", "entregan", "entregas", "entregame", "dar", "doy", "das", "da", "damos", "dan", "das", "dame", "ceder", "cedo", "cedes", "cede", "cedemos", "ceden", "cedes", "cedeme", "largar", "largo", "largas", "larga", "largamos", "largan", "largas", "largame"},{"dar"}},
            {{"disparar", "disparo", "disparas", "dispara", "disparamos", "disparan", "disparas", "apuñalar", "apuñalo", "apuñalas", "apuñala", "apuñalamos", "apuñalan", "apuñalas", "apuñalaron"},{"disparar"}},
            {{"matar", "mato", "matas", "mata", "matamos", "matan", "matas", "quemar", "quemo", "quemas", "quema", "quemamos", "queman", "quemas"},{"matar"}},
            {{"amigo", "ameo", "guacho", "loco", "pibe", "cabeza", "chabon", "gorreado"},{"amigo"}},
            {{"dale", "andale"},{"dale"}},
            {{"mover", "muevo", "mueves", "mueve", "movemos", "mueven", "moves", "mueva"},{"mover"}},
            {{"arriba", "levantar", "levanto", "levantas", "levanta", "levantamos", "levantan", "levantas", "levantate"},{"arriba"}},
            {{"manos", "mano"},{"manos"}},
            {{"quieto", "quieta", "quietos", "quietas", "quietito", "parado", "parada", "parados", "paradas", "tranquilo", "tranquila", "tranquilos", "tranquilas", "calmado", "calmada", "calmados", "calmadas"},{"quieto"}},
            {{"cosas", "todo", "celu", "celular", "telefono", "mochila", "zapatillas"},{"cosas"}},
            {{"rapido", "pronto", "apurate", "apurese", "apuremonos", "apurense", "apresurate", "apresurate", "apresuro", "apresuramos", "apresuraron"},{"rapido"}},
            {{"tener", "tengo", "tienes", "tiene", "tenemos", "tienen", "tenes", "poseer", "poseo", "posees", "posee", "poseemos", "poseen", "posees"},{"tener"}},
            {{"arma", "pistola", "revolver", "cuchillo", "faca", "facon", "fierro", "chumbo"},{"arma"}},
            {{"donde"},{"donde"}},
            {{"estar", "esta", "este", "estemos", "estad", "esten", "esta", "estate", "estan"},{"estar"}},
            {{"nadie", "ninguno"},{"nadie"}},
            {{"salir", "sali", "salgo", "sales", "sale", "salimos", "salen", "salis", "irse", "partir", "ausentarse", "marchar", "huir", "alejarse", "saliendo", "marchando", "huyendo"},{"salir"}},
            {{"vivo", "vives", "vive", "vivimos", "vivis", "vivimos", "vivis", "viven", "viviendo"},{"vivo"}},
            {{"abrir", "abre", "abra", "abramos", "abrid", "abran", "abri", "abro", "abres", "abrimos", "abris", "abren", "abriendo", "abrime"},{"abrir"}},
            {{"caja", "registradora"},{"caja"}},
            {{"llamar", "llamo", "llamas", "llama", "llamamos", "llamais", "llaman", "llamas", "llamando", "llame"},{"llamar"}},
            {{"avisar", "aviso", "avisas", "avisa", "avisamos", "avisais", "avisan", "avisas", "avisando", "avisame"},{"avisar"}},
            {{"policia", "cobani", "azul", "yuta", "gorra"},{"policia"}},
            {{"gritar", "gritarme", "grito", "gritas", "grita", "gritamos", "gritan", "gritando", "clamar", "gritando", "chillando"},{"gritar"}},
            {{"robar", "robo", "robas", "roba", "robamos", "robais", "roban", "robas", "robando"},{"robar"}},
            {{"ayudar", "ayudo", "ayudas", "ayuda", "ayudamos", "ayudais", "ayudan", "ayudas", "auxiliar", "auxilio", "socorrer", "socorro", "ayudando", "socorriendo"},{"ayudar"}},
            {{"llevar", "llevo", "llevas", "lleva", "llevamos", "llevais", "llevan", "llevas", "llevando", "llevame", "llevate"},{"llevar"}},
            {{"hacer", "hago", "haces", "hace", "hacemos", "haceis", "hacen", "haces", "haciendo", "haceme", "hagas"},{"hacer"}},
            {{"dañar", "daño", "dañas", "daña", "dañamos", "dañan", "dañas", "dañando", "golpear", "golpeo", "golpeas", "golpea", "golpeamos", "golpean", "golpeas", "golpeando"},{"dañar"}},
            {{"pegar", "pego", "pegas", "pega", "pegamos", "pegan", "pegando"},{"pegar"}},
            {{"lastimar", "lastimo", "lastimas", "lastima", "lastimamos", "lastiman", "lastimas", "lastimando"},{"lastimar"}},
            {{"herir", "hiero", "hieres", "hiere", "herimos", "hieren", "heris", "hiriendo", "herido"},{"herir"}},
            {{"abusador", "abusar", "abusa", "abusamos", "abusan", "violador", "violar", "viola", "violo", "violan", "violamos", "acosador", "acosar", "acoso", "acosan", "acosamos", "abusando", "violando", "acosando"},{"abusador"}},
            {{"soltar", "suelto", "sueltas", "suelta", "soltamos", "sueltan", "solta", "soltame"},{"soltar"}},
            {{"dejar", "dejo", "deja", "dejas", "dejan", "dejamos", "deja", "dejamos", "dejando", "dejate"},{"dejar"}},
            {{"liberar", "libero", "libera", "liberas", "liberamos", "liberan", "libera", "liberando"},{"liberar"}},
            {{"quitar", "quito", "quita", "quitas", "quitamos", "quitan", "quitando", "quitate"},{"quitar"}},
            {{"sacar", "saco", "sacas", "saca", "sacamos", "sacan", "saca", "sacando", "sacate"},{"sacar"}},
            {{"dolor", "doler", "duelo", "duele", "doles", "doliendo"},{"dolor"}},
            {{"volver", "vuelvo", "vuelves", "vuelve", "volvemos", "vuelven", "volves"},{"volver"}},
            {{"alguien", "alguno", "todos"},{"alguien"}},
            {{"ambulancia", "medico", "medicos", "enfermero"},{"ambulancia"}},
            {{"fuego", "incendio", "incendiar", "incendias", "incendia", "incendiamos", "incendian", "incendias", "incendiando"},{"fuego"}},
            {{"morir", "muero", "muere", "mueres", "morimos", "moris", "mueren", "fallecer", "fellezco", "falleces", "fallece", "fallecemos", "fallecen", "falleces", "muriendo", "falleciendo", "morite"},{"morir"}},
            {{"asfixiar", "asfixio", "asfixia", "asfixiamos", "asfixiando", "sofocar", "sofoca", "sofoco", "sofocando"},{"asfixiar"}},
            {{"perder", "pierdo", "pierdes", "pierde", "perdemos", "pierden", "perdiendo", "perdete"},{"perder"}},
            {{"conocimiento", "inconsciente", "desvanece", "desvanecido", "desvanecer", "desvaneciendo"},{"conocimiento"}},
            {{"chocar", "choco", "chocas", "choca", "chocamos", "chocando", "chocan"},{"chocar"}},
            {{"mogumbos", "leviosa", "MAIAAMEE"},{"clave"}},
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
