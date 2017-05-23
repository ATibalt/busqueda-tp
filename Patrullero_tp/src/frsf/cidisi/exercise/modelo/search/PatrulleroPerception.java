package frsf.cidisi.exercise.modelo.search;

import java.util.List;

import domain.Calle;
import domain.Esquina;
import domain.Mapa;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PatrulleroPerception extends Perception {

    public static int UNKNOWN_PERCEPTION = -1;   
	private List<Calle> callesCortadas;
	private List<Calle> callesCongestionadas;
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
    	
        Patrullero agent = (Patrullero) agentIn;
        AmbientePatrullero environment = (AmbientePatrullero) environmentIn;
        EstadoAmbiente environmentState =  environment.getEnvironmentState();
        
        this.setPosicionAlerta(environmentState.getposicionAgente());
        this.setCallesCortadas(environmentState.getcallesCortadas());
        this.setCallesCongestionadas(environmentState.getcallesCongestionadas());
    }
    
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        
        str.append("			Posicion de la alerta: "+ this.posicionAlerta.toString());
        str.append("\n Calles cortadas: \n");
        str.append(callesCortadas);
        str.append("\n Calles congestionadas: \n");
        str.append(callesCongestionadas);
  
        return str.toString();
    }

	public Esquina getPosicionAlerta() {
		return posicionAlerta;
	}

	public void setPosicionAlerta(Esquina posicionAlerta) {
		this.posicionAlerta = posicionAlerta;
	}

	public List<Calle> getCallesCortadas() {
		return callesCortadas;
	}

	public void setCallesCortadas(List<Calle> callesCortadas) {
		this.callesCortadas = callesCortadas;
	}

	public List<Calle> getCallesCongestionadas() {
		return callesCongestionadas;
	}

	public void setCallesCongestionadas(List<Calle> callesCongestionadas) {
		this.callesCongestionadas = callesCongestionadas;
	}
	
	
}
