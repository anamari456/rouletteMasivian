package com.masivian.roulette.service;
import com.masivian.roulette.exception.RouletteNotFoundException;
import com.masivian.roulette.exception.RouletteNotOpenedException;
import com.masivian.roulette.model.Bet;
import com.masivian.roulette.model.BetRepository;
import com.masivian.roulette.model.Roulette;
import com.masivian.roulette.model.RouletteRepository;
import com.masivian.roulette.utils.RouletteState;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CloseRouletteService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RouletteRepository rouletteRepository;
    @Autowired 
    private BetRepository betRepository;
    @Autowired
    private CalculateBetResultService calculateBetResultService;
    public List<Bet> close(Long rouletteId){
        try {
            log.info("Obtaining Roulette from DataBase");
            Roulette roulette = rouletteRepository.findById(rouletteId).orElseThrow(() -> new RouletteNotFoundException(rouletteId));
            closeRoulette(roulette);
            roulette.setWinningNumber(generateWinningNumber());
            rouletteRepository.save(roulette);
            calculateBetResultService.calculate(roulette);
            List<Bet> bets = betRepository.findByRoulette(roulette);
            
            return bets;
        } catch (RouletteNotFoundException | RouletteNotOpenedException ex) {
            log.error(ex.getMessage());
            
            return null;
        }
    }
    private void closeRoulette(Roulette roulette) throws RouletteNotOpenedException{
        if(!roulette.getRoluletteState().equals(RouletteState.OPENED)){
                throw new RouletteNotOpenedException();
            }
            log.info("Changing Roulette state");
            roulette.setRoluletteState(RouletteState.CLOSED);
    }
    private Integer generateWinningNumber(){
        log.info("Generating winning number");
        Random random = new Random();
        
        return random.ints(0, 37).findFirst().getAsInt();
    }
}