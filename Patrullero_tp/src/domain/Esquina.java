package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Esquina {
	
	List<String> calles;

	public Esquina(){
		
	}
	
	public Esquina (String calle1){
		calles = new ArrayList<String>();
		calles.add(calle1);
	}

	public Esquina (String calle1, String calle2){
		calles = new ArrayList<String>();
		calles.add(calle1);
		calles.add(calle2);
	}

	public Esquina (String calle1, String calle2, String calle3){
		calles = new ArrayList<String>();
		calles.add(calle1);
		calles.add(calle2);
		calles.add(calle3);
	}
	
	public String toString() {
		String nombre = "";
		for (String c : calles) {
			nombre += "/";
			nombre += c;
		}
		return "Esq."+nombre;
	}

	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof Esquina)) {
			return false;
		}
		Esquina esq = (Esquina) obj;
		if (this.calles == null && esq.calles == null) {
			return true;
		}
		if ((this.calles == null && esq.calles != null)
				|| this.calles != null && esq.calles == null
				|| this.calles.size() != esq.calles.size()) {
			return false;
		}



		List<String> thisCalles = new ArrayList<>(this.calles);
		List<String> esqCalles = new ArrayList<>(esq.calles);

		Collections.sort(thisCalles);
		Collections.sort(esqCalles);
		return thisCalles.equals(esqCalles);
	}
	
	public Esquina clone(){
		Esquina esquina = new Esquina();
		
		List<String> callesClone = new ArrayList<String>();
		callesClone.addAll(this.calles);
		
		esquina.setCalles(callesClone);
		
		return esquina;
	}

	public List<String> getCalles() {
		return calles;
	}

	public void setCalles(List<String> calles) {
		this.calles = calles;
	}
	
}
