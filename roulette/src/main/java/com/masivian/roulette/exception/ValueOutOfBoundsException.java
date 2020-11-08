package com.masivian.roulette.exception;
public class ValueOutOfBoundsException extends Exception{
    public ValueOutOfBoundsException(Integer value) {
        super("Value " + value + " exceeds limits");
    }
}