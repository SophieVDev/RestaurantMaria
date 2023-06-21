package com.example.projetrestaurant.mappers;

import com.example.projetrestaurant.business.Reservation;
import com.example.projetrestaurant.jpa.ReservationEntity;

public class ReservationMapper {

    public static ReservationEntity fromBusinessToEntity(Reservation reservation){
        ReservationEntity entity = new ReservationEntity(
                reservation.getNombreCouverts()
                , reservation.getHoraire()
                ,reservation.getPrenom()
                ,reservation.getNom()
        );

        entity.setTable((TableMapper.fromBusinessToEntity(reservation.getTable())));
       // entity.setRestaurant(RestaurantMapper.fromBusinessToEntity(reservation.get));
return entity;

    }
}

