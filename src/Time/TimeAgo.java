package Time;

import java.util.Calendar;
/**
 * This class describes a TimeAgo object. It can show the time passed between two Dates and represent them as a string.
 *
 * @version 1.0a
 * 
 */
public class TimeAgo {

	/*
	 * Test method
	 * 
	 */
	public static void main(String args[]) {
		
		 
	   	 Calendar cal1 = Calendar.getInstance();
	   	 cal1.set(1990, (1 -1), 18, 1, 07, 01);	//Year; Month; Day; Hour; Minute; Second;
	
	   	 Calendar cal2 = Calendar.getInstance(); //Year; Month; Day; Hour; Minute; Second;
	     cal2.set(1992, (12 -1), 21, 16, 48, 21);
	   	 
	     Calendar cal3 = Calendar.getInstance(); //Year; Month; Day; Hour; Minute; Second;
	     cal3.set(2015, (1 -1), 18, 1, 7, 18);
	     System.out.println("Last Birthday: " + cal1.getTime());
	     
	   	 System.out.println(timeAgo(cal1));
	   	
   }
	
		private static long seconds 			= 0;
		private static long minutes	 			= 0;
		private static long hours	 			= 0;
		private	static long days 				= 0;
		private	static long weeks 				= 0;
		private	static long months 				= 0;
		private static long years 				= 0;
		
		private final static long SECOND 		= 1000L;
		private final static long MINUTE		= 60000L;
		private final static long HOUR			= 3600000L;	
		private final static long DAY 			= 86400000L;
		private final static long WEEK 			= 604800000L;
		private final static long MONTH 		= 2629743830L;
		private final static long YEAR 			= 31536000000L;
	
	TimeAgo(){
		
	}
    
	TimeAgo(Calendar firstCalendar, Calendar secondCalendar){
		timeBetween(firstCalendar, secondCalendar);
	}
	
	/**
	 * This method returns a String with the Time passed between the two Dates, broken down to Time Units.
	 * 
	 * @param firstCalendar First Date as Calendar Object.
	 * @param secondCalendar Second Date as Calendar Object.
	 * 
	 * @return A String with the Time passed between the two dates. 
	 */
	public static String timeBetween(Calendar firstCalendar, Calendar secondCalendar){
		long intervalInMs = CalendarIntervalInMs(firstCalendar, secondCalendar);
		IntervalToTimeUnits(intervalInMs);
		
		String timeAgoMessage = "";
		int counter = 0;
		
		
		if(TimeAgoSettings.showYears){
			timeAgoMessage += years + " Years ";
			counter++;
		}
		if(TimeAgoSettings.showMonths){
			timeAgoMessage += months + " Months ";
			counter++;
		}
		if(TimeAgoSettings.showWeeks){
			timeAgoMessage += weeks + " Weeks ";
			counter++;
		}
		if(TimeAgoSettings.showDays){
			timeAgoMessage += days + " Days ";
			counter++;
		}
		if(TimeAgoSettings.showHours){
			timeAgoMessage += hours + " Hours ";
			counter++;
		}
		if(TimeAgoSettings.showMinutes){
			timeAgoMessage += minutes + " Minutes ";
			counter++;
		}
		if(TimeAgoSettings.showSeconds){
			timeAgoMessage += seconds + " Seconds ";
			counter++;
		}
		if(counter != 0 ){
			timeAgoMessage += "Ago.";
		}
		
		
		return timeAgoMessage;
	}
	
	/**
	 * This method returns a String with the Time passed between a Dates and the current Time, broken down to Time Units.
	 * 
	 * @param oldDate First date as calendar object.
	 * 
	 * @return A string with the time passed between a date and the current time.
	 */
	public static String timeAgo(Calendar oldDate){
		if(oldDate != null){
		Calendar currentTime = Calendar.getInstance();
		return timeBetween(oldDate, currentTime);
		}
		else{
			return "";
		}
	}
	
	/**
	 * This method calculates milliseconds(ms) to time units.
	 * 
	 * @param ms milliseconds.
	 */
    private static void IntervalToTimeUnits(long ms){
    	
    	long temp 			= ms;
    	
    	if(TimeAgoSettings.showYears){
    		years 				= temp/YEAR;
    		temp 				= temp - years * YEAR;
    	}
    	if(TimeAgoSettings.showMonths){
    		months 				= temp/MONTH;
    		temp 				= temp - months * MONTH;
    	}
    	if(TimeAgoSettings.showWeeks){
    		weeks 				= temp/WEEK;
    		temp				= temp - weeks * WEEK;
    	}
    	if(TimeAgoSettings.showDays){
    		days 				= temp/DAY;
    		temp				= temp - days * DAY;
    	}
    	if(TimeAgoSettings.showHours){
    		hours	 			= temp/HOUR;
    		temp				= temp - hours * HOUR;
    	}
    	if(TimeAgoSettings.showMinutes){
    		minutes 			= temp/MINUTE;
    		temp				= temp - minutes * MINUTE;
    	}
    	if(TimeAgoSettings.showSeconds){
    		seconds 			= temp/SECOND;
    	}
   
    }

    /**
     * This method calculates the milliseconds between two dates.
     * 
     * @param firstCalendar First date as calendar object.
     * @param secondCalendar Second date as calendar object.
     * 
     * @return Interval between the two dates.
     */
    private static long CalendarIntervalInMs(Calendar firstCalendar, Calendar secondCalendar){
    	if(firstCalendar != null && secondCalendar != null){
    		
    		long fistCalendarMs 	= firstCalendar.getTimeInMillis();
    		long secondCalendarMs 	= secondCalendar.getTimeInMillis();
    		
    		long msInterval = Math.abs(fistCalendarMs - secondCalendarMs);
    		
    		return msInterval;
    	}
    	else{
    		
    		return 0;
    	}
    }
}