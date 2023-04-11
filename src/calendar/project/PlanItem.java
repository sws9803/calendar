package calendar.project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {

	// TODO Auto-generated method stub
	public Date planDate;
	public String detail;
	public String peoples = "";
	
	public static Date getDatefromString(String strDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public PlanItem(String date, String detail) {
		this.planDate= getDatefromString(date);
		this.detail = detail;
	}

	public Date getDate() {
		return planDate;
	}
	
	public void addPeople(String name) {
		peoples += name + ",";

	}

	public String saveString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String sdate = formatter.format(planDate);
		return sdate + "," + "\"" + detail + "\"" + "\n";
	}
}
