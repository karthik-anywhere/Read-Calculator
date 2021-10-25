package com.mainmodule;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.averagemodule.AverageCalculator;
import com.averagemodule.AverageContainer;
import com.averagemodule.InvalidOptionException;
import com.input.ScannerSingleton;
import com.input.UserInput;
import com.readmodule.FileContainer;
import com.tokenmodule.FileToken;

public class ReadCalculator {

	public static FileContainer performFileTask(int option) {
		FileContainer fileType = FileFactory.getType(option);
		fileType.getUserInput(option);
		fileType.addFileToFileContainer(fileType.getFile());
		return fileType;
	}

	public static void performAvgCalculation(FileContainer fileType) throws InvalidOptionException {
		int avgOption = UserInput.getAvgOptionFromUser();
		AverageContainer avgType = new AverageCalculator();
		avgType.getAverageInput(avgOption);
		int count = FileToken.calculateToken(fileType.fileStore.values().toString());
		double totalMinutes = avgType.calculateReadingTime(count);
		System.out.println("Reading Time for " + count + " words with the speed of " + avgType.avg + " words per minute"
				+ " is " + totalMinutes + " minutes.");
	}

	public static void main(String[] args) {

		boolean exit = false;
		try {
			do {
				int option = UserInput.getOptionFromUser();
				if (option != 4) {
					performAvgCalculation(performFileTask(option));
				} else {
					exit = true;
				}
			} while (!exit);
		} catch (InputMismatchException e) {
			System.out.println("Enter only Integer value !");
		} catch (InvalidOptionException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Please enter valid input!");
		} finally {
			Scanner s = ScannerSingleton.getInstance();
			s.close();
		}
	}
}
