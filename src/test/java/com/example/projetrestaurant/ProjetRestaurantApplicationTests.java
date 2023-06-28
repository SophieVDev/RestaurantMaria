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
import java.util.Optional;

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
        //TableEntity entityTable = new TableEntity(1,4);
        //tableRepository.save(entityTable);
        TableEntity entityTable = null;
        Optional<TableEntity> optionalTable = tableRepository.findById(1);
        if(optionalTable.isPresent()){
            entityTable = optionalTable.get();
        }


        Reservation reservation = new Reservation(4,
                LocalDateTime.of(2023, 6, 30, 10, 0),
                "Michel",
                "Duroc");

        ReservationEntity entityReservation = ReservationMapper.fromBusinessToEntity(reservation);
        entityReservation.setTable(entityTable);
        System.out.println(entityReservation);
        //reservationRepository.save(entityReservation);
    }


}


