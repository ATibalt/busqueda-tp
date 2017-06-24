/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesTp;

import frsf.cidici.faia.solver.productionsystem.Rule;
import java.util.List;

public class Regla extends Rule {

    @Override
    public boolean isActive(Object status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Regla (List<String> condicion, String then){
        super();
        this.setCondition(condicion);
        this.setThen(then);
    }

    public boolean contiene(List<String> oracion) {
        int cantidadEncontrada=0;
        List<String> condicion = (List<String>)this.getCondition();

        if(condicion.size() != oracion.size()){
            return false;
        }

        for(int i = 0; i < condicion.size(); i++ ){
            if(condicion.get(i).toLowerCase().equals(oracion.get(i).toLowerCase())){
                cantidadEncontrada++;
            }
        }
        return  cantidadEncontrada == condicion.size();
    }
    
    
}
