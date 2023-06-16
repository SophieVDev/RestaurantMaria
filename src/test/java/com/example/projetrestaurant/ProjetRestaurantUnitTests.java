package com.example.projetrestaurant;

import com.example.projetrestaurant.business.DemandeReservation;
import com.example.projetrestaurant.business.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ProjetRestaurantUnitTests {
    static Restaurant restaurant;

    @BeforeEach
    void setUp(){
        restaurant = Restaurant.creationdeNotreRestaurant();
    }

    /*@Test
    void testCreationRestaurantMaria() {
       System.out.println(restaurant);
       assertEquals(4,restaurant.getTables().size());
    }*/

    @Test
    void testHoraireMin(){
        DemandeReservation demande = new DemandeReservation(4, LocalDateTime.of(2023, 6, 21, 10, 0),
                                                                                        "Michel",
                                                                                        "henric");
        assertEquals("Le restaurant est ouvert à partir de 12h00", restaurant.validerDemandeReservation(demande));
    }

    @Test
    void testHoraireMax(){
        DemandeReservation demande = new DemandeReservation(4, LocalDateTime.of(2023, 6, 21, 14, 0),
                "Michel",
                "henric");
        assertEquals("Vous pouvez réserver uniquement de 12h à 13h", restaurant.validerDemandeReservation(demande));
    }

    @Test
    void testHoraireMidi(){
        DemandeReservation demande = new DemandeReservation(4, LocalDateTime.of(2023, 6, 21, 12, 0),
                "Michel",
                "henric");
        assertEquals("OK: réservation enregistrée", restaurant.validerDemandeReservation(demande));
    }
    @Test
    void testHoraireTreizeHeure(){
        DemandeReservation demande = new DemandeReservation(4, LocalDateTime.of(2023, 6, 21, 13, 5),
                "Michel",
                "henric");
        assertEquals("OK: réservation enregistrée", restaurant.validerDemandeReservation(demande));
    }

}
