package com.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {

	public static int getOptionFromUser() throws InputMismatchException {

		System.out.println(
				"Select option to Read Calculate: \n 1.Select files from Directory \n 2.Select file by file name \n 3.By giving text \n 4.Exit ");
		return getIntUserInput();
	}

	public static int getAvgOptionFromUser() throws InputMismatchException {

		System.out.println("Select Reading Level: \n 1.Low \n 2.Intermediate \n 3.Advanced \n 4.Custom");
		return getIntUserInput();
	}

	public static int getIntUserInput() throws InputMismatchException {
		Scanner s = ScannerSingleton.getInstance();
		return s.nextInt();
	}

	public static String getStringUserInput() throws InputMismatchException {

		Scanner s = new Scanner(System.in);
		return s.nextLine();

	}

}
