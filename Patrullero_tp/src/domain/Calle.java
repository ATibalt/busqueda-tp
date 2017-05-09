package domain;

public class Calle {
	String nombre;
	int altura;
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
	
	public Calle(String nombre) {
		this.nombre = nombre;
		this.altura = 1;
	}
	
	public String toString() {
		return "Calle."+this.nombre;
	}
}
