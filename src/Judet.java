import java.util.ArrayList;
import java.util.HashMap;

public class Judet {
	public HashMap<String,Oras> HMOrase =new HashMap<String,Oras>();	
	/*Un judet contine un HashMap de orase. O data gasit orasul voi apela functia get 
	 * a Hashmapului de informatii pentru a stabili daca in locul respectiv se poate sta
	 * perioada A-B  -------------> Not Done Yet.
	 */
	
	/*public Judet() {
		this.HMOrase = new HashMap<String,String>();
	}*/
	
	public Judet() {
		this.HMOrase = new HashMap<String,Oras>();
	}
	public Judet(HashMap<String, Oras> hMOrase) {
		super();
		HMOrase = hMOrase;
	}
	
	public void addOras(String nOras,Oras oras) {
		this.HMOrase.put(nOras, oras);
	}
}
