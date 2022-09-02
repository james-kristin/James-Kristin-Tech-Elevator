package com.techelevator;

import java.util.Arrays;
import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Please enter in a series of decimal values (separated by spaces): ");
		String value = input.nextLine();
		String[] decimal = value.split(" " );

		for (int i = 0; i < decimal.length; i++) {
			int integerValue = Integer.parseInt(decimal[i]);
			String binaryValue = Integer.toBinaryString(integerValue);
			System.out.println(integerValue + " in binary is " + binaryValue);
		}








	}

}
