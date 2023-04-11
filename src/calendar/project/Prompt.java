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
		switch(week) {
		case "su":
			return 0;
		case "mo":
			return 1;
		case "tu":
			return 2;
		case "we":
			return 3;
		case "th":
			return 4;
		case "fr":
			return 5;
		case "sa":
			return 6;
		default:
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

		boolean isLoop = true;
		while (isLoop) {
			System.out.println("명령(1, 2, 3, h, q)");
			String cmd = scan.next();
			switch(cmd) {
			case "1":
				cmdRegister(scan, cal);
				break;
			case "2":
				cmdSerch(scan, cal);
				break;
			case "3":
				cmdCal(scan, cal);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				isLoop = false;
				break;
			}
		}
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
		PlanItem plan;
		plan = c.serchPlan(date);
		if (plan != null) {
		System.out.println(plan.detail);
		} else {
			System.out.println("일정이 없습니다.");
		}
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
				word = word.replace(";","");
				text = word;
				break;
			}
		}
		c.registerPlan(date, text);
	}

	public static void main(String[] args) throws ParseException {
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
