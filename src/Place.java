import java.util.ArrayList;

public class Place {

	private String name;
	private String oras;
	private Double price;
	private ArrayList<String> activities;
	private Period period;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOras() {
		return oras;
	}
	public void setOras(String oras) {
		this.oras = oras;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public ArrayList<String> getActivities() {
		return activities;
	}
	public void setActivities(ArrayList<String> activities) {
		this.activities = activities;
	}
	public Period getPeriod() {
		return period;
	}
	public void setPeriod(Period period) {
		this.period = period;
	}
	public Place(String name, String oras, Double price, ArrayList<String> activities, Period period) {
		super();
		this.name = name;
		this.oras = oras;
		this.price = price;
		this.activities = activities;
		this.period = period;
	}

}
