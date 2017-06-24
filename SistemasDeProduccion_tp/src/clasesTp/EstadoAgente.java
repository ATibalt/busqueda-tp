/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesTp;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.state.AgentState;

import java.util.Arrays;

public class EstadoAgente extends AgentState{
    
    private String[] oracionPreprocesada;

    @Override
    public void updateState(Perception p) {
        Percepcion perception = (Percepcion)p;
        oracionPreprocesada= Procesamiento.start(perception.getInput());
    }

    @Override
    public String toString() {
        return "Oracion preprocesada: "+ Arrays.toString(oracionPreprocesada);
    }

    @Override
    public void initState() {
        //TODO
    }

    public String[] getOracionPreprocesada() {
        return oracionPreprocesada;
    }
    
}
