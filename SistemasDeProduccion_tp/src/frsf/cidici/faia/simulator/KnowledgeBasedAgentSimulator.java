package frsf.cidici.faia.simulator;

import frsf.cidici.faia.solver.productionsystem.ProductionSystemAction;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.simulator.events.EventType;
import frsf.cidisi.faia.simulator.events.SimulatorEventNotifier;
//import procesamiento.Nodo;
import clasesTp.Agente;
import clasesTp.Datos;
import clasesTp.EstadoAgente;

import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

//import frsf.cidisi.exercise.agente.search.FuncionalidadTp2;

/**
 * Clase que implementa el simulador de un agente basado en conocimiento.
 * @author Grupo 12: Blas,Mar�a Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class KnowledgeBasedAgentSimulator extends frsf.cidisi.faia.simulator.Simulator {
        private String respuesta;
	/**
	 * Constructor.
	 * @param environment
	 * @param agents
	 */
    public KnowledgeBasedAgentSimulator(Environment environment, Vector<Agent> agents) {
        super(environment,agents);
    }
    
    /**
     * Constructor.
     * @param environment
     * @param agent
     */
    public KnowledgeBasedAgentSimulator(Environment environment, Agent agent) {
   		Vector<Agent> v = new Vector<Agent>();
   		v.add(agent);
    	this.environment = environment;
    	this.agents = v;
    }
	
	@Override
	public void start() {

        System.out.println("----------------------------------------------------");
        System.out.println("--- " + this.getSimulatorName() + " ---");
        System.out.println("----------------------------------------------------");
        System.out.println();

        Perception perception;
        Action action = null;
        //TODO Futuro: Esta hecho para el Agente pero deber�a incluirse el m�todo learn en la clase agente.
        Agente agent;

        agent = (Agente) this.getAgents().firstElement();

        //do {

            System.out.println("------------------------------------");

            System.out.println("Sending perception to agent...");
            perception = this.getPercept();
            agent.see(perception);
            System.out.println("Perception: " + perception);

            System.out.println("Agent State: " + agent.getAgentState());
            System.out.println("Environment: " + environment);

            System.out.println("Asking the agent that start the learning process...");
            try {
                action = agent.learn();
            } catch (Exception ex) {
                Logger.getLogger(KnowledgeBasedAgentSimulator.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (action == null)
            	System.out.println("\nRule to execute: None");
            else
            {
            	ProductionSystemAction act = (ProductionSystemAction) action;
            	System.out.println("\nRule to execute: " + act.getPeerRuleData().getRule().getId());
                try {
                    imprimirThen(act, agent.getAgentState());
                } catch (IOException ex) {
                    Logger.getLogger(KnowledgeBasedAgentSimulator.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            

            this.ruleReturned(agent, action);

        //} while (!this.finishForRule((ProductionSystemAction)action) && !this.finishForAgentState(agent));

        // Check what happened.
        if (this.finishForRule((ProductionSystemAction)action)) {
            System.out.println("The agent has executed the finish rule.");
        } else {
            System.out.println("The agent has finished learning!");
        }

        // Leave a blank line
        System.out.println();

        // This call can be moved to the Simulator class
        this.environment.close();

        // Launch simulationFinished event
        SimulatorEventNotifier.runEventHandlers(EventType.SimulationFinished, null);
		
	}

	protected boolean finishForAgentState(Agent agent) {
		// TODO Futuro: Ver como deber� ser este m�todo
		return false;
	}

	protected boolean finishForRule(ProductionSystemAction action) {
		
            return(((String)action.getPeerRuleData().getRule().getThen()).equalsIgnoreCase("Proceso finalizado."));
	}
	
	public String getSimulatorName() {
        return "Knowledge Based Simulator";
    }

    public void ruleReturned(Agent agent,Action action) {
        if(action!=null)
        {
        	this.updateState(action);
        }
    }
    
    protected void updateState(Action action) {
    	//TODO Futuro: Esta hecho para el Agente pero deber�a incluirse en otro lugar el metodo requerido.
        this.getEnvironment().updateState(((Agente) agents.elementAt(0)).getAgentState(), action);
    }


    //TODO ver metodo imprimirThen();
    private void imprimirThen(ProductionSystemAction action,EstadoAgente estadoAgente) throws IOException {
        /*
        if(action.getRule().getId()==2.0){
            for(Nodo nodoIterado: estadoChatBot.getOracionPreprocesada().getLista())
                if(nodoIterado.getClave().equals("profesoridentificado")){
                    String [] persona = nodoIterado.getPalabra().getPalabra().split(" ");
                    String nombre = persona[0].substring(0, 1).toUpperCase() + persona[0].substring(1);
                    String apellido = persona[1].substring(0, 1).toUpperCase() + persona[1].substring(1);
                    respuesta=(nombre+" "+apellido+" "+action.getRule().getThen()
                            +Datos.getLugar(nodoIterado.getPalabra().getPalabra()));
                }
        }
        else if(action.getRule().getId()== 2.1 || action.getRule().getId()== 3.1){
            for(Nodo nodoIterado: estadoChatBot.getOracionPreprocesada().getLista())
                if(nodoIterado.getClave().equals("profesoridentificado"))
                    respuesta=(action.getRule().getThen()
                            +Datos.getLugar(nodoIterado.getPalabra().getPalabra()));
        }
        else if(action.getRule().getId()== 4.2 || action.getRule().getId()== 5.1){
            for(Nodo nodoIterado: estadoChatBot.getOracionPreprocesada().getLista())
                if(nodoIterado.getClave().equals("materiadetectada")){
                    if(Datos.getMateriaRendir(nodoIterado.getPalabra().getPalabra())!=null)
                    respuesta=(action.getRule().getThen()
                            +Datos.getMateriaRendir(nodoIterado.getPalabra().getPalabra()));
                    else
                        respuesta= "Hoy no se rinde";
                }
        }
        else if(action.getRule().getId()==5.0){
            for(Nodo nodoIterado: estadoChatBot.getOracionPreprocesada().getLista())
                if(nodoIterado.getClave().equals("materiadetectada")){
                    String materia= nodoIterado.getPalabra().getPalabra();
                    String materiaMayus= materia.substring(0, 1).toUpperCase()+materia.substring(1);
                    if(Datos.getMateriaRendir(nodoIterado.getPalabra().getPalabra())!=null)
                    respuesta=(materiaMayus+action.getRule().getThen()
                            +Datos.getMateriaRendir(nodoIterado.getPalabra().getPalabra()));
                     else
                        respuesta= "Hoy no se rinde";
                }
        }
        else if(action.getRule().getId()==6.0 || action.getRule().getId()==6.1){
            for(Nodo nodoIterado: estadoChatBot.getOracionPreprocesada().getLista())
                if(nodoIterado.getClave().equals("materiadetectada")){
                    String materia= nodoIterado.getPalabra().getPalabra();
                    String materiaMayus= materia.substring(0, 1).toUpperCase()+materia.substring(1);
                    respuesta=(materiaMayus+action.getRule().getThen()
                            +Datos.getMateriaCursar(nodoIterado.getPalabra().getPalabra()));
                }
        }
        else if(action.getRule().getId()==7.0 || action.getRule().getId()==7.1){
            *//*for(Nodo nodoIterado: estadoChatBot.getOracionPreprocesada().getLista())
                if(nodoIterado.getClave().equals("lugarfacultad")){
                    System.out.println(action.getRule().getThen());
                    FuncionalidadTp2 tp1 = new FuncionalidadTp2();
                    List<String> listaRespuestaCamino= tp1.getRecorrido(Datos.getPuntoFacultad(nodoIterado.getPalabra().getPalabra()));
                    respuesta=listaRespuestaCamino.remove(0);
                    for(String string:listaRespuestaCamino){
                        respuesta+='\n'+ string+" ";
                    }
                    respuesta+="y llegas a destino";
                }
             *//*
        }
        else if(action.getRule().getId()==15.0){
            for(Nodo nodoIterado: estadoChatBot.getOracionPreprocesada().getLista())
                if(nodoIterado.getClave().equals("materiadetectada")){
                    String materia= nodoIterado.getPalabra().getPalabra();
                    String materiaMayus= materia.substring(0, 1).toUpperCase()+materia.substring(1);
                    respuesta=(materiaMayus+action.getRule().getThen()
                            +Datos.getProfesoresDictado(nodoIterado.getPalabra().getPalabra()));
                }    
        }
        else if(action.getRule().getId()==15.1){
            for(Nodo nodoIterado: estadoChatBot.getOracionPreprocesada().getLista())
                if(nodoIterado.getClave().equals("materiadetectada"))
                    respuesta=(action.getRule().getThen()
                            +Datos.getProfesoresDictado(nodoIterado.getPalabra().getPalabra()));
        }
        else if(action.getRule().getId()==15.2){
            for(Nodo nodoIterado: estadoChatBot.getOracionPreprocesada().getLista())
                if(nodoIterado.getClave().equals("materiadetectada")){
                    String materia= nodoIterado.getPalabra().getPalabra();
                    String materiaMayus= materia.substring(0, 1).toUpperCase()+materia.substring(1);
                    respuesta=(Datos.getProfesoresDictado(nodoIterado.getPalabra().getPalabra())+
                            action.getRule().getThen()+materiaMayus);
                }
        }
        
        else
             respuesta=(String) (action.getRule().getThen());
        
        System.out.println(respuesta);*/
    }

    public String getRespuesta() {
        return respuesta;
    }
    
}
