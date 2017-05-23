package frsf.cidisi.exercise.modelo.search;

import domain.Mapa;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.environment.Environment;

public class AmbientePatrullero extends Environment {

    public AmbientePatrullero(Mapa mapa) {
        // Create the environment state
        this.environmentState = new EstadoAmbiente(mapa);
    }

    public EstadoAmbiente getEnvironmentState() {
        return (EstadoAmbiente) super.getEnvironmentState();
    }

    /**
     * This method is called by the simulator. Given the Agent, it creates
     * a new perception reading, for example, the agent position.
     * @param agent
     * @return A perception that will be given to the agent by the simulator.
     */
    @Override
    public  PatrulleroPerception getPercept() {
        // Create a new perception to return
         PatrulleroPerception perception = new PatrulleroPerception();
		
		//Set the perceptions sensors
         perception.setPosicionAlerta(this.getEnvironmentState().getposicionAlerta());
         perception.setCallesCortadas(this.getEnvironmentState().getcallesCortadas());
         perception.setCallesCongestionadas(this.getEnvironmentState().getcallesCongestionadas());

        return perception;
    }

    
    public String toString() {
        return environmentState.toString();
    }

    
    public boolean agentFailed(Action actionReturned) {

        EstadoAmbiente envState = this.getEnvironmentState();

        // TODO: Complete Method        

        return false;
    }

	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
    
    
}
