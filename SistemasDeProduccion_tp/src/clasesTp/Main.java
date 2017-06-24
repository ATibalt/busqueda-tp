/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesTp;

import frsf.cidici.faia.simulator.KnowledgeBasedAgentSimulator;
import frsf.cidici.faia.solver.productionsystem.ProductionSystem;
import interfaz.InterfazChat;
import javafx.concurrent.Task;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 *
 * @author USUARIO
 */
public class Main {
    public static void main(String[] args){
        Ambiente ambiente = new Ambiente(new EstadoAmbiente());
        Agente agente = new Agente();
        KnowledgeBasedAgentSimulator simulador = new KnowledgeBasedAgentSimulator(ambiente, agente);

        new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(InterfazChat.class);
            }
        }.start();
        InterfazChat mainInterfaz = InterfazChat.waitForMainInterfaz();

        Consumer<String> runSimulator = input -> {
            ambiente.setPercept(input);
            simulador.start();
        };

        mainInterfaz.setSimulator(runSimulator);
        mainInterfaz.setPrintAllSetter(setter -> {
            simulador.setPrintAll(setter);
            ProductionSystem.setPrintAll(setter);
        });
        mainInterfaz.setPrintThenSetter(setter -> {
            simulador.setPrintThen(setter);
            ProductionSystem.setPrintThen(setter);
        });
    }
}
