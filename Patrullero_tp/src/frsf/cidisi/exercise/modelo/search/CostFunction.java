package frsf.cidisi.exercise.modelo.search;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;
import frsf.cidisi.faia.state.AgentState;

/**
 * This class can be used in any search strategy like
 * Uniform Cost.
 */
public class CostFunction implements IStepCostFunction {
	
    /**
     * This method calculates the cost of the given NTree node.
     */
    @Override
    public double calculateCost(NTree node) {
        
        //TODO: Complete Method
        //node posee como atributo el estado, el cuál tiene el costo asociado
        return ((EstadoPatrullero)node.getAgentState()).getCosto();
    }
}
