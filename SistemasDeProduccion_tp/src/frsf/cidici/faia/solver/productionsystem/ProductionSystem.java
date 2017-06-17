package frsf.cidici.faia.solver.productionsystem;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.solver.Solve;
import procesamiento.Lista;
import procesamiento.Nodo;
import tp.Datos;
import tp.Regla;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa el solver del sistema de producci�n.
 * @author Grupo 12: Blas,Mar�a Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class ProductionSystem extends Solve{

	//TODO Futuro: Agregar la MI, MP y MT.
	private List<Criteria> criteria= new ArrayList<>();
        public static List<Rule> used = new ArrayList<>();
        private Lista memoriaTrabajo;
        public static List<Regla> memoriaProduccion= Datos.cargarDatos();
        
        
	
        
	
	/**
	 * Constructor.
	 * Recibe las estrategias en el orden a ser aplicadas.
     * @param s
	 */
	public ProductionSystem(List<Criteria> s){
		criteria = s;
	}
	
	@Override
	public void showSolution() {
	}

	@Override
	public Action solve(Object[] params) throws Exception {

            Rule reglaSeleccionada;

            memoriaTrabajo= (Lista) params[0];


            //Se obtienen las reglas activas
            List<Regla> activeRules = this.match();

            //Si no hay reglas activas se termina.
            if(activeRules.isEmpty())
                activeRules= Datos.getRestoEstimulos();
                
            
            System.out.println("Reglas activas:");
             for(Regla reglaIterada : activeRules)
                    {
                            System.out.print("(" + reglaIterada.getId() + ") ");
                    }
                    //Se resuelven los conflictos.
            for(Criteria actualCriteria: criteria){
                if(activeRules.size()==1) break;
                System.out.println("\nCriterio:" + actualCriteria.toString());
                List<Regla> finalRules = actualCriteria.apply(activeRules);
                if(finalRules.size()==0) 
                    System.out.print("No hay reglas en Conflicto");
                else{
                    System.out.print("Reglas en Conflicto: ");
                    for(Regla reglaIterada : finalRules)
                    {
                            System.out.print("(" + reglaIterada.getId() + ") ");
                    }
                    activeRules = finalRules;
                }
            }

            //Se obtiene la regla elegida.
            reglaSeleccionada = activeRules.get(0);

            //Se ejecuta la regla.
            this.ejecutar(reglaSeleccionada);



            return new ProductionSystemAction(reglaSeleccionada);
		
	}
	
	protected List<Regla> match(){
            List<Regla> retorno = new ArrayList<>();
		for(Regla reglaIterada: memoriaProduccion){
                    if(reglaIterada.contiene(memoriaTrabajo)){
                        if(reglaIterada.getId()>=4.0 && reglaIterada.getId()<5.0){
                            for(Nodo nodoIterado: memoriaTrabajo.getLista()){
                                if(nodoIterado.getClave().equals("materiadetectada")){
                                    if(Datos.getMateriaRendir(nodoIterado.getPalabra().getPalabra())==null){
                                        if(reglaIterada.getId()==4.1)
                                            retorno.add(reglaIterada);
                                    }
                                    else retorno.add(reglaIterada);
                                }
                            }
                        }
                        else retorno.add(reglaIterada);
                         
                        
                    }
                }
                
		return retorno;
	}
	
	protected void ejecutar(Rule r){
            used.add(r);
		
	}

    private static List<Regla> cargarReglas() {
        
        /*List<Regla> retorno = new ArrayList<>();
        List<String> listaCondicion= new ArrayList<>();
        
        listaCondicion.add("hola");
        Regla regla1= new Regla(listaCondicion,"Buenas");
        regla1.setId(1);
        retorno.add(regla1);
        
     
        Regla regla2= new Regla(listaCondicion,"Hola");
        regla2.setId(2);
        retorno.add(regla2);*/
        
        
        return null;
        
        
    }

}
