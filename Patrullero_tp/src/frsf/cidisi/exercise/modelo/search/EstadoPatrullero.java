package frsf.cidisi.exercise.modelo.search;
import java.util.List;
import domain.Calle;
import domain.Esquina;
import domain.Mapa;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * Represent the internal state of the Agent.
 */
public class EstadoPatrullero extends SearchBasedAgentState {
	
	//TODO: Setup Variables
	private Mapa mapa;
    private Esquina posicionAgente;
    private Esquina posicionAlerta;
    //TODO: cambiar lista de eventos por lista de calles cortadas y lista de calles congestionadas
    //private Other listaEventos;
	private List<Calle> callesCortadas;
	private List<Calle> callesCongestionadas;
	
    public EstadoPatrullero() {
        this.initState();
    }

    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
		//TODO: Complete Method. IMPORTANTE !! realizar bien este metodo
		
        return null;
    }

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        
        //TODO: Complete Method
    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
        //TODO: Complete Method - setea el estado incial
    	mapa = new Mapa();
    	posicionAgente = mapa.getPosicionAgente();
    	posicionAlerta = mapa.getAlerta();
    	callesCortadas = mapa.getCallesCortadas();
    	callesCongestionadas = mapa.getCallesCongestionadas();
    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method

        return str;
    }

    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
       //TODO: Complete Method
    	 if (!(obj instanceof EstadoPatrullero)) {
             return false;
         }
         return posicionAgente.equals(((EstadoPatrullero) obj).getposicionAgente());
    }

    //TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
   	
	 public Esquina getposicionAgente(){
	    return posicionAgente;
	 }
     public void setposicionAgente(Esquina arg){
        posicionAgente = arg;
     }
     public Esquina getposicionAlerta(){
        return posicionAlerta;
     }
     public void setposicionAlerta(Esquina arg){
        posicionAlerta = arg;
     }
//     public Other getlistaEventos(){
//        return listaEventos;
//     }
//     public void setlistaEventos(Other arg){
//        listaEventos = arg;
//     }

	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
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

