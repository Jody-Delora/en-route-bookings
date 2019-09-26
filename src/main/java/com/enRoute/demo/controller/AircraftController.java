package com.enRoute.demo.controller;

import com.enRoute.demo.model.Aircraft;
import com.enRoute.demo.service.AircraftService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
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
public class AircraftController {
  
    @Autowired
    private AircraftService aircraftService;
    
  @RequestMapping("/flight/{departureLocation}/{arrivalLocation}/{departureDate}/class/{className}/aircrafts")
    public List<Aircraft> getAllAircrafts(@PathVariable String departureLocation,@PathVariable String arrivalLocation,@PathVariable Date departureDate,@PathVariable String className){
        return aircraftService.getAllAircrafts(departureLocation,arrivalLocation,departureDate,className);
    }
    @RequestMapping("/aircrafts")
    public List<Aircraft> getSearch(){
        return aircraftService.getAllAircrafts();
    }
    @RequestMapping("/aircraft/{id}")
    public Aircraft getAircraft(@PathVariable Long id){
        return aircraftService.getAircraft(id);
    }
    
    @RequestMapping(method=RequestMethod.POST,value="/uploadCarrierLogo")
    public void uploadCarrierLogo(@RequestParam("carrierLogo") MultipartFile carrierLogo){

       Path carrierLogoPath=Paths.get("C:\\Users\\JODY\\Downloads\\Samples\\src\\main\\resources\\static\\kulula\\src\\assets\\images\\flight_images\\",carrierLogo.getOriginalFilename());  
       try{
            Files.copy(carrierLogo.getInputStream(), carrierLogoPath);
        }catch(IOException e){
            e.printStackTrace();
        }
       
    }
    
    @RequestMapping(method=RequestMethod.POST,value="/uploadFlightImages")
    public void uploadflightImages(@RequestParam("flightImage") MultipartFile flightImage){
       
        Path flightImagePath=Paths.get("C:\\Users\\JODY\\Downloads\\Samples\\src\\main\\resources\\static\\kulula\\src\\assets\\images\\flight_images\\",flightImage.getOriginalFilename());
        try{
            Files.copy(flightImage.getInputStream(), flightImagePath);
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    
   
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.POST,value="/aircraft")
    public void addAircraft(@RequestBody Aircraft aircraft){
        
        aircraft.setCarrierLogo("..\\..\\..\\assets\\images\\flight_images\\"+aircraft.getCarrierLogo());
        int extraSize=aircraft.getFlightSchedule().get(aircraft.getFlightSchedule().size()-1).getFlightExtra().size();
           
        for(int i=0;i<extraSize;i++){
            aircraft.getFlightSchedule().get(aircraft.getFlightSchedule().size()-1)
                .getFlightExtra().get(i).setExtraImage(
                        "..\\..\\..\\assets\\images\\flight_images\\"+aircraft.getFlightSchedule().get(aircraft.getFlightSchedule().size()-1)
                .getFlightExtra().get(i).getExtraImage());
        }  

        aircraftService.addAircraft(aircraft);
    }
    
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.PUT,value="/secured/updateAircraft")
    public void updateAircraft(@RequestBody Aircraft aircraft){
        aircraftService.updateAircraft(aircraft);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.DELETE,value="/secured/aircraft/{id}")
    public void deleteAircraft(@PathVariable Long id){
        aircraftService.deleteAircraft(id);
    }
   
}

