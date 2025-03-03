package insurance;

import java.text.DecimalFormat;


/**
 * Home insurance policy
 * 
 * Policy information includes: - name of insured - house square footage -
 * amount of dwelling coverage in dollars - amount of contents coverage in
 * dollars - amount of liability coverage in dollars Sales commision is based on
 * the formula: comission = (liability * 30%) + ((dwelling + contents) * 20%)
 */
public class Home extends Policy{


	private double footage = 0;
	private double dwelling = 0;
	private double contents = 0;
	private double liability = 0;

	// ****************************************************************
	// Constructor
	// ****************************************************************

	// constructor with all variables for instanced state
	public Home(String fName, String lName, double footage, double dwelling, double contents, double liability) {
		super(fName, lName);
		this.footage = footage;
		this.dwelling = dwelling;
		this.contents = contents;
		this.liability = liability;
	}

	// constructor with no input uses user input values in class definition until
	// client sets them otherwise
	public Home() {
		super();
	}

	// ****************************************************************
	// Methods
	// ****************************************************************

	// compute commission
	public void computeCommission() {
		commission = (liability * 0.3) + ((dwelling + contents) * 0.2);
		return;
	}

	// toString
	/**
	 * Name (Last, First): Doe, John House square footage: 1000 sqft Dwelling
	 * coverage: $100000.00 Contents coverage: $25000.00 Liability coverage:
	 * $50000.00 Agent commission: $40000.00
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("$###,###,###.00");
		return "Home Policy\n----------\nName: " + lName + ", " + fName + "\nHouse square footage: " + footage
				+ " sqft\nDwelling coverage: " + df.format(dwelling) + "\nContents coverage: " + df.format(contents)
				+ "\nLiability coverage: " + df.format(liability) + "\nAgent commission: "
				+ df.format(commission) + "\n\n";
	}

	// ****************************************************************
	// Getters and setters
	// ****************************************************************

	// square footage
	public void setFootage(double footage) {
		this.footage = footage;
		return;
	}

	public double getFootage() {
		return footage;
	}

	// dwelling coverage
	public void setDwelling(double dwelling) {
		this.dwelling = dwelling;
		return;
	}

	public double getDwelling() {
		return dwelling;
	}

	// contents coverage
	public void setContents(double contents) {
		this.contents = contents;
		return;
	}

	public double getContents() {
		return contents;
	}

	// liability coverage
	public void setLiability(double liability) {
		this.liability = liability;
		return;
	}

	public double getLiability() {
		return liability;
	}
}
