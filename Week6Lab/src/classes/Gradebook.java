package classes;

public class Gradebook {

	Student[] students; // Array of student records

	public Gradebook() {
		students = new Student[0]; // Initialize empty gradebook
	}

	// Add a new student by resizing the array
	public void addStudent(Student student) {
		Student[] temp = students;
		students = new Student[temp.length + 1];
		for (int i = 0; i < temp.length; i++) {
			students[i] = temp[i];
		}
		students[students.length - 1] = student;
	}

	// Remove a student by replacing them with the last entry
	public void removeStudent(int index) {
		if (index >= 0 && index < students.length) {
			students[index] = students[students.length - 1];
			Student[] tempArr = students;
			students = new Student[tempArr.length - 1];
			for (int i = 0; i < students.length; i++) {
				students[i] = tempArr[i];
			}
		}
	}

	// Clear the gradebook
	public void clearGradebook() {
		students = new Student[0];
	}

	// Replace a student at a specific index
	public void setStudentAt(Student student, int index) {
		try {
			students[index] = student;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index out of bounds. " + e.getMessage());
		}
	}

	// Retrieve a student at a specific index
	public Student getStudentAt(int index) {
		return students[index];
	}

	// Sort the students by score
	public void sortStudents() {
		Sorting.selectionSort(students);
	}

	// String representation of the gradebook
	@Override
	public String toString() {
		String output = String.format("%-15s %-15s %5s\n", "<First Name>", "<Last Name>", "<Score>");
		output += "---------------------------------------------------------\n";

		if (students.length < 1) {
			output += "No students in gradebook.";
		} else {
			for (Student student : students) {
				output += student.toString() + "\n";
			}
		}

		return output;
	}
}
