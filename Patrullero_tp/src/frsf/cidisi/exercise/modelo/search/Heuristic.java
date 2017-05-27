package frsf.cidisi.exercise.modelo.search;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

/**
 * This class allows to define a function to be used by any
 * informed search strategy, like A Star or Greedy.
 */
public class Heuristic implements IEstimatedCostFunction {

    /**
     * It returns the estimated cost to reach the goal from a NTree node.
     */
    @Override
    public double getEstimatedCost(NTree node) {
        EstadoPatrullero agState = (EstadoPatrullero) node.getAgentState();
	
		//función heuristica será el camino mínimo al nodo destindo, es decir a la alerta, multiplicado por el costo de transitar una calle libre
        //así se garantiza no sobrestimar el costo real
        return agState.getMapa().getCostoMinimo(agState.getposicionAgente(), agState.getposicionAlerta()) * 1;
    }
}
