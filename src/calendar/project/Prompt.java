package calendar.project;

import java.text.ParseException;
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
		} else if (week.equals("mo")) {
			return 1;
		} else if (week.equals("tu")) {
			return 2;
		} else if (week.equals("we")) {
			return 3;
		} else if (week.equals("th")) {
			return 4;
		} else if (week.equals("fr")) {
			return 5;
		} else if (week.equals("sa")) {
			return 6;
		} else {
			return 0;
		}
	}

	public void printMenu() {
		System.out.println("+--------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+--------------------+");
	}

	public void runPrompt() throws ParseException {
		printMenu();

		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {
			System.out.println("명령(1, 2, 3, h, q)");
			String cmd = scan.next();
			if (cmd.equals("1"))
				cmdRegister(scan, cal);
			else if (cmd.equals("2"))
				cmdSerch(scan, cal);
			else if (cmd.equals("3"))
				cmdCal(scan, cal);
			else if (cmd.equals("h"))
				printMenu();
			else if (cmd.equals("q"))
				break;
		}
//		System.out.println("Thank you. Bye~");
//		scan.close();

//			System.out.println("년도를 입력하시오");
//			System.out.print("YEAR> ");
//			year = scan.nextInt();
//			if (year == -1) {
//				break;
//			}
//			System.out.println("달를 입력하시오");
//			System.out.print("MONTH> ");
//			month = scan.nextInt();
//			if (month == -1) {
//				break;
//			}
//			if (month > 12) {
//				System.out.println("잘못된 입력입니다.");
//				continue;
//			}
//			System.out.println("첫째 날의 요일을 입력하세요 (su, mo, tu, we, th, fr, sa)");
//			System.out.print("WEEK> ");
//			String str_weekday = scan.next();
//			weekday = parseDay(str_weekday);

//			cal.printCalendar(year,month);
//			cal.maxdays(year,month);
//		}
		System.out.println("Bye~");
		scan.close();
	}

	private void cmdCal(Scanner s, Calendar c) {
		// TODO Auto-generated method stub
		int month = 1;
		int year = 2017;
		System.out.println("년도를 입력하시오");
		System.out.print("YEAR> ");
		year = s.nextInt();

		System.out.println("달를 입력하시오");
		System.out.print("MONTH> ");
		month = s.nextInt();
		if (month > 12) {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		c.printCalendar(year, month);
	}

	private void cmdSerch(Scanner s, Calendar c) {
		// TODO Auto-generated method stub
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해주세요 (yyyy-MM-dd)");
		String date = s.next();
		String plan = "";
		try {
			plan = c.serchPlan(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("일정 검색 중 오류가 발생했습니다.");
		}
		System.out.println(plan);
	}

	private void cmdRegister(Scanner s, Calendar c) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해주세요 (yyyy-MM-dd)");
		String date = s.next();
		String text = "";
		System.out.println("일정을 입력해 주세요. (문장의 끝에 ; 을 입력해주세요)");
		while(true) {
			String word = s.next();
			text += word + " ";
			if (word.endsWith(";")) {
				break;
			}
		}
		c.registerPlan(date, text);
	}

	public static void main(String[] args) {

	}
}
