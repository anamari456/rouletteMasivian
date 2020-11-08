package com.masivian.roulette.controller;
import com.masivian.roulette.model.Customer;
import com.masivian.roulette.service.CreateCustomerService;
import com.masivian.roulette.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping(value="/customer")
public class CreateCustomerController {
    @Autowired
    private CreateCustomerService createCustomerService;
    @GetMapping(value="/create")
    public @ResponseBody Customer create(@RequestParam(required = true, name = Const.PARAMETER_CUSTOMER_NAME) String name,
            @RequestParam(required = true, name = Const.PARAMETER_CREDIT_AMOUNT) Long creditAmount){
        
        return createCustomerService.create(name, creditAmount);
    }
}