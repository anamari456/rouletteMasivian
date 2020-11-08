package com.masivian.roulette.controller;
import com.masivian.roulette.service.OpenRouletteService;
import com.masivian.roulette.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping(value="/roulette")
public class OpenRouletteController {
    @Autowired
    private OpenRouletteService openRouletteService;
    @GetMapping(value="/open")
    public @ResponseBody String open(@RequestParam(required = true, name = Const.PARAMETER_ROULETTE_ID) Long rouletteId){
        
        return openRouletteService.open(rouletteId);
    }
}