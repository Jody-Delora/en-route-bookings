package com.enRoute.demo.service;

import com.enRoute.demo.model.Aircraft;
import com.enRoute.demo.repository.AircraftRepository;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author JODY
 */
@Service
public class AircraftService{
    @Autowired
    private AircraftRepository aircraftRepository;
    
	public List<Aircraft> getAllAircrafts(String departureLocation,String arrivalLocation,Date departureDate,String className) {
            List<Aircraft> aircrafts = new ArrayList<>();
                    aircraftRepository.findByFlightScheduleDepartureLocationAndFlightScheduleArrivalLocationAndFlightScheduleDepartureDateAndFlightScheduleAirlineClassClassName(departureLocation,arrivalLocation,departureDate,className)
                    .forEach(aircrafts::add);
            return aircrafts;
	}
        public List<Aircraft> getAllAircrafts() {
            return (List<Aircraft>) aircraftRepository.findAll();
	}
 
	public Aircraft getAircraft(Long id) {
               return aircraftRepository.findById(id).orElse(null);
	}
 
	public void addAircraft(@RequestBody Aircraft aircraft) {
                aircraftRepository.save(aircraft);

	}
       
	public void updateAircraft(@RequestBody Aircraft aircraft) {
                aircraftRepository.save(aircraft);
	}
        
	public void deleteAircraft(Long id) {
                aircraftRepository.deleteById(id);
	}
}
 


