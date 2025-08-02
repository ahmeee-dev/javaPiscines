import java.util.Scanner;

public class AttendanceTable {
	public static void main(String[] args) {

		Scanner myScan = new Scanner(System.in);
		String[] students = studentsRecord();
		int[] classTime = new int[2];
		int[] classDate = new int[2];
		String token = "";

		for (int i = 0; i < 2; i++) {
			token = myScan.next();
			if (token.equals("."))
				break;
			classTime[i] = token;
			token = myScan.next();
			classDate[i] = getDate(token);
			// to put them in crescent order
			if (i == 1 && classDate[0] < classDate[1]) {
				int temp = classDate[0];
				classDate[0] = classDate[1];
				classDate[1] = temp;
				temp = classTime[0];
				classTime[0] = classTime[1];
				classTime[1] = temp;
			}
		}



	}

	public static String[] studentsRecord(Scanner myScan) {
		String[] students;
		students = new String[10];
		String newStudent;

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

	// due to days displacement (September 2020 started on Tuesday), to optimize code started counting from Tuesday
	public static int getDate(String date) {

		String[] weekdays = { "TU", "WE", "TH", "FR", "SA", "SU" };
		for (int i = 0; i < 7; i++) {
			if (date.equals(weekdays[i]))
				return (i + 1);
		}
		return (0);
	}
}