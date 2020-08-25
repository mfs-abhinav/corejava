package com.abhi.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class DateConvert {
	
	private static final String DEFAULT_INCOMING_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'+00:00'";
	
	private static final String DEFAULT_DB_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	public static void main(String[] args) throws ParseException {
		
		// String incomingDateTimeString = "2019-06-28T10:48:04.312+00:00";
		
//		Date today = new Date(120, 7, 10, 0, 0, 0);
//		System.out.println(today.getTime());
		
		
		ZoneId etZoneId = ZoneId.of("America/New_York");
		ZoneId utcZoneId = ZoneId.of("UTC");
		
		Long hospitalMigrationDateInMS = 1596997800000L;
        
        Date hospitalMigrationDate = new Date(hospitalMigrationDateInMS); 
        
        LocalDateTime currentDateTime = new Date().toInstant().atZone(etZoneId).toLocalDateTime();
        
        LocalDateTime ldt = hospitalMigrationDate.toInstant().atZone(etZoneId).toLocalDateTime();
        ZoneOffset zoneOffSet = etZoneId.getRules().getOffset(ldt);
        int timeDiff = Math.abs(zoneOffSet.getTotalSeconds()) / 3600;

        LocalDateTime extendedHospitalMigrationDate = ldt.plusHours(4 + timeDiff);
        
        boolean isTodayBeforeHospitalMigration = currentDateTime.isBefore(extendedHospitalMigrationDate);
        
        System.out.println(timeDiff);
        System.out.println("hospital migration date time is: " + hospitalMigrationDate);
        System.out.println("hospital migration local date time in est: " + ldt);
        System.out.println("Current date time is: " + currentDateTime);
        System.out.println("Extended date time is: " + extendedHospitalMigrationDate);
        System.out.println("Is todays date before migration date: " + isTodayBeforeHospitalMigration);
		
		
		
		// here error will occur b/c offset is used in datatimestring
		/*LocalDateTime localDateTime = LocalDateTime.parse(incomingDateTimeString);
		System.out.println(localDateTime);*/
		
		// System.out.println(convertToUTCTimeZone1(incomingDateTimeString));		
		
		/*String dateTime = "2018-03-29 10:12:07";
		
		String convertedDate1 = convertToUTCTimeZone1(dateTime);
		
		System.out.println("Converted Date1 is: " + convertedDate1);
		
		String convertedDate2 = convertToUTCTimeZone2(dateTime);
		
		System.out.println("Converted Date1 is: " + convertedDate2);*/

	}

	public static String convertToUTCTimeZone1(String dateTimeString) throws ParseException {

		if (dateTimeString != null && dateTimeString.length() == 29) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'+00:00'");
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
			
			
			LocalDateTime localNZ = LocalDateTime.parse(dateTimeString, formatter);
			System.out.println(localNZ);
			
			ZonedDateTime zonedNZ = ZonedDateTime.of(localNZ, ZoneId.of("UTC"));
			
			
			LocalDateTime localUTC = zonedNZ.withZoneSameInstant(ZoneId.of("America/New_York")).toLocalDateTime();
			System.out.println(localUTC);
			return localUTC.format(dateFormat) + "T" + localUTC.format(timeFormat) + "Z";
		} else {
			return dateTimeString;
		}

	}
	
	public static String convertToUTCTimeZone2(String dateTimeString) throws ParseException {

		if ( dateTimeString != null && dateTimeString.length() == 19 ) {
			String inputPattern = "yyyy-MM-dd hh:mm:ss";
			String utcPattern = "yyyy-MM-dd'T'HH:mm:ssZ";
			SimpleDateFormat sdf = new SimpleDateFormat(inputPattern);
            sdf.setTimeZone(TimeZone.getTimeZone("EST"));
            Date date = sdf.parse(dateTimeString);
            
			ZonedDateTime zdt = ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC"));

			return zdt.format(DateTimeFormatter.ofPattern(utcPattern));

		} else {
			return dateTimeString;
		}

	}

}
