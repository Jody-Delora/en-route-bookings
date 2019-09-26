package com.enRoute.demo.service;

import com.enRoute.demo.model.Car;
import com.enRoute.demo.repository.CarRepository;
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
public class CarService{
    @Autowired
    private CarRepository carRepository;
    
        public List<Car> getAllCars(String pickUpLocation) {
            List<Car> cars = new ArrayList<>();
            List<String>list = null;
            carRepository.findByCarSupplierBranchBranchSuburb(pickUpLocation)
            .forEach(cars::add);
            return cars;
	}
        public List<Car> getAllCars() {
  
        return (List<Car>) carRepository.findAll();
	}
 
	public Car getCar(Long id) {
               return carRepository.findById(id).orElse(null);
	}
 
	public void addCar(@RequestBody Car car) {
                carRepository.save(car);

	}
       
	public void updateCar(@RequestBody Car car) {
                carRepository.save(car);
	}
 
	public void deleteCar(Long id) {
                carRepository.deleteById(id);
	}

}

