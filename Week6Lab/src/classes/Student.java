package classes;

// The Student class implements Comparable<Student> to allow comparison between Student objects
public class Student implements Comparable<Student> {

    // Private instance variables to store the student's score, first name, and last name
    private int score;
    private String firstName;
    private String lastName;

    // Constructor that initializes all fields
    public Student(String firstName, String lastName, int score) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.score = score;
    }

    // Overloaded constructor that sets firstName to an empty string if not provided
    public Student(String lastName, int score) {
        this("", lastName, score);
    }

    // Overloaded constructor that sets firstName to an empty string and score to 0 if not provided
    public Student(String lastName) {
        this("", lastName, 0);
    }

    // Overloaded constructor that sets lastName to "Unknown" and firstName to an empty string
    public Student(int score) {
        this("", "Unknown", score);
    }

    // Method required by the Comparable interface; currently returns 0 (no actual comparison logic implemented)
    @Override
    public int compareTo(Student o) {
        int result;
        if (this.score == o.score) {
        	result=0;
        } else if (this.score < o.score) {
        	result = -1;
        } else {
        	result = 1;
        }
        return result;
    }
    
    @Override
    public String toString() {
        return String.format("%-15s %-15s %5d", firstName, lastName, score);
    }

    // Getter method for score
    public int getScore() {
        return score;
    }

    // Setter method for score
    public void setScore(int score) {
        this.score = score;
    }

    // Getter method for first name
    public String getFirstName() {
        return firstName;
    }

    // Setter method for first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter method for last name
    public String getLastName() {
        return lastName;
    }

    // Setter method for last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
