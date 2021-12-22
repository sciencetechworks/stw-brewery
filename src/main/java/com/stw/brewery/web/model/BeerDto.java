
package com.stw.brewery.web.model;

import java.time.OffsetDateTime;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *          ScienceTechWorks
 * @author Ramon.Talavera@gmail.com 
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
 @Null //Do not allow user to handle the id
 private UUID id;
 
 @NotBlank
 private String beerName;
 
 @NotBlank
 private String beerStyle;
 
 @Positive
 private Long upc;
 
 private OffsetDateTime createdDate;
 
 private OffsetDateTime lastUpdatedDate;
}
