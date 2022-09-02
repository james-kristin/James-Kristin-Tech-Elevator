package com.techelevator;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Please enter a number: ");
		String value = input.nextLine();
		int length = Integer.parseInt(value);

		int fib1 = 1;
		int fib2 = 1;

		if (length > 1) {
			System.out.print("0, 1, 1, ");
			for (int i = 1; i + fib1 <= length;) {
				fib2 = i + fib1;
				i = fib1;
				fib1 = fib2;
				System.out.print(fib2 + ", ");
			}

		} else if (length == 0) {
			System.out.println("0, 1");
		} else if (length == 1) {
			System.out.println("0, 1, 1");
		}






	}
}
