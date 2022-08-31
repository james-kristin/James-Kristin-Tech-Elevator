package com.techelevator;

public class Tutorial {

    public static void main(String[] args) {

        int i;
        for (i = 0; i<= 5; i++) {
            System.out.println(i);
        }

        for (i = 10; i>=0; i-- ) {
            System.out.println(i);
        }

        int[] forecastTemperatures = new int[5];
        forecastTemperatures[0] = 85;
        forecastTemperatures[1] = 78;
        forecastTemperatures[2] = 58;
        forecastTemperatures[3] = 79;
        forecastTemperatures[4] = 74;
        forecastTemperatures[2] += 10;

        for (i=0; i < forecastTemperatures.length; i++) {
            System.out.println(forecastTemperatures[i]);
        }

        int highestTemperatureValue = forecastTemperatures[0];
        int highestTemperatureindex = 0;
        int tomorrow = 0;

        for (int j = 1; j < forecastTemperatures.length; j++) {
            if (forecastTemperatures [j] > highestTemperatureValue) {
                highestTemperatureValue = forecastTemperatures[j];
                highestTemperatureindex = j;
            }
        }

        System.out.println("The highest temperature is " + highestTemperatureValue);

        
        if (highestTemperatureindex == tomorrow) {
            System.out.println("The highest temperature is tomorrow");
        } else {
            System.out.println("The highest temperature is in " + (highestTemperatureindex + 1) + " days");
        }







    }
}
