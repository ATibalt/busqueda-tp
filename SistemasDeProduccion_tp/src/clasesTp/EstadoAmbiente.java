package clasesTp;

import frsf.cidici.faia.solver.productionsystem.Rule;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

import java.util.LinkedList;

/**
 * Esta clase representa el estado del ambiente del Agente.
 * @author Grupo 12.
 */
public class EstadoAmbiente extends EnvironmentState {
	
    private LinkedList<String> log;
    private String input;
    private String output;

    /**
     * Constructor.
     */
    public EstadoAmbiente() {
        log = new LinkedList<String>();
    	output = "";
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {
    }

    /**
     * String representation of the real world state.
     * @return 
     */
    @Override
    public String toString() {
        String str = "Input: " + input.toString();
        return str;
    }

    // The following methods are agent-specific.
     public LinkedList<String> getlog(){
        return log;
     }
     
     public void setlog(LinkedList<String> arg){
        log = arg;
     }	
     
     public String getinput(){
         return input;
     }
     
     public void setinput(String arg){
         input = arg;
     }

     public String getoutput(){
         return output;
     }
     
     public void setoutput(String arg){
         output = arg;
     }

     public void agregarLineaAlLog(String linea){
    	 log.addLast(linea);
     }
     
     /**
      * Metodo que actualiza la respuesta y el log de chat.
      * @param resp
      */
     public void actualizar(String resp){
        output = resp;
    	if (resp!=null) 
             this.agregarLineaAlLog(resp);
     }
     
     /**
      * Metodo que borra la respuesta.
      */
     public void borraroutput(){
    	 output = "";
     }
     
    public void updateState(AgentState ast, Rule rule) {
        this.actualizar((String)rule.getThen());
        
    }
     
}

