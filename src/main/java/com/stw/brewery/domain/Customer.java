
package com.stw.brewery.domain;

import java.util.UUID;
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
public class Customer {
 private UUID id;

 private String name;
}