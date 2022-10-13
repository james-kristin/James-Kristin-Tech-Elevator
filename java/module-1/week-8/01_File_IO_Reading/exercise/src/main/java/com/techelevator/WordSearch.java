package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

		System.out.println("What is the name of the file path that should be searched?");
		String filePath = userInput.nextLine();

		System.out.println("what is the word you are searching for?");
		String searchWord = userInput.nextLine();

		System.out.println("Should the search be case sensitive?(Y/N)");
		String caseSensitivity = userInput.nextLine();
		boolean isCaseSensitive = false;

		if (caseSensitivity.equalsIgnoreCase("Y")) {
			isCaseSensitive = true;
		} else if (caseSensitivity.equalsIgnoreCase("N")) {
			isCaseSensitive = false;
		} else {
			System.out.println("invalid input");
		}

		File bookFile = new File(filePath);

		int lineCount = 0;

		try (Scanner fileInput = new Scanner(bookFile)) {
			while (fileInput.hasNextLine()) {
				String lineOfText =fileInput.nextLine();
				lineCount++;
				if (isCaseSensitive) {
					if (lineOfText.contains(searchWord)) {
						System.out.println(lineCount + ": " + lineOfText);
					}
				} else {
					String lowerCaseLineOfTest = lineOfText.toLowerCase();
					String lowerCaseSearchWord = searchWord.toLowerCase();

					if (lowerCaseLineOfTest.contains(lowerCaseSearchWord)) {
						System.out.println(lineCount + ": " + lineOfText);
					}
				}
			}


		}
		catch (FileNotFoundException e) {
			System.out.println("The file was not found: " + bookFile.getAbsolutePath());
		}
	}

}
