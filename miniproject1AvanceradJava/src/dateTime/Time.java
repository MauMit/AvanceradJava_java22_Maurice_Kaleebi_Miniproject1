package dateTime;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Time {

	private Scanner scan = new Scanner(System.in);
	private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	private LocalTime currentTime = LocalTime.now();
	
	
	public void getTime() {

		System.out.println("Current Time is: " + currentTime.format(dateTimeFormatter));

	}

	public void setTime() {
		System.out.println("Enter a new Time: HH:mm:ss ");

		boolean checker = false;

		while (!checker) {

			String userInput = scan.nextLine();

			try {
				LocalTime newTime = LocalTime.parse(userInput, dateTimeFormatter);
				currentTime = newTime;
				System.out.println("New Time is: " + newTime.format(dateTimeFormatter));
				checker = true;

			} catch (DateTimeException e) {
				System.out.println("Invalid Time format, try again: HH:mm:ss");
			}

		}

	}

}
