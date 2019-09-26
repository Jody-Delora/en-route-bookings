package com.enRoute.demo.controller;

import com.enRoute.demo.model.Hotel;
import com.enRoute.demo.service.HotelService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
public class HotelController {
   
    @Autowired
    private HotelService hotelService;
    
    @RequestMapping("/hotels/{hotelCity}/{hotelProvince}/{locationType}/{propertyType}/{hotelName}/{hotelChain}/{starRating}")
    public List<Hotel> getAllHotels(@PathVariable String hotelCity,@PathVariable String hotelProvince,@PathVariable String hotelName,@PathVariable String locationType,@PathVariable String propertyType,@PathVariable String hotelChain,@PathVariable String starRating){
        return hotelService.getAllHotels(hotelCity,hotelProvince,hotelName,locationType,propertyType,hotelChain,starRating);
    }
  
    @RequestMapping("/hotels")
    public List<Hotel> getAllHotels(){
        return hotelService.getAllHotels();
    }
    @RequestMapping("/hotel/{id}")
    public Hotel getHotel(@PathVariable Long id){
        return hotelService.getHotel(id);
    }
    @RequestMapping(method=RequestMethod.POST,value="/uploadHotelImages")
    public void uploadHotelImages(@RequestParam("hotelImages") MultipartFile hotelImages){
     
       /* for(MultipartFile hotelImage:hotelImages){*/
            Path hotelImagePath=Paths.get("C:\\Users\\JODY\\Downloads\\Samples\\src\\main\\resources\\static\\kulula\\src\\assets\\images\\hotel_images\\",hotelImages.getOriginalFilename());
            try{
                Files.copy(hotelImages.getInputStream(), hotelImagePath);
                }catch(IOException e){
                    e.printStackTrace();
            }
       /* } */
    }
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.POST,value="/hotel")
    public void addHotel(@RequestBody Hotel hotel){
        int hotelImageSize=hotel.getHotelImage().size()-1;
        List<String> hotelImages=new ArrayList<String>();
        for(int i=0;i<hotelImageSize;i++){
            Path hotelImagePath=Paths.get("..\\..\\..\\assets\\images\\hotel_images\\",hotel.getHotelImage().get(i));  
            hotelImages.add(hotelImagePath.toString());
        }
        
        hotel.setHotelImage(hotelImages);
        hotelService.addHotel(hotel);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.PUT,value="/secured/hotel")
    public void updateHotel(@RequestBody Hotel hotel){
        hotelService.updateHotel(hotel);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.DELETE,value="/secured/hotel/{id}")
    public void deleteHotel(@PathVariable Long id){
        hotelService.deleteHotel(id);
    }
   
}
