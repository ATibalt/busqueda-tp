

package frsf.cidisi.exercise.modelo.search;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoPatrullero extends GoalTest {

    @Override
    public boolean isGoalState (AgentState agentState) {
    	EstadoPatrullero estadoPatrullero = (EstadoPatrullero) agentState;
    	
        if  (estadoPatrullero.getposicionAgente().equals(estadoPatrullero.getposicionAlerta())) //( posicionAgente == posicionAlerta)
        	{
            return true;
        	}
        return false;
	}
}