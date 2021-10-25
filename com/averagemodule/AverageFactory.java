package com.averagemodule;

public class AverageFactory {
	public static AverageContainer getType() {
		return new AverageCalculator();
	}
}
