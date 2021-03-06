package domain;

import java.util.ArrayList;
import java.util.List;

import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;

public class Mapa {

	private DirectedGraph<Esquina, Calle> g;
	private Esquina posicionAgente;
	private Esquina posicionAlerta;
	private List<Calle> callesCortadas;
	private List<Calle> callesCongestionadas;
	
	public Mapa() {
		this.Crear();
		this.callesCortadas = new ArrayList<Calle>();
		this.callesCongestionadas = new ArrayList<Calle>();
		
		for(Calle calle : g.getEdges()){
			if(calle.cortada){
				this.callesCortadas.add(calle);
			}
			if(calle.congestionada){
				this.callesCongestionadas.add(calle);
			}
		}
	}

	public Esquina getPosicionAgente() {
		return posicionAgente;
	}

	public void setPosicionAgente(Esquina posicionAgente) {
		this.posicionAgente = posicionAgente;
	}

	public Esquina getPosicionAlerta() {
		return posicionAlerta;
	}

	public void setPosicionAlerta(Esquina posicionAlerta) {
		this.posicionAlerta = posicionAlerta;
	}

	public List<Calle> getCallesCortadas() {
		return callesCortadas;
	}

	public void setCallesCortadas(List<Calle> callesCortadas) {
		this.callesCortadas = callesCortadas;
	}

	public List<Calle> getCallesCongestionadas() {
		return callesCongestionadas;
	}

	public void setCallesCongestionadas(List<Calle> callesCongestionadas) {
		this.callesCongestionadas = callesCongestionadas;
	}

	public DirectedGraph<Esquina, Calle> getGrafo() {
		return g;
	}

	public void setGrafo(DirectedGraph<Esquina, Calle> g) {
		this.g = g;
	}
	
	public List<Esquina> getAdyacentes(Esquina esquina) {
		List<Esquina> esquinas = new ArrayList<Esquina>(g.getVertices());
		for(Esquina esq : esquinas){
			if(esq.equals(esquina))
				return new ArrayList<Esquina>(g.getSuccessors(esq));
		}
		return new ArrayList<Esquina>();
	}

	public Calle getCalleEntreEsquinas(Esquina esquina1Aux, Esquina esquina2Aux) throws Exception {
		
		Esquina esquina1 = new Esquina();
		Esquina esquina2 = new Esquina();
		
		List<Esquina> esquinas = new ArrayList<Esquina>(g.getVertices());
		for(Esquina esq : esquinas){
			if(esq.equals(esquina1Aux)){
				esquina1 = esq;
			}
			if	(esq.equals(esquina2Aux)){
				esquina2 = esq;
			}
		}
		
		Calle calleEntreEsquinas = g.findEdge(esquina1, esquina2);
		
		if(calleEntreEsquinas == null)
			throw new Exception("No existe calle entre las esquinas "+esquina1Aux+" y "+esquina2Aux);
		
		return calleEntreEsquinas;
	}

	public int getCostoMinimo(Esquina esquina1Aux, Esquina esquina2Aux) {
		Esquina esquina1 = new Esquina();
		Esquina esquina2 = new Esquina();
		
		List<Esquina> esquinas = new ArrayList<Esquina>(g.getVertices());
		for(Esquina esq : esquinas){
			if(esq.equals(esquina1Aux)){
				esquina1 = esq;
			}
			if(esq.equals(esquina2Aux)){
				esquina2 = esq;
			}
		}
		
		DijkstraShortestPath<Esquina, Calle> alg = new DijkstraShortestPath<Esquina, Calle>(g);
		List<Calle> l = alg.getPath(esquina1, esquina2);
		return l.size();
	}

	public Esquina getEsquinaExistente(Esquina e) {
		List<Esquina> esquinas = new ArrayList<Esquina>(g.getVertices());
		for(Esquina esq : esquinas){
			if(esq.equals(e)){
				return esq;
			}
		}
		return null;
	}

	public Calle getCalleExistente(Calle c) {
		List<Calle> calles = new ArrayList<>(g.getEdges());
		for(Calle calle : calles) {
			if(calle.equals(c)){
				return calle;
			}
		}
		return null;
	}

	public List<Calle> getCalles() {
		List<Calle> calles = new ArrayList<>();
		calles.addAll(g.getEdges());
		return calles;
	}

