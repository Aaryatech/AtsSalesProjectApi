package com.ats.hrmgt.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
 

public class DateConvertor {

	
		public static String convertToYMD(String date) {
			
			String convertedDate=null;
			try {
				SimpleDateFormat ymdSDF = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat dmySDF = new SimpleDateFormat("dd-MM-yyyy");
				Date dmyDate = dmySDF.parse(date);
				
				convertedDate=ymdSDF.format(dmyDate);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return convertedDate;

		}
		
	public static String convertToDMY(String utildate) {
			
			String convertedDate=null;
			try {
				SimpleDateFormat ymdSDF = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat ymdSDF2 = new SimpleDateFormat("yyyy-MM-dd");

				
				SimpleDateFormat dmySDF = new SimpleDateFormat("dd-MM-yyyy");

				Date ymdDate = ymdSDF2.parse(utildate);
				
				convertedDate=dmySDF.format(ymdDate);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return convertedDate;

		}
		
	public static java.sql.Date convertToSqlDate(String date) {
			
			java.sql.Date convertedDate=null;
			try {
				SimpleDateFormat ymdSDF = new SimpleDateFormat("yyyy-mm-dd");
				SimpleDateFormat dmySDF = new SimpleDateFormat("dd-MM-yyyy");

				Date dmyDate = dmySDF.parse(date);
				
				System.out.println("converted util date commons "+dmyDate);

				
				

				convertedDate=new java.sql.Date(dmyDate.getTime());
				System.out.println("converted sql date commons "+convertedDate);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return convertedDate;

		}

	
	
	public static List<String> getAllMonth(Date x) {
		
 		List<String> dateList = new ArrayList<String>();
		try {
			Date date = new Date();
			SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
			String currDate = sf1.format(date);

			SimpleDateFormat sf = new SimpleDateFormat("MM-yyyy");
 
			LocalDate localDate = LocalDate.parse((currDate));
			LocalDate oneMonthLater = localDate.plusMonths(1);
			String joinnigDate = sf.format(x);
 
			String currDateNew = String.valueOf(oneMonthLater.getMonthValue()).concat("-")
					.concat(String.valueOf(oneMonthLater.getYear()));

		 
			DateFormat formater = new SimpleDateFormat("MM-yyyy");

			Calendar beginCalendar = Calendar.getInstance();
			Calendar finishCalendar = Calendar.getInstance();
			try {
				beginCalendar.setTime(formater.parse(joinnigDate));
				finishCalendar.setTime(formater.parse(currDateNew));
			} catch (Exception e) {
				e.printStackTrace();
			}

		
			while (beginCalendar.before(finishCalendar)) {
				// add one month to date per loop
				String date1 = formater.format(beginCalendar.getTime()).toUpperCase();
				System.out.println(date1);
				dateList.add(date1);
				beginCalendar.add(Calendar.MONTH, 1);
			}

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dateList;

	}

	
	
public static List<String> getAllMonthBetDates(Date  fromDate,Date toDate) {
		
 		List<String> dateList = new ArrayList<String>();
		try {
		 
			SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
			String currDate = sf1.format(toDate);
			
			System.err.println(currDate);

			SimpleDateFormat sf = new SimpleDateFormat("MM-yyyy");
 
			LocalDate localDate = LocalDate.parse((currDate));
			LocalDate oneMonthLater = localDate.plusMonths(1);
			String fDate = sf.format(fromDate);
 
			String tDate = String.valueOf(oneMonthLater.getMonthValue()).concat("-")
					.concat(String.valueOf(oneMonthLater.getYear()));

		 
			DateFormat formater = new SimpleDateFormat("MM-yyyy");
			
			System.err.println("from date "+fDate);
			System.err.println("to date "+tDate);

			Calendar beginCalendar = Calendar.getInstance();
			Calendar finishCalendar = Calendar.getInstance();
			try {
				beginCalendar.setTime(formater.parse(fDate));
				finishCalendar.setTime(formater.parse(tDate));
			} catch (Exception e) {
				e.printStackTrace();
			}

		
			while (beginCalendar.before(finishCalendar)) {
				// add one month to date per loop
				String date1 = formater.format(beginCalendar.getTime()).toUpperCase();
				System.out.println(date1);
				dateList.add(date1);
				beginCalendar.add(Calendar.MONTH, 1);
			}

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dateList;

	}



public static String getMonthsStartEnd() {
	String leaveDateRange = null;
	String fromDate = null;
	String toDate = null;
	Calendar c = Calendar.getInstance(); // this takes current date

	// System.out.println(c.getTime());

	 c.add(Calendar.MONTH, 1);  
        c.set(Calendar.DAY_OF_MONTH, 1);  
        c.add(Calendar.DATE, -1);  
	Date toDate1 = c.getTime();
//System.err.println("to date "+toDate1);
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	toDate = sdf.format(toDate1);
	c = Calendar.getInstance(); 
	c.set(Calendar.DAY_OF_MONTH, 1);
	Date fromDate1 = c.getTime();
	
	

	fromDate = sdf.format(fromDate1);

	leaveDateRange = fromDate.concat(" to ").concat(toDate);
	return leaveDateRange;
}
		









 
		
		

	}


