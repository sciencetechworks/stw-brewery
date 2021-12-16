package com.stw.brewery.services;

import com.stw.brewery.web.model.CustomerDto;
import java.util.UUID;

/**
 *
 * @author Usuario
 */
public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
}
