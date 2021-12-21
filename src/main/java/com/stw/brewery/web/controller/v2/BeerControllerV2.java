
package com.stw.brewery.web.controller.v2;

import com.stw.brewery.services.v2.BeerServiceV2;
import com.stw.brewery.web.model.v2.BeerDtoV2;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
@Validated
@Slf4j
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
    
    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }
    
    // GET: READ RESOURCE
    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@NotNull @PathVariable("beerId") UUID beerId){
       return  new ResponseEntity<>(beerServiceV2.getBeerById(beerId),HttpStatus.OK);
    }

    // POST: CREATE RESOURCE
    @PostMapping
    public ResponseEntity handlePost(@Valid @NotNull @RequestBody BeerDtoV2 beerDtoV2) {
        BeerDtoV2 savedDto = beerServiceV2.saveNewBeer(beerDtoV2);
        
        HttpHeaders headers= new HttpHeaders();
        
        URL url=null;
        try {
            url = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path(/*"/api/v1/beer/"+*/"/"+savedDto.getId().toString())
                    .encode()
                    .build()
                    .toUri()
                    .toURL();
        } catch (MalformedURLException ex) {
            System.err.println("MalformedURL");
        }
        
       //String generatedLocation="http://"+hostname+
       //         "/api/v1/beer/"+savedDto.getId().toString();
       String generatedLocation=url.toString();
       headers.add("Location", generatedLocation);
        
        return new ResponseEntity(headers,HttpStatus.CREATED); //401
    }
    
    //PUT: UPDATE RESOURCE
    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(
            @PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDtoV2){
        beerServiceV2.updateBeer(beerId,beerDtoV2);
        return new ResponseEntity(HttpStatus.NO_CONTENT); //204
    }
    
    //DELETE: DELETE RESOURCE
    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
     beerServiceV2.deleteById(beerId);
     log.debug("Deleted!");
    }
    
   @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e){
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
