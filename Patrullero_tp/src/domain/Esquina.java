package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leandro
 *
 */
public class Esquina {
	
	List<String> calles;
	
	public Esquina (String calle1, String calle2){
		calles = new ArrayList<String>();
		calles.add(calle1);
		calles.add(calle2);
	}
	
	public String toString() {
		String nombre = "";
		for (String c : calles) {
			nombre += "/";
			nombre += c;
		}
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
