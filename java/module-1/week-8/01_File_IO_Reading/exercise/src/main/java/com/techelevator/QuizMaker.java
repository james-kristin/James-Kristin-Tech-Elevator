package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

		System.out.println("What is the file path of the quiz questions file?");
		String filePath = userInput.nextLine();

		File quizFile = new File(filePath);

		try (Scanner quizInput = new Scanner(quizFile)) {
			int score = 0;
			int questions = 0;
			while (quizInput.hasNextLine()) {
				String[] quizSetup = quizInput.nextLine().split("\\|");
				int answer = 0;


				for (int i = 0; i < quizSetup.length; i++) {
					if (i == 0) {
						System.out.println(quizSetup[i]);
					} else if (quizSetup[i].contains("*")) {
						answer = i;
						System.out.println(i + ". " + quizSetup[i].substring(0, quizSetup[i].length() - 1));
					} else {
						System.out.println(i + ". " + quizSetup[i]);
					}
				}
				System.out.println("Your Answer: ");
				String answerInput = userInput.next();
				int answerInt = Integer.valueOf(answerInput);

				if (answer == answerInt) {
					System.out.println("Correct!");
					score++;
					questions++;
				} else {
					System.out.println("Incorrect");
					questions++;
				}
			}
			System.out.println("You got " + score + " answer(s) correct out of the " + questions + " asked.");

		} catch (FileNotFoundException e) {
			System.out.println("File path for quiz not found: " + quizFile.getAbsolutePath());
			return;
		}
	}

}
