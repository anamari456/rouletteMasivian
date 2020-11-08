package com.masivian.roulette.service;
import com.masivian.roulette.model.Bet;
import com.masivian.roulette.model.BetRepository;
import com.masivian.roulette.model.Roulette;
import com.masivian.roulette.utils.RouletteColorCalculator;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CalculateBetResultService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BetRepository betRepository;
    public void calculate(Roulette roulette) {
        log.info("Calculating Bets Result");
        List<Bet> bets = betRepository.findByRoulette(roulette);
        List<Bet> winnerColorBets = bets.stream().filter(bet -> (bet.getNumber() == null
                || (bet.getNumber() != null && !bet.getNumber().equals(roulette.getWinningNumber())))
                && bet.getBetColor().equals(RouletteColorCalculator.calculate(roulette.getWinningNumber())))
                .collect(Collectors.toList());
        winnerColorBets.stream().forEach(bet -> bet.setRewardValue(1.8 * bet.getBetValue()));
        List<Bet> winnerNumberBets = bets.stream().filter(bet -> bet.getNumber() != null
                && bet.getNumber().equals(roulette.getWinningNumber())).collect(Collectors.toList());
        winnerNumberBets.stream().forEach(bet -> bet.setRewardValue(5.0 * bet.getBetValue()));
        betRepository.saveAll(winnerColorBets);
        betRepository.saveAll(winnerNumberBets);
    }
}
