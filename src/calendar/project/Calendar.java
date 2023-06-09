package calendar.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Calendar {

	private static final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final String SAVE_FILE="calendar.dat";
	
	
	private HashMap <Date, PlanItem> planMap;
	
	public Calendar() {
		planMap = new HashMap<Date, PlanItem>();
		File f = new File(SAVE_FILE);
		if(!f.exists()) {
			return;
		}
		try {
			Scanner s = new Scanner(f);
			while(!s.hasNext()) {
				String line = s.nextLine();
				String[] words = line.split(",");
				String date = words[0];
				String detail = words[1].replaceAll("\"","");
				PlanItem p = new PlanItem(date,detail);
				planMap.put(p.getDate(), p);
			}
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param date ex: "2017-06-20"
	 * @param plan
	 * @throws ParseException 
	 */
	public void registerPlan(String strDate, String plan) {
		PlanItem p = new PlanItem(strDate, plan);
		planMap.put(p.getDate(), p);
		
		File f = new File(SAVE_FILE);
		String item = p.saveString();
		try {
			FileWriter fw = new FileWriter(f,true);
			fw.write(item);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public PlanItem serchPlan(String strDate) {
		Date date = PlanItem.getDatefromString(strDate);
		return planMap.get(date);
		
	}
	
	//윤년계산
	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	//최대 날짜
	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		} else {
			return MAX_DAYS[month];
		}
	}
	
	//달력 출력
	public void printCalendar(int year, int month) {
		
		System.out.printf("    <<%d년%d월>>\n", year, month);
		System.out.println("-------------------");
		System.out.println("SU MO TU WE TH FR SA");
		
		//get weekday automatically
		int weekday = getWeekday(year, month ,1);
		
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
		
//요일 찾기
	private int getWeekday(int year, int month, int day) {
		// TODO Auto-generated method stub
		int syear = 1970;
		final int STANDARD_WEEKDAY = 3; // 목요일
		
		int count = 0;
		
		for (int i  = syear; i <= year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}
		
		for(int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year,i);
			count += delta;
		}
		
		count += day -1;
		
		int weekday = ( count + STANDARD_WEEKDAY ) % 7;
		return weekday;
	}

	//당월 최대 날짜
	public void maxdays(int year, int month) {
		// 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램\
		if (1 <= month && month <= 12) {
			System.out.println(month + "월은 " + getMaxDaysOfMonth(year, month) + "일까지 있습니다.");

		} else {
			System.out.println("잘못입력했습니다.");
		}
	}
	
	
	public static void main(String[] args) throws ParseException {

	}
}