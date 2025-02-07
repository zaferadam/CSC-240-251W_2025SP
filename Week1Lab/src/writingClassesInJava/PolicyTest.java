package writingClassesInJava;

public class PolicyTest {

	public static void main(String[] args)

	{

		// Create and set an Auto policy object setting data using constructor

		Auto a = new Auto("Jerry", "Seinfed", "Chevy", "Malibu", 10000.0, 50000.0);

		// Compute commission

		a.computeCommission();

		// Print auto policy

		System.out.println(a);

		// Create and set a Home policy object setting data using setters

		Home h = new Home();

		h.setFirstName("Elaine");

		h.setLastName("Benes");

		h.setContents(5000);

		h.setDwelling(32000);

		h.setFootage(4000);

		h.setLiability(10000);

		// Compute commission

		h.computeCommission();

		// Print home policy

		System.out.println(h);

		// Create and set an Life policy object setting data using constructor

		Life l = new Life("Cosmo", "Kramer", 35, 50000);

		// Compute commission

		l.computeCommission();

		// Print life policy

		System.out.println(l);

		// Test getters

		System.out.println("Get life firstName: " + l.getFirstName());

		System.out.println("Get life lastName: " + l.getLastName());

		System.out.println("Get life age: " + l.getAge());

		System.out.println("Get life term: " + l.getTerm());

	}

}