package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserIntreaction {

	InputStreamReader inputStreamReader;
	BufferedReader bufferedReader;
	private int numberEntered;
	private TradingReport report;
	
	public UserIntreaction(TradingReport report) {

		this.report = report;
		inputStreamReader = new InputStreamReader(System.in);
		bufferedReader = new BufferedReader(inputStreamReader);
		giveUserChoice();
	}
	
	private void giveUserChoice() {
		// a loop to ask the user for choice again and again
		do {
			start();
		} while (numberEntered != 0);
	}

	private void start() {
	
		System.out.println("Enter 1 to display HIGHEST CAPITAL OF A COMPANY");
		System.out.println("Enter 2 to display LOWEST CAPITAL OF A COMPANY");
		System.out.println("Enter 3 to display HIGHEST SHARES WITH AN INVESOTR");
		System.out.println("Enter 4 to display LOWEST SHARES OF AN INVESTOR");
		System.out.println("Enter 0 to EXIT THE SYSTEM");

		try {
			numberEntered = Integer.parseInt(bufferedReader.readLine());// get user input
		} catch (Exception e) {
			System.out.println("Please enter a number");
			giveUserChoice();
		}
		workAccordingToInput(numberEntered);// proceed according to the user input
	}

	private void workAccordingToInput(int numberEntered) {

		switch (numberEntered) {
		case 1:
			report.showHighestCapital();
			break;
		
		case 2:
			report.showLowestCapital();
			break;
		
		case 3:
			report.showHighestShares();
			break;
		
		case 4:
			report.showLowestShares();
			break;

		default:
			break;
		}
	}	
}
