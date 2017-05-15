package domain;

import java.util.ArrayList;
import java.util.List;

import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;

public class Mapa {

	DirectedGraph<Esquina, Calle> g;

	public Mapa() {
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

		Calle AG59 = new Calle("A Godoy", 5900, false, false);
		Calle AG60 = new Calle("A Godoy", 6000, false, false);
		Calle AG61 = new Calle("A Godoy", 6100, false, false);
		Calle AG62 = new Calle("A Godoy", 6200, false, false);
		Calle AG63 = new Calle("A Godoy", 6300, false, false);
		Calle AG64 = new Calle("A Godoy", 6400, false, false);
		Calle AG65 = new Calle("A Godoy", 6500, false, false);
		Calle AG66 = new Calle("A Godoy", 6600, false, false);
		Calle AG67 = new Calle("A Godoy", 6700, false, false);
		Calle AG68 = new Calle("A Godoy", 6800, false, false);

		Calle Cu60 = new Calle("Cullen", 6000, false, false);
		Calle Cu61 = new Calle("Cullen", 6100, false, false);
		Calle Cu62 = new Calle("Cullen", 6200, false, false);
		Calle Cu63 = new Calle("Cullen", 6300, false, false);
		Calle Cu64 = new Calle("Cullen", 6400, false, false);
		Calle Cu65 = new Calle("Cullen", 6500, false, false);
		Calle Cu66 = new Calle("Cullen", 6600, false, false);
		Calle Cu67 = new Calle("Cullen", 6700, false, false);
		Calle Cu68 = new Calle("Cullen", 6800, false, false);

		Calle Ec62 = new Calle("Echague", 6200, false, false);
		Calle Ec63 = new Calle("Echague", 6300, false, false);
		Calle Ec64 = new Calle("Echague", 6400, false, false);
		Calle Ec65 = new Calle("Echague", 6500, false, false);
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
		Calle JPL10 = new Calle("JP Lopez", 1000, false, false);

		Calle AC3 = new Calle("Angel Cassanello", 300, false, false);
		Calle AC4 = new Calle("Angel Cassanello", 400, false, false);
		Calle AC5 = new Calle("Angel Cassanello", 500, false, false);
		Calle AC6 = new Calle("Angel Cassanello", 600, false, false);
		Calle AC7 = new Calle("Angel Cassanello", 700, false, false);
		Calle AC8 = new Calle("Angel Cassanello", 800, false, false);
		Calle AC9 = new Calle("Angel Cassanello", 900, false, false);
		Calle AC10 = new Calle("Angel Cassanello", 1000, false, false);
		
		Calle RA4 = new Calle("Ricardo Aldao", 400, false, false);
		Calle RA5 = new Calle("Ricardo Aldao", 500, false, false);
		Calle RA6 = new Calle("Ricardo Aldao", 600, false, false);
		Calle RA7 = new Calle("Ricardo Aldao", 700, false, false);
		Calle RA8 = new Calle("Ricardo Aldao", 800, false, false);
		Calle RA9 = new Calle("Ricardo Aldao", 900, false, false);
		Calle RA10 = new Calle("Ricardo Aldao", 1000, false, false);
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
		Calle La11 = new Calle("Lavaisse", 1100, false, false);
		Calle La12 = new Calle("Lavaisse", 1200, false, false);
		
		Calle Ll6 = new Calle("Llerena", 600, false, false);
		Calle Ll7 = new Calle("Llerena", 700, false, false);
		Calle Ll8 = new Calle("Llerena", 800, false, false);
		Calle Ll9 = new Calle("Llerena", 900, false, false);
		Calle Ll10 = new Calle("Llerena", 1000, false, false);
		Calle Ll11 = new Calle("Llerena", 1100, false, false);
		Calle Ll12 = new Calle("Llerena", 1200, false, false);
		
		Calle Pu8 = new Calle("Pujato", 800, false, false);
		
		Esquina e1 = new Esquina("e1");
		Esquina e2 = new Esquina("e2");
		Esquina e3 = new Esquina("e3");

		g.addVertex(e1);
		g.addVertex(e2);
		g.addVertex(e3);

		g.addEdge(c1, e1, e2);
		g.addEdge(c2, e2, e3);
		g.addEdge(c3, e3, e1);

		System.out.println("Sucesores" + g.getSuccessors(e2));

		System.out.println("Grafo" + g.toString());
	}

	public List<Calle> getCallesCortadas() {
		List<Calle> callesCortadas = new ArrayList<Calle>();

		return callesCortadas;
	}

	public List<Calle> getCallesCongestionadas() {
		List<Calle> callesCongestionadas = new ArrayList<Calle>();

		return callesCongestionadas;
	}

	public Esquina getAlerta() {
		Esquina alerta = null;

		return alerta;
	}

	public Esquina getPosicionAgente() {
		Esquina posAgente = null;

		return posAgente;
	}

	public List<Esquina> getAdyacentes(Esquina esquina) {
		return (List<Esquina>) g.getSuccessors(esquina);
	}
}