	public List<Esquina> getEsquinasDeCalle(Calle calle) {
		return new ArrayList<>(g.getIncidentVertices(calle));
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
		Calle gp615 = new Calle("General Paz", 6150, false, false);
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
		
		Calle AB56 = new Calle("Almirante Brown", 5600, false, false);
		Calle AB57 = new Calle("Almirante Brown", 5700, false, false);
		Calle AB58 = new Calle("Almirante Brown", 5800, false, false);
		Calle AB59 = new Calle("Almirante Brown", 5900, false, false);
		Calle AB60 = new Calle("Almirante Brown", 6000, false, false);
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
		Calle VS595 = new Calle("Velez Sarsfield", 5950, false, false);
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
		Calle Ta595 = new Calle("Tacuari", 5950, false, false);
		Calle Ta60 = new Calle("Tacuari", 6000, false, false);
		Calle Ta61 = new Calle("Tacuari", 6100, false, false);
		Calle Ta615 = new Calle("Tacuari", 6150, false, false);
		Calle Ta62 = new Calle("Tacuari", 6200, false, false);
		Calle Ta63 = new Calle("Tacuari", 6300, false, false);
		Calle Ta64 = new Calle("Tacuari", 6400, false, false);
		Calle Ta65 = new Calle("Tacuari", 6500, false, false);
		Calle Ta655 = new Calle("Tacuari", 6550, false, false);
		Calle Ta66 = new Calle("Tacuari", 6600, false, false);
		Calle Ta67 = new Calle("Tacuari", 6700, false, false);
		Calle Ta68 = new Calle("Tacuari", 6800, false, false);

		Calle Pi57 = new Calle("Piedras", 5700, false, false);
		Calle Pi58 = new Calle("Piedras", 5800, false, false);
		Calle Pi59 = new Calle("Piedras", 5900, false, false);
		Calle Pi595 = new Calle("Piedras", 5950, false, false);
		Calle Pi60 = new Calle("Piedras", 6000, false, false);
		Calle Pi61 = new Calle("Piedras", 6100, false, false);
		Calle Pi615 = new Calle("Piedras", 6150, false, false);
		Calle Pi62 = new Calle("Piedras", 6200, false, false);
		Calle Pi63 = new Calle("Piedras", 6300, false, false);
		Calle Pi64 = new Calle("Piedras", 6400, false, false);
		Calle Pi65 = new Calle("Piedras", 6500, false, false);
		Calle Pi655 = new Calle("Piedras", 6550, false, false);
		Calle Pi66 = new Calle("Piedras", 6600, false, false);
		Calle Pi67 = new Calle("Piedras", 6700, false, false);
		Calle Pi68 = new Calle("Piedras", 6800, false, false);

		Calle AG59 = new Calle("A Godoy", 5900, false, false);
		Calle AG595 = new Calle("A Godoy", 5950, false, false);
		Calle AG60 = new Calle("A Godoy", 6000, false, false);
		Calle AG61 = new Calle("A Godoy", 6100, false, false);
		Calle AG615 = new Calle("A Godoy", 6150, false, false);
		Calle AG62 = new Calle("A Godoy", 6200, false, false);
		Calle AG63 = new Calle("A Godoy", 6300, false, false);
		Calle AG64 = new Calle("A Godoy", 6400, false, false);
		Calle AG65 = new Calle("A Godoy", 6500, false, false);
		Calle AG655 = new Calle("A Godoy", 6550, false, false);
		Calle AG66 = new Calle("A Godoy", 6600, false, false);
		Calle AG67 = new Calle("A Godoy", 6700, false, false);
		Calle AG68 = new Calle("A Godoy", 6800, false, false);

		Calle Cu60 = new Calle("Cullen", 6000, false, false);
		Calle Cu62 = new Calle("Cullen", 6200, false, false);
		Calle Cu63 = new Calle("Cullen", 6300, false, false);
		Calle Cu64 = new Calle("Cullen", 6400, false, false);
		Calle Cu65 = new Calle("Cullen", 6500, false, false);
		Calle Cu655 = new Calle("Cullen", 6550, false, false);
		Calle Cu66 = new Calle("Cullen", 6600, false, false);
		Calle Cu67 = new Calle("Cullen", 6700, false, false);
		Calle Cu68 = new Calle("Cullen", 6800, false, false);

		Calle Ec62 = new Calle("Echague", 6200, false, false);
		Calle Ec63 = new Calle("Echague", 6300, false, false);
		Calle Ec64 = new Calle("Echague", 6400, false, false);
		Calle Ec65 = new Calle("Echague", 6500, false, false);
		Calle Ec655 = new Calle("Echague", 6550, false, false);
		Calle Ec66 = new Calle("Echague", 6600, false, false);
		Calle Ec67 = new Calle("Echague", 6700, false, false);
		Calle Ec68 = new Calle("Echague", 6800, false, false);

		Calle To64 = new Calle("Talcahuano", 6400, false, false);
		Calle To65 = new Calle("Talcahuano", 6500, false, false);
		Calle To66 = new Calle("Talcahuano", 6600, false, false);
		Calle To67 = new Calle("Talcahuano", 6700, false, false);
		Calle To68 = new Calle("Talcahuano", 6800, false, false);

		Calle De65 = new Calle("Defensa", 6500, false, false);
		Calle De66 = new Calle("Defensa", 6600, false, false);
		Calle De67 = new Calle("Defensa", 6700, false, false);
		Calle De68 = new Calle("Defensa", 6800, false, false);

		Calle Ri66 = new Calle("Riobamba", 6600, false, false);
		Calle Ri67 = new Calle("Riobamba", 6700, false, false);
		Calle Ri68 = new Calle("Riobamba", 6800, false, false);

		Calle PP54 = new Calle("Pasaje Pizzorino", 5400, false, false);
		Calle PP55 = new Calle("Pasaje Pizzorino", 5500, false, false);
		Calle PP56 = new Calle("Pasaje Pizzorino", 5600, false, false);
		Calle PP57 = new Calle("Pasaje Pizzorino", 5700, false, false);
		
		Calle CP61 = new Calle("Calle Pizzorino", 6100, false, false);
		
		Calle PA58 = new Calle("Pasaje Arzamendia", 5800, false, false);
		Calle PA59 = new Calle("Pasaje Arzamendia", 5900, false, false);

		Calle Do54 = new Calle("Dorrego", 5400, false, false);
		Calle Do55 = new Calle("Dorrego", 5500, false, false);
		Calle Do56 = new Calle("Dorrego", 5600, false, false);
		Calle Do57 = new Calle("Dorrego", 5700, false, false);
		Calle Do58 = new Calle("Dorrego", 5800, false, false);
		Calle Do59 = new Calle("Dorrego", 5900, false, false);
		Calle Do60 = new Calle("Dorrego", 6000, false, false);
		Calle Do605 = new Calle("Dorrego", 6050, false, false);
		Calle Do61 = new Calle("Dorrego", 6100, false, false);
		Calle Do62 = new Calle("Dorrego", 6200, false, false);
		Calle Do63 = new Calle("Dorrego", 6300, false, false);

		Calle Av54 = new Calle("Avellaneda", 5400, false, false);
		Calle Av55 = new Calle("Avellaneda", 5500, false, false);
		Calle Av56 = new Calle("Avellaneda", 5600, false, false);
		Calle Av57 = new Calle("Avellaneda", 5700, false, false);
		Calle Av58 = new Calle("Avellaneda", 5800, false, false);
		Calle Av59 = new Calle("Avellaneda", 5900, false, false);
		Calle Av60 = new Calle("Avellaneda", 6000, false, false);

		Calle Gu54 = new Calle("Guemes", 5400, false, false);
		Calle Gu55 = new Calle("Guemes", 5500, false, false);
		Calle Gu56 = new Calle("Guemes", 5600, false, false);
		Calle Gu57 = new Calle("Guemes", 5700, false, false);

		Calle La54 = new Calle("Lavalle", 5400, false, false);
		Calle La55 = new Calle("Lavalle", 5500, false, false);
		
		Calle EZ1 = new Calle("Estanislao Zeballos", 100, false, false);
		Calle EZ2 = new Calle("Estanislao Zeballos", 200, false, false);
		Calle EZ3 = new Calle("Estanislao Zeballos", 300, false, false);
		Calle EZ4 = new Calle("Estanislao Zeballos", 400, false, false);
		Calle EZ5 = new Calle("Estanislao Zeballos", 500, false, false);
		Calle EZ6 = new Calle("Estanislao Zeballos", 600, false, false);
		Calle EZ7 = new Calle("Estanislao Zeballos", 700, false, false);
		Calle EZ8 = new Calle("Estanislao Zeballos", 800, false, false);
		Calle EZ9 = new Calle("Estanislao Zeballos", 900, false, false);
		Calle EZ10 = new Calle("Estanislao Zeballos", 1000, false, false);
		
		Calle JC1 = new Calle("Juan Castelli", 100, false, false);
		Calle JC2 = new Calle("Juan Castelli", 200, false, false);
		Calle JC3 = new Calle("Juan Castelli", 300, false, false);
		Calle JC4 = new Calle("Juan Castelli", 400, false, false);
		Calle JC5 = new Calle("Juan Castelli", 500, false, false);
		Calle JC6 = new Calle("Juan Castelli", 600, false, false);
		Calle JC7 = new Calle("Juan Castelli", 700, false, false);
		Calle JC8 = new Calle("Juan Castelli", 800, false, false);
		Calle JC9 = new Calle("Juan Castelli", 900, false, false);
		Calle JC10 = new Calle("Juan Castelli", 1000, false, false);
		
		Calle CH2 = new Calle("Calle Hernandarias", 200, false, false);
		Calle CH3 = new Calle("Calle Hernandarias", 300, false, false);
		Calle CH4 = new Calle("Calle Hernandarias", 400, false, false);
		Calle CH5 = new Calle("Calle Hernandarias", 500, false, false);
		Calle CH6 = new Calle("Calle Hernandarias", 600, false, false);
		Calle CH7 = new Calle("Calle Hernandarias", 700, false, false);
		Calle CH8 = new Calle("Calle Hernandarias", 800, false, false);
		Calle CH9 = new Calle("Calle Hernandarias", 900, false, false);
		Calle CH10 = new Calle("Calle Hernandarias", 1000, false, false);

		Calle JPL3 = new Calle("JP Lopez", 300, false, false);
		Calle JPL4 = new Calle("JP Lopez", 400, false, false);
		Calle JPL5 = new Calle("JP Lopez", 500, false, false);
		Calle JPL6 = new Calle("JP Lopez", 600, false, false);
		Calle JPL7 = new Calle("JP Lopez", 700, false, false);
		Calle JPL8 = new Calle("JP Lopez", 800, false, false);
		Calle JPL9 = new Calle("JP Lopez", 900, false, false);

		Calle AC3 = new Calle("Angel Cassanello", 300, false, false);
		Calle AC4 = new Calle("Angel Cassanello", 400, false, false);
		Calle AC5 = new Calle("Angel Cassanello", 500, false, false);
		Calle AC6 = new Calle("Angel Cassanello", 600, false, false);
		Calle AC7 = new Calle("Angel Cassanello", 700, false, false);
		Calle AC8 = new Calle("Angel Cassanello", 800, false, false);
		Calle AC9 = new Calle("Angel Cassanello", 900, false, false);
		Calle AC10 = new Calle("Angel Cassanello", 1000, false, false);
		Calle AC11 = new Calle("Angel Cassanello", 1100, false, false);
		
		Calle RA4 = new Calle("Ricardo Aldao", 400, false, false);
		Calle RA5 = new Calle("Ricardo Aldao", 500, false, false);
		Calle RA6 = new Calle("Ricardo Aldao", 600, false, false);
		Calle RA7 = new Calle("Ricardo Aldao", 700, false, false);
		Calle RA8 = new Calle("Ricardo Aldao", 800, false, false);
		Calle RA9 = new Calle("Ricardo Aldao", 900, false, false);
		Calle RA11 = new Calle("Ricardo Aldao", 1100, false, false);
		

		Calle PV4 = new Calle("Pedro de Vega", 400, false, false);
		Calle PV5 = new Calle("Pedro de Vega", 500, false, false);
		Calle PV6 = new Calle("Pedro de Vega", 600, false, false);
		Calle PV7 = new Calle("Pedro de Vega", 700, false, false);
		Calle PV8 = new Calle("Pedro de Vega", 800, false, false);
		Calle PV9 = new Calle("Pedro de Vega", 900, false, false);
		Calle PV10 = new Calle("Pedro de Vega", 1000, false, false);
		Calle PV11 = new Calle("Pedro de Vega", 1100, false, false);
		
		Calle PI8 = new Calle("Pasaje Iturri", 800, false, false);
		Calle PI9 = new Calle("Pasaje Iturri", 900, false, false);
		
		Calle Go7 = new Calle("Gorostiaga", 700, false, false);
		Calle Go8 = new Calle("Gorostiaga", 800, false, false);
		Calle Go9 = new Calle("Gorostiaga", 900, false, false);
		Calle Go10 = new Calle("Gorostiaga", 1000, false, false);
		Calle Go11 = new Calle("Gorostiaga", 1100, false, false);
		Calle Go12 = new Calle("Gorostiaga", 1200, false, false);

		Calle Mo11 = new Calle("Mosquera", 1100, false, false);
		Calle Mo12 = new Calle("Mosquera", 1200, false, false);

		Calle MS7 = new Calle("Marco Sastre", 700, false, false);
		Calle MS8 = new Calle("Marco Sastre", 800, false, false);
		Calle MS9 = new Calle("Marco Sastre", 900, false, false);
		
		Calle DH7 = new Calle("D Huergo", 700, false, false);
		Calle DH8 = new Calle("D Huergo", 800, false, false);
		Calle DH9 = new Calle("D Huergo", 900, false, false);
		Calle DH10 = new Calle("D Huergo", 1000, false, false);
		Calle DH11 = new Calle("D Huergo", 1100, false, false);
		Calle DH12 = new Calle("D Huergo", 1200, false, false);
		Calle DH125 = new Calle("D Huergo", 1250, false, false);
		Calle DH13 = new Calle("D Huergo", 1300, false, false);
		
		Calle RG8 = new Calle("Ruperto Godoy", 800, false, false);
		Calle RG9 = new Calle("Ruperto Godoy", 900, false, false);
		Calle RG10 = new Calle("Ruperto Godoy", 1000, false, false);
		Calle RG11 = new Calle("Ruperto Godoy", 1100, false, false);
		Calle RG12 = new Calle("Ruperto Godoy", 1200, false, false);
		Calle RG13 = new Calle("Ruperto Godoy", 1300, false, false);
		
		Calle SD8 = new Calle("Santiago Derqui", 800, false, false);
		Calle SD9 = new Calle("Santiago Derqui", 900, false, false);
		Calle SD10 = new Calle("Santiago Derqui", 1000, false, false);
		Calle SD11 = new Calle("Santiago Derqui", 1100, false, false);
		Calle SD12 = new Calle("Santiago Derqui", 1200, false, false);
		Calle SD13 = new Calle("Santiago Derqui", 1300, false, false);
		Calle SD14 = new Calle("Santiago Derqui", 1400, false, false);
		
		Calle JMZ9 = new Calle("Jose Maria Zuviria", 900, false, false);
		Calle JMZ10 = new Calle("Jose Maria Zuviria", 1000, false, false);
		Calle JMZ11 = new Calle("Jose Maria Zuviria", 1100, false, false);
		Calle JMZ12 = new Calle("Jose Maria Zuviria", 1200, false, false);
		Calle JMZ13 = new Calle("Jose Maria Zuviria", 1300, false, false);
		Calle JMZ14 = new Calle("Jose Maria Zuviria", 1400, false, false);
		
		Calle La7 = new Calle("Lavaisse", 700, false, false);
		Calle La8 = new Calle("Lavaisse", 800, false, false);
		Calle La9 = new Calle("Lavaisse", 900, false, false);
		Calle La10 = new Calle("Lavaisse", 1000, false, false);
		Calle La10_2 = new Calle("Lavaisse", 1000, false, false);
		Calle La11 = new Calle("Lavaisse", 1100, false, false);
		Calle La115 = new Calle("Lavaisse", 1150, false, false);
		Calle La12 = new Calle("Lavaisse", 1200, false, false);
		Calle La125 = new Calle("Lavaisse", 1250, false, false);
		
		Calle Ll6 = new Calle("Llerena", 600, false, false);
		Calle Ll7 = new Calle("Llerena", 700, false, false);
		Calle Ll8 = new Calle("Llerena", 800, false, false);
		Calle Ll9 = new Calle("Llerena", 900, false, false);
		Calle Ll10 = new Calle("Llerena", 1000, false, false);
		Calle Ll11 = new Calle("Llerena", 1100, false, false);
		Calle Ll12 = new Calle("Llerena", 1200, false, false);
		Calle Ll13 = new Calle("Llerena", 1300, false, false);
		
		Calle Pu8 = new Calle("Pujato", 800, false, false);
		Calle Pu6 = new Calle("Pujato", 600, false, false);
		Calle Pu5 = new Calle("Pujato", 500, false, false);


		Esquina e512 = new Esquina("Pasaje Arzamendia", "Lavaisse");
		g.addVertex(e512);
		Esquina e1 = new Esquina("General Paz", "Obispo Boneo");
		g.addVertex(e1);
		Esquina e2 = new Esquina("Tacuari", "Obispo Boneo");
		g.addVertex(e2);
		Esquina e3 = new Esquina("Obispo Boneo", "Piedras");
		g.addVertex(e3);
		Esquina e4 = new Esquina("A Godoy", "Obispo Boneo");
		g.addVertex(e4);
		Esquina e5 = new Esquina("Cullen", "Obispo Boneo");
		g.addVertex(e5);
		Esquina e6 = new Esquina("Obispo Boneo", "Echague");
		g.addVertex(e6);
		Esquina e7 = new Esquina("Talcahuano", "Obispo Boneo");
		g.addVertex(e7);
		Esquina e8 = new Esquina("Obispo Boneo", "Defensa");
		g.addVertex(e8);
		Esquina e9 = new Esquina("Obispo Boneo", "Riobamba");
		g.addVertex(e9);
		Esquina e522 = new Esquina("Gorostiaga", "Tacuari");
		g.addVertex(e522);
		Esquina e11 = new Esquina("General Paz", "Estanislao Zeballos");
		g.addVertex(e11);
		Esquina e12 = new Esquina("Velez Sarsfield", "Estanislao Zeballos");
		g.addVertex(e12);
		Esquina e13 = new Esquina("Tacuari", "Estanislao Zeballos");
		g.addVertex(e13);
		Esquina e14 = new Esquina("Estanislao Zeballos", "Piedras");
		g.addVertex(e14);
		Esquina e15 = new Esquina("A Godoy", "Estanislao Zeballos");
		g.addVertex(e15);
		Esquina e16 = new Esquina("Cullen", "Estanislao Zeballos");
		g.addVertex(e16);
		Esquina e17 = new Esquina("Estanislao Zeballos", "Echague");
		g.addVertex(e17);
		Esquina e18 = new Esquina("Talcahuano", "Estanislao Zeballos");
		g.addVertex(e18);
		Esquina e19 = new Esquina("Estanislao Zeballos", "Defensa");
		g.addVertex(e19);
		Esquina e20 = new Esquina("Estanislao Zeballos", "Riobamba");
		g.addVertex(e20);
		Esquina e21 = new Esquina("Estanislao Zeballos", "Almirante Brown");
		g.addVertex(e21);
		Esquina e22 = new Esquina("General Paz", "Juan Castelli");
		g.addVertex(e22);
		Esquina e23 = new Esquina("Velez Sarsfield", "Juan Castelli");
		g.addVertex(e23);
		Esquina e24 = new Esquina("Tacuari", "Juan Castelli");
		g.addVertex(e24);
		Esquina e25 = new Esquina("Juan Castelli", "Piedras");
		g.addVertex(e25);
		Esquina e26 = new Esquina("A Godoy", "Juan Castelli");
		g.addVertex(e26);
		Esquina e27 = new Esquina("Cullen", "Juan Castelli");
		g.addVertex(e27);
		Esquina e28 = new Esquina("Juan Castelli", "Echague");
		g.addVertex(e28);
		Esquina e29 = new Esquina("Talcahuano", "Juan Castelli");
		g.addVertex(e29);
		Esquina e30 = new Esquina("Juan Castelli", "Defensa");
		g.addVertex(e30);
		Esquina e31 = new Esquina("Juan Castelli", "Riobamba");
		g.addVertex(e31);
		Esquina e32 = new Esquina("Juan Castelli", "Almirante Brown");
		g.addVertex(e32);
		Esquina e33 = new Esquina("General Paz", "Calle Hernandarias");
		g.addVertex(e33);
		Esquina e34 = new Esquina("Velez Sarsfield", "Calle Hernandarias");
		g.addVertex(e34);
		Esquina e35 = new Esquina("Tacuari", "Calle Hernandarias");
		g.addVertex(e35);
		Esquina e36 = new Esquina("Piedras", "Calle Hernandarias");
		g.addVertex(e36);
		Esquina e37 = new Esquina("A Godoy", "Calle Hernandarias");
		g.addVertex(e37);
		Esquina e38 = new Esquina("Cullen", "Calle Hernandarias");
		g.addVertex(e38);
		Esquina e39 = new Esquina("Echague", "Calle Hernandarias");
		g.addVertex(e39);
		Esquina e40 = new Esquina("Talcahuano", "Calle Hernandarias");
		g.addVertex(e40);
		Esquina e41 = new Esquina("Defensa", "Calle Hernandarias");
		g.addVertex(e41);
		Esquina e42 = new Esquina("Riobamba", "Almirante Brown", "Calle Hernandarias");
		g.addVertex(e42);
		Esquina e519 = new Esquina("Gorostiaga", "Lavaisse");
		g.addVertex(e519);
		Esquina e44 = new Esquina("Velez Sarsfield", "JP Lopez");
		g.addVertex(e44);
		Esquina e45 = new Esquina("Tacuari", "JP Lopez");
		g.addVertex(e45);
		Esquina e46 = new Esquina("JP Lopez", "Piedras");
		g.addVertex(e46);
		Esquina e47 = new Esquina("A Godoy", "JP Lopez");
		g.addVertex(e47);
		Esquina e48 = new Esquina("Cullen", "JP Lopez");
		g.addVertex(e48);
		Esquina e49 = new Esquina("Echague", "JP Lopez");
		g.addVertex(e49);
		Esquina e50 = new Esquina("Talcahuano", "JP Lopez");
		g.addVertex(e50);
		Esquina e51 = new Esquina("Almirante Brown", "JP Lopez", "Defensa");
		g.addVertex(e51);
		Esquina e52 = new Esquina("Angel Cassanello", "General Paz");
		g.addVertex(e52);
		Esquina e53 = new Esquina("Dorrego", "Angel Cassanello");
		g.addVertex(e53);
		Esquina e54 = new Esquina("Angel Cassanello", "Velez Sarsfield");
		g.addVertex(e54);
		Esquina e521 = new Esquina("Gorostiaga", "Piedras");
		g.addVertex(e521);
		Esquina e56 = new Esquina("Angel Cassanello", "Piedras");
		g.addVertex(e56);
		Esquina e57 = new Esquina("Angel Cassanello", "A Godoy");
		g.addVertex(e57);
		Esquina e58 = new Esquina("Angel Cassanello", "Cullen");
		g.addVertex(e58);
		Esquina e59 = new Esquina("Angel Cassanello", "Echague");
		g.addVertex(e59);
		Esquina e60 = new Esquina("Angel Cassanello", "Talcahuano");
		g.addVertex(e60);
		Esquina e10 = new Esquina("Obispo Boneo", "Almirante Brown");
		g.addVertex(e10);
		Esquina e62 = new Esquina("General Paz", "Ricardo Aldao");
		g.addVertex(e62);
		Esquina e63 = new Esquina("Dorrego", "Ricardo Aldao");
		g.addVertex(e63);
		Esquina e64 = new Esquina("Velez Sarsfield", "Ricardo Aldao");
		g.addVertex(e64);
		Esquina e65 = new Esquina("Tacuari", "Ricardo Aldao");
		g.addVertex(e65);
		Esquina e66 = new Esquina("Ricardo Aldao", "Piedras");
		g.addVertex(e66);
		Esquina e67 = new Esquina("A Godoy", "Ricardo Aldao");
		g.addVertex(e67);
		Esquina e68 = new Esquina("Cullen", "Ricardo Aldao");
		g.addVertex(e68);
		Esquina e69 = new Esquina("Ricardo Aldao", "Echague");
		g.addVertex(e69);
		Esquina e70 = new Esquina("Ricardo Aldao", "Almirante Brown");
		g.addVertex(e70);
		Esquina e71 = new Esquina("General Paz", "Pedro de Vega");
		g.addVertex(e71);
		Esquina e72 = new Esquina("Dorrego", "Pedro de Vega");
		g.addVertex(e72);
		Esquina e73 = new Esquina("Velez Sarsfield", "Pedro de Vega");
		g.addVertex(e73);
		Esquina e74 = new Esquina("Tacuari", "Pedro de Vega");
		g.addVertex(e74);
		Esquina e75 = new Esquina("Piedras", "Pedro de Vega");
		g.addVertex(e75);
		Esquina e76 = new Esquina("A Godoy", "Pedro de Vega");
		g.addVertex(e76);
		Esquina e77 = new Esquina("Cullen", "Pedro de Vega");
		g.addVertex(e77);
		Esquina e78 = new Esquina("Echague", "Pedro de Vega");
		g.addVertex(e78);
		Esquina e79 = new Esquina("Almirante Brown", "Pedro de Vega");
		g.addVertex(e79);
		Esquina e80 = new Esquina("General Paz", "Lavaisse");
		g.addVertex(e80);
		Esquina e81 = new Esquina("Avellaneda", "Lavaisse");
		g.addVertex(e81);
		Esquina e514 = new Esquina("D Huergo", "Pasaje Arzamendia");
		g.addVertex(e514);
		Esquina e83 = new Esquina("Velez Sarsfield", "Lavaisse");
		g.addVertex(e83);
		Esquina e84 = new Esquina("Tacuari", "Lavaisse");
		g.addVertex(e84);
		Esquina e526 = new Esquina("Calle Pizzorino", "Gorostiaga");
		g.addVertex(e526);
		Esquina e86 = new Esquina("A Godoy", "Lavaisse");
		g.addVertex(e86);
		Esquina e87 = new Esquina("Cullen", "Almirante Brown");
		g.addVertex(e87);
		Esquina e88 = new Esquina("General Paz", "Llerena");
		g.addVertex(e88);
		Esquina e89 = new Esquina("Avellaneda", "Llerena");
		g.addVertex(e89);
		Esquina e90 = new Esquina("Dorrego", "Llerena");
		g.addVertex(e90);
		Esquina e91 = new Esquina("Velez Sarsfield", "Llerena");
		g.addVertex(e91);
		Esquina e92 = new Esquina("Tacuari", "Llerena");
		g.addVertex(e92);
		Esquina e93 = new Esquina("Llerena", "Piedras");
		g.addVertex(e93);
		Esquina e94 = new Esquina("A Godoy", "Llerena");
		g.addVertex(e94);
		Esquina e95 = new Esquina("Almirante Brown", "Llerena");
		g.addVertex(e95);
		Esquina e96 = new Esquina("D Huergo", "General Paz");
		g.addVertex(e96);
		Esquina e97 = new Esquina("D Huergo", "Guemes");
		g.addVertex(e97);
		Esquina e98 = new Esquina("D Huergo", "Avellaneda");
		g.addVertex(e98);
		Esquina e99 = new Esquina("Dorrego", "D Huergo");
		g.addVertex(e99);
		Esquina e100 = new Esquina("Pasaje Pizzorino", "D Huergo", "Llerena");
		g.addVertex(e100);
		Esquina e101 = new Esquina("D Huergo", "Velez Sarsfield");
		g.addVertex(e101);
		Esquina e102 = new Esquina("D Huergo", "Tacuari");
		g.addVertex(e102);
		Esquina e103 = new Esquina("D Huergo", "Piedras");
		g.addVertex(e103);
		Esquina e104 = new Esquina("D Huergo", "Almirante Brown");
		g.addVertex(e104);
		Esquina e105 = new Esquina("General Paz", "Ruperto Godoy");
		g.addVertex(e105);
		Esquina e106 = new Esquina("Guemes", "Ruperto Godoy");
		g.addVertex(e106);
		Esquina e107 = new Esquina("Avellaneda", "Ruperto Godoy");
		g.addVertex(e107);
		Esquina e108 = new Esquina("Dorrego", "Ruperto Godoy");
		g.addVertex(e108);
		Esquina e109 = new Esquina("Pasaje Pizzorino", "Ruperto Godoy");
		g.addVertex(e109);
		Esquina e110 = new Esquina("Velez Sarsfield", "Ruperto Godoy");
		g.addVertex(e110);
		Esquina e111 = new Esquina("Tacuari", "Ruperto Godoy");
		g.addVertex(e111);
		Esquina e515 = new Esquina("General Paz", "Mosquera");
		g.addVertex(e515);
		Esquina e113 = new Esquina("General Paz", "Santiago Derqui");
		g.addVertex(e113);
		Esquina e114 = new Esquina("Lavalle", "Santiago Derqui");
		g.addVertex(e114);
		Esquina e115 = new Esquina("Guemes", "Santiago Derqui");
		g.addVertex(e115);
		Esquina e116 = new Esquina("Avellaneda", "Santiago Derqui");
		g.addVertex(e116);
		Esquina e117 = new Esquina("Dorrego", "Santiago Derqui");
		g.addVertex(e117);
		Esquina e118 = new Esquina("Pasaje Pizzorino", "Santiago Derqui");
		g.addVertex(e118);
		Esquina e119 = new Esquina("Velez Sarsfield", "Santiago Derqui");
		g.addVertex(e119);
		Esquina e120 = new Esquina("Tacuari", "Santiago Derqui");
		g.addVertex(e120);
		Esquina e121 = new Esquina("Santiago Derqui", "Almirante Brown");
		g.addVertex(e121);
		Esquina e123 = new Esquina("General Paz", "Jose Maria Zuviria");
		g.addVertex(e123);
		Esquina e124 = new Esquina("Lavalle", "Jose Maria Zuviria");
		g.addVertex(e124);
		Esquina e125 = new Esquina("Guemes", "Jose Maria Zuviria");
		g.addVertex(e125);
		Esquina e126 = new Esquina("Avellaneda", "Jose Maria Zuviria");
		g.addVertex(e126);
		Esquina e127 = new Esquina("Dorrego", "Jose Maria Zuviria");
		g.addVertex(e127);
		Esquina e128 = new Esquina("Pasaje Pizzorino", "Jose Maria Zuviria");
		g.addVertex(e128);
		Esquina e129 = new Esquina("Velez Sarsfield", "Jose Maria Zuviria");
		g.addVertex(e129);
		Esquina e130 = new Esquina("Tacuari", "Jose Maria Zuviria");
		g.addVertex(e130);
		Esquina e131 = new Esquina("General Paz", "Salvador del Carril");
		g.addVertex(e131);
		Esquina e132 = new Esquina("Lavalle", "Salvador del Carril");
		g.addVertex(e132);
		Esquina e133 = new Esquina("Guemes", "Salvador del Carril");
		g.addVertex(e133);
		Esquina e134 = new Esquina("Avellaneda", "Salvador del Carril");
		g.addVertex(e134);
		Esquina e135 = new Esquina("Dorrego", "Salvador del Carril");
		g.addVertex(e135);
		Esquina e136 = new Esquina("Pasaje Pizzorino", "Velez Sarsfield", "Salvador del Carril");
		g.addVertex(e136);
		Esquina e137 = new Esquina("Tacuari", "Salvador del Carril");
		g.addVertex(e137);
		Esquina e138 = new Esquina("Almirante Brown", "Salvador del Carril");
		g.addVertex(e138);
		Esquina e516 = new Esquina("Mosquera");
		g.addVertex(e516);
		Esquina e112 = new Esquina("Ruperto Godoy", "Almirante Brown", "Piedras");
		g.addVertex(e112);
		Esquina e517 = new Esquina("Dorrego", "Mosquera");
		g.addVertex(e517);
		Esquina e518 = new Esquina("Gorostiaga", "Avellaneda");
		g.addVertex(e518);
		Esquina e43 = new Esquina("General Paz");
		g.addVertex(e43);
		Esquina e513 = new Esquina("Pasaje Arzamendia", "Llerena");
		g.addVertex(e513);
		Esquina e520 = new Esquina("Gorostiaga", "A Godoy");
		g.addVertex(e520);
		Esquina e55 = new Esquina("Angel Cassanello", "Tacuari");
		g.addVertex(e55);
		Esquina e523 = new Esquina("Gorostiaga", "Velez Sarsfield");
		g.addVertex(e523);
		Esquina e61 = new Esquina("Angel Cassanello", "Almirante Brown");
		g.addVertex(e61);
		Esquina e524 = new Esquina("Calle Pizzorino", "Pedro de Vega");
		g.addVertex(e524);
		Esquina e525 = new Esquina("Dorrego", "Gorostiaga");
		g.addVertex(e525);
		Esquina e527 = new Esquina("Gorostiaga", "General Paz");
		g.addVertex(e527);
		Esquina e507 = new Esquina("Pujato", "Echague");
		g.addVertex(e507);
		Esquina e82 = new Esquina("Dorrego", "Lavaisse");
		g.addVertex(e82);
		Esquina e500 = new Esquina("A Godoy", "Marco Sastre");
		g.addVertex(e500);
		Esquina e501 = new Esquina("Marco Sastre", "Piedras");
		g.addVertex(e501);
		Esquina e502 = new Esquina("Tacuari", "Marco Sastre");
		g.addVertex(e502);
		Esquina e503 = new Esquina("Velez Sarsfield", "Marco Sastre");
		g.addVertex(e503);
		Esquina e504 = new Esquina("Pasaje Iturri", "Piedras");
		g.addVertex(e504);
		Esquina e505 = new Esquina("Pasaje Iturri", "A Godoy");
		g.addVertex(e505);
		Esquina e506 = new Esquina("Pasaje Iturri", "Tacuari");
		g.addVertex(e506);
		Esquina e511 = new Esquina("Tacuari", "Pujato");
		g.addVertex(e511);
		Esquina e508 = new Esquina("Cullen", "Pujato");
		g.addVertex(e508);
		Esquina e509 = new Esquina("Pujato", "A Godoy");
		g.addVertex(e509);
		Esquina e510 = new Esquina("Pujato", "Piedras");
		g.addVertex(e510);
		Esquina e85 = new Esquina("Lavaisse", "Piedras");
		g.addVertex(e85);
		g.addEdge(OB9, e1, e2);
		g.addEdge(OB8, e2, e3);
		g.addEdge(OB7, e3, e4);
		g.addEdge(OB6, e4, e5);
		g.addEdge(OB5, e5, e6);
		g.addEdge(OB4, e6, e7);
		g.addEdge(OB3, e7, e8);
		g.addEdge(OB2, e8, e9);
		g.addEdge(OB1, e9, e10);
		g.addEdge(EZ10, e12, e11);
		g.addEdge(EZ9, e13, e12);
		g.addEdge(EZ8, e14, e13);
		g.addEdge(EZ7, e15, e14);
		g.addEdge(EZ6, e16, e15);
		g.addEdge(EZ5, e17, e16);
		g.addEdge(EZ4, e18, e17);
		g.addEdge(EZ3, e19, e18);
		g.addEdge(EZ2, e20, e19);
		g.addEdge(EZ1, e21, e20);
		g.addEdge(JC10, e22, e23);
		g.addEdge(JC9, e23, e24);
		g.addEdge(JC8, e24, e25);
		g.addEdge(JC7, e25, e26);
		g.addEdge(JC6, e26, e27);
		g.addEdge(JC5, e27, e28);
		g.addEdge(JC4, e28, e29);
		g.addEdge(JC3, e29, e30);
		g.addEdge(JC2, e30, e31);
		g.addEdge(JC1, e31, e32);
		g.addEdge(CH10, e34, e33);
		g.addEdge(CH9, e35, e34);
		g.addEdge(CH8, e36, e35);
		g.addEdge(CH7, e37, e36);
		g.addEdge(CH6, e38, e37);
		g.addEdge(CH5, e39, e38);
		g.addEdge(CH4, e40, e39);
		g.addEdge(CH3, e41, e40);
		g.addEdge(CH2, e42, e41);
		g.addEdge(JPL9, e44, e45);
		g.addEdge(JPL8, e45, e46);
		g.addEdge(JPL7, e46, e47);
		g.addEdge(JPL6, e47, e48);
		g.addEdge(JPL5, e48, e49);
		g.addEdge(JPL4, e49, e50);
		g.addEdge(JPL3, e50, e51);
		g.addEdge(AC11, e52, e53);
		Calle AC11_2 = new Calle("Angel Cassanello", 1100, false, false);
		g.addEdge(AC11_2, e53, e52);
		g.addEdge(AC10, e53, e54);
		Calle AC10_2 = new Calle("Angel Cassanello", 1000, false, false);
		g.addEdge(AC10_2, e54, e53);
		g.addEdge(AC9, e54, e55);
		Calle AC9_2 = new Calle("Angel Cassanello", 900, false, false);
		g.addEdge(AC9_2, e55, e54);
		g.addEdge(AC8, e55, e56);
		Calle AC8_2 = new Calle("Angel Cassanello", 800, false, false);
		g.addEdge(AC8_2, e56, e55);
		g.addEdge(AC7, e56, e57);
		Calle AC7_2 = new Calle("Angel Cassanello", 700, false, false);
		g.addEdge(AC7_2, e57, e56);
		g.addEdge(AC6, e57, e58);
		Calle AC6_2 = new Calle("Angel Cassanello", 600, false, false);
		g.addEdge(AC6_2, e58, e57);
		g.addEdge(AC5, e58, e59);
		Calle AC5_2 = new Calle("Angel Cassanello", 500, false, false);
		g.addEdge(AC5_2, e59, e58);
		g.addEdge(AC4, e59, e60);
		Calle AC4_2 = new Calle("Angel Cassanello", 400, false, false);
		g.addEdge(AC4_2, e60, e59);
		g.addEdge(AC3, e60, e61);
		Calle AC3_2 = new Calle("Angel Cassanello", 300, false, false);
		g.addEdge(AC3_2, e61, e60);
		g.addEdge(RA11, e62, e63);
		g.addEdge(RA9, e64, e65);
		g.addEdge(RA8, e65, e66);
		g.addEdge(RA7, e66, e67);
		g.addEdge(RA6, e67, e68);
		g.addEdge(RA5, e68, e69);
		g.addEdge(RA4, e69, e70);
		g.addEdge(PV11, e71, e72);
		g.addEdge(PV10, e72, e524);
		g.addEdge(PV9, e74, e73);
		g.addEdge(PV8, e75, e74);
		g.addEdge(PV7, e76, e75);
		g.addEdge(PV6, e77, e76);
		g.addEdge(PV5, e78, e77);
		g.addEdge(PV4, e79, e78);
		g.addEdge(PI9, e506, e504);
		g.addEdge(PI8, e504, e505);
		g.addEdge(Go7, e520, e521);
		g.addEdge(Go8, e521, e522);
		g.addEdge(Go9, e522, e523);
		g.addEdge(Go10, e526, e525);
		g.addEdge(Go11, e519, e518);
		g.addEdge(Go12, e518, e527);
		g.addEdge(Mo12, e515, e516);
		g.addEdge(Mo11, e516, e517);
		g.addEdge(MS7, e500, e501);
		g.addEdge(MS8, e501, e502);
		g.addEdge(MS9, e502, e503);
		g.addEdge(DH13, e97, e96);
		g.addEdge(DH12, e514, e97);
		g.addEdge(DH125, e98, e514);
		g.addEdge(DH11, e99, e98);
		g.addEdge(DH10, e100, e99);
		g.addEdge(DH9, e102, e101);
		g.addEdge(DH8, e103, e102);
		g.addEdge(DH7, e104, e103);
		g.addEdge(RG13, e105, e106);
		g.addEdge(RG12, e106, e107);
		g.addEdge(RG11, e107, e108);
		g.addEdge(RG10, e108, e109);
		g.addEdge(RG9, e110, e111);
		g.addEdge(RG8, e111, e112);
		g.addEdge(SD14, e114, e113);
		g.addEdge(SD13, e115, e114);
		g.addEdge(SD12, e116, e115);
		g.addEdge(SD11, e117, e116);
		g.addEdge(SD10, e118, e117);
		g.addEdge(SD9, e120, e119);
		g.addEdge(SD8, e121, e120);
		g.addEdge(JMZ14, e123, e124);
		g.addEdge(JMZ13, e124, e125);
		g.addEdge(JMZ12, e125, e126);
		g.addEdge(JMZ11, e126, e127);
		g.addEdge(JMZ10, e127, e128);
		g.addEdge(JMZ9, e129, e130);
		g.addEdge(La125, e80, e512);
		g.addEdge(La12, e512, e81);
		g.addEdge(La115, e81, e519);
		g.addEdge(La11, e519, e82);
		g.addEdge(La10, e82, e83);
		g.addEdge(La10_2, e83, e82);
		g.addEdge(La9, e83, e84);
		g.addEdge(La8, e84, e85);
		g.addEdge(La7, e85, e86);
		g.addEdge(Ll13, e88, e513);
		g.addEdge(Ll12, e513, e89);
		g.addEdge(Ll11, e89, e90);
		g.addEdge(Ll10, e90, e100);
		g.addEdge(Ll9, e91, e92);
		g.addEdge(Ll8, e92, e93);
		g.addEdge(Ll7, e93, e94);
		g.addEdge(Ll6, e94, e95);
		g.addEdge(Pu8, e511, e510);
		g.addEdge(Pu6, e509, e508);
		g.addEdge(Pu5, e508, e507);
		g.addEdge(SC14, e131, e132);
		Calle SC14_2 = new Calle("Salvador del Carril", 1400, false, false);
		g.addEdge(SC14_2, e132, e131);
		g.addEdge(SC13, e132, e133);
		Calle SC13_2 = new Calle("Salvador del Carril", 1300, false, false);
		g.addEdge(SC13_2, e133, e132);
		g.addEdge(SC12, e133, e134);
		Calle SC12_2 = new Calle("Salvador del Carril", 1200, false, false);
		g.addEdge(SC12_2, e134, e133);
		g.addEdge(SC11, e134, e135);
		Calle SC11_2 = new Calle("Salvador del Carril", 1100, false, false);
		g.addEdge(SC11_2, e135, e134);
		g.addEdge(SC10, e135, e136);
		Calle SC10_2 = new Calle("Salvador del Carril", 1000, false, false);
		g.addEdge(SC10_2, e136, e135);
		g.addEdge(SC9, e136, e137);
		Calle SC9_2 = new Calle("Salvador del Carril", 900, false, false);
		g.addEdge(SC9_2, e137, e136);
		g.addEdge(SC8, e137, e138);
		Calle SC8_2 = new Calle("Salvador del Carril", 800, false, false);
		g.addEdge(SC8_2, e138, e137);
		g.addEdge(gp68, e1, e11);
		Calle gp68_2 = new Calle("General Paz", 6800, false, false);
		g.addEdge(gp68_2, e11, e1);
		g.addEdge(gp67, e11, e22);
		Calle gp67_2 = new Calle("General Paz", 6700, false, false);
		g.addEdge(gp67_2, e22, e11);
		g.addEdge(gp66, e22, e33);
		Calle gp66_2 = new Calle("General Paz", 6600, false, false);
		g.addEdge(gp66_2, e33, e22);
		g.addEdge(gp65, e33, e43);
		Calle gp65_2 = new Calle("General Paz", 6500, false, false);
		g.addEdge(gp65_2, e43, e33);
		g.addEdge(gp64, e43, e52);
		Calle gp64_2 = new Calle("General Paz", 6400, false, false);
		g.addEdge(gp64_2, e52, e43);
		g.addEdge(gp63, e52, e62);
		Calle gp63_2 = new Calle("General Paz", 6300, false, false);
		g.addEdge(gp63_2, e62, e52);
		g.addEdge(gp62, e62, e71);
		Calle gp62_2 = new Calle("General Paz", 6200, false, false);
		g.addEdge(gp62_2, e71, e62);
		g.addEdge(gp615, e71, e515);
		Calle gp615_2 = new Calle("General Paz", 6150, false, false);
		g.addEdge(gp615_2, e515, e71);
		g.addEdge(gp61, e515, e527);
		Calle gp61_2 = new Calle("General Paz", 6100, false, false);
		g.addEdge(gp61_2, e527, e515);
		g.addEdge(gp60, e527, e80);
		Calle gp60_2 = new Calle("General Paz", 6000, false, false);
		g.addEdge(gp60_2, e80, e527);
		g.addEdge(gp59, e80, e88);
		Calle gp59_2 = new Calle("General Paz", 5900, false, false);
		g.addEdge(gp59_2, e88, e80);
		g.addEdge(gp58, e88, e96);
		Calle gp58_2 = new Calle("General Paz", 5800, false, false);
		g.addEdge(gp58_2, e96, e88);
		g.addEdge(gp57, e96, e105);
		Calle gp57_2 = new Calle("General Paz", 5700, false, false);
		g.addEdge(gp57_2, e105, e96);
		g.addEdge(gp56, e105, e113);
		Calle gp56_2 = new Calle("General Paz", 5600, false, false);
		g.addEdge(gp56_2, e113, e105);
		g.addEdge(gp55, e113, e123);
		Calle gp55_2 = new Calle("General Paz", 5500, false, false);
		g.addEdge(gp55_2, e123, e113);
		g.addEdge(gp54, e123, e131);
		Calle gp54_2 = new Calle("General Paz", 5400, false, false);
		g.addEdge(gp54_2, e131, e123);
		g.addEdge(AB68, e10, e21);
		Calle AB68_2 = new Calle("Almirante Brown", 6800, false, false);
		g.addEdge(AB68_2, e21, e10);
		g.addEdge(AB67, e21, e32);
		Calle AB67_2 = new Calle("Almirante Brown", 6700, false, false);
		g.addEdge(AB67_2, e32, e21);
		g.addEdge(AB66, e32, e42);
		Calle AB66_2 = new Calle("Almirante Brown", 6600, false, false);
		g.addEdge(AB66_2, e42, e32);
		g.addEdge(AB65, e42, e51);
		Calle AB65_2 = new Calle("Almirante Brown", 6500, false, false);
		g.addEdge(AB65_2, e51, e42);
		g.addEdge(AB64, e51, e61);
		Calle AB64_2 = new Calle("Almirante Brown", 6400, false, false);
		g.addEdge(AB64_2, e61, e51);
		g.addEdge(AB63, e61, e70);
		Calle AB63_2 = new Calle("Almirante Brown", 6300, false, false);
		g.addEdge(AB63_2, e70, e61);
		g.addEdge(AB62, e70, e79);
		Calle AB62_2 = new Calle("Almirante Brown", 6200, false, false);
		g.addEdge(AB62_2, e79, e70);
		g.addEdge(AB60, e79, e87);
		Calle AB60_2 = new Calle("Almirante Brown", 6000, false, false);
		g.addEdge(AB60_2, e87, e79);
		g.addEdge(AB59, e87, e95);
		Calle AB59_2 = new Calle("Almirante Brown", 5900, false, false);
		g.addEdge(AB59_2, e95, e87);
		g.addEdge(AB58, e95, e104);
		Calle AB58_2 = new Calle("Almirante Brown", 5800, false, false);
		g.addEdge(AB58_2, e104, e95);
		g.addEdge(AB57, e104, e112);
		Calle AB57_2 = new Calle("Almirante Brown", 5700, false, false);
		g.addEdge(AB57_2, e112, e104);
		g.addEdge(AB56, e112, e121);
		Calle AB56_2 = new Calle("Almirante Brown", 5600, false, false);
		g.addEdge(AB56_2, e121, e112);
		g.addEdge(AB54, e121, e138);
		Calle AB54_2 = new Calle("Almirante Brown", 5400, false, false);
		g.addEdge(AB54_2, e138, e121);
		g.addEdge(VS67, e23, e12);
		g.addEdge(VS66, e34, e23);
		g.addEdge(VS65, e44, e34);
		g.addEdge(VS64, e54, e44);
		g.addEdge(VS63, e64, e54);
		g.addEdge(VS62, e73, e64);
		g.addEdge(VS61, e523, e73);
		g.addEdge(VS60, e83, e523);
		g.addEdge(VS595, e503, e83);
		g.addEdge(VS59, e91, e503);
		g.addEdge(VS58, e101, e91);
		g.addEdge(VS57, e110, e101);
		g.addEdge(VS56, e119, e110);
		g.addEdge(VS55, e129, e119);
		g.addEdge(VS54, e136, e129);
		g.addEdge(Ta68, e2, e13);
		g.addEdge(Ta67, e13, e24);
		g.addEdge(Ta66, e24, e35);
		g.addEdge(Ta655, e35, e511);
		g.addEdge(Ta65, e511, e45);
		g.addEdge(Ta64, e45, e55);
		g.addEdge(Ta63, e55, e65);
		g.addEdge(Ta62, e65, e74);
		g.addEdge(Ta615, e74, e506);
		g.addEdge(Ta61, e506, e522);
		g.addEdge(Ta60, e522, e84);
		g.addEdge(Ta595, e84, e502);
		g.addEdge(Ta59, e502, e92);
		g.addEdge(Ta58, e92, e102);
		g.addEdge(Ta57, e102, e111);
		g.addEdge(Ta56, e111, e120);
		g.addEdge(Ta55, e120, e130);
		g.addEdge(Ta54, e130, e137);
		g.addEdge(Pi68, e14, e3);
		g.addEdge(Pi67, e25, e14);
		g.addEdge(Pi66, e36, e25);
		g.addEdge(Pi655, e510, e36);
		g.addEdge(Pi65, e46, e510);
		g.addEdge(Pi64, e56, e46);
		g.addEdge(Pi63, e66, e56);
		g.addEdge(Pi62, e75, e66);
		g.addEdge(Pi615, e504, e75);
		g.addEdge(Pi61, e521, e504);
		g.addEdge(Pi60, e85, e521);
		g.addEdge(Pi595, e501, e85);
		g.addEdge(Pi59, e93, e501);
		g.addEdge(Pi58, e103, e93);
		g.addEdge(Pi57, e112, e103);
		g.addEdge(AG68, e4, e15);
		g.addEdge(AG67, e15, e26);
		g.addEdge(AG66, e26, e37);
		g.addEdge(AG655, e37, e509);
		g.addEdge(AG65, e509, e47);
		g.addEdge(AG64, e47, e57);
		g.addEdge(AG63, e57, e67);
		g.addEdge(AG62, e67, e76);
		g.addEdge(AG615, e76, e505);
		g.addEdge(AG61, e505, e520);
		g.addEdge(AG60, e520, e86);
		g.addEdge(AG595, e86, e500);
		g.addEdge(AG59, e500, e94);
		g.addEdge(Cu68, e16, e5);
		g.addEdge(Cu67, e27, e16);
		g.addEdge(Cu66, e38, e27);
		g.addEdge(Cu655, e508, e38);
		g.addEdge(Cu65, e48, e508);
		g.addEdge(Cu64, e58, e48);
		g.addEdge(Cu63, e68, e58);
		g.addEdge(Cu62, e77, e68);
		g.addEdge(Cu60, e87, e77);
		g.addEdge(Ec68, e6, e17);
		g.addEdge(Ec67, e17, e28);
		g.addEdge(Ec66, e28, e39);
		g.addEdge(Ec655, e39, e507);
		g.addEdge(Ec65, e507, e49);
		g.addEdge(Ec64, e49, e59);
		g.addEdge(Ec63, e59, e69);
		g.addEdge(Ec62, e69, e78);
		g.addEdge(To68, e18, e7);
		g.addEdge(To67, e29, e18);
		g.addEdge(To66, e40, e29);
		g.addEdge(To65, e50, e40);
		g.addEdge(To64, e60, e50);
		g.addEdge(De68, e8, e19);
		g.addEdge(De67, e19, e30);
		g.addEdge(De66, e30, e41);
		g.addEdge(De65, e41, e51);
		g.addEdge(Ri68, e9, e20);
		g.addEdge(Ri67, e20, e31);
		g.addEdge(Ri66, e31, e42);
		g.addEdge(PP57, e100, e109);
		g.addEdge(PP56, e109, e118);
		g.addEdge(PP55, e118, e128);
		g.addEdge(PP54, e128, e136);
		g.addEdge(CP61, e524, e526);
		g.addEdge(PA59, e512, e513);
		g.addEdge(PA58, e513, e514);
		g.addEdge(Do63, e53, e63);
		Calle Do63_2 = new Calle("Dorrego", 6300, false, false);
		g.addEdge(Do63_2, e63, e53);
		g.addEdge(Do62, e63, e72);
		Calle Do62_2 = new Calle("Dorrego", 6200, false, false);
		g.addEdge(Do62_2, e72, e63);
		g.addEdge(Do61, e72, e525);
		Calle Do61_2 = new Calle("Dorrego", 6100, false, false);
		g.addEdge(Do61_2, e525, e72);
		g.addEdge(Do60, e525, e517);
		Calle Do60_2 = new Calle("Dorrego", 6000, false, false);
		g.addEdge(Do60_2, e517, e525);
		g.addEdge(Do605, e517, e82);
		Calle Do605_2 = new Calle("Dorrego", 6050, false, false);
		g.addEdge(Do605_2, e82, e517);
		g.addEdge(Do59, e82, e90);
		Calle Do59_2 = new Calle("Dorrego", 5900, false, false);
		g.addEdge(Do59_2, e90, e82);
		g.addEdge(Do58, e90, e99);
		Calle Do58_2 = new Calle("Dorrego", 5800, false, false);
		g.addEdge(Do58_2, e99, e90);
		g.addEdge(Do57, e99, e108);
		Calle Do57_2 = new Calle("Dorrego", 5700, false, false);
		g.addEdge(Do57_2, e108, e99);
		g.addEdge(Do56, e108, e117);
		Calle Do56_2 = new Calle("Dorrego", 5600, false, false);
		g.addEdge(Do56_2, e117, e108);
		g.addEdge(Do55, e117, e127);
		Calle Do55_2 = new Calle("Dorrego", 5500, false, false);
		g.addEdge(Do55_2, e127, e117);
		g.addEdge(Do54, e127, e135);
		Calle Do54_2 = new Calle("Dorrego", 5400, false, false);
		g.addEdge(Do54_2, e135, e127);
		g.addEdge(Av54, e134, e126);
		g.addEdge(Av55, e126, e116);
		g.addEdge(Av56, e116, e107);
		g.addEdge(Av57, e107, e98);
		g.addEdge(Av58, e98, e89);
		g.addEdge(Av59, e89, e81);
		g.addEdge(Av60, e81, e518);
		g.addEdge(Gu57, e97, e106);
		g.addEdge(Gu56, e106, e115);
		g.addEdge(Gu55, e115, e125);
		g.addEdge(Gu54, e125, e133);
		g.addEdge(La55, e124, e114);
		g.addEdge(La54, e132, e124);
	}
}
