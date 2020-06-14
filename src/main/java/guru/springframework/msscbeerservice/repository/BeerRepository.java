package guru.springframework.msscbeerservice.repository;

import guru.springframework.msscbeerservice.brewery.model.BeerStyleEnum;
import guru.springframework.msscbeerservice.domain.Beer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
  Page<Beer> findAllByBeerNameAndBeerStyle(
          String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest);

  Page<Beer> findAllByBeerName(String beerName, PageRequest pageRequest);

  Page<Beer> findAllByBeerStyle(BeerStyleEnum beerStyle, PageRequest pageRequest);

  Beer findByUpc(Long beerUPC);
}
