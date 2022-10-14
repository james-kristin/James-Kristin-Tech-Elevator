package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

		System.out.println("What is the destination File?");
		String destinationFilePath = userInput.nextLine();

		File destinationFile = new File(destinationFilePath);

		try (PrintWriter destinationWriter = new PrintWriter(destinationFile)) {
			for (int i = 1; i <= 300; i++) {
				if ((i % 3 == 0) && (i % 5 == 0)) {
					destinationWriter.println("FizzBuzz");
				} else if (i % 3 == 0) {
					destinationWriter.println("Fizz");
				} else if (i % 5 == 0) {
					destinationWriter.println("Buzz");
				} else {
					destinationWriter.println(i);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("The destination file path could not be found: " + destinationFile.getAbsolutePath());
			return;
		}
	}

}
