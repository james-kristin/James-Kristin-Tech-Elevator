package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Please enter the length: ");
		String value = input.nextLine();
		int length = Integer.parseInt(value);

		System.out.print("Is the measurement in (m)eter, or (f)eet? ");
		String unit = input.nextLine();

		if (unit.equals("m")) {
			double convertedLength = metersToFeet(length);
			int intLength = (int)convertedLength;
			System.out.println(length + "m is " + intLength + "f.");
		} else if (unit.equals("f")) {
			double convertedLength = feetToMeters(length);
			int intLength = (int)convertedLength;
			System.out.println(length + "f is " + intLength + "m.");
		} else {
			System.out.println("Invalid unit type!");
		}

	}
	public static double metersToFeet(double meters) {
		final double TO_FEET_CONVERSION = 3.2808399;
		return meters * TO_FEET_CONVERSION;
	}
	public static double feetToMeters(double feet) {
		final double TO_METERS_CONVERSION = 0.3048;
		return feet * TO_METERS_CONVERSION;
	}

}
