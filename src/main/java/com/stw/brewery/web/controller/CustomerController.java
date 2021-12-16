
package com.stw.brewery.web.controller;

import com.stw.brewery.services.CustomerService;
import com.stw.brewery.web.model.CustomerDto;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *          ScienceTechWorks
 * @author Ramon.Talavera@gmail.com 
 */
@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
    
    private final CustomerService customerService;

    public CustomerController(CustomerService beerService) {
        this.customerService = beerService;
    }
    
    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){
       return  new ResponseEntity<>(customerService.getCustomerById(customerId),HttpStatus.OK);
    }

}
