package com.example.projetrestaurant.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@jakarta.persistence.Table(name="tables")
public class TableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int numeroTable;
    private int nombreCouverts;

    public TableEntity() {
    }

    public TableEntity(int numeroTable, int nombreCouverts) {
        this.numeroTable = numeroTable;
        this.nombreCouverts = nombreCouverts;
    }

    public int getNumeroTable() {
        return numeroTable;
    }

    public void setNumeroTable(int numeroTable) {
        this.numeroTable = numeroTable;
    }

    public int getNombreCouverts() {
        return nombreCouverts;
    }

    public void setNombreCouverts(int nombreCouverts) {
        this.nombreCouverts = nombreCouverts;
    }

    @Override
    public String toString() {
        return "TableEntity{" +
                "numeroTable=" + numeroTable +
                ", nombreCouverts=" + nombreCouverts +
                '}';
    }
}
