package runtime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import classes.Task;

public class TaskList {
	// Stores the user's menu selection
	private int selection;
	// Controls the loop for running the application
	private boolean running;
	// List to store task objects
	private ArrayList<Task> tasks;
	// Static Scanner instance to handle user input
	private static final Scanner scan = new Scanner(System.in);

	// Constructor initializes default values
	public TaskList() {
		selection = 0;
		running = true;
		tasks = new ArrayList<>();
	}

	// Main method to run the task list application
	public void run() {
		while (running) {
			// Display menu options
			System.out.println("-----------------------------");
			System.out.println("Welcome to Task Priority List");
			System.out.println("-----------------------------");
			System.out.println("Enter any of the following:");
			System.out.println("     1) Add a new task to the list");
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
			case 1: // Add a new task
				System.out.println("Task: ");
				String taskName = scan.nextLine(); // Get task name

				int priority;
				do {
					System.out.println("Priority (1-5): ");
					while (!scan.hasNextInt()) { // Ensure valid integer input
						System.out.println("Invalid input! Enter a number between 1 and 5.");
						scan.next(); // Clear invalid input
					}
					priority = scan.nextInt();
					scan.nextLine(); // Consume newline
				} while (priority < 1 || priority > 5); // Ensure priority is within range

				tasks.add(new Task(priority, taskName)); // Add task to list
				break;

			case 2: // Print the task list
				if (tasks.isEmpty()) {
					System.out.println("No tasks available.");
				} else {
					tasks.sort(Comparator.comparing(Task::getPriority)); // Sort tasks by priority (ascending order)
					for (Task current : tasks) {
						System.out.println(current); // Print each task
					}
				}
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

	// Main method to initiate the TaskList application
	public static void main(String[] args) {
		TaskList tl = new TaskList(); // Create TaskList instance
		tl.run(); // Start the application
	}
}
