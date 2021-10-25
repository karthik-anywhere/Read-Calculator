package com.averagemodule;

public class AverageCalculator extends AverageContainer {
	@Override
	public double calculateReadingTime(int totalWords) {
		double mins = (double) totalWords / avg;
		return mins;
	}
}
