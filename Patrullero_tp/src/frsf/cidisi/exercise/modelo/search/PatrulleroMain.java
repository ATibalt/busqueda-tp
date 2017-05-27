package frsf.cidisi.exercise.modelo.search;

import domain.Mapa;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import interfaz.Config;
import interfaz.MainInterfaz;

public class PatrulleroMain {

    public static void main(String[] args) throws PrologConnectorException {
    	
    	Mapa mapa = new Mapa();

        new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(MainInterfaz.class);
            }
        }.start();
        MainInterfaz mainInterfaz = MainInterfaz.waitForMainInterfaz();

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
        mainInterfaz.init(task, mapa);
    }
}
