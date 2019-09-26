package com.enRoute.demo.repository;

import com.enRoute.demo.model.Hotel;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author JODY
 */
public interface HotelRepository extends CrudRepository<Hotel, Long> {
List<Hotel>findByHotelSuburbLikeOrHotelProvinceOrLocationTypeOrPropertyTypeOrHotelNameLikeOrHotelChainOrStarRating(String hotelCity,String hotelProvince,String locationType,String propertyType,String hotelName,String hotelChain,String starRating); 
 
}
