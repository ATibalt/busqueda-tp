package frsf.cidici.faia.simulator;

import frsf.cidici.faia.solver.productionsystem.ProductionSystemAction;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.simulator.events.EventType;
import frsf.cidisi.faia.simulator.events.SimulatorEventNotifier;
import clasesTp.Agente;
import clasesTp.Datos;
import clasesTp.EstadoAgente;
import java.io.IOException;
import java.util.Vector;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa el simulador de un agente basado en conocimiento.
 * @author Grupo 12: Blas,Mar�a Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class KnowledgeBasedAgentSimulator extends frsf.cidisi.faia.simulator.Simulator {

    private String respuesta;
    private Consumer<String> printAll;
    private Consumer<String> printThen;

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

        printAll.accept("----------------------------------------------------");
        printAll.accept("--- " + this.getSimulatorName() + " ---");
        printAll.accept("----------------------------------------------------");
        printAll.accept(" ");

        Perception perception;
        Action action = null;
        //TODO Futuro: Esta hecho para el Agente pero deber�a incluirse el m�todo learn en la clase agente.
        Agente agent;

        agent = (Agente) this.getAgents().firstElement();

        //do {

            printAll.accept("------------------------------------");

            printAll.accept("Sending perception to agent...");
            perception = this.getPercept();
            agent.see(perception);
            printAll.accept("Perception: " + perception);

            printAll.accept("Agent State: " + agent.getAgentState());
            printAll.accept("Environment: " + environment);

            printAll.accept("Asking the agent that start the learning process...");
            try {
                action = agent.learn();
            } catch (Exception ex) {
                Logger.getLogger(KnowledgeBasedAgentSimulator.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (action == null)
            	printAll.accept("\nRule to execute: None - No se detecto ningun incidente para dicha frase");
            else
            {
            	ProductionSystemAction act = (ProductionSystemAction) action;
            	printAll.accept("\nRule to execute: " + act.getPeerRuleData().getRule().getId());
                try {
                    imprimirThen(act, agent.getAgentState());
                } catch (IOException ex) {
                    Logger.getLogger(KnowledgeBasedAgentSimulator.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            

            this.ruleReturned(agent, action);

        //} while (!this.finishForRule((ProductionSystemAction)action) && !this.finishForAgentState(agent));

        // Check what happened.
        if(action == null){
            printAll.accept("The agent has finished, none rule for execute.");
        }else if (this.finishForRule((ProductionSystemAction)action)) {
            printAll.accept("The agent has executed the finish rule.");
        } else {
            printAll.accept("The agent has finished learning!");
        }

        // Leave a blank line
        printAll.accept(" ");

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



    private void imprimirThen(ProductionSystemAction action,EstadoAgente estadoAgente) throws IOException {
        //TODO ver de ejecutar el tp 1 con ciertas reglas
        respuesta=(String) (action.getPeerRuleData().getRule().getThen());
        printAll.accept(respuesta);
        printThen.accept(respuesta);
    }

    public String getRespuesta() {
        return respuesta;
    }


    public Consumer<String> getPrintAll() {
        return printAll;
    }

    public void setPrintAll(Consumer<String> printAll) {
        this.printAll = printAll;
    }

    public Consumer<String> getPrintThen() {
        return printThen;
    }

    public void setPrintThen(Consumer<String> printThen) {
        this.printThen = printThen;
    }
}
