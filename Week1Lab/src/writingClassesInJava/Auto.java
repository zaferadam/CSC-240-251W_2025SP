package writingClassesInJava;

import java.text.DecimalFormat;

/**
 * Auto insurance policy
 * 
 * Policy information includes: - name of insured - make and model of automobile
 * - amount of liability coverage in dollars - amount of collision coverage in
 * dollars Sales commission is based on the formula: commission = (liability +
 * collision) * 30%
 */
public class Auto {

	/**
	 * instanced variables
	 */
	private String firstName = "";
	private String lastName = "";
	private String make = "";
	private String model = "";
	private double liability = 0;
	private double collision = 0;
	private double commission = 0;

	// ****************************************************************
	// Class Constructor
	// ****************************************************************

	public Auto(String fName, String lName, String make, String model, double liability, double collision) {
		firstName = fName;
		lastName = lName;
		this.make = make;
		this.model = model;
		this.liability = liability;
		this.collision = collision;
	}

	// constructor with no input uses default values in class definition until
	// client sets them otherwise
	public Auto() {

	}

	// ****************************************************************
	// Class Operators
	// ****************************************************************

	// Compute Commission
	// ***********
	public void computeCommission() {
		commission = (this.collision + this.liability) * 0.3;
		return;
	}

	// Output String
	// ***********
	/**
	 * Name (Last, First): Doe, John Make - Model: Ford - Focus Liability Coverage:
	 * $10000.00 Collision Coverage: $50000.00
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("$###,###,###.00");
		return "Auto Policy\n----------\nName: " + lastName + ", " + firstName + "\nMake - Model: " + make + " - "
				+ model + "\nLiability Coverage: " + df.format(liability) + "\nCollision Coverage: "
				+ df.format(collision) + "\nAgent Commision: " + df.format(commission) + "\n\n";
	}

	// ****************************************************************
	// Define setters and getters for class variables
	// ****************************************************************

	// First Name
	// ***********
	public void setFirstName(String name) {
		firstName = name;
		return;
	}

	public String getFirstName() {
		return firstName;
	}

	// Last Name
	// ***********
	public void setLastName(String name) {
		lastName = name;
		return;
	}

	public String getLastName() {
		return lastName;
	}

	// Auto Make
	// ***********
	public void setMake(String make) {
		this.make = make;
		return;
	}

	public String getMake() {
		return this.make;
	}

	// Auto Model
	// ***********
	public void setModel(String model) {
		this.model = model;
		return;
	}

	public String getModel() {
		return this.model;
	}

	// Liability Coverage
	// ***********
	public void setLiability(double liability) {
		this.liability = liability;
		return;
	}

	public double getLiability() {
		return this.liability;
	}

	// Collision Coverage
	// ***********
	public void setCollision(double collision) {
		this.collision = collision;
		return;
	}

	public double getCollision() {
		return this.collision;
	}

}