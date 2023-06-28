package com.example.projetrestaurant.service;

import com.example.projetrestaurant.business.DemandeReservation;
import com.example.projetrestaurant.business.Reservation;
import com.example.projetrestaurant.business.Restaurant;
import com.example.projetrestaurant.jpa.ReservationEntity;
import com.example.projetrestaurant.jpa.ReservationRepository;
import com.example.projetrestaurant.jpa.RestaurantEntity;
import com.example.projetrestaurant.jpa.RestaurantRepository;
import com.example.projetrestaurant.mappers.ReservationMapper;
import com.example.projetrestaurant.mappers.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Reservation> getReservations() {
        List<Reservation> reservations = new ArrayList<>();
        List<ReservationEntity> entities = reservationRepository.findAll();
        for (ReservationEntity entity : entities) {
            reservations.add(ReservationMapper.fromENtityToBusiness(entity));

        }
        return reservations;
    }

    public void ajouterReservation(DemandeReservation demande){
        Optional<RestaurantEntity> optional = restaurantRepository.findById(1);
        if(optional.isPresent()){
            RestaurantEntity entity = optional.get();
            Restaurant resto = RestaurantMapper.fromEntityToBusiness(entity);
            String reponse = resto.validerDemandeReservation(demande);
            //TODO:en fonction de la réponse, enregistrer ou non la réservation en BDD
        }
    }
}
