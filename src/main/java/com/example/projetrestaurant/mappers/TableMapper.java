package com.example.projetrestaurant.mappers;
import com.example.projetrestaurant.business.Table;
import com.example.projetrestaurant.jpa.TableEntity;

public class TableMapper {
    public static TableEntity fromBusinessToEntity(Table table) {
        TableEntity entity = new TableEntity();
        entity.setNumeroTable(table.getNumeroTable());
        entity.setNombreCouverts(table.getNombreCouverts());
        return entity;
    }
}
