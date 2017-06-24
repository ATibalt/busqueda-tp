package frsf.cidici.faia.solver.productionsystem;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.solver.Solve;
import clasesTp.Datos;
import clasesTp.Regla;

import java.util.*;

/**
 * Clase que implementa el solver del sistema de producci�n.
 * @author Grupo 12: Blas,Mar�a Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class ProductionSystem extends Solve{

	//TODO Futuro: Agregar la MI, MP y MT.
    private LinkedList<Criteria> criteria;
    public static LinkedList<PeerRuleData> used = new LinkedList<PeerRuleData>();
    //oración ya procesada, es decir, las palabras claves (antecedentes de una regla)
    private String[] oracionProcesada = {};

    public static List<Regla> memoriaProduccion= Datos.cargarDatos();

	/**
	 * Constructor.
	 * Recibe las estrategias en el orden a ser aplicadas.
     * @param s
	 */
	public ProductionSystem(LinkedList<Criteria> s){
		criteria = s;
	}
	
	@Override
	public void showSolution() {
	}

	@Override
	public Action solve(Object[] params) throws Exception {

            PeerRuleData reglaSeleccionada;

            oracionProcesada = (String[]) params;

            //Se obtienen las reglas activas
            LinkedList<PeerRuleData> activeRules = this.match();

            //Si no hay reglas activas se termina.
            if(activeRules.isEmpty())
                //TODO: cambiar, se retornan reglas tipo Entrada incorrecta, o no se puede procesar la frase
                //activeRules= Datos.getRestoEstimulos();
                return null;
            
            System.out.println("Reglas activas:");
             for(PeerRuleData reglaIterada : activeRules)
                    {
                            System.out.print("(" + reglaIterada.getRule().getId() + ") ");
                    }
            //Se resuelven los conflictos.
            for(Iterator<Criteria> i = criteria.iterator(); i.hasNext();)
            {
                Criteria actualCriteria = i.next();
                System.out.println("\nCriterio:" + actualCriteria.toString());
                LinkedList<PeerRuleData> finalRules = actualCriteria.apply(activeRules);
                if(finalRules.size()==0) System.out.print("Reglas en Conflicto: -");
                else
                {
                    System.out.print("Reglas en Conflicto: ");
                    for(Iterator<PeerRuleData> j = finalRules.iterator(); j.hasNext();)
                    {
                        System.out.print("(" + j.next().getRule().getId().toString() + ") ");
                    }
                    activeRules = finalRules;
                    if(activeRules.size()==1) break;
                }
            }

            //Se obtiene la regla elegida.
            reglaSeleccionada = activeRules.getFirst();

            //Se ejecuta la regla.
            this.ejecutar(reglaSeleccionada);

            return new ProductionSystemAction(reglaSeleccionada);
		
	}
	
	protected LinkedList<PeerRuleData> match(){
        LinkedList<PeerRuleData> reglasRetorno = new LinkedList<PeerRuleData>();
        List<String> oracionList = new ArrayList<String>(Arrays.asList(this.oracionProcesada));

        for(Regla regla : memoriaProduccion) {
            if (regla.contiene(oracionList)) {
                PeerRuleData parReglaDato = new PeerRuleData(regla, oracionList);
                reglasRetorno.add(parReglaDato);
            }
        }
		return reglasRetorno;
	}
	
	protected void ejecutar(PeerRuleData r){
            used.add(r);
	}
}
