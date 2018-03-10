import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class DisplayInfo {
	// afisarea informatiilor specifice taskului 1
	public static void showAllInfo(String X, HashMap<String, Place> HM) {
		Place place = HM.get(X);

		FileWriter fw = null;
		BufferedWriter bw = null;
		try {

			fw = new FileWriter("output.out", true);
			bw = new BufferedWriter(fw);
			bw.write("Locul se numeste: " + place.getName() + "\n");
			bw.write("Orasul este: " + place.getOras() + "\n");
			bw.write("Pretul mediu pe zi este: " + place.getPrice() + "\n");
			bw.write("Activitatile care se pot practica aici sunt: ");
			for (int i = 0; i < place.getActivities().size(); i++) {
				bw.write(place.getActivities().get(i) + ((i==place.getActivities().size()-1)?"\n":" "));
			}
			bw.write("Perioada este " + place.getPeriod().getDay_start() + "." + place.getPeriod().getMonth_start() + "-"
					+ place.getPeriod().getDay_end() + "." + place.getPeriod().getMonth_end());

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
	}
}
