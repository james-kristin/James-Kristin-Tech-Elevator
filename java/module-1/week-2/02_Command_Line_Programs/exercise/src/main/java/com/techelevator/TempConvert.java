package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Please enter the temperature: ");
		String value = input.nextLine();
		int temperature = Integer.parseInt(value);

		System.out.print("Is the temperature in (C)elsius, or (F)ahrenheit? ");
		String tempScale = input.nextLine();

		if (tempScale.equals("C")) {
			double convertedTemp = celsiusToFahrenheit(temperature);
			int intTemp = (int)convertedTemp;
			System.out.println(temperature + "C is " + intTemp + "F.");
		} else if (tempScale.equals("F")) {
			double convertedTemp = fahrenheitToCelsius(temperature);
			int intTemp = (int)convertedTemp;
			System.out.println(temperature + "F is " + intTemp + "C.");
		} else {
			System.out.println("Invalid temperature scale");
		}

	}
	public static double celsiusToFahrenheit(double tempCelsius) {
		return tempCelsius * 1.8 + 32;

	}
	public static double fahrenheitToCelsius(double tempFahrenheit) {
		return (tempFahrenheit - 32) / 1.8;
	}

}
