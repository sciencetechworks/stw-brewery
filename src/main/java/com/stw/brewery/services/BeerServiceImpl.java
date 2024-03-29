
package com.stw.brewery.services;

import com.stw.brewery.web.model.BeerDto;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 *          ScienceTechWorks
 * @author Ramon.Talavera@gmail.com 
 */
@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
      //todo - would add a real impl to update beer  
    }

    @Override
    public void deleteById(UUID beerId) {
        //todo - would add a real impl to delete beer  
    }

}
