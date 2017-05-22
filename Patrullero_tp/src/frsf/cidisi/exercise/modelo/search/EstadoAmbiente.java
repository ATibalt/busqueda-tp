package frsf.cidisi.exercise.modelo.search;
import java.util.List;
import domain.Calle;
import domain.Esquina;
import domain.Mapa;
import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class EstadoAmbiente extends EnvironmentState {	
	
	private Mapa mapa;
	private List<Calle> callesCortadas;
    private List<Calle> callesCongestionadas;
    private Esquina posicionAlerta;
    private Esquina posicionAgente;
	
    public EstadoAmbiente() {
    	mapa = new Mapa();
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {
		callesCortadas = mapa.getCallesCortadas();
		callesCongestionadas = mapa.getCallesCongestionadas();
		posicionAlerta = mapa.getPosicionAlerta();
		posicionAgente = mapa.getPosicionAgente();
    }
	/**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "Estado ambiente:";

        str += "\nPosicion de la alerta: "+this.posicionAlerta.toString();
        str += "\nPosicion del agente: "+this.posicionAgente.toString();
        return str;
    }

	public Mapa getMapa() {
		return mapa;
	}
	
	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
	
	public List<Calle> getcallesCortadas(){
	   return callesCortadas;
	}
	
	public void setcallesCortadas(List<Calle> arg){
	    callesCortadas = arg;
	}
	 
	public List<Calle> getcallesCongestionadas(){
		 return callesCongestionadas;
	}
	 
	public void setcallesCongestionadas(List<Calle> arg){
	    callesCongestionadas = arg;
	}
	public Esquina getposicionAlerta(){
	    return posicionAlerta;
	}
	public void setposicionAlerta(Esquina arg){
	    posicionAlerta = arg;
	}
	public Esquina getposicionAgente(){
	    return posicionAgente;
	}
	public void setposicionAgente(Esquina arg){
	    posicionAgente = arg;
	}


}