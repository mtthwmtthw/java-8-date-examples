package calc;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import static java.time.temporal.ChronoUnit.DAYS;

public class DateIntervalCalculator {

	public static boolean returnIfIntervalByDateAndInteger(LocalDate startingDate, LocalDate testDate, int interval) {
		int length = Period.between(testDate, startingDate).getDays();
		
		if (length % interval == 0) {
			return true;
		}	
		
		return false;
	}
	
	public static List<LocalDate> returnIntervalDatesByRange(LocalDate startingDate, LocalDate endDate, int interval) {
		List<LocalDate> dates = new ArrayList<LocalDate>();
		int length = (int)DAYS.between(startingDate, endDate);
		int occurences = length / interval;
		
		dates = returnDatesByRequestedOccurencesAndInterval(startingDate, occurences, interval);
		
		return dates;
	}
	
	public static List<LocalDate> returnDatesByRequestedOccurencesAndInterval(LocalDate startingDate, int occurences, int interval) {
		List<LocalDate> dates = new ArrayList<LocalDate>();
		LocalDate dateIndex = startingDate;
		
		for(int i = 0; i < occurences; i++) {
			LocalDate nextDate = dateIndex.plusDays(interval);
			dates.add(nextDate);
			dateIndex = nextDate;
		}
		
		return dates;
	}
	
}
