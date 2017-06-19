/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesTp;

import frsf.cidici.faia.solver.productionsystem.*;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class Agente extends Agent{

    EstadoAgente estado;
    ProductionSystem maquinaInferencia;
            
    public Agente(){
        LinkedList<Criteria> criterios = new LinkedList<>();
        //Creacion del criterio Especificidad
        criterios.add(new Specificity());
        //Creacion del criterio No duplicacion
        criterios.add(new NoDuplication());
        //Creacion del criterio Prioridad
        criterios.add(new Priority());
        //Creacion del criterio Novedad
        criterios.add(new Novelty());
        //Creacion del criterio Aleatorio
        criterios.add(new Random());
        estado= new EstadoAgente();
        maquinaInferencia= new ProductionSystem(criterios);
    }        
    
    @Override
    public Action selectAction() {
        //TODO
        return null;
    }

    public void see(Perception perception) {
        estado.updateState(perception);
    }

    public EstadoAgente getAgentState() {
        return estado;
    }

    public void setAgentState(EstadoAgente estado) {
        this.estado = estado;
    }

    public Action learn() throws Exception {
        String[] arregloLista = estado.getOracionPreprocesada();
        return maquinaInferencia.solve(arregloLista);
        
    }

    
    
}
