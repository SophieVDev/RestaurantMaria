package com.example.projetrestaurant.jpa;

import com.example.projetrestaurant.business.Table;
import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@jakarta.persistence.Table(name="reservations")
// IL y a deja une classe qui s'appelle table c'ets pourca quon laisse le jakarta.performance
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int nombreCouverts;
    private LocalDateTime horaire;
    private String prenom;
    private String nom;

    @ManyToOne
    private TableEntity table;

    @ManyToOne
    private RestaurantEntity restaurantEntity;

    public ReservationEntity() {
    }

    public ReservationEntity(int nombreCouverts, LocalDateTime horaire, String prenom, String nom) {
        this.nombreCouverts = nombreCouverts;
        this.horaire = horaire;
        this.prenom = prenom;
        this.nom = nom;
    }

    public int getNombreCouverts() {
        return nombreCouverts;
    }

    public void setNombreCouverts(int nombreCouverts) {
        this.nombreCouverts = nombreCouverts;
    }

    public LocalDateTime getHoraire() {
        return horaire;
    }

    public void setHoraire(LocalDateTime horaire) {
        this.horaire = horaire;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TableEntity getTable() {
        return table;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*
    public RestaurantEntity getRestaurantEntity() {

        return restaurantEntity;
    }

    public void setRestaurantEntity(RestaurantEntity restaurant) {
        this.restaurant = restaurant;
    }
*/
    public void setTable(TableEntity table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "ReservationEntity{" +
                "nombreCouverts=" + nombreCouverts +
                ", horaire=" + horaire +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
               // ", table=" + table +
                '}';
    }
}
