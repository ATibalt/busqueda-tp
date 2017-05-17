package domain;

/**
 * @author Leandro
 *
 */
public class Esquina {
	
	String nombre;
	
	
	public Esquina(String nombre) {
		this.nombre = nombre;
	}
	
	public Esquina(){
		
	}
	
	public String toString() {
		return "Esq."+nombre;
	}
	
	public boolean Equals(Esquina obj){
		if( this.nombre.equals(obj.nombre)){
			return true;
		}
		return false;
	}
	
	public Esquina clone(){
		Esquina esquina = new Esquina();
		esquina.setNombre(this.nombre);
		return esquina;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
