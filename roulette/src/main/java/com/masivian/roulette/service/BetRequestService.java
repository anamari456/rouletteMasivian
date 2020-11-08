package com.masivian.roulette.service;
import com.masivian.roulette.exception.ColorNotAllowdException;
import com.masivian.roulette.exception.CustomerNotFoundException;
import com.masivian.roulette.exception.RouletteNotFoundException;
import com.masivian.roulette.exception.RouletteNotOpenedException;
import com.masivian.roulette.exception.ValueOutOfBoundsException;
import com.masivian.roulette.model.Customer;
import com.masivian.roulette.model.CustomerRepository;
import com.masivian.roulette.model.Roulette;
import com.masivian.roulette.model.RouletteRepository;
import com.masivian.roulette.utils.ResultState;
import com.masivian.roulette.utils.RouletteState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BetRequestService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RouletteRepository rouletteRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CreateBetService createBetService;
    public String createBet(Long rouletteId, Long customerId, Integer betValue, Integer betNumber, String betColor) {
        try {
            log.info("Obtaining Roulette from DataBase");
            Roulette roulette = rouletteRepository.findById(rouletteId).orElseThrow(() -> new RouletteNotFoundException(rouletteId));
            if(!roulette.getRoluletteState().equals(RouletteState.OPENED)){
                throw new RouletteNotOpenedException();
            }
            log.info("Obtaining Customer from DataBase");
            Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));
            log.info("Creating Bet");
            createBetService.create(roulette, customer, betNumber, betColor, betValue);
            log.info("Calculating customer credit");
            customer.setCreditAmount(customer.getCreditAmount() - betValue);
            customerRepository.save(customer);
            
            return ResultState.EXITOSO.toString();
        } catch (RouletteNotFoundException | RouletteNotOpenedException | CustomerNotFoundException | ValueOutOfBoundsException | ColorNotAllowdException ex) {
            log.error(ex.getMessage());
            
            return ResultState.DENEGADO.toString();
        }
    }
}