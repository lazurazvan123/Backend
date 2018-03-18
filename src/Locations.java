import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Locations {
	
	
	
	public static HashMap<String,Country> getLocations(String locuri){
		
		FileReader fr = null;
		BufferedReader br = null;
		String CurrentLine;
		HashMap<String,Country> HMC = new HashMap<String,Country>();

		try {

			fr = new FileReader(locuri);
			br = new BufferedReader(fr);
			
			while ((CurrentLine = br.readLine()) != null) {
				String[] arrline = CurrentLine.split(" ");
				
				
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
	return HMC;
	}

}
