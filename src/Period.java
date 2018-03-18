
public class Period {

	private int month_start;
	private int day_start;
	private int month_end;
	private int day_end;
	
	
	public Period(int month_start, int day_start, int month_end, int day_end) {
		super();
		this.month_start = month_start;
		this.day_start = day_start;
		this.month_end = month_end;
		this.day_end = day_end;
	}
	
	public int getMonth_start() {
		return month_start;
	}
	public void setMonth_start(int month_start) {
		this.month_start = month_start;
	}
	public int getDay_start() {
		return day_start;
	}
	public void setDay_start(int day_start) {
		this.day_start = day_start;
	}
	public int getMonth_end() {
		return month_end;
	}
	public void setMonth_end(int month_end) {
		this.month_end = month_end;
	}
	public int getDay_end() {
		return day_end;
	}
	public void setDay_end(int day_end) {
		this.day_end = day_end;
	}
	
}
