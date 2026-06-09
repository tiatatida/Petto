package petto.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {
	public static void welcomeDateAndTime() {
		LocalDateTime localdatetime = LocalDateTime.now();
		DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy\nHH:mm:ss");
		String format = localdatetime.format(datetimeformatter);
		System.out.println(format);
	}

	public static void time() {
		LocalTime localtime = LocalTime.now().withNano(0);
		System.out.println(localtime);
	}
	
	public static void date() {
		LocalDate localdate = LocalDate.now();
		DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String format = localdate.format(datetimeformatter);
		System.out.println(format);
	}

}
