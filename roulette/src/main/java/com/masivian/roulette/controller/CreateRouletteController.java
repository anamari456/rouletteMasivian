package com.masivian.roulette.controller;
import com.masivian.roulette.model.Roulette;
import com.masivian.roulette.service.CreateRouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping(value="/roulette")
public class CreateRouletteController {
    @Autowired
    private CreateRouletteService createRouletteService;
    @GetMapping(value="/create")
    public @ResponseBody Roulette create(){
        
        return createRouletteService.create();
    }
}