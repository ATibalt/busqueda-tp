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
	
		//Method: Complete Method
		//TODO: realizar una función heuristica que calcule el costo hasta el destino (minima cantidad de aristas para llegar al destino).
        //ver las aristas entre la posicion actual y el destino y determinar si se puede llegar y dar el costo 
        return 0;
    }
}
