import java.util.Scanner;

public class AttendanceTable {
	public static void main(String[] args) {

		Scanner myScan = new Scanner(System.in);
		String[] students = studentsRecord(myScan);
		int[] classTime = new int[10];
		int[] classDate = new int[10];
		int classCount = 0;
		String token = "";
		int tokenInt = 0;

		for (int i = 0; i < 10; i++) {
			if (myScan.hasNextInt())
				tokenInt = myScan.nextInt();
			else {
				myScan.next();
				break;
			}
			classTime[i] = tokenInt;
			token = myScan.next();
			classDate[i] = getDate(token);
			classCount++;
		}

		// Put them in ascending order in case of descending one
		for (int i = 0; i < classCount; i++) {
			for (int j = 0; j < classCount - i - 1; j++) {
				if (classDate[j] > classDate[j + 1]) {
					int tempDate = classDate[j];
					classDate[j] = classDate[j + 1];
					classDate[j + 1] = tempDate;

					int tempTime = classTime[j];
					classTime[j] = classTime[j + 1];
					classTime[j + 1] = tempTime;
				}
			}
		}

		int classMonth = 0;
		for (int i = 0; i < classCount; i++) {
			if (classDate[i] == 1 || classDate[i] == 2)
				classMonth += 5;
			else
				classMonth += 4;
		}

		int StudentsArrLen = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null)
				StudentsArrLen++;
		}
		int[][] attendance = new int[StudentsArrLen][classMonth]; //Students lenght va messo manualmente per non avere errori

		while (true) {
			String studentPresence = myScan.next();
			if (studentPresence.equals("."))
				break;
			int timePresence = myScan.nextInt();
			int datePresence = myScan.nextInt();
			int presence = myScan.next().equals("HERE") ? 1 : -1;

			
			
			for (int i = 0; i < StudentsArrLen; i++) {
				int week = 1;
				for (int j = 0; j < classMonth; j++) {
					if (j > 0 && j % classCount == 0)
						week++;
					int day = classDate[j % classCount] + ((week - 1) * 7);
					if (studentPresence.equals(students[i]) && datePresence == day && timePresence == classTime[j % classCount]) {
						attendance[i][j] = presence;
						i = StudentsArrLen; //optimizing performances
						j = classMonth;
					}
					
				}
			}
		}

		String[] weekdays = { "TU", "WE", "TH", "FR", "SA", "SU", "MO" };
		int week = 1;
		System.out.print("           ");
		for (int i = 0; i < classMonth; i++) {
			for (int j = 0; j < classCount; j++) {
				int day = classDate[j] + ((week - 1) * 7);
				if (day < 31) {
					String spaces = day >= 10 ? "  " : "   ";
					System.out.print(classTime[j] + ":00 " + weekdays[classDate[j] - 1] + spaces + day + "|");
					i++;
				}
			}
			i--;
			week++;
		}
		System.out.println("");

		for (int i = 0; i < StudentsArrLen; i++) {
			int spaces = 11 - students[i].length();
			for (int q = 0; q < spaces; q++) {
				System.out.print(" ");
			} 
			System.out.print(students[i]);

			for (int j = 0; j < classMonth; j++) {
				System.out.print("         ");
				if (attendance[i][j] >= 0)
					System.out.print(" ");
				System.out.print(attendance[i][j] + "|");
			}
			System.out.println("");
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
			else if (newStudent.length() > 10) {
				System.out.println("Error: Names longer than 10 won't count");
				i--;
				continue;
			}
			else if (newStudent.equals("")) {
				System.out.println("Error: Students without name won't count");
				i--;
				continue;
			}
			students[i] = newStudent;
		}
		return (students);
	}

	// due to days displacement (September 2020 started on Tuesday), to optimize code started counting from Tuesday
	public static int getDate(String date) {

		String[] weekdays = { "TU", "WE", "TH", "FR", "SA", "SU", "MO"};
		for (int i = 0; i < 7; i++) {
			if (date.equals(weekdays[i]))
				return (i + 1);
		}
		return (0);
	}
}