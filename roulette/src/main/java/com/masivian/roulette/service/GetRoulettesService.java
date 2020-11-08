package com.masivian.roulette.service;
import com.masivian.roulette.model.Roulette;
import com.masivian.roulette.model.RouletteRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GetRoulettesService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RouletteRepository rouletteRepository;
    public List<Roulette> getAll(){
        log.info("Obtaining all roulettes");
        List<Roulette> roulettes = rouletteRepository.findAll();
        
        return roulettes;
    }
}