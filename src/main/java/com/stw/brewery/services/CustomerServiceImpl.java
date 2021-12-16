
package com.stw.brewery.services;

import com.stw.brewery.web.model.CustomerDto;
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
    
    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
      //todo - would add a real impl to update customer  
    }

    @Override
    public void deleteById(UUID customerId) {
        //todo - would add a real impl to delete customer  
    }


}
