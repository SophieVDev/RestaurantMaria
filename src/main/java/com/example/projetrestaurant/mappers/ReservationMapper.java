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

    public static Reservation fromENtityToBusiness(ReservationEntity entity){
        Reservation resa = new Reservation();
        resa.setNom(entity.getNom());
        resa.setPrenom(entity.getPrenom());
        resa.setNombreCouverts(entity.getNombreCouverts());
        resa.setHoraire(entity.getHoraire());
        //resa.setTable(entity.getTable());

        return resa;
    }
}

