import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadPlaces {

	public static HashMap<String, Country> readplaces(String places) {
		HashMap<String, Country> HMP = new HashMap<String, Country>();

		String CurrentLine;
		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader(places);
			br = new BufferedReader(fr);

			while ((CurrentLine = br.readLine()) != null) {
				String[] arrline = CurrentLine.split(" ");
				if (HMP.containsKey(arrline[0])) {
					if (HMP.get(arrline[0]).HMJudete.containsKey(arrline[1])) {
						if (HMP.get(arrline[0]).HMJudete.get(arrline[1]).HMOrase.containsKey((arrline[2]))) {
							if (!HMP.get(arrline[0]).HMJudete.get(arrline[1]).HMOrase.get((arrline[2])).locuri
									.contains(arrline[3])) {
								HMP.get(arrline[0]).HMJudete.get(arrline[1]).HMOrase.get((arrline[2])).locuri
										.add(arrline[3]);
							}
						}else {
							Oras oras = new Oras();
							oras.locuri.add(arrline[3]);
							HMP.get(arrline[0]).HMJudete.get(arrline[1]).HMOrase.put(arrline[2],oras);
						}
					}else {
						Judet judet =new Judet();
						Oras oras = new Oras();
						oras.locuri.add(arrline[3]);
						judet.HMOrase.put(arrline[2],oras);
						HMP.get(arrline[0]).HMJudete.put(arrline[1], judet);
					}
				}else {
					Country country = new Country();
					Judet judet =new Judet();
					Oras oras = new Oras();
					oras.locuri.add(arrline[3]);
					judet.HMOrase.put(arrline[2], oras);
					country.HMJudete.put(arrline[1], judet);
					HMP.put(arrline[0], country);
				}
			}

		} catch (

		IOException e) {
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
		return HMP;
	}
}
