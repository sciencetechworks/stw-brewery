package com.stw.brewery.services.v2;

import com.stw.brewery.web.model.BeerDto;
import com.stw.brewery.web.model.v2.BeerDtoV2;
import java.util.UUID;

/**
 *
 * @author Usuario
 */
public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID beerId);
    
    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDtoV2);
    
    void updateBeer(UUID beerId,BeerDtoV2 beerDtoV2);
    
    void deleteById(UUID beerId);
}
