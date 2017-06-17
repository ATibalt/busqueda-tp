package frsf.cidici.faia.solver.productionsystem;

import clasesTp.Regla;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa el criterio de no duplicacion.
 * @author Grupo 12: Blas,Mar�a Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class NoDuplication extends Criteria {
	
	@Override
	public List<Regla> apply(List<Regla> listaReglasCandidatas) {
	
            List<Regla> ret = new ArrayList<>();
			
		
            for(Regla reglaIterada: listaReglasCandidatas){
    		if(!used(reglaIterada))
                    ret.add(reglaIterada);
            }
            if(ret.isEmpty()){
                ProductionSystem.used.removeAll(listaReglasCandidatas);
                return listaReglasCandidatas;
            }    
            return ret;	
		
	}

	@Override
	public String toString() {	
		return "No Duplication (No duplicación)";
	}

	private boolean used(Rule r){
            for(Rule usada: ProductionSystem.used){
                if (usada.equals(r))
                    return true;
            }
            return false;
        
	}
}
