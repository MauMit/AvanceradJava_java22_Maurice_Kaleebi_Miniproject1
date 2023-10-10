package main;

import interfaces.PossibleAction;
import java.util.Scanner;
import dateTime.Date;
import dateTime.Time;

public class Display implements PossibleAction {

	STATE current_state = STATE.DisplayTime;
	Date date = new Date();
	Time time = new Time();

	enum STATE {
		DisplayTime, ChangeTime, DisplayDate, ChangeDate
	}

	@Override
	public void displayTime() {
		if (current_state == STATE.DisplayDate || current_state == STATE.ChangeTime) {
			current_state = STATE.DisplayTime;
			System.out.println("Current State: " + current_state);
			time.getTime();
		} else {
			System.out.println("Wrong state");
		}
	}

	@Override
	public void displayDate() {
		if (current_state == STATE.DisplayTime || current_state == STATE.ChangeDate) {
			current_state = STATE.DisplayDate;
			System.out.println("Current State: " + current_state);
			date.getDate();
		} else {
			System.out.println("Wrong State");
		}
	}

	@Override
	public void changeTime() {
		if (current_state == STATE.DisplayTime) {
			current_state = STATE.ChangeTime;
			System.out.println("Current State: " + current_state);
			time.setTime();
		} else {
			System.out.println("Wrong State");
		}
	}

	@Override
	public void changeDate() {
		if (current_state == STATE.DisplayDate) {
			current_state = STATE.ChangeDate;
			System.out.println("Current State: " + current_state);
			date.setDate();
		} else {
			System.out.println("Wrong State");
		}

	}
	

	public void mainLoop() {
		String userInput = "";
		Scanner scan = new Scanner(System.in);
		time.getTime();
		System.out.println("Current State: " + current_state);

		while (!userInput.equals("q")) {
			System.out.println("1. Display Time\n" + "2. Change Time\n" + "3. Display Date\n" + "4. Change Date\n"
					+ "5. Enter \"q\" to close the clock"

			);

			userInput = scan.nextLine().trim();
			switch (userInput) {
			case "1": {
				displayTime();
				break;
			}

			case "2": {
				changeTime();
				break;
			}

			case "3": {
				displayDate();
				break;

			}
			case "4": {
				changeDate();
				break;

			}
			case "q": {
				System.out.println("You've closed down the clock");
			}

			
			}
		}
		scan.close();
	}

	public static void main(String[] args) {
		Display display = new Display();
		display.mainLoop();
		

	}

}
