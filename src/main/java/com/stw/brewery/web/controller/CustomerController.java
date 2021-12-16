
package com.stw.brewery.web.controller;

import com.stw.brewery.services.CustomerService;
import com.stw.brewery.web.model.CustomerDto;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *          ScienceTechWorks
 * @author Ramon.Talavera@gmail.com 
 */
@Slf4j 
@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
    
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    // GET: READ Customer
    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){
       return  new ResponseEntity<>(customerService.getCustomerById(customerId),HttpStatus.OK);
    }

    // POST: CREATE RESOURCE
    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto) {
        CustomerDto savedDto = customerService.saveNewCustomer(customerDto);
        
        HttpHeaders headers= new HttpHeaders();
        
        URL url=null;
        try {
            url = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path(/*"/api/v1/customer/"+*/"/"+savedDto.getId().toString())
                    .encode()
                    .build()
                    .toUri()
                    .toURL();
        } catch (MalformedURLException ex) {
            System.err.println("MalformedURL");
        }
        
       //String generatedLocation="http://"+hostname+
       //         "/api/v1/customer/"+savedDto.getId().toString();
       String generatedLocation=url.toString();
       headers.add("Location", generatedLocation);
        
        return new ResponseEntity(headers,HttpStatus.CREATED); //401
    }
    
    //PUT: UPDATE RESOURCE
    @PutMapping({"/{customerId}"})
    public ResponseEntity handleUpdate(
            @PathVariable("customerId") UUID customerId, 
            @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId,customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT); //204
    }
    
    //DELETE: DELETE RESOURCE
    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId){
     customerService.deleteById(customerId);
     log.debug("Deleted!");
    }
}
