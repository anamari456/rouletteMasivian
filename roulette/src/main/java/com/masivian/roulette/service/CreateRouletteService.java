package com.masivian.roulette.service;
import com.masivian.roulette.model.Roulette;
import com.masivian.roulette.model.RouletteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CreateRouletteService {
    @Autowired
    private RouletteRepository rouletteRepository;
    public Roulette create(){
        Roulette roulette = Roulette.createInitialRoulette();
        rouletteRepository.save(roulette);
        
        return roulette;
    }
}