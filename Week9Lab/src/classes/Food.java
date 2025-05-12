package classes;

public class Food {

	private String name, type;
	private double calories, daily;

	public Food(String name, String type, double calories, double daily) {
		this.name = name;
		this.type = type;
		this.calories = calories;
		this.daily = daily;
	}
	
	public Food() {
		this("","",0,0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public double getDailyPercent() {
		return daily;
	}

	public void setDaily(double daily) {
		this.daily = daily;
	}

	@Override
	public String toString() {
		String output = String.format("%-20s %-15s %15s %15s",  name, type, calories, daily);
		return output;
	}
}
