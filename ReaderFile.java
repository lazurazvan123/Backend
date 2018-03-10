import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ReaderFile {

	public static HashMap<String, Place> readData(String input) {

		HashMap<String, Place> HM = new HashMap<String,Place>();
		
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
		
		return HM;
	}
}
