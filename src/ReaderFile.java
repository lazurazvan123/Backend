import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReaderFile {

	public static Storage readData(String input) {

		HashMap<String, Place> HM = new HashMap<String,Place>();
	    HashMap<String,ArrayList<String>> activities_places = new  HashMap<String,ArrayList<String>>();
		String name;
		String oras;
		Double price;
		
		Period period;
		int nrActivities;
		String Date;

		String CurrentLine;
		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader(input);
			br = new BufferedReader(fr);

			while ((CurrentLine = br.readLine()) != null) {
				String[] arrline = CurrentLine.split(" ");
				name = arrline[0];
				oras = arrline[1];
				price = Double.valueOf(arrline[2]);
				nrActivities = Integer.valueOf(arrline[3]);
				int j;
				ArrayList<String> activities = new ArrayList<String>();	
				for (j = 4; j <= nrActivities + 3; j++) {
					activities.add(arrline[j]);
				}
				Date = arrline[j];
				String[] arrDateStart = new String[2];
				arrDateStart = Date.split("\\.");
				j++;
				Date = arrline[j];
				String[] arrDateFinal = Date.split("\\.");
				period = new Period(Integer.valueOf(arrDateStart[1]), Integer.valueOf(arrDateStart[0]),
						Integer.valueOf(arrDateFinal[1]),Integer.valueOf(arrDateFinal[0]));
				
				Place place = new Place(name,oras,price,activities,period);
				
				int month_start  = Integer.valueOf(arrDateStart[1]);
				int day_start = Integer.valueOf(arrDateStart[0]);
				int month_end = Integer.valueOf(arrDateFinal[1]);
				int day_end = Integer.valueOf(arrDateFinal[0]);
				
				int ok=0;
				
				if(month_start == month_end) {
					if(day_start-day_end+1>=10) {
						ok=1;
					}
				}
				
				if(month_start < month_end) {
					if(day_end + 30 - day_start +1 >= 10) {
						ok=1;
					}
				}
				
				if(ok==1) {
					int k;
					for(k=0;k<activities.size();k++) {
						if(activities_places.containsKey(activities.get(k))){
							activities_places.get(activities.get(k)).add(name);
						}else {
							ArrayList<String> arrl = new ArrayList<String>();
							arrl.add(name);
							activities_places.put(activities.get(k),arrl);
						}
					}
				}
				
				HM.put(name,place);
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		Storage stor = new Storage(HM,activities_places);
		return stor;
	}
}
