package com.masivian.roulette.exception;
public class CustomerNotFoundException extends Exception{
    public CustomerNotFoundException(Long customerId) {
        super("Customer not found in DataBase for id: "+customerId);
    }
}