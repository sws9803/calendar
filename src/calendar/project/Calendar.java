package calendar.project;

import java.util.Scanner;

public class Calendar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

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

	public void sample() {
		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();
		Prompt p = new Prompt();
		while (true) {
			System.out.println("년도를 입력하시오");
			System.out.print(p.YEAR_PROMPT);
			int year = scan.nextInt();
			if (year<0) {
				break;
			}
			System.out.println("달을 입력하시오");
			System.out.print(p.MONTH_PROMPT);
			int month = scan.nextInt();
			if (1>month || month>12) {
				break;
			}
			int maxDay = getMaxDaysOfMonth(year, month);
			
			
			System.out.printf("    <<%4d년%3d월>>\n", year, month);
			System.out.println("-------------------");
			System.out.println("SU MO TU WE TH FR SA");
			for (int i = 1; i <= maxDay; i++) {
				System.out.printf("%3d", i);
				if (i % 7 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			cal.runPrompt(year, month);
		}
		scan.close();
	}

	public void runPrompt(int year, int month) {
		// TODO Auto-generated method stub
//		Scanner scan = new Scanner(System.in);
		Prompt p = new Prompt();
		Calendar cal = new Calendar();
		// 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램\
//		int month = 0;
//			System.out.println("달을 입력하세요.");
//			System.out.print(p.PROMPT);
//			month = scan.nextInt();

		if (1 <= month && month <= 12) {
			System.out.print(p.PROMPT);
			System.out.println(month + "월은 " + cal.getMaxDaysOfMonth(year, month) + "일까지 있습니다.");

		} else {
			System.out.print(p.PROMPT);
			System.out.println("잘못입력했습니다.");
		}
//		scan.close();
	}

	public static void main(String[] args) {
		Calendar cal = new Calendar();
		cal.sample();
	}
}