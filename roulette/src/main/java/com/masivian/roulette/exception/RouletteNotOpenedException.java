package com.masivian.roulette.exception;
public class RouletteNotOpenedException extends Exception{
    public RouletteNotOpenedException() {
        super("Roulette is not opened");
    }
}