package classes;

/**
 * The Denomination class represents a monetary unit (bill or coin) 
 * and keeps track of how many units are used.
 */
public class Denomination {

	private double coefficient; // The dollar value of a single unit of this denomination
	private int count;          // The number of units of this denomination in use

	/**
	 * Constructor that sets the denomination's value and initializes count to 0.
	 * 
	 * @param coefficient The dollar value of the denomination (e.g., 0.25 for a quarter).
	 */
	public Denomination(double coefficient) {
		this.coefficient = coefficient;
		setCount(0); // initialize count to zero
	}

	/**
	 * Default constructor sets the denomination value to 0.
	 */
	public Denomination() {
		this(0);
	}

	/**
	 * Returns a string representation of the denomination.
	 * 
	 * @return A string like "Denomination of $0.25"
	 */
	@Override
	public String toString() {
		String print = "Denomination of $" + coefficient;
		return print;
	}

	/**
	 * Calculates the total dollar value based on the count.
	 * 
	 * @return The total value in dollars.
	 */
	public double valueDollars() {
		return coefficient * count;
	}

	/**
	 * Calculates the total value in cents based on the count.
	 * 
	 * @return The total value in cents.
	 */
	public double valueCents() {
		return coefficient * count * 100;
	}

	/**
	 * Getter for the count of this denomination.
	 * 
	 * @return The number of units.
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Setter for the count of this denomination.
	 * 
	 * @param count The number of units to set.
	 */
	public void setCount(int count) {
		this.count = count;
	}
}
