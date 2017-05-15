package domain;

public class Calle {
	
	String nombre;
	int altura;
	boolean cortada;
	boolean congestionada;
	
	public Calle(String nombre, int altura, boolean cortada,
			boolean congestionada) {
		super();
		this.nombre = nombre;
		this.altura = altura;
		this.cortada = cortada;
		this.congestionada = congestionada;
	}
	/*
	public Calle(String nombre) {
		super();
		this.nombre = nombre;
	}
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public boolean isCortada() {
		return cortada;
	}

	public void setCortada(boolean cortada) {
		this.cortada = cortada;
	}

	public boolean isCongestionada() {
		return congestionada;
	}

	public void setCongestionada(boolean congestionada) {
		this.congestionada = congestionada;
	}

	public String toString() {
		return "Calle."+this.nombre;
	}
}
