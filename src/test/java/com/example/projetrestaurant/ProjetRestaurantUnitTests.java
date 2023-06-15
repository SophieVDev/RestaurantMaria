package com.example.projetrestaurant;

import com.example.projetrestaurant.business.Restaurant;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProjetRestaurantUnitTests {

    @Test
    void testCreationRestaurantMaria() {
       Restaurant restaurant =  Restaurant.creationdeNotreRestaurant();
       System.out.println(restaurant);
       assertEquals(4,restaurant.getTables().size());
    }

}
