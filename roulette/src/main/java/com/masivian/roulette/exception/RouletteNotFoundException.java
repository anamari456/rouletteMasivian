package com.masivian.roulette.exception;
public class RouletteNotFoundException extends Exception{
    public RouletteNotFoundException(Long rouletteId) {
        super("Roulette not found in DataBase for id: "+rouletteId);
    }
}