package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();

        System.out.println("What is the replacement word?");
        String replacementWord = userInput.nextLine();

        System.out.println("What is the source file?");
        String sourceFilePath = userInput.nextLine();

        System.out.println("What is the destination file?");
        String destinationFilePath = userInput.nextLine();

        File sourceFile = new File(sourceFilePath);
        File destinationFile = new File(destinationFilePath);

        try (Scanner sourceInput = new Scanner(sourceFile);
             PrintWriter destinationWriter = new PrintWriter(destinationFile)) {

                while (sourceInput.hasNextLine()) {
                    String lineOfText =sourceInput.nextLine();

                    if (lineOfText.contains(searchWord)) {
                        destinationWriter.println(lineOfText.replace(searchWord, replacementWord));
                    } else {
                        destinationWriter.println(lineOfText);
                    }
                }
        } catch (FileNotFoundException e) {
            System.out.println("One or more file paths could not be found" + sourceFile.getAbsolutePath() + " or " + destinationFile.getAbsolutePath());
            return;
        }
    }

}
