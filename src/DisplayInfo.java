import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DisplayInfo {
	// afisarea informatiilor specifice taskului 1
	public static void showAllInfo(String X, HashMap<String, Place> HM) {
		Place place = HM.get(X);
		int i;
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {

			fw = new FileWriter("output.out", true);
			bw = new BufferedWriter(fw);
			bw.write("Locul se numeste: " + place.getName() + "\n");
			bw.write("Orasul este: " + place.getOras() + "\n");
			bw.write("Pretul mediu pe zi este: " + place.getPrice() + "\n");
			bw.write("Activitatile care se pot practica aici sunt: ");
			for (i = 0; i < place.getActivities().size(); i++) {
				bw.write(place.getActivities().get(i) + ((i == place.getActivities().size() - 1) ? "\n" : " "));
			}
			bw.write("Perioada este " + place.getPeriod().getDay_start() + "." + place.getPeriod().getMonth_start()
					+ "-" + place.getPeriod().getDay_end() + "." + place.getPeriod().getMonth_end());

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

	/*
	 * Am adaugat intr-o coada de prioritate (pq) toate locatiile in care se poate
	 * merge in perioada A-B acolo. Pentru a obtine TOP5 i-am dat ca argument
	 * constructorului cozii un comparator care ordoneaza elementele in functie de
	 * pret.Am facut cate un if separat pentru cazurile in care clientul vrea sa
	 * stie informatii specifice despre oras,judet sau tara.
	 */
	public static void top5(String area, Period period, HashMap<String, Place> HM, HashMap<String, Country> HMC) {
		FileWriter fw = null;
		BufferedWriter bw = null;

		// Coada de prioritate
		PriorityQueue<Place> pq = new PriorityQueue<Place>(new Comparator<Place>() {
			public int compare(Place p1, Place p2) {
				return (int) (p1.getPrice() - p2.getPrice());
				// comparam preturile
			}
		});

		try {

			fw = new FileWriter("output.out", true);
			bw = new BufferedWriter(fw);
			String[] arrarea = area.split(":");
			if (arrarea[0].equals("TARA")) {
				Country country = HMC.get(arrarea[1]);
				for (Map.Entry<String, Judet> entry : country.HMJudete.entrySet()) {
					Judet judet = entry.getValue();
					for (Map.Entry<String, Oras> entry1 : judet.HMOrase.entrySet()) {
						Oras oras = entry1.getValue();
						int i;
						for (i = 0; i < oras.locuri.size(); i++) {
							System.out.println(oras.locuri.get(i));
							if (HM.get(oras.locuri.get(i)).getPeriod().getMonth_start() < period.getMonth_start()
									&& HM.get(oras.locuri.get(i)).getPeriod().getMonth_end() > period.getMonth_end()) {
								pq.add(HM.get(oras.locuri.get(i)));
							}
							if (HM.get(oras.locuri.get(i)).getPeriod().getMonth_start() == period.getMonth_start()
									&& HM.get(oras.locuri.get(i)).getPeriod().getMonth_end() > period.getMonth_end()) {
								if (HM.get(oras.locuri.get(i)).getPeriod().getDay_start() <= period.getDay_start()) {
									pq.add(HM.get(oras.locuri.get(i)));
								}
							}

							if (HM.get(oras.locuri.get(i)).getPeriod().getMonth_start() < period.getMonth_start()
									&& HM.get(oras.locuri.get(i)).getPeriod().getMonth_end() == period.getMonth_end()) {
								if (HM.get(oras.locuri.get(i)).getPeriod().getDay_end() >= period.getDay_end()) {
									pq.add(HM.get(oras.locuri.get(i)));
								}
							}

							if (HM.get(oras.locuri.get(i)).getPeriod().getMonth_start() == period.getMonth_start()
									&& HM.get(oras.locuri.get(i)).getPeriod().getMonth_end() == period.getMonth_end()) {
								if (HM.get(oras.locuri.get(i)).getPeriod().getDay_end() >= period.getDay_end() && HM
										.get(oras.locuri.get(i)).getPeriod().getDay_start() <= period.getDay_start()) {
									pq.add(HM.get(oras.locuri.get(i)));
								}
							}

						}
					}
				}

			}

			if (arrarea[0].equals("JUDET")) {
				for (Map.Entry<String, Country> entry : HMC.entrySet()) {
					Country value = entry.getValue();
					if (value.HMJudete.containsKey(arrarea[1])) {
						Judet judet = value.HMJudete.get(arrarea[1]);
						for (Map.Entry<String, Oras> entry1 : judet.HMOrase.entrySet()) {
							ArrayList<String> zone = entry1.getValue().locuri;
							int i;
							for (i = 0; i < zone.size(); i++) {
								if (HM.get(zone.get(i)).getPeriod().getMonth_start() < period.getMonth_start()
										&& HM.get(zone.get(i)).getPeriod().getMonth_end() > period.getMonth_end()) {
									pq.add(HM.get(zone.get(i)));
								}
								if (HM.get(zone.get(i)).getPeriod().getMonth_start() == period.getMonth_start()
										&& HM.get(zone.get(i)).getPeriod().getMonth_end() > period.getMonth_end()) {
									if (HM.get(zone.get(i)).getPeriod().getDay_start() <= period.getDay_start()) {
										pq.add(HM.get(zone.get(i)));
									}
								}

								if (HM.get(zone.get(i)).getPeriod().getMonth_start() < period.getMonth_start()
										&& HM.get(zone.get(i)).getPeriod().getMonth_end() == period.getMonth_end()) {
									if (HM.get(zone.get(i)).getPeriod().getDay_end() >= period.getDay_end()) {
										pq.add(HM.get(zone.get(i)));
									}
								}

								if (HM.get(zone.get(i)).getPeriod().getMonth_start() == period.getMonth_start()
										&& HM.get(zone.get(i)).getPeriod().getMonth_end() == period.getMonth_end()) {
									if (HM.get(zone.get(i)).getPeriod().getDay_end() >= period.getDay_end() && HM
											.get(zone.get(i)).getPeriod().getDay_start() <= period.getDay_start()) {
										pq.add(HM.get(zone.get(i)));
									}
								}

							}
						}

					}
				}

			}

			if (arrarea[0].equals("ORAS")) {
				for (Map.Entry<String, Country> entry : HMC.entrySet()) {
					Country value = entry.getValue();
					for (Map.Entry<String, Judet> entry1 : value.HMJudete.entrySet()) {
						Judet value1 = entry1.getValue();
						for (Map.Entry<String, Oras> entry2 : value1.HMOrase.entrySet()) {
							Oras oras = entry2.getValue();
							String nume = entry2.getKey();
							int i;
							if (nume.equals(arrarea[1]))
								for (i = 0; i < oras.locuri.size(); i++) {
									if (HM.get(oras.locuri.get(i)).getPeriod().getMonth_start() < period
											.getMonth_start()
											&& HM.get(oras.locuri.get(i)).getPeriod().getMonth_end() > period
													.getMonth_end()) {
										pq.add(HM.get(oras.locuri.get(i)));
									}
									if (HM.get(oras.locuri.get(i)).getPeriod().getMonth_start() == period
											.getMonth_start()
											&& HM.get(oras.locuri.get(i)).getPeriod().getMonth_end() > period
													.getMonth_end()) {
										if (HM.get(oras.locuri.get(i)).getPeriod().getDay_start() <= period
												.getDay_start()) {
											pq.add(HM.get(oras.locuri.get(i)));
										}
									}

									if (HM.get(oras.locuri.get(i)).getPeriod().getMonth_start() < period
											.getMonth_start()
											&& HM.get(oras.locuri.get(i)).getPeriod().getMonth_end() == period
													.getMonth_end()) {
										if (HM.get(oras.locuri.get(i)).getPeriod().getDay_end() >= period
												.getDay_end()) {
											pq.add(HM.get(oras.locuri.get(i)));
										}
									}

									if (HM.get(oras.locuri.get(i)).getPeriod().getMonth_start() == period
											.getMonth_start()
											&& HM.get(oras.locuri.get(i)).getPeriod().getMonth_end() == period
													.getMonth_end()) {
										if (HM.get(oras.locuri.get(i)).getPeriod().getDay_end() >= period.getDay_end()
												&& HM.get(oras.locuri.get(i)).getPeriod().getDay_start() <= period
														.getDay_start()) {
											pq.add(HM.get(oras.locuri.get(i)));
										}
									}

								}

						}
					}
				}

			}

			int i;
			bw.write("\n\nTOP:");
			for (i = 0; i < 5; i++) {
				if (!pq.isEmpty()) {
					bw.write(pq.poll().getName() + " ");
				}
			}

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

	public static void tenDays(String nameOfPlace) {

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {

			fw = new FileWriter("output.out", true);
			bw = new BufferedWriter(fw);
			bw.write("\n\nBest place is " + nameOfPlace);

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
