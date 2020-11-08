package com.masivian.roulette.exception;
public class RouletteAlreadyClosedException extends Exception{
    public RouletteAlreadyClosedException() {
        super("Roulette already closed");
    }
}