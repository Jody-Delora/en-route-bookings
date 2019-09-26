package com.enRoute.demo.controller;

import com.enRoute.demo.model.SeatSelection;
import com.enRoute.demo.service.SeatSelectionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JODY
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
public class SeatSelectionController {
   
    @Autowired
    private SeatSelectionService seatService;
  
    @RequestMapping("/seat")
    public List<SeatSelection> getAllSeats(){
        return seatService.getAllSeats();
    }
   
    @RequestMapping("/seat/{id}")
    public SeatSelection getSeat(@PathVariable Long id){
        return seatService.getSeat(id);
    }
   
   @RequestMapping(method=RequestMethod.POST,value="/seat")
    public void addSeat(@RequestBody SeatSelection seat){ 
        seatService.addSeat(seat);
    }
   
    @RequestMapping(method=RequestMethod.PUT,value="/seat/{id}")
    public void updateSeat(@PathVariable Long id,@RequestBody SeatSelection seat){
        seatService.updateSeat(id,seat);
    }
    @RequestMapping(method=RequestMethod.DELETE,value="/seat/{id}")
    public void deleteSeat(@PathVariable Long id){
        seatService.deleteSeat(id);
    }
   
}

