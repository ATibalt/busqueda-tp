package frsf.cidisi.exercise.modelo.search;

import domain.Mapa;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import interfaz.Config;
import interfaz.MainInterfaz;
import javafx.application.Platform;
import javafx.stage.Stage;

public class PatrulleroMain {

    public static void main(String[] args) throws PrologConnectorException {
    	
    	Mapa mapa = new Mapa();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                Patrullero agent = new Patrullero(mapa, Config.metodo);

                AmbientePatrullero environment = new AmbientePatrullero(mapa);

                SearchBasedAgentSimulator simulator =
                        new SearchBasedAgentSimulator(environment, agent);

                simulator.start();
            }
        };

        if (args.length != 0 && args[0].equals("random")) {
            Platform.runLater(() -> {
                MainInterfaz mainInterfaz = new MainInterfaz();
                try {
                    mainInterfaz.start(new Stage());
                } catch (Exception e) { System.out.printf("Error MainInterfaz: %s", e); }
                mainInterfaz.init(task, mapa);
                mainInterfaz.runRandom();
            });
        } else {
            new Thread() {
                @Override
                public void run() {
                    javafx.application.Application.launch(MainInterfaz.class);
                }
            }.start();
            MainInterfaz mainInterfaz = MainInterfaz.waitForMainInterfaz();

            mainInterfaz.init(task, mapa);
        }
    }
}
