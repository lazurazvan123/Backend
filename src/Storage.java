import java.util.ArrayList;
import java.util.HashMap;

public class Storage {
	
	public HashMap<String,Place> places;
	public HashMap<String,ArrayList<String>> activities_places;
	
	public Storage() {
		this.places = new HashMap<String,Place>();
		ArrayList<String> arr = new ArrayList<String>();
		activities_places = new HashMap<String,ArrayList<String>>();
	}

	public Storage(HashMap<String, Place> places, HashMap<String, ArrayList<String>> activities_places) {
		super();
		this.places = places;
		this.activities_places = activities_places;
	}
}
