package insurance;

import java.text.DecimalFormat;


/**
 * Life insurance policy
 * 
 * Policy information includes: - name of insured - age of insured - amount of
 * term life coverage in dollars Sales commission is based on the following
 * formula: commission = term life * 20%
 */
public class Life extends Policy{

	private int age = 0;
	private double term = 0;

	// ****************************************************************
	// Constructor
	// ****************************************************************

	// constructor with all variables for instanced state
	public Life(String fName, String lName, int age, double term) {
		super(fName, lName);
		this.age = age;
		this.term = term;
	}

	// constructor with no input uses user input values in class definition until
	// client sets them otherwise
	public Life() {
		super();
	}

	// ****************************************************************
	// Methods
	// ****************************************************************
	// compute commission
	public void computeCommission() {
		commission = term * 0.2;
		return;
	}

	// toString
	public String toString() {
		DecimalFormat df = new DecimalFormat("$###,###,###.00");
		return "Life Policy\n----------\nName: " + lName + ", " + fName + "\nAge: " + age
				+ " years\nAmount of term life coverage: " + df.format(term) + "\nAgent commission: "
				+ df.format(commission) + "\n\n";
	}

	// ****************************************************************
	// Getters and setters
	// ****************************************************************

	// age
	public void setAge(int age) {
		this.age = age;
		return;
	}

	public int getAge() {
		return age;
	}

	// term
	public void setTerm(double term) {
		this.term = term;
		return;
	}

	public double getTerm() {
		return term;
	}
}
