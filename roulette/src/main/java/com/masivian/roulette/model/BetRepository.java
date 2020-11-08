package com.masivian.roulette.model;
import com.masivian.roulette.utils.BetColor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BetRepository extends JpaRepository<Bet, Long>{
    List<Bet> findByRoulette(Roulette roulette);
}