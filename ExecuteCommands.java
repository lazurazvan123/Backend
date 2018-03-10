import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ExecuteCommands {
	

	public static void executeCommands(String commands,HashMap<String,Place> HM) {
		
		FileReader fr = null;
		BufferedReader br = null;
		String CurrentLine;
		
		try {

			fr = new FileReader(commands);
			br = new BufferedReader(fr);
			
			// parcurgem lista de comenzi
			while ((CurrentLine = br.readLine()) != null) {
				
				String[] arrline = CurrentLine.split(" ");	
				if(arrline[0].equals("AllInfo")) {
					DisplayInfo.showAllInfo(arrline[1],HM);
				}
				
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
	}
}
