package com.input;

import java.util.Scanner;

public class ScannerSingleton {
	private static Scanner s;

	public ScannerSingleton() {
	}

	public static Scanner getInstance() {

		if (s == null) {
			s = new Scanner(System.in);
		}
		return s;
	}
}
