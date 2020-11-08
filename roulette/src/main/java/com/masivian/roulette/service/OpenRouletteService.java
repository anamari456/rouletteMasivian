package com.masivian.roulette.service;
import com.masivian.roulette.exception.RouletteAlreadyClosedException;
import com.masivian.roulette.exception.RouletteNotFoundException;
import com.masivian.roulette.model.Roulette;
import com.masivian.roulette.model.RouletteRepository;
import com.masivian.roulette.utils.ResultState;
import com.masivian.roulette.utils.RouletteState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OpenRouletteService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RouletteRepository rouletteRepository;
    public String open(Long rouletteId){
        try {
            log.info("Obtaining Roulette from DataBase");
            Roulette roulette = rouletteRepository.findById(rouletteId).orElseThrow(() -> new RouletteNotFoundException(rouletteId));
            if(roulette.getRoluletteState().equals(RouletteState.CREATED)){
                log.info("Changing Roulette state");
                roulette.setRoluletteState(RouletteState.OPENED);
                rouletteRepository.save(roulette);
            }else if(roulette.getRoluletteState().equals(RouletteState.CLOSED)){
                throw new RouletteAlreadyClosedException();
            }
            
            return ResultState.EXITOSO.toString();
        } catch (RouletteNotFoundException | RouletteAlreadyClosedException ex) {
            log.error(ex.getMessage());
            
            return ResultState.DENEGADO.toString();
        }
    }
}