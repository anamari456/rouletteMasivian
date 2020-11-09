package com.masivian.roulette.utils;
public class RouletteColorCalculator {
    public static BetColor calculate(Integer number){
        
        return (number%2==0)?BetColor.ROJO:BetColor.NEGRO;
    }
}