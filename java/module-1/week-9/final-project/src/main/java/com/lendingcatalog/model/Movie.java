package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.time.LocalDate;
import java.util.UUID;

public class Movie implements  CatalogItem {
    private String id;
    private String name;
    private String director;
    private LocalDate releaseDate;

    public Movie(String name, String director, LocalDate releaseDate) {
        this.name = name;
        this.director = director;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "* " + name + System.lineSeparator()
                + " - Directed by: " + director + System.lineSeparator()
                + " - Released: " + releaseDate + System.lineSeparator()
                + " - Id: " + id;
    }

    @Override
    public boolean matchesName(String searchStr) {
        if (searchStr.isEmpty()) {
            return false;
        }
        String lowerSearchStr = searchStr.toLowerCase();
        String lowerName = name.toLowerCase();
        if (lowerName.contains(lowerSearchStr)) {
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
        String lowerDirector = director.toLowerCase();
        if (lowerDirector.contains(lowerSearchStr)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean matchesYear(int searchStr) {
        if (releaseDate.getYear() == searchStr) {
            return true;
        }
        return false;
    }

    @Override
    public void registerItem() {
        id = UUID.randomUUID().toString();

        try {
            FileStorageService.writeContentsToFile(toString(), "src/main/resources/logs/Movie-Log.txt", true  );
        } catch (FileStorageException e) {
            System.err.println(e.getMessage());
        }
    }
}
