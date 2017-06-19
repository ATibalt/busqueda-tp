/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesTp;

import frsf.cidici.faia.simulator.KnowledgeBasedAgentSimulator;

/**
 *
 * @author USUARIO
 */
public class Main {
    public static void main(String[] args){
        Ambiente ambiente = new Ambiente(new EstadoAmbiente());
        Agente agente = new Agente();

        //TODO: input de prueba, borrar luego
        String input = "Entregame toda la plata!";
        ambiente.setPercept(input);

        KnowledgeBasedAgentSimulator simulador = new KnowledgeBasedAgentSimulator(ambiente, agente);
        simulador.start();
    }
}
