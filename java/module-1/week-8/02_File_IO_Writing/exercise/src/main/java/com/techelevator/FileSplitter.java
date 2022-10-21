package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class FileSplitter {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

		System.out.println("What is the file path of the input file?");
		String inputFilePath = userInput.nextLine();

		System.out.println("How many lines of text (max) should there be in the split files?");
		String maxTextLines = userInput.nextLine();

		File inputFile = new File(inputFilePath);
		System.out.println(inputFile);
		File convertedInputFile = convertInputFile(inputFile, 1);



	}
	static private File convertInputFile(File inputFile, int timesSplit) {
		String inputPath = inputFile.getAbsolutePath();
		int dotIndex = inputPath.lastIndexOf('.');

		String convertedPath;

		if (dotIndex >= 0) {
			convertedPath = inputPath.substring(0, dotIndex) + "-" + timesSplit + inputPath.substring(dotIndex, +1);

		} else {
			convertedPath = inputPath + "-" + timesSplit;

		}
		return new File(convertedPath);
	}

}
