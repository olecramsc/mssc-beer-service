package guru.springframework.msscbeerservice.services;

import guru.springframework.msscbeerservice.brewery.model.BeerDto;
import guru.springframework.msscbeerservice.brewery.model.BeerPagedList;
import guru.springframework.msscbeerservice.brewery.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    BeerDto getById(UUID beerId, Boolean showInventory);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    List<BeerDto> getAll();

    BeerPagedList list(String beerName, BeerStyleEnum beerStyle, Boolean showInventory, PageRequest pageRequest);

    BeerDto getBeerByUPC(Long beerUPC);
}
