package com.enRoute.demo.repository;

import com.enRoute.demo.model.Aircraft;
import java.sql.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author JODY
 */
public interface AircraftRepository extends CrudRepository<Aircraft, Long> {
    List<Aircraft> findByFlightScheduleDepartureLocationAndFlightScheduleArrivalLocationAndFlightScheduleDepartureDateAndFlightScheduleAirlineClassClassName(String departureLocation,String arrivalLocation,Date departureDate,String className);
 
}