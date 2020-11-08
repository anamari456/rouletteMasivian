package com.masivian.roulette.model;
import com.masivian.roulette.utils.BetColor;
import com.masivian.roulette.utils.RouletteColorCalculator;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Bet implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Roulette roulette;
    private Integer number;
    @Enumerated(EnumType.STRING)
    private BetColor betColor;
    @ManyToOne
    private Customer customer;
    private Integer betValue;
    private Double rewardValue;
    protected Bet() {
    }
    protected Bet(Roulette roulette, Customer customer, Integer number, BetColor betColor, Integer betValue) {
        this.roulette = roulette;
        this.number = number;
        this.betColor = betColor;
        this.betValue = betValue;
        this.customer = customer;
    }
    public static Bet createBetNumber(Roulette roulette, Customer customer, Integer number, Integer betValue){
        return new Bet(roulette, customer, number, RouletteColorCalculator.calculate(number), betValue);
    }
    public static Bet createBetColor(Roulette roulette, Customer customer, BetColor betColor, Integer betValue){
        return new Bet(roulette, customer, null, betColor, betValue);
    }
    public Long getId() {
        return id;
    }
    public Roulette getRoulette() {
        return roulette;
    }
    public void setRoulette(Roulette roulette) {
        this.roulette = roulette;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public BetColor getBetColor() {
        return betColor;
    }
    public void setBetColor(BetColor betColor) {
        this.betColor = betColor;
    }
    public Integer getBetValue() {
        return betValue;
    }
    public void setBetValue(Integer betValue) {
        this.betValue = betValue;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Double getRewardValue() {
        return rewardValue;
    }
    public void setRewardValue(Double rewardValue) {
        this.rewardValue = rewardValue;
    }
}