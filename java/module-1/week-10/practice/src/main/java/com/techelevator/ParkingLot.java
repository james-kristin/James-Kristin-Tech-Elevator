package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    // DO NOT REMOVE the DEFAULT_NUMBER_OF_... constants!!!!!
    public static final int DEFAULT_NUMBER_OF_COMPACT_SLOTS = 3;
    public static final int DEFAULT_NUMBER_OF_MIDSIZE_SLOTS = 5;
    public static final int DEFAULT_NUMBER_OF_FULLSIZE_SLOTS = 2;

    private String name;
    private boolean open;
    private int numberOfCompactSlots;
    private int numberOfMidsizeSlots;
    private int numberOfFullsizeSlots;
    private List<Car> compactList = new ArrayList<>();
    private List<Car> midsizeList = new ArrayList<>();
    private List<Car> fullsizeList = new ArrayList<>();


    public String getName() {
        return name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public int getNumberOfCompactSlots() {
        return numberOfCompactSlots;
    }

    public int getNumberOfMidsizeSlots() {
        return numberOfMidsizeSlots;
    }

    public int getNumberOfFullsizeSlots() {
        return numberOfFullsizeSlots;
    }

    public ParkingLot(String name) {
        this.name = name;
        open = false;
        numberOfCompactSlots = DEFAULT_NUMBER_OF_COMPACT_SLOTS;
        numberOfMidsizeSlots = DEFAULT_NUMBER_OF_MIDSIZE_SLOTS;
        numberOfFullsizeSlots = DEFAULT_NUMBER_OF_FULLSIZE_SLOTS;
    }

    public ParkingLot(String name, boolean open) {
        this.name = name;
        this.open = open;
        numberOfCompactSlots = DEFAULT_NUMBER_OF_COMPACT_SLOTS;
        numberOfMidsizeSlots = DEFAULT_NUMBER_OF_MIDSIZE_SLOTS;
        numberOfFullsizeSlots = DEFAULT_NUMBER_OF_FULLSIZE_SLOTS;
    }

    public ParkingLot(String name, boolean open, int numberOfCompactSlots, int numberOfMidsizeSlots, int numberOfFullsizeSlots) {
        this.name = name;
        this.open = open;
        this.numberOfCompactSlots = numberOfCompactSlots;
        this.numberOfMidsizeSlots = numberOfMidsizeSlots;
        this.numberOfFullsizeSlots = numberOfFullsizeSlots;
    }

    public int getLotSize() {
        return numberOfCompactSlots + numberOfMidsizeSlots + numberOfFullsizeSlots;
    }

    public int numberOfAvailableSlots(String carType) {
        if (carType.equalsIgnoreCase("Compact")) {
            return numberOfCompactSlots - compactList.size();
        } else if (carType.equalsIgnoreCase("Midsize")) {
            return numberOfMidsizeSlots - midsizeList.size();
        } else {
            return numberOfFullsizeSlots - fullsizeList.size();
        }
    }

    public boolean park(Car car) {
        String carType = car.getType();
        if (carType.equalsIgnoreCase("Compact")) {
            if (numberOfAvailableSlots("Compact") > 0) {
                compactList.add(car);
                return true;
            } else {
                return false;
            }
        } else if (carType.equalsIgnoreCase("Midsize")) {
            if (numberOfAvailableSlots("Midsize") > 0) {
                midsizeList.add(car);

                return true;
            } else {
                return false;
            }
        } else {
            if (numberOfAvailableSlots("Fullsize") > 0) {
                fullsizeList.add(car);
                return true;
            } else {
                return false;
            }
        }
    }

    public Car exit(String car, String license) {
        if (car.equalsIgnoreCase("Compact")) {
            for (Car compact : compactList) {
                if (compact.getLicense().equalsIgnoreCase(license)) {
                    compactList.remove(compact);
                    return compact;
                } else {
                    return null;
                }
            }
        } else if (car.equalsIgnoreCase("Midsize")) {
            for (Car midSize : midsizeList) {
                if (midSize.getLicense().equalsIgnoreCase(license)) {
                    midsizeList.remove(midSize);
                    return midSize;
                } else {
                    return null;
                }
            }

        } else {
            for (Car fullSize : fullsizeList) {
                if (fullSize.getLicense().equalsIgnoreCase(license)) {
                    fullsizeList.remove(fullSize);
                    return fullSize;
                } else {
                    return null;
                }
            }
        }
        return null;

    }
}
