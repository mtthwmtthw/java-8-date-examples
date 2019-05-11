package calc;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.time.LocalDate;

import org.junit.Test;

public class DateIntervalCalculatorTest {

	@Test
	public void testIfIntervalOfDateByInteger() throws ParseException {
		LocalDate startDate = LocalDate.parse("2019-01-01");
		LocalDate testDate = LocalDate.parse("2019-01-31");
		LocalDate anotherTestDate = LocalDate.parse("2019-03-01");
		
		int interval = 30;
		
		assertTrue(DateIntervalCalculator.returnIfIntervalByDateAndInteger(startDate, testDate, interval));
		assertTrue(DateIntervalCalculator.returnIfIntervalByDateAndInteger(startDate, anotherTestDate, interval));
		
	}
	
	@Test
	public void testReturnDatesByIntervalAndRange() throws ParseException {
		int interval = 90;
		LocalDate startDate = LocalDate.parse("2019-01-01");
		LocalDate endDate = LocalDate.parse("2024-01-31");
		String dates = "2019-04-01\n" + 
				"2019-06-30\n" + 
				"2019-09-28\n" + 
				"2019-12-27\n" + 
				"2020-03-26\n" + 
				"2020-06-24\n" + 
				"2020-09-22\n" + 
				"2020-12-21\n" + 
				"2021-03-21\n" + 
				"2021-06-19\n" + 
				"2021-09-17\n" + 
				"2021-12-16\n" + 
				"2022-03-16\n" + 
				"2022-06-14\n" + 
				"2022-09-12\n" + 
				"2022-12-11\n" + 
				"2023-03-11\n" + 
				"2023-06-09\n" + 
				"2023-09-07\n" + 
				"2023-12-06";
		String[] dateArray = dates.split("\\n");
		LocalDate[] parsedDates = new LocalDate[dateArray.length];
		
		for(int i = 0; i < dateArray.length; i++) {
			parsedDates[i] = LocalDate.parse(dateArray[i]);
		}
		
		assertArrayEquals(parsedDates, DateIntervalCalculator.returnIntervalDatesByRange(startDate, endDate, interval).toArray());
		
	}
	
	@Test
	public void testReturnDatesByOccurencesAndInterval() throws ParseException {
		int interval = 90;
		int occurences = 12;
		LocalDate startDate = LocalDate.parse("2019-01-01");
		String dates = "2019-04-01\n" + 
				"2019-06-30\n" + 
				"2019-09-28\n" + 
				"2019-12-27\n" + 
				"2020-03-26\n" + 
				"2020-06-24\n" + 
				"2020-09-22\n" + 
				"2020-12-21\n" + 
				"2021-03-21\n" + 
				"2021-06-19\n" + 
				"2021-09-17\n" + 
				"2021-12-16\n";
		String[] dateArray = dates.split("\\n");
		LocalDate[] parsedDates = new LocalDate[dateArray.length];
		
		for(int i = 0; i < dateArray.length; i++) {
			parsedDates[i] = LocalDate.parse(dateArray[i]);
		}
		
		assertArrayEquals(parsedDates, DateIntervalCalculator.returnDatesByRequestedOccurencesAndInterval(startDate, occurences, interval).toArray());
		
	}
}
