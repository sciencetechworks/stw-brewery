package com.stw.brewery.services;

import com.stw.brewery.web.model.BeerDto;
import java.util.UUID;

/**
 *
 * @author Usuario
 */
public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}
