
package com.stw.brewery.web.controller;

import com.stw.brewery.services.BeerService;
import com.stw.brewery.web.model.BeerDto;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import javax.validation.Valid;
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
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
    
    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }
    
    // GET: READ RESOURCE
    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
       return  new ResponseEntity<>(beerService.getBeerById(beerId),HttpStatus.OK);
    }

    // POST: CREATE RESOURCE
    @PostMapping
    public ResponseEntity handlePost(@Valid @RequestBody BeerDto beerDto) {
        BeerDto savedDto = beerService.saveNewBeer(beerDto);
        
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
            @PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto){
        beerService.updateBeer(beerId,beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT); //204
    }
    
    //DELETE: DELETE RESOURCE
    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
     beerService.deleteById(beerId);
     log.debug("Deleted!");
    }
}
