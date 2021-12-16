
package com.stw.brewery.services;

import com.stw.brewery.web.model.BeerDto;
import com.stw.brewery.web.model.CustomerDto;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 *          ScienceTechWorks
 * @author Ramon.Talavera@gmail.com 
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Michael Moore")
                .build();
    }

}
