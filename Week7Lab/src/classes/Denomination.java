package classes;

public class Denomination {

	private double coefficient;
	private int count;
	
	public Denomination (double coefficient) {
		this.coefficient = coefficient;
		setCount(0);
	}
	
	public Denomination () {
		this(0);
	}
	
	@Override
	public String toString() {
		String print = "Denomination of $" + coefficient;
		return print;
	}
	
	public double valueDollars() {
		return coefficient * count;
	}
	
	public double valueCents() {
		return coefficient * count * 100;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
