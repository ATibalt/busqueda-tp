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
import procesamiento.Lista;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class Agente extends Agent{

    EstadoAgente estado;
    ProductionSystem maquinaInferencia;
            
    public Agente(){
        List<Criteria> criterios = new ArrayList<>();
        criterios.add(new Specificity());
        criterios.add(new NoDuplication());
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
        Lista[] arregloLista = {estado.getOracionPreprocesada()};
        return maquinaInferencia.solve(arregloLista);
        
    }

    
    
}
