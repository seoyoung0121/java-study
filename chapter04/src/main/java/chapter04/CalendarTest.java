package chapter04;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarTest {

	public static void main(String[] args) {
		
//		Locale aLocale = Locale.getDefault(Locale.Category.FORMAT);
//		TimeZone tz = TimeZone.getDefault();
//		System.out.println(aLocale + ":" + tz); 

		
		Calendar cal = Calendar.getInstance();
		printDate(cal);
		
		cal.set(Calendar.YEAR, 2024);
		cal.set(Calendar.MONTH, 11); //12월  - 1
		cal.set(Calendar.DATE, 25);
		printDate(cal);
		
		cal.set(2001, 7, 14);
		cal.add(Calendar.DATE, 10000); //앞 날짜의 10000일 후는 언제?
		printDate(cal);
		
		

	}

	private static void printDate(Calendar cal) {
		final String[] DAYS = {"일", "월", "화", "수", "목", "금", "토"};
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); // 0 - 11, +1
		int day = cal.get(Calendar.DAY_OF_WEEK); // 1(일) - 7(토)
		int date = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println(
				year + "-" +
				(month + 1) + "-" +
				date + " " +
				DAYS[day-1] + "요일 " +
				hour + ":" +
				minute + ":" +
				second);
	}

}
