package classes;

import interfaces.Priority;

// Task class implements the Priority interface
public class Task implements Priority {
	// Fields to store task details
	private int priority;
	private String task;

	// Constructor that initializes both priority and task
	public Task(int priority, String task) {
		setPriority(priority);
		setTask(task);
	}

	// Default constructor assigns default values
	public Task() {
		this(5, "Unknown"); // Default priority = 5, task = "Unknown"
	}

	// Constructor with only priority, assigns "Unknown" as task name
	public Task(int priority) {
		this(priority, "Unknown");
	}

	// Constructor with only task name, assigns priority 5
	public Task(String task) {
		this(5, task);
	}

	// Returns a formatted string representation of the task
	@Override
	public String toString() {
		return "Task: " + task + "\t\tPriority: " + priority;
	}

	// Sets the priority of the task
	@Override
	public void setPriority(int priority) {
		this.priority = priority;
	}

	// Returns the priority of the task
	@Override
	public int getPriority() {
		return priority;
	}

	// Returns the task description
	public String getTask() {
		return task;
	}

	// Sets the task description
	public void setTask(String task) {
		this.task = task;
	}
}
