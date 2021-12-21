
package com.stw.brewery.web.model;

import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
public class CustomerDto {
 private UUID id;
 
 @NotBlank
 @Size(min=3,max=100)
 private String name;
}
