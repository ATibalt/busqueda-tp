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
	
	public Calle(){
		
	}
	
	public Calle clone(){
		Calle calleClone = new Calle();
		calleClone.setNombre(this.getNombre());
		calleClone.setAltura(this.getAltura());
		calleClone.setCortada(this.isCortada());
		calleClone.setCongestionada(this.isCongestionada());
		return calleClone;
	}
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof Calle)) {
			return false;
		}
		Calle calle = (Calle) obj;
	
		if(this.nombre.equals(calle.nombre)
				&& this.altura == calle.altura
				&& this.cortada == calle.cortada
				&& this.congestionada == calle.congestionada){
			return true;
		}
		
		return false;
	}
	
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
		return this.nombre+" al "+this.altura;
	}
}
