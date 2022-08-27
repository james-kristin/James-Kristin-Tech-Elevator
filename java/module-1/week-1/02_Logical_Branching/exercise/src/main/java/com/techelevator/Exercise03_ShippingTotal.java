package com.techelevator;

public class Exercise03_ShippingTotal {

    /*
    Scamper Shipping Company specializes in small, local deliveries.
    The problems below ask you to implement the logic to calculate a shipping amount for a package.
     */

    // You can use these constants in your solutions.
    private final int MAX_WEIGHT_POUNDS = 40;
    private final double UP_TO_40_LB_RATE = 0.50;
    private final double OVER_40_LB_RATE = 0.75;
    private final double RATE_OF_40_LB = (MAX_WEIGHT_POUNDS * UP_TO_40_LB_RATE);
    private final double DISCOUNT_RATE = 0.9;

    /*
    Scamper Shipping Company charges $0.50 per pound up to 40 pounds. After that, it's $0.75 for each additional pound.
    Implement the logic needed to calculate the shipping rate when provided a weight in pounds.

    Examples:
    calculateShippingTotal(10) ➔ 5.0
    calculateShippingTotal(25) ➔ 12.5
    calculateShippingTotal(45) ➔ 23.75
     */
    public double calculateShippingTotal(int weightPounds) {
        if (weightPounds <= MAX_WEIGHT_POUNDS) {
            double shippingRate = weightPounds * UP_TO_40_LB_RATE;
            return shippingRate;
        } else {
            double shippingRate = RATE_OF_40_LB + ((weightPounds - MAX_WEIGHT_POUNDS) * OVER_40_LB_RATE);
            return shippingRate;
        }
    }

    /*
    Scamper Shipping Company now allows customers to provide a discount code to give them 10% off of their order.
    Implement the logic to calculate the correct shipping rate when provided a weight in pounds and a boolean value for hasDiscount.

    Examples:
    calculateShippingTotal(10, false) ➔ 5.0
    calculateShippingTotal(10, true) ➔ 4.5
    calculateShippingTotal(25, false) ➔ 12.5
    calculateShippingTotal(25, true) ➔ 11.25
    calculateShippingTotal(45, false) ➔ 23.75
    calculateShippingTotal(45, true) ➔ 21.375
     */
    public double calculateShippingTotal(int weightPounds, boolean hasDiscount) {
        if (weightPounds <= MAX_WEIGHT_POUNDS && hasDiscount) {
           double shippingRate = (weightPounds * UP_TO_40_LB_RATE) * DISCOUNT_RATE;
            return shippingRate;
        } else if (weightPounds <= MAX_WEIGHT_POUNDS) {
            double shippingRate = weightPounds * UP_TO_40_LB_RATE;
            return shippingRate;
        } else if (hasDiscount) {
            double shippingRate = (RATE_OF_40_LB + ((weightPounds - MAX_WEIGHT_POUNDS) * OVER_40_LB_RATE)) * DISCOUNT_RATE;
            return shippingRate;
        } else {
         double shippingRate = RATE_OF_40_LB + ((weightPounds - MAX_WEIGHT_POUNDS) * OVER_40_LB_RATE);
         return shippingRate;
        }
    }

    /*
    As the business grows for Scamper Shipping Company, they now offer discounts in various amounts.
    Implement the logic to calculate the shipping rate when provided a weight in pounds
    and a discount percentage (for example, 0.1 = 10% off).

    Examples:
    calculateShippingTotal(10, 0) ➔ 5.0
    calculateShippingTotal(10, 0.1) ➔ 4.5
    calculateShippingTotal(25, 0.15) ➔ 10.625
    calculateShippingTotal(45, 0.2) ➔ 19.0
     */
    public double calculateShippingTotal(int weightPounds, double discountPercentage) {
            if (weightPounds <= MAX_WEIGHT_POUNDS && discountPercentage > 0) {
                double shippingRate = (weightPounds * UP_TO_40_LB_RATE) * (1 - discountPercentage);
                return shippingRate;
            }else if (weightPounds <= MAX_WEIGHT_POUNDS){
                double shippingRate = weightPounds * UP_TO_40_LB_RATE;
                return shippingRate;
            } else if (discountPercentage > 0) {
                double shippingRate = (RATE_OF_40_LB + ((weightPounds - MAX_WEIGHT_POUNDS) * OVER_40_LB_RATE)) * (1 - discountPercentage);
                return shippingRate;
            } else {
                double shippingRate = RATE_OF_40_LB + ((weightPounds - MAX_WEIGHT_POUNDS) * OVER_40_LB_RATE);
                return shippingRate;
            }




    }
}
