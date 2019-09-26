package com.enRoute.demo.repository;

import com.enRoute.demo.model.Car;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author JODY
 */
public interface CarRepository extends CrudRepository<Car, Long>{ 
List<Car> findByCarSupplierBranchBranchSuburb(String pickUpLocation);
}
