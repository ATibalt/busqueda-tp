package frsf.cidisi.exercise.modelo.search;

import domain.Mapa;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class PatrulleroMain {

    public static void main(String[] args) throws PrologConnectorException {
    	
    	Mapa mapa = new Mapa();
    	
        Patrullero agent = new Patrullero(mapa);

        AmbientePatrullero environment = new AmbientePatrullero(mapa);

        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(environment, agent);
        
        simulator.start();
    }

}
