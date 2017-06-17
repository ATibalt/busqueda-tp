package frsf.cidici.faia.solver.productionsystem;

import tp.Regla;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa el criterio de especificidad.
 * @author Grupo 12: Blas,Mar�a Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class Specificity extends Criteria {

	@Override
	public List<Regla> apply(List<Regla> listaReglasCandidatas) {
		
            int specifity, mayor = 0;	
            List<Regla> retorno = new ArrayList<>();
            for(Regla reglaIterada: listaReglasCandidatas)
            { 
                specifity = ((List<String>)reglaIterada.getCondition()).size();
                if(specifity > mayor){
                    retorno = new ArrayList<>();
                    retorno.add(reglaIterada);
                    mayor = specifity;
                }
                else if(specifity== mayor){
                    retorno.add(reglaIterada);
                }
            }
            	
            return retorno;

	}

	@Override
	public String toString() {
		return "Specificity (Especificidad)";
	}

}
