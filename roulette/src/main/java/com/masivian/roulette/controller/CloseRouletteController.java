package com.masivian.roulette.controller;
import com.masivian.roulette.service.CloseRouletteService;
import com.masivian.roulette.model.Bet;
import com.masivian.roulette.utils.Const;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping(value="/roulette")
public class CloseRouletteController {
    @Autowired
    private CloseRouletteService closeRouletteService;
    @GetMapping(value="/close")
    public @ResponseBody List<Bet> close(@RequestParam(required = true, name = Const.PARAMETER_ROULETTE_ID) Long rouletteId){
        
        return closeRouletteService.close(rouletteId);
    }
}