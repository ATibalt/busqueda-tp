package domain;

import java.util.ArrayList;
import java.util.List;

import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;

public class Mapa {
	
	public void Crear() {
		DirectedGraph<Esquina, Calle> g = new DirectedSparseMultigraph<Esquina, Calle>();
		
		Esquina e1 = new Esquina("e1");
		Esquina e2 = new Esquina("e2");
		Esquina e3 = new Esquina("e3");
		
		g.addVertex(e1);
		g.addVertex(e2);
		g.addVertex(e3);
		
		Calle c1 = new Calle("c1");
		Calle c2 = new Calle("c2");
		Calle c3 = new Calle("c3");
		
		g.addEdge(c1, e1, e2);
		g.addEdge(c2, e2, e3);
		g.addEdge(c3, e3, e1);
		
		System.out.println(g.getSuccessors(e2));
		
		System.out.println(g.toString());
	}
	
	public List<Calle> getCallesCortadas(){
		List<Calle> callesCortadas = new ArrayList<Calle>();
		
		return callesCortadas;
	}
	
	public List<Calle> getCallesCongestionadas(){
		List<Calle> callesCongestionadas = new ArrayList<Calle>();
		
		return callesCongestionadas;
	}

	public Esquina getAlerta(){
		Esquina alerta = null;
		
		return alerta;		
	}
	
	public Esquina getPosicionAgente(){
		Esquina posAgente = null;
		
		return posAgente;		
	}
}
