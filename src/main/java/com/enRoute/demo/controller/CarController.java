package com.enRoute.demo.controller;

import com.enRoute.demo.model.Car;
import com.enRoute.demo.service.CarService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author JODY
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
public class CarController {
   
    @Autowired
    private CarService carService;
  
    @RequestMapping("/cars/{pickUpLocation}")
    public List<Car> getAllCars(@PathVariable String pickUpLocation){
        return carService.getAllCars(pickUpLocation);
    }
    
    @RequestMapping("/cars")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }
   
    @RequestMapping("/car/{id}")
    public Car getCar(@PathVariable Long id){
        return carService.getCar(id);
    }
   @RequestMapping(method=RequestMethod.POST,value="/uploadCarImage")
    public void uploadCarImage(@RequestParam("carImage") MultipartFile carImage){
           
            Path carImagePath=Paths.get("C:\\Users\\JODY\\Downloads\\Samples\\src\\main\\resources\\static\\kulula\\src\\assets\\images\\car_images\\",carImage.getOriginalFilename());
            try{
                Files.copy(carImage.getInputStream(), carImagePath);
                }catch(IOException e){
                    e.printStackTrace();
            } 
    }
    @RequestMapping(method=RequestMethod.POST,value="/uploadSupplierLogo")
    public void uploadSupplierLogo(@RequestParam("supplierLogo") MultipartFile supplierLogo){   
            Path supplierLogoPath=Paths.get("C:\\Users\\JODY\\Downloads\\Samples\\src\\main\\resources\\static\\kulula\\src\\assets\\images\\car_images\\",supplierLogo.getOriginalFilename());
            try{
                Files.copy(supplierLogo.getInputStream(), supplierLogoPath);
                }catch(IOException e){
                    e.printStackTrace();
            } 
    }
  
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.POST,value="/car")
    public void addCar(@RequestBody Car car){ 
        Path carImagePath=Paths.get("..\\..\\..\\assets\\images\\car_images\\",car.getCarImage());  
        car.setCarImage(carImagePath.toString());
        
        Path supplierLogoPath=Paths.get("..\\..\\..\\assets\\images\\car_images\\",car.getCarSupplier().getCarSupplierLogo());  
        car.getCarSupplier().setCarSupplierLogo(supplierLogoPath.toString());
        
        carService.addCar(car);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.PUT,value="/secured/car")
    public void updateCar(@RequestBody Car car){
        carService.updateCar(car);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.DELETE,value="/secured/car/{id}")
    public void deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
    }
   
}
