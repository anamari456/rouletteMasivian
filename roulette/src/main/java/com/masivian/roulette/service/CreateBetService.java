package com.masivian.roulette.service;
import com.masivian.roulette.exception.ColorNotAllowdException;
import com.masivian.roulette.exception.ValueOutOfBoundsException;
import com.masivian.roulette.model.BetRepository;
import com.masivian.roulette.model.Bet;
import com.masivian.roulette.model.Customer;
import com.masivian.roulette.model.Roulette;
import com.masivian.roulette.utils.BetColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CreateBetService {
    @Autowired
    private BetRepository betRepository;
    public Bet create(Roulette roulette, Customer customer, Integer betNumber, String betColor, Integer betValue) throws ValueOutOfBoundsException, ColorNotAllowdException{
        validateBetData(betNumber, betColor, betValue);
        Bet bet;
        if(betNumber==null){
            BetColor color = betColor.equalsIgnoreCase(BetColor.NEGRO.name())?BetColor.NEGRO:BetColor.ROJO;
            bet = Bet.createBetColor(roulette, customer, color, betValue);
        }else{
            bet = Bet.createBetNumber(roulette, customer, betNumber, betValue);
        }
        betRepository.save(bet);
        
        return bet;
    }
    private void validateBetData(Integer betNumber, String betColor, Integer betValue) throws ValueOutOfBoundsException, ColorNotAllowdException{
        validateNumber(betNumber, 0, 36);
        validateNumber(betValue, 0, 10000);
        validateColor(betColor);
    }
    private void validateNumber(Integer value, Integer min,Integer max) throws ValueOutOfBoundsException{
        if(value!=null && !(value>=min && value<=max)){
            throw new ValueOutOfBoundsException(value);
        }
    }
    private void validateColor(String color) throws ColorNotAllowdException{
        if(color!=null && !( color.equalsIgnoreCase(BetColor.NEGRO.name()) || color.equalsIgnoreCase(BetColor.ROJO.name()))){
            throw new ColorNotAllowdException(color);
        }
    }
}