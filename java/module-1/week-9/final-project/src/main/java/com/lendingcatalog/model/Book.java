package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

public class Book implements CatalogItem{
    private String id;
    private String title;
    private String author;
    private LocalDate publishDate;

    public Book(String title, String author, String publishDate) {
        this.title = title;
        this.author = author;
        this.publishDate = LocalDate.parse(publishDate);
    }

    @Override
    public String toString() {
        return "* " + title + System.lineSeparator()
                + " - Written by: " + author + System.lineSeparator()
                + " - Published: " + publishDate + System.lineSeparator()
                + " - Id: " + id;
    }

    @Override
    public boolean matchesName(String searchStr) {
        if (searchStr.isEmpty()) {
            return false;
        }
        String lowerSearchStr = searchStr.toLowerCase();
        String lowerTitle = title.toLowerCase();
        if (lowerTitle.contains(lowerSearchStr)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        if (searchStr.isEmpty()) {
            return false;
        }
        String lowerSearchStr = searchStr.toLowerCase();
        String lowerAuthor = author.toLowerCase();
        if (lowerAuthor.contains(lowerSearchStr)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean matchesYear(int searchStr) {
        if (publishDate.getYear() == searchStr) {
            return true;
        }
        return false;
    }

    @Override
    public void registerItem() {
        id = UUID.randomUUID().toString();

        try {
            FileStorageService.writeContentsToFile(toString(), "src/main/resources/logs/Book-Log.txt", true  );
        } catch (FileStorageException e) {
            System.err.println(e.getMessage());
        }
    }
}
