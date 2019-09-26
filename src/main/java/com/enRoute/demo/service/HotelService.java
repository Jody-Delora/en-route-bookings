package com.enRoute.demo.service;

import com.enRoute.demo.model.Hotel;
import com.enRoute.demo.repository.HotelRepository;
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
public class HotelService{
    @Autowired
    private HotelRepository hotelRepository;
	
    public List<Hotel> getAllHotels(String hotelCity,String hotelProvince,String locationType,String propertyType,String hotelName,String hotelChain,String starRating) {
            List<Hotel> hotels = new ArrayList<>();
                  List<String>list = null;
                    hotelRepository.findByHotelSuburbLikeOrHotelProvinceOrLocationTypeOrPropertyTypeOrHotelNameLikeOrHotelChainOrStarRating(hotelCity,hotelProvince,locationType,propertyType,hotelName,hotelChain,starRating)
                    .forEach(hotels::add);
            return hotels;
	}
        public List<Hotel> getAllHotels() {
  
        return (List<Hotel>) hotelRepository.findAll();
	}
 
	public Hotel getHotel(Long id) {
               return hotelRepository.findById(id).orElse(null);
	}
 
	public void addHotel(@RequestBody Hotel hotel) {
                hotelRepository.save(hotel);

	}
       
	public void updateHotel(@RequestBody Hotel hotel) {
                hotelRepository.save(hotel);
	}
 
	public void deleteHotel(Long id) {
                hotelRepository.deleteById(id);
	}

}
