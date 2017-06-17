package frsf.cidici.faia.solver.productionsystem;

import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import clasesTp.EstadoAmbiente;

/**
 * Clase que implementa las acciones que el sistema de produccion puede
 * devolverle al ambiente.
 * @author Grupo 12: Blas,Mar�a Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class ProductionSystemAction extends frsf.cidisi.faia.agent.Action {

	Rule rule;
	
	public ProductionSystemAction(Rule r){
		rule = r;
	}
	
	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est){
		//TODO Futuro: Esto esta armado para el Chatbot pero deber�a incorporarse en la clase Enviroment el metodo update.
		EstadoAmbiente cest = (EstadoAmbiente) est;
		cest.updateState(ast,rule);
		return cest;
	}

	@Override
	public String toString() {
		return "Ejecutar";
	}
	
	public Rule getRule(){
		return rule;
	}

}
