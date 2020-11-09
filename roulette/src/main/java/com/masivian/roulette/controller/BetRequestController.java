package com.masivian.roulette.controller;
import com.masivian.roulette.service.BetRequestService;
import com.masivian.roulette.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping(value="/roulette")
public class BetRequestController {
    @Autowired
    private BetRequestService betRequestService;
    @GetMapping(value="/bet")
    public @ResponseBody String createBet(@RequestParam(required = true, name = Constants.PARAMETER_ROULETTE_ID) Long rouletteId,
            @RequestParam(required = true, name = Constants.PARAMETER_CUSTOMER_ID) Long customerId,
            @RequestParam(required = true, name = Constants.PARAMETER_BET_VALUE) Integer betValue,
            @RequestParam(required = false, name = Constants.PARAMETER_BET_NUMBER) Integer betNumber,
            @RequestParam(required = false, name = Constants.PARAMETER_BET_COLOR) String betColor){
        
        return betRequestService.createBet(rouletteId, customerId, betValue, betNumber, betColor);
    }
}
