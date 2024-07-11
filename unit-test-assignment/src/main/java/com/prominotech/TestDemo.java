package com.prominotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			int sum = a + b;
			return sum;
		}
		else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	/*
	 * Method that divides instead of adds two integers
	 */
	public int dividePositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a / b;
		}
		else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	
	/**
     * Returns the square of a randomly generated integer between 1 and 10.
     * Uses getRandomInt() to get the random integer.
     */
    int randomNumberSquared() {
        int randomNumber = getRandomInt();
        return randomNumber * randomNumber;
    }
    /* 
     * "Produces a number that could be any whole number from 1 to 10."
     */
    int getRandomInt() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }
}
