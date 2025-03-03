package insurance;

public abstract class Policy {

	/**
	 * Instanced Variables
	 */
	protected String fName = "";
	protected String lName = "";
	protected double commission = 0;
	
	public Policy (String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
	}
	
	public Policy() {
		super();
	}
	
	public abstract void computeCommission();

	public String getFirstName() {
		return fName;
	}

	public void setFirstName(String fName) {
		this.fName = fName;
	}

	public String getLastName() {
		return lName;
	}

	public void setLastName(String lName) {
		this.lName = lName;
	}
	
}
