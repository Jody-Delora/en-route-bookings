package com.enRoute.demo.service;

import com.enRoute.demo.model.SeatSelection;
import com.enRoute.demo.repository.SeatSelectionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author JODY
 */
@Service
public class SeatSelectionService {
     @Autowired
    private SeatSelectionRepository seatRepository;
     
    public List<SeatSelection> getAllSeats() {
            return (List<SeatSelection>) seatRepository.findAll();
	}
 
	public SeatSelection getSeat(Long id) {
               return seatRepository.findById(id).orElse(null);
	}
 
	public void addSeat(@RequestBody SeatSelection seat) {
                seatRepository.save(seat);

	}
        public void updateSeat(@PathVariable Long id,@RequestBody SeatSelection seat) {
            seatRepository.save(seat);
	}
        
	public void deleteSeat(Long id) {
                seatRepository.deleteById(id);
	}
}
