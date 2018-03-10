import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		String input="input.in";
		String comenzi="comenzi.in";
		String locuri="places";
		//task2 -> HashMap<String,Country> HMC = Locations.getLocations(locuri);
		
		/*
		Introducem datele de input : locurile de vacanta  + informatiile despre ele
		Datele sunt introduse intr-un HashMap din urmatorul motiv : la taskul 1 locurile 
		trebuie gasite dupa nume, care va reprezenta "cheia" din HashMap. Prin urmare,
		de fiecare data cand se cere informatiile despre un anumit loc, acestea vor fi gasite
		in timp O(n)
		*/
		HashMap<String,Place> places = ReaderFile.readData(input);
		//executam comenzile , la acest moment doar comanda "AllInfo" functioneaza
		ExecuteCommands.executeCommands(comenzi, places);
	}

}
