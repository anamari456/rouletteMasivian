package com.masivian.roulette.exception;
public class ColorNotAllowdException extends Exception{
    public ColorNotAllowdException(String color) {
        super("Color " + color + " not allowd");
    }
}