import java.util.ArrayList;
import java.util.HashMap;

public class Country {
	public HashMap<String,Judet> HMJudete =new HashMap<String,Judet>();
	/*
	 * Aceasta clasa este folosita pentru a stoca tarile intr-un hashmap, pentru ca,
	 * in cazul taskului 2 , in care ni se da doar locatia , sa putem gasi elementul respectiv mult
	 * mai repede. Fiecare tara contine la randul ei un Hashmap de judete din acelasi motiv
	 */
	/*public Country() {
		HMJudete =  new HashMap<String,Judet>();
	}*/
	
	public Country() {
		this.HMJudete = new HashMap<String,Judet>();
	}
	public Country(HashMap<String, Judet> hMJudete) {
		super();
		HMJudete = hMJudete;
	}
	
	public void addJudet(String nJudet, Judet jud) {
		this.HMJudete.put(nJudet, jud);
	}



}
