package com.masivian.roulette.controller;
import com.masivian.roulette.model.Roulette;
import com.masivian.roulette.service.GetRoulettesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping(value="/roulette")
public class GetRoulettesController {
    @Autowired
    private GetRoulettesService getRoulettesService;
    @GetMapping(value="/getAll")
    public @ResponseBody List<Roulette> getAll(){
        
        return getRoulettesService.getAll();
    }
}