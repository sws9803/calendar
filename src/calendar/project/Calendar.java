package calendar.project;

import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("일 월 화 수 목 금 토");
		System.out.println("-----------------");
		System.out.println("1  2  3  4  5  6  7");
		System.out.println("8  9  10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
		
		//숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		System.out.println("달을 입력하세요.");
		Scanner scan = new Scanner(System.in);
//		String number = scan.next();
		// int num = scan.nextInt(); 하면 한번에 처리
//		int num = Integer.parseInt(number);
		int num = scan.nextInt();
//		String temp = "1,2,3,4,5,6,7,8,9,10,11,12";
//		String[] month = temp.split(",");
		int[] month = {1,2,3,4,5,6,7,8,9,10,11,12};
		
		if (1<=num && num<=12) {
			System.out.println(num + "월은 " + month[num-1] + "일까지 있습니다.");
			
		}else {
			System.out.println("잘못입력했습니다.");
		}
		scan.close();
	}

}
