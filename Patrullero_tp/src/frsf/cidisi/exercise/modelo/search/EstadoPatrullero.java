package frsf.cidisi.exercise.modelo.search;
import java.util.ArrayList;
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
	
	private Mapa mapa;
	
    private Esquina posicionAgente;
    private Esquina posicionAlerta;
	private List<Calle> callesCortadas;
	private List<Calle> callesCongestionadas;
    private Double combustible;

	private double costo;
	
    public EstadoPatrullero(Mapa mapa) {
    	this.mapa = mapa;
    	posicionAgente = new Esquina();
    	posicionAlerta = new Esquina();
    	callesCortadas = new ArrayList<Calle>();
    	callesCongestionadas = new ArrayList<Calle>();
    	costo = 0.0;
    	combustible = 0d;
        this.initState();
    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
    	posicionAgente = this.mapa.getPosicionAgente();
    	posicionAlerta = this.mapa.getPosicionAlerta();
    	callesCortadas = this.mapa.getCallesCortadas();
    	callesCongestionadas = this.mapa.getCallesCongestionadas();
    	costo = 0.0;
    	combustible = new Double(500);
    }
    
    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {

		EstadoPatrullero estadoClone = new EstadoPatrullero(this.mapa);
			
		estadoClone.setposicionAgente(this.posicionAgente.clone());
		estadoClone.setposicionAlerta(this.posicionAlerta.clone());
		
		List<Calle> callesCortadasAux = new ArrayList<Calle>();
		if(callesCortadas != null){
			for(Calle calle : this.callesCortadas){
			callesCortadasAux.add(calle.clone());
			}
		}
		
		List<Calle> callesCongestionadasAux = new ArrayList<Calle>();
		if(callesCongestionadas != null){
			for(Calle calle : this.callesCongestionadas){
			callesCongestionadasAux.add(calle.clone());
			}
		}
		
		estadoClone.costo = this.costo;
		estadoClone.combustible = this.combustible;

        return estadoClone;
    }

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        //TODO: Complete Method
    	PatrulleroPerception perception = (PatrulleroPerception) p;
    	
    	this.setposicionAlerta(perception.getPosicionAlerta());
    	this.setCallesCortadas(perception.getCallesCortadas());
    	this.setCallesCongestionadas(perception.getCallesCongestionadas());
    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
    	String str = "";

        str += "\n			Posicion de la alerta: "+this.posicionAlerta.toString();
        str += "\n			Posicion del agente: "+this.posicionAgente.toString();
        return str;
    }

    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
    	 if (!(obj instanceof EstadoPatrullero)) {
             return false;
         }
         return posicionAgente.equals(((EstadoPatrullero) obj).getposicionAgente());
    }
   	
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
	
	public double getCosto(){
		return this.costo;
	}
	
	public void incrementarCosto(double costo){
		this.costo += costo;
	}

	public Double getCombustible() { return this.combustible;}

	public void  decrementarCombustible( Double comb){ this.combustible -= comb;}
}

