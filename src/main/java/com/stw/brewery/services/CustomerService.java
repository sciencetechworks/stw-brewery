package com.stw.brewery.services;

import com.stw.brewery.web.model.CustomerDto;
import com.stw.brewery.web.model.CustomerDto;
import java.util.UUID;

/**
 *
 * @author Usuario
 */
public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
    
    CustomerDto saveNewCustomer(CustomerDto customerDto);
    
    void updateCustomer(UUID customerId,CustomerDto customerDto);
    
    void deleteById(UUID customerId);
}
