package frsf.cidisi.exercise.modelo.search.actions;
import java.util.List;

import domain.Calle;
import domain.Esquina;
import frsf.cidisi.exercise.modelo.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrAnodoX extends SearchAction {

	private Esquina nodoX;
	private double costo;
	
    public IrAnodoX(Esquina nodoX) {
		super();
		this.nodoX = nodoX;
		this.costo = 0;
	}
	/**
     * This method updates a tree node state when the search process is running.
     * It does not updates the real world state.
     */
	
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        EstadoPatrullero agentState = (EstadoPatrullero) s;
        
        Esquina posicionAgente = agentState.getposicionAgente();
        List<Esquina> esquinasAdyacentes = agentState.getMapa().getAdyacentes(posicionAgente);
        List<Calle> callesCortadas = agentState.getCallesCortadas();
        List<Calle> callesCongestionadas = agentState.getCallesCongestionadas();
        
        if(esquinasAdyacentes.contains(nodoX))//Ver si anda bien el contains!
        {	//calle entre la esquina actual del agente y la esquina a la que irá
        	Calle calleEntreEsquinas = null; //TODO: agentState.getCalle(posicionAgente, nodoX);
        	
        	if(!callesCortadas.contains(calleEntreEsquinas)){
        		//si la calle no está cortada, entonces el agente pasa a estar en la esquina X
        		agentState.setposicionAgente(nodoX);
        		
        		if(callesCongestionadas.contains(calleEntreEsquinas)){
        			//si la calle no está cortada pero si congestionada, tendrá un costo ir a la esquina X
        			costo = 10;
        		}
        		return agentState;
        	}
        }
        return null;
    }

    /**
     * This method updates the agent state and the real world state.
     */
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EstadoAmbiente environmentState = (EstadoAmbiente) est;
        EstadoPatrullero agentState = ((EstadoPatrullero) ast);

        Esquina posicionAgente = agentState.getposicionAgente();
        List<Esquina> esquinasAdyacentes = agentState.getMapa().getAdyacentes(posicionAgente);
        List<Calle> callesCortadas = agentState.getCallesCortadas();
        
        if(esquinasAdyacentes.contains(nodoX)) {
        	
        	Calle calleEntreEsquinas = null; //TODO: agentState.getCalle(posicionAgente, nodoX);
        	
        	if(!callesCortadas.contains(calleEntreEsquinas)){
        		// Update the real world
                environmentState.setposicionAgente(nodoX);
                // Update the agent state
        		agentState.setposicionAgente(nodoX);
        		
        		return environmentState;
        	}  
        }
        return null;
    }

    /**
     * This method returns the action cost.
     */
    @Override
    public Double getCost() {
    	return this.costo;
      //  return new Double(0);
    }

    /**
     * This method is not important for a search based agent, but is essensial
     * when creating a calculus based one.
     */
    @Override
    public String toString() {
        return "IrAnodoX: "+nodoX.toString();
    }
}