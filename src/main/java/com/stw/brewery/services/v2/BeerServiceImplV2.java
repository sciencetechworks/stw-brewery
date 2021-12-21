
package com.stw.brewery.services.v2;

import com.stw.brewery.web.model.BeerDto;
import com.stw.brewery.web.model.v2.BeerDtoV2;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 *          ScienceTechWorks
 * @author Ramon.Talavera@gmail.com 
 */
@Service
public class BeerServiceImplV2 implements BeerServiceV2 {

    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDtoV2) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDtoV2) {
      //todo - would add a real impl to update beer  
    }

    @Override
    public void deleteById(UUID beerId) {
        //todo - would add a real impl to delete beer  
    }

}
