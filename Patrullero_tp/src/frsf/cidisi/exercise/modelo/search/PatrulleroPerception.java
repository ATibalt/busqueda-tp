package frsf.cidisi.exercise.modelo.search;

import domain.Esquina;
import domain.Mapa;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PatrulleroPerception extends Perception {

    public static int UNKNOWN_PERCEPTION = -1;   
	private Mapa mapa;
	private Esquina posicionAlerta;
	
    public  PatrulleroPerception() {
    	//TODO: Complete Method
    }

    public PatrulleroPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    @Override
    public void initPerception(Agent agentIn, Environment environmentIn) {
    	
        //Patrullero agent = (Patrullero) agentIn;
        AmbientePatrullero environment = (AmbientePatrullero) environmentIn;
        EstadoAmbiente environmentState =  environment.getEnvironmentState();
        
        this.setMapa(environmentState.getMapa());
        this.setPosicionAlerta(environmentState.getposicionAgente());
    }
    
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        //TODO: Complete Method

        return str.toString();
    }

	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	public Esquina getPosicionAlerta() {
		return posicionAlerta;
	}

	public void setPosicionAlerta(Esquina posicionAlerta) {
		this.posicionAlerta = posicionAlerta;
	}
}
