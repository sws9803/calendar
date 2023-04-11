package calendar.project;

import java.util.Scanner;

public class Prompt {

	/**
	 * 
	 * @param week 요일명
	 * @return 0~6 (0 = Sunday~)
	 */

	public int parseDay(String week) {
		if (week.equals("su")) {
			return 0;
		}else if (week.equals("mo")) {
			return 1;
		}else if (week.equals("tu")) {
			return 2;
		}else if (week.equals("we")) {
			return 3;
		}else if (week.equals("th")) {
			return 4;
		}else if (week.equals("fr")) {
			return 5;
		}else if (week.equals("sa")) {
			return 6;
		}else {
			return 0;
		}
	}
	
	public void runPrompt() {
		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		int month = -1;
		int year = -1;
		int weekday = 0;
		
		while(true) {
			System.out.println("년도를 입력하시오");
			System.out.print("YEAR> ");
			year = scan.nextInt();
			if (year == -1) {
				break;
			}
			System.out.println("달를 입력하시오");
			System.out.print("MONTH> ");
			month = scan.nextInt();
			if (month == -1) {
				break;
			}
			if (month > 12) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
//			System.out.println("첫째 날의 요일을 입력하세요 (su, mo, tu, we, th, fr, sa)");
//			System.out.print("WEEK> ");
//			String str_weekday = scan.next();
//			weekday = parseDay(str_weekday);
			if (weekday == -1) {
				break;
			}
			
			cal.printCalendar(year,month);
//			cal.maxdays(year,month);
		}
		System.out.println("Bye~");
		scan.close();
	}
	
	public static void main(String[] args) {
		
	}
}
