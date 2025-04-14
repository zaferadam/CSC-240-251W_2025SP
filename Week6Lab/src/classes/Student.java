package classes;

// Implements Comparable for sorting by score
public class Student implements Comparable<Student> {

	private int score;
	private String firstName;
	private String lastName;

	// Full constructor
	public Student(String firstName, String lastName, int score) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.score = score;
	}

	// Overloaded constructors for flexibility
	public Student(String lastName, int score) {
		this("", lastName, score);
	}

	public Student(String lastName) {
		this("", lastName, 0);
	}

	public Student(int score) {
		this("", "Unknown", score);
	}

	// Implement comparison based on score
	@Override
	public int compareTo(Student o) {
		if (this.score == o.score) {
			return 0;
		} else if (this.score < o.score) {
			return -1;
		} else {
			return 1;
		}
	}

	// String output format
	@Override
	public String toString() {
		return String.format("%-15s %-15s %5d", firstName, lastName, score);
	}

	// Getters and setters
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
