import java.util.ArrayList;
import java.util.HashMap;

public class Country {
	public HashMap<String,Judet> HMJudete;
	/*
	 * Aceasta clasa este folosita pentru a stoca tarile intr-un hashmap, pentru ca,
	 * in cazul taskului 2 , in care ni se da doar locatia , sa putem gasi elementul respectiv mult
	 * mai repede. Fiecare tara contine la randul ei un Hashmap de judete din acelasi motiv
	 */
	
	public Country(HashMap<String, Judet> hMJudete) {
		super();
		HMJudete = hMJudete;
	}



}
