
package com.stw.brewery.web.mappers;

import com.stw.brewery.domain.Customer;
import com.stw.brewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

/**
 *          ScienceTechWorks
 * @author Ramon.Talavera@gmail.com 
 */
@Mapper
public interface CustomerMapper {
    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto customerDto);
}
