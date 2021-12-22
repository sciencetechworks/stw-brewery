
package com.stw.brewery.web.mappers;

import com.stw.brewery.domain.Beer;
import com.stw.brewery.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 *          ScienceTechWorks
 * @author Ramon.Talavera@gmail.com 
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
