package frsf.cidisi.exercise.modelo.search;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PatrulleroPerception extends Perception {

	//TODO: Setup Statics
    //public static int UNKNOWN_PERCEPTION = -1;   
	
	
	//TODO: Setup Sensors
	private int cortecalle;
	private int congestioncalle;
	private int alerta;
	
 

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
    	
    	//TODO: Complete Method
        
        //Patrullero agent = (Patrullero) agentIn;
        //AmbientePatrullero environment = (AmbientePatrullero) environmentIn;
        //EstadoAmbiente environmentState =
        //        environment.getEnvironmentState();
       
        
    }
    
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        //TODO: Complete Method

        return str.toString();
    }

    // The following methods are agent-specific:
    //TODO: Complete this section with the agent-specific methods
	
     public int getcortecalle(){
        return cortecalle;
     }
     public void setcortecalle(int arg){
        this.cortecalle = arg;
     }
     public int getcongestioncalle(){
        return congestioncalle;
     }
     public void setcongestioncalle(int arg){
        this.congestioncalle = arg;
     }
     public int getalerta(){
        return alerta;
     }
     public void setalerta(int arg){
        this.alerta = arg;
     }
	
   
}
