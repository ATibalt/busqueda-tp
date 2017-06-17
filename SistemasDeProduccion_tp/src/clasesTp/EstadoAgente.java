/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesTp;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.state.AgentState;
import procesamiento.Lista;
import procesamiento.Preprocesamiento;

/**
 *
 * @author USUARIO
 */
public class EstadoAgente extends AgentState{
    
    private Lista oracionPreprocesada;

    @Override
    public void updateState(Perception p) {
        Percepcion perception = (Percepcion)p;
        oracionPreprocesada= Preprocesamiento.start(perception.getInput());
    }

    @Override
    public String toString() {
        return "Oracion preprocesada: "+ oracionPreprocesada.toString(); 
    }

    @Override
    public void initState() {
        //TODO
    }

    public Lista getOracionPreprocesada() {
        return oracionPreprocesada;
    }
    
}
