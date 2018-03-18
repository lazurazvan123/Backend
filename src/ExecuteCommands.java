import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ExecuteCommands {

	public static void executeCommands(String commands, HashMap<String, Place> HM, HashMap<String, Country> HMC,
			HashMap<String, ArrayList<String>> activities_places) {

		FileReader fr = null;
		BufferedReader br = null;
		String CurrentLine;

		try {

			fr = new FileReader(commands);
			br = new BufferedReader(fr);

			// parcurgem lista de comenzi
			while ((CurrentLine = br.readLine()) != null) {

				String[] arrline = CurrentLine.split(" ");
				if (arrline[0].equals("AllInfo")) {
					DisplayInfo.showAllInfo(arrline[1], HM);
				}
				if (arrline[0].equals("TOP5")) {
					int day_start = Integer.valueOf(arrline[2]);
					int month_start = Integer.valueOf(arrline[3]);
					int day_end = Integer.valueOf(arrline[4]);
					int month_end = Integer.valueOf(arrline[5]);
					Period period = new Period(month_start, day_start, month_end, day_end);
					DisplayInfo.top5(arrline[1], period, HM, HMC);
				}

				if (arrline[0].equals("10Days")) {
					
					ArrayList<String> arrAct = activities_places.get(arrline[1]);
					Collections.sort(arrAct,new Comparator<String>() {

						@Override
						public int compare(String arg0, String arg1) {
							if(HM.get(arg0).getPrice() > HM.get(arg1).getPrice() )
								return 1;
							return -1;
						}
					});
					DisplayInfo.tenDays(arrAct.get(0));
					
					

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
