package calendar.project;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		//입력 : 키보드로 두 수의 입력을 받는다.
		//출력 : 화면에 두 수의 합을 출력한다.
		
		System.out.println("수를 입력하세요.  ex) 5 10");
		Scanner scan = new Scanner(System.in);
		String inputValue = scan.nextLine();
		String[] value = inputValue.split(" ");

		int[] result = new int[value.length];
		int temp = 0;
		
		for (int i = 0; i<value.length; i++) {
			result[i] = Integer.parseInt(value[i]);
			temp = temp + result[i];
		}
		
		System.out.println("수의 합은" + ( temp ) + "입니다");
		
		scan.close();
	}
}
