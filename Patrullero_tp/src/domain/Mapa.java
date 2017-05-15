package domain;

import java.util.ArrayList;
import java.util.List;

import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;

public class Mapa {
	
	DirectedGraph<Esquina, Calle> g;
	
	public Mapa(){
		this.Crear();
	}
	
	public void Crear() {
		g = new DirectedSparseMultigraph<Esquina, Calle>();
		
		Calle gp68 = new Calle("General Paz", 6800, false, false);
		Calle gp67 = new Calle("General Paz", 6700, false, false);
		Calle gp66 = new Calle("General Paz", 6600, false, false);
		Calle gp65 = new Calle("General Paz", 6500, false, false);
		Calle gp64 = new Calle("General Paz", 6400, false, false);
		Calle gp63 = new Calle("General Paz", 6300, false, false);
		Calle gp62 = new Calle("General Paz", 6200, false, false);
		Calle gp61 = new Calle("General Paz", 6100, false, false);
		Calle gp60 = new Calle("General Paz", 6000, false, false);
		Calle gp59 = new Calle("General Paz", 5900, false, false);
		Calle gp58 = new Calle("General Paz", 5800, false, false);
		Calle gp57 = new Calle("General Paz", 5700, false, false);
		Calle gp56 = new Calle("General Paz", 5600, false, false);
		Calle gp55 = new Calle("General Paz", 5500, false, false);
		Calle gp54 = new Calle("General Paz", 5400, false, false);
		
		Calle SC14 = new Calle("Salvador del Carril", 1400, false, false);
		Calle SC13 = new Calle("Salvador del Carril", 1300, false, false);
		Calle SC12 = new Calle("Salvador del Carril", 1200, false, false);
		Calle SC11 = new Calle("Salvador del Carril", 1100, false, false);
		Calle SC10 = new Calle("Salvador del Carril", 1000, false, false);
		Calle SC9 = new Calle("Salvador del Carril", 900, false, false);
		Calle SC8 = new Calle("Salvador del Carril", 800, false, false);

		Calle OB9 = new Calle("Obispo Boneo", 900, false, false);
		Calle OB8 = new Calle("Obispo Boneo", 800, false, false);
		Calle OB7 = new Calle("Obispo Boneo", 700, false, false);
		Calle OB6 = new Calle("Obispo Boneo", 600, false, false);
		Calle OB5 = new Calle("Obispo Boneo", 500, false, false);
		Calle OB4 = new Calle("Obispo Boneo", 400, false, false);
		Calle OB3 = new Calle("Obispo Boneo", 300, false, false);
		Calle OB2 = new Calle("Obispo Boneo", 200, false, false);
		Calle OB1 = new Calle("Obispo Boneo", 100, false, false);
		
		Calle AB54 = new Calle("Almirante Brown", 5400, false, false);
		Calle AB55 = new Calle("Almirante Brown", 5500, false, false);
		Calle AB56 = new Calle("Almirante Brown", 5600, false, false);
		Calle AB57 = new Calle("Almirante Brown", 5700, false, false);
		Calle AB58 = new Calle("Almirante Brown", 5800, false, false);
		Calle AB59 = new Calle("Almirante Brown", 5900, false, false);
		Calle AB60 = new Calle("Almirante Brown", 6000, false, false);
		Calle AB61 = new Calle("Almirante Brown", 6100, false, false);
		Calle AB62 = new Calle("Almirante Brown", 6200, false, false);
		Calle AB63 = new Calle("Almirante Brown", 6300, false, false);
		Calle AB64 = new Calle("Almirante Brown", 6400, false, false);
		Calle AB65 = new Calle("Almirante Brown", 6500, false, false);
		Calle AB66 = new Calle("Almirante Brown", 6600, false, false);
		Calle AB67 = new Calle("Almirante Brown", 6700, false, false);
		Calle AB68 = new Calle("Almirante Brown", 6800, false, false);
		
		Calle VS54 = new Calle("Velez Sarsfield", 5400, false, false);
		Calle VS55 = new Calle("Velez Sarsfield", 5500, false, false);
		Calle VS56 = new Calle("Velez Sarsfield", 5600, false, false);
		Calle VS57 = new Calle("Velez Sarsfield", 5700, false, false);
		Calle VS58 = new Calle("Velez Sarsfield", 5800, false, false);
		Calle VS59 = new Calle("Velez Sarsfield", 5900, false, false);
		Calle VS60 = new Calle("Velez Sarsfield", 6000, false, false);
		Calle VS61 = new Calle("Velez Sarsfield", 6100, false, false);
		Calle VS62 = new Calle("Velez Sarsfield", 6200, false, false);
		Calle VS63 = new Calle("Velez Sarsfield", 6300, false, false);
		Calle VS64 = new Calle("Velez Sarsfield", 6400, false, false);
		Calle VS65 = new Calle("Velez Sarsfield", 6500, false, false);
		Calle VS66 = new Calle("Velez Sarsfield", 6600, false, false);
		Calle VS67 = new Calle("Velez Sarsfield", 6700, false, false);
		
		Calle Ta54 = new Calle("Tacuari", 5400, false, false);
		Calle Ta55 = new Calle("Tacuari", 5500, false, false);
		Calle Ta56 = new Calle("Tacuari", 5600, false, false);
		Calle Ta57 = new Calle("Tacuari", 5700, false, false);
		Calle Ta58 = new Calle("Tacuari", 5800, false, false);
		Calle Ta59 = new Calle("Tacuari", 5900, false, false);
		Calle Ta60 = new Calle("Tacuari", 6000, false, false);
		Calle Ta61 = new Calle("Tacuari", 6100, false, false);
		Calle Ta62 = new Calle("Tacuari", 6200, false, false);
		Calle Ta63 = new Calle("Tacuari", 6300, false, false);
		Calle Ta64 = new Calle("Tacuari", 6400, false, false);
		Calle Ta65 = new Calle("Tacuari", 6500, false, false);
		Calle Ta66 = new Calle("Tacuari", 6600, false, false);
		Calle Ta67 = new Calle("Tacuari", 6700, false, false);
		Calle Ta68 = new Calle("Tacuari", 6800, false, false);
		
		Calle Pi57 = new Calle("Piedras", 5700, false, false);
		Calle Pi58 = new Calle("Piedras", 5800, false, false);
		Calle Pi59 = new Calle("Piedras", 5900, false, false);
		Calle Pi60 = new Calle("Piedras", 6000, false, false);
		Calle Pi61 = new Calle("Piedras", 6100, false, false);
		Calle Pi62 = new Calle("Piedras", 6200, false, false);
		Calle Pi63 = new Calle("Piedras", 6300, false, false);
		Calle Pi64 = new Calle("Piedras", 6400, false, false);
		Calle Pi65 = new Calle("Piedras", 6500, false, false);
		Calle Pi66 = new Calle("Piedras", 6600, false, false);
		Calle Pi67 = new Calle("Piedras", 6700, false, false);
		Calle Pi68 = new Calle("Piedras", 6800, false, false);
		
				
		Esquina e1 = new Esquina("e1");
		Esquina e2 = new Esquina("e2");
		Esquina e3 = new Esquina("e3");
		
		g.addVertex(e1);
		g.addVertex(e2);
		g.addVertex(e3);
		
		
		
		g.addEdge(c1, e1, e2);
		g.addEdge(c2, e2, e3);
		g.addEdge(c3, e3, e1);
		
		System.out.println("Sucesores"+g.getSuccessors(e2));
		
		System.out.println("Grafo"+g.toString());
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
	
	public List<Esquina> getAdyacentes(Esquina esquina){
		return (List<Esquina>) g.getSuccessors(esquina);
	}
}
