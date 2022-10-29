package com.techelevator;

public class HotelReservation {

    public static final int CLEANING_FEE = 25;
    public static final int MINI_BAR_FEE = 15;

    private String name;
    private int numberOfNights;
    private int nightlyRate;
    private int estimatedTotal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public int getNightlyRate() {
        return nightlyRate;
    }

    public void setNightlyRate(int nightlyRate) {
        this.nightlyRate = nightlyRate;
    }

    public int getEstimatedTotal() {
        estimatedTotal =  nightlyRate * numberOfNights;
        return estimatedTotal;
    }

    public HotelReservation(String name, int numberOfNights, int nightlyRate) {
        this.name = name;
        this.numberOfNights = numberOfNights;
        this.nightlyRate = nightlyRate;
        estimatedTotal = nightlyRate * numberOfNights;
    }


    public int getActualTotal(boolean requiresCleaning, boolean usedMinibar) {
        if (usedMinibar && requiresCleaning) {
            return estimatedTotal + MINI_BAR_FEE + (CLEANING_FEE * 2);
        } else if (requiresCleaning) {
            return estimatedTotal + CLEANING_FEE;
        } else if (usedMinibar) {
            return estimatedTotal + MINI_BAR_FEE;
        } else {
            return estimatedTotal;
        }
    }

    @Override
    public String toString() {
        return getName() + ":" + getEstimatedTotal();
    }
}
