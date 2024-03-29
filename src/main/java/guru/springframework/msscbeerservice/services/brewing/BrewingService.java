package guru.springframework.msscbeerservice.services.brewing;

import guru.springframework.msscbeerservice.brewery.model.events.BrewBeerEvent;
import guru.springframework.msscbeerservice.config.JmsConfig;
import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repository.BeerRepository;
import guru.springframework.msscbeerservice.services.InventoryService;
import guru.springframework.msscbeerservice.web.mappers.BeerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {

    private final BeerRepository beerRepository;
    private final InventoryService inventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    @Scheduled(fixedRate = 5000)
    public void checkForLowInventory() {
        List<Beer> beers = beerRepository.findAll();
        beers.forEach(
                beer -> {
                    Integer onHandInventory = inventoryService.getOnHandInventory(beer.getId());
                    log.debug("Min on hand is " + beer.getMinOnHand());
                    log.debug("Inventory is " + onHandInventory);
                    if (beer.getMinOnHand() >= onHandInventory) {
                        jmsTemplate.convertAndSend(
                                JmsConfig.BREWING_REQUEST_QUEUE, new BrewBeerEvent(beerMapper.toDto(beer)));
                    }
                });
    }
}
