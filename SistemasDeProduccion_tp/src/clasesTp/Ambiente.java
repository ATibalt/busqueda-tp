/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesTp;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

/**
 *
 * @author USUARIO
 */
public class Ambiente extends Environment {
    public Ambiente(EstadoAmbiente estado){
        super();
        this.setEnvironmentState(estado);
    }
    @Override
    public Perception getPercept() {
        Percepcion percepcion = new Percepcion();
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            perception.setInput(br.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Ambiente.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        percepcion.setInput(((EstadoAmbiente)getEnvironmentState()).getinput());
        //((EstadoAmbiente) getEnvironmentState()).setinput("chau");
        return percepcion;
    }
    
    public void setPercept(String input){
        ((EstadoAmbiente) getEnvironmentState()).setinput(input);
    }
    
    public String toString(){
        return this.getEnvironmentState().toString();
    }
    
}
