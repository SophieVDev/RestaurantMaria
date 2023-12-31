package com.example.projetrestaurant.api;

import com.example.projetrestaurant.business.DemandeReservation;
import com.example.projetrestaurant.business.Reservation;
import com.example.projetrestaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping("reservations")
    public List<Reservation> getReservations(){
return restaurantService.getReservations();
    }

    @PostMapping("reservations")
    public void postReservation(@RequestBody DemandeReservation demande) {
       System.out.println(demande);
    }
}
