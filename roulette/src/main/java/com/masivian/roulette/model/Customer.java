package com.masivian.roulette.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private Long creditAmount;
    protected Customer() {
    }
    protected Customer(String name, Long creditAmount) {
        this.name = name;
        this.creditAmount = creditAmount;
    }
    public Long getId() {
        return id;
    }
    public static Customer createCustomer(String name, Long creditAmount){
        
        return new Customer(name, creditAmount);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getCreditAmount() {
        return creditAmount;
    }
    public void setCreditAmount(Long creditAmount) {
        this.creditAmount = creditAmount;
    } 
}