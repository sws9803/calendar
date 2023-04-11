package calendar.project;

public class Calendar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
//
	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		} else {
			return MAX_DAYS[month - 1];
		}
	}
	
	public void printCalendar(int year, int month, int weekday) {
		
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println("-------------------");
		System.out.println("SU MO TU WE TH FR SA");
		
		//print blank space
		for (int i = 0; i< weekday; i ++) {
			System.out.print("   ");
		}
		
		int maxDay = getMaxDaysOfMonth(year, month);
		int count = 7 - weekday;
		int delim = (count < 7) ? count : 0;
		
		//print first line
		for (int i = 1; i<=count; i++) {
			System.out.printf("%3d",i);
		}
		System.out.println();
		
		for (int i = count +1 ; i <= (maxDay); i++) {
			System.out.printf("%3d", i);
			if (i % 7 == delim) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
	}
		

	public void maxdays(int year, int month) {
		// 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램\
		if (1 <= month && month <= 12) {
			System.out.println(month + "월은 " + getMaxDaysOfMonth(year, month) + "일까지 있습니다.");

		} else {
			System.out.println("잘못입력했습니다.");
		}
	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();

	}
}