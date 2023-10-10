package dateTime;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Date {

	private Scanner scan = new Scanner(System.in);
	private LocalDate currentDate = LocalDate.now();

	public void getDate() {
		System.out.println("Current Date is: " + currentDate);

	}

	public void setDate() {
		System.out.println("Enter a new Date: yyyy-MM-dd ");

		boolean checker = false;

		while (!checker) {

			String userInput = scan.nextLine();

			try {
				LocalDate newDate = LocalDate.parse(userInput);
				currentDate = newDate;
				System.out.println("New Date is: " + newDate);
				checker = true;

			} catch (DateTimeException e) {

				System.out.println("Invalid Date format, try again: yyyy-MM-dd");
			}

		}
	}

}
