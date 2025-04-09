package runtime;

import java.util.Scanner;
import classes.Gradebook;
import classes.Student;

public class Driver {

	private boolean running;
	private int entries;
	private int selection;
	private Gradebook gradebook;
	private static final Scanner scan = new Scanner(System.in);

	public Driver() {
		running = true;
		entries = 5;
		selection = 0;
		gradebook = new Gradebook();
	}

	public void run() {

		while (running) {
			// Display menu options
			System.out.println("-----------------------------");
			System.out.println("Welcome to Parkland Gradebook Manager");
			System.out.println("-----------------------------");
			System.out.println("Enter any of the following:");
			System.out.println("     1) Enter new Student List");
			System.out.println("     2) Print the List");
			System.out.println("     3) Quit");

			try {
				selection = scan.nextInt(); // Read user selection
				scan.nextLine(); // Consume newline to avoid input issues
			} catch (Exception e) {
				System.out.println("Invalid input! Please enter a number.");
				scan.nextLine(); // Clear invalid input
				continue; // Restart loop
			}

			// Handle user's menu selection
			switch (selection) {
			case 1: // Add a new Gradebook
				gradebook.clearGradebook();
				System.out.println("Add " + entries + " students to the gradebook:");
				String[] temp;
				for (int i = 0; i < entries; i++) {
					try {
						System.out.print("<First Name> <Last Name> <Score>: ");
						temp = scan.nextLine().trim().split("\\s+");

						if (temp.length < 3) {
							throw new IllegalArgumentException(
									"Not enough input values. Expected format: <FirstName> <LastName> <Score>");
						}

						String firstName = temp[0];
						String lastName = temp[1];
						int score = Integer.parseInt(temp[2]);
						if (score < 0 || score > 100) {
							throw new IllegalArgumentException("Score must be between 0 and 100");
						}

						gradebook.addStudent(new Student(firstName, lastName, score));
					} catch (NumberFormatException e) {
						System.out.println("Invalid input: Score must be an integer. Please try again.");
						i--; // Decrement i to retry the same iteration
					} catch (IllegalArgumentException e) {
						System.out.println("Invalid input: " + e.getMessage());
						i--; // Decrement i to retry
					} catch (Exception e) {
						System.out.println("Unexpected error: " + e.getMessage());
						i--; // Decrement i to retry
					}
				}
				break;

			case 2: // Print the task Gradebook
				gradebook.sortStudents();
				System.out.println(gradebook);
				break;

			case 3: // Quit the application
				running = false;
				System.out.println("Thank you, please come again!");
				break;

			default:
				System.out.println("Invalid Selection"); // Handle invalid menu choices
				break;
			}
		}

	}

	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.run();
	}
}
