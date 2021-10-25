package com.averagemodule;

import com.input.UserInput;

public abstract class AverageContainer {
	public int avg;

	public void getAverageInput(int option) throws InvalidOptionException {
		switch (option) {
		case 1:
			avg = 100;
			break;
		case 2:
			avg = 200;
			break;
		case 3:
			avg = 300;
			break;
		case 4:
			System.out.println("Enter No.of.words that you're reading per minute:");
			avg = UserInput.getIntUserInput();
			break;
		default:
			throw new InvalidOptionException("Please Enter valid option for Average Time");
		}
	};

	public abstract double calculateReadingTime(int totalWords);
}
