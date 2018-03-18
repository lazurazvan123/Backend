import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		String input="input.in";
		String comenzi="comenzi.in";
		String locuri="places.in";
		
		/*
		Introducem datele de input : locurile de vacanta  + informatiile despre ele
		Datele sunt introduse intr-un HashMap din urmatorul motiv : la taskul 1 locurile 
		trebuie gasite dupa nume, care va reprezenta "cheia" din HashMap. Prin urmare,
		de fiecare data cand se cere informatiile despre un anumit loc, acestea vor fi gasite
		in timp O(1)
		*/
		
		/*Urmatorul apel de functie retine toate locurile de vacanta impreuna cu pozitiile lor pe harta
		(Tara-Judet-Oras)*/
		HashMap<String,Country> countries = ReadPlaces.readplaces(locuri);
		/*Urmatorul apel retine atat informatiile despre fiecare loc, cat si activitatile separat carora le sunt
		 * asociate locurile unde se pot practica (stor)
		 */
		Storage stor = ReaderFile.readData(input);
		HashMap<String,Place> places = stor.places;
		HashMap<String,ArrayList<String>>activities_places = stor.activities_places;
		//executam comenzile AllInfo(task1) TOP5 (task2) 10Days(task3)
		ExecuteCommands.executeCommands(comenzi, places,countries,stor.activities_places);
	}

}
