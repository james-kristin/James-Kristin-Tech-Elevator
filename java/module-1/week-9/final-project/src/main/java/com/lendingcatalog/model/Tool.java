package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.util.UUID;

public class Tool implements CatalogItem {
    private String id;
    private String type;
    private String manufacturer;
    private int count;

    public Tool(String type, String manufacturer, int count) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.count = count;
    }

    @Override
    public String toString() {
        return "* " + type + System.lineSeparator()
                + " - Manufactured by: " + manufacturer + System.lineSeparator()
                + " - Count: " + count + System.lineSeparator()
                + " - Id: " + id;
    }

    @Override
    public boolean matchesName(String searchStr) {
        if (searchStr.isEmpty()) {
            return false;
        }
        String lowerSearchStr = searchStr.toLowerCase();
        String lowerType = type.toLowerCase();
        if (lowerType.contains(lowerSearchStr)) {
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
        String lowerManufacturer = manufacturer.toLowerCase();
        if (lowerManufacturer.contains(lowerSearchStr)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean matchesYear(int searchStr) {
        return false;
    }

    @Override
    public void registerItem() {
        id = UUID.randomUUID().toString();

        try {
            FileStorageService.writeContentsToFile(toString(), "src/main/resources/logs/Tool-Log.txt", true  );
        } catch (FileStorageException e) {
            System.err.println(e.getMessage());
        }    }
}
