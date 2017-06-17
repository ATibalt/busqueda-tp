/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesTp;

import frsf.cidici.faia.solver.productionsystem.Rule;
import procesamiento.Lista;
import procesamiento.Nodo;

import java.util.List;

/**
 *
 * @author USUARIO
 */
public class Regla extends Rule {

    @Override
    public boolean isActive(Object status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Regla (List<String> condicion, String then){
        super();
        this.setCondition(condicion);
        this.setThen(then);
        //TODO setear los ids y toodo eso
    }

    public boolean contiene(Lista lista) {
        int cantidadEncontrada=0;
        for(Nodo nodoIterado: lista.getLista()){
            for(String condicionIterada: (List<String>)this.getCondition()){
                if(condicionIterada.equals(nodoIterado.getClave()))
                    cantidadEncontrada++;
            }
        }
        return  cantidadEncontrada== ((List<String>)this.getCondition()).size();
       
    
    }
    
    
}