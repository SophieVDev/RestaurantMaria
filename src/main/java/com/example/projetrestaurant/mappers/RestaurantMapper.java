package com.example.projetrestaurant.mappers;

import com.example.projetrestaurant.business.Restaurant;
import com.example.projetrestaurant.business.Table;
import com.example.projetrestaurant.jpa.RestaurantEntity;
import com.example.projetrestaurant.jpa.TableEntity;

public class RestaurantMapper {
    public static RestaurantEntity fromBusinessToEntity(Restaurant restaurant) {
        RestaurantEntity entity = new RestaurantEntity();
        entity.setAdresse(restaurant.getAdresse());
        entity.setNom(restaurant.getNom());
        entity.setEmail(restaurant.getEmail());
        entity.setTelephone(restaurant.getTelephone());

        for (Table table : restaurant.getTables()){
            TableEntity tableEntity = TableMapper.fromBusinessToEntity(table);
            entity.addTable(tableEntity);
        }
        return entity;
    }
    public static Restaurant fromEntityToBusiness(RestaurantEntity entity){
        Restaurant resto = new Restaurant();
        resto.setNom(entity.getNom());
        //à completer
        for(TableEntity tableEntity : entity.getTables()){
            Table table = TableMapper.fromEntityToBusiness(tableEntity);
            resto.addTable(table);
        }

       return resto;
    }
}
