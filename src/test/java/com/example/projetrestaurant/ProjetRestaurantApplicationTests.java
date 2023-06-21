package com.example.projetrestaurant;

import com.example.projetrestaurant.business.Reservation;
import com.example.projetrestaurant.business.Restaurant;
import com.example.projetrestaurant.jpa.*;
import com.example.projetrestaurant.mappers.ReservationMapper;
import com.example.projetrestaurant.mappers.RestaurantMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class ProjetRestaurantApplicationTests {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    TableRepository tableRepository;

    @Test
    void testCreationRestaurant() {
        Restaurant monRestaurant = Restaurant.creationdeNotreRestaurant();
        RestaurantEntity entity = RestaurantMapper.fromBusinessToEntity(monRestaurant);
        restaurantRepository.save(entity);
    }

    @Test
    void testLireRestaurant() {
        List<RestaurantEntity> restaurants = restaurantRepository.findAll();
        for (RestaurantEntity r : restaurants) {
            System.out.println(r);
        }
    }

    @Test
    void testReservation() {
        TableEntity entityTable = new TableEntity(1,4);
        tableRepository.save(entityTable);

        Reservation reservation = new Reservation(4,
                LocalDateTime.of(2023, 6, 21, 10, 0),
                "Michel",
                "Duroc");

        ReservationEntity entityReservation = ReservationMapper.fromBusinessToEntity(reservation);
        entityReservation.setTable(entityTable);
        reservationRepository.save(entityReservation);
    }


}


