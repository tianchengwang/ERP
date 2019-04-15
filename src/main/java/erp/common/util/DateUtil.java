package erp.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String getToday(){
		String today = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date now = new Date();
		today = sdf.format(now);
		return today;
	}
	public static Integer getMonth(){
		String month = "";
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		Date now = new Date();
		month = sdf.format(now);
		/*if(month.startsWith(0))
			month.substring(1);*/
		int m = Integer.parseInt(month); 
		return m;
	}
	public static Double getTimeSub(String startDate,String endDate) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date startdate = sdf.parse(startDate);
		Date enddate = sdf.parse(endDate);
		double days = (enddate.getTime() - startdate.getTime()) / (24*3600*1000);
		
		return days;
	}
	public static void main(String[] args) {
		System.out.println(getMonth());
	}
}
