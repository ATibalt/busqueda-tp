package frsf.cidici.faia.simulator;

import frsf.cidici.faia.solver.productionsystem.ProductionSystemAction;
import frsf.cidisi.exercise.modelo.search.Patrullero;
import frsf.cidisi.exercise.modelo.search.PatrulleroMain;
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

            if (action == null) {
                printAll.accept("\nRule to execute: None");
                printThen.accept("No se detecto ningun incidente para dicha frase");
            }
            else
            {
            	ProductionSystemAction act = (ProductionSystemAction) action;
            	printAll.accept("\nRule to execute: " + act.getPeerRuleData().getRule().getId());
                try {
                    imprimirThen(act, agent.getAgentState());
                    this.ejecutarBusqueda(act);
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

	public void ejecutarBusqueda(ProductionSystemAction action){
        double idRegla = action.getPeerRuleData().getRule().getId();
        if(idRegla == 1.0 || idRegla == 2.1 || idRegla == 3.0 || idRegla == 5.0 || idRegla == 6.0 || idRegla == 7.0
                || idRegla == 8.0 || idRegla == 9.1 || idRegla == 11.1 || idRegla == 12.0 || idRegla == 13.0|| idRegla == 14.1
                || idRegla == 15.1|| idRegla == 17.0|| idRegla == 18.0|| idRegla == 19.1 || idRegla == 22.0|| idRegla == 25.0
                || idRegla == 27.1|| idRegla == 28.1|| idRegla == 29.0|| idRegla == 30.1|| idRegla == 31.0|| idRegla == 32.1
                || idRegla == 33.1|| idRegla == 34.0|| idRegla == 35.1|| idRegla == 36.2){
            new Thread() {
                @Override
                public void run() {
                    try {
                        PatrulleroMain.main(new String[]{"random"});
                    } catch(Exception e) { System.out.printf("Error simulador: %s", e); }
                }
            }.start();
        }
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
        respuesta=(String) (action.getPeerRuleData().getRule().getThen());
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
