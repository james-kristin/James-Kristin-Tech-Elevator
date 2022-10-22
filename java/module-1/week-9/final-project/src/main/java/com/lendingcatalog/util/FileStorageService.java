package com.lendingcatalog.util;

import com.lendingcatalog.util.exception.FileStorageException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileStorageService {

    // Requirement: File I/O
    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileStorageException {
       File dataFile = new File(filename);
        if (appendFile) {
           try (PrintWriter dataOutput = new PrintWriter(new FileOutputStream(dataFile, true))) {
               dataOutput.println(LocalDateTime.now() + "- new " + contents + "created");
           } catch (FileNotFoundException e) {
               System.err.println(e.getMessage());
           }
       } else {
           try (PrintWriter dataOutput = new PrintWriter(dataFile)) {
               dataOutput.println(LocalDateTime.now() + "- new " + contents + "created");
           } catch (FileNotFoundException e) {
               System.err.println(e.getMessage());
           }
       }

    }

    public static List<String> readContentsOfFile(String filename) throws FileStorageException {
       File dataFile = new File(filename);
        List<String> contents = new ArrayList<>();
        try (Scanner dataInput = new Scanner(dataFile)) {
            while (dataInput.hasNextLine()) {
                String lineOfInput = dataInput.nextLine();
                contents.add(lineOfInput);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return contents;
    }
}
