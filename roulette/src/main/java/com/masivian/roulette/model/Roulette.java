package com.masivian.roulette.model;

import com.masivian.roulette.utils.RouletteState;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Roulette implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RouletteState roluletteState;
    private Integer winningNumber;
    protected Roulette() {
    }
    protected Roulette(RouletteState roluletteState) {
        this.roluletteState = roluletteState;
    }
    public static Roulette createInitialRoulette(){
        return new Roulette(RouletteState.CREATED);
    }
    public Long getId() {
        return id;
    }
    public RouletteState getRoluletteState() {
        return roluletteState;
    }
    public void setRoluletteState(RouletteState roluletteState) {
        this.roluletteState = roluletteState;
    }
    public Integer getWinningNumber() {
        return winningNumber;
    }
    public void setWinningNumber(Integer winningNumber) {
        this.winningNumber = winningNumber;
    }
}
