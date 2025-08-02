import java.util.Scanner;

public class AttendanceTable {
	public static void main(String[] args) {
		
	}

	public static String[] studentsRecord() {
		String[] students;
		students = new String[10];
		String newStudent;
		Scanner myScan = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			newStudent = myScan.nextLine();
			if (newStudent.equals("."))
				break;
			else if (newStudent.length() > 10)
				System.out.println("Error: Names longer than 10 won't count");
				i--;
				continue;
			else if (newStudent.equals("")) {
				System.out.println("Error: Students without name won't count");
				i--;
				continue;
			}
			students[i] = newStudent;
		}
	} 
}