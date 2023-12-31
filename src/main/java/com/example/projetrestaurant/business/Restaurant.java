package com.example.projetrestaurant.business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant {

    private String nom;
    private String adresse;
    private String telephone;

    private String email;

    private List<Table> tables = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant(String nom, String adresse, String telephone, String email) {
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public List<Reservation> getReservation() {
        return reservations;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservations = reservation;
    }

    public void addTable(Table table){
        this.tables.add(table);
    }
    @Override
    public String toString() {
        return "Restaurant{" +
                "nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", tables=" + tables +
                ", reservation=" + reservations +
                '}';
    }

    public static Restaurant creationdeNotreRestaurant() {
        Restaurant restaurantMaria = new Restaurant("Chez Maria",
                "1 rue de la Paix",
                "01 45 25 24 25",
                "marie@restaurant.fr");

        restaurantMaria.ajouterTable(1, 6);
        restaurantMaria.ajouterTable(2, 2);
        restaurantMaria.ajouterTable(3, 2);
        restaurantMaria.ajouterTable(4, 4);
        return restaurantMaria;
    }

    private void ajouterTable(int numeroTable, int nombreCouverts) {
        tables.add(new Table(numeroTable, nombreCouverts));

        //faire un tri croissant et ne pas réserver une table de 6 avec seulement 2 personne car c'est la première dans la liste
        tables.sort(Comparator.comparing(Table::getNombreCouverts));
    }

    private void ajouterReservation(Reservation reservation) {
   reservations.add(reservation);
    }

    public String validerDemandeReservation(DemandeReservation demande) {

        if (demande.getHoraire().getHour() < 12) {
            return "Le restaurant est ouvert à partir de 12h00";
        }
        if (demande.getHoraire().getHour() > 13) {
            return "Vous pouvez réserver uniquement de 12h à 13h";
        }
        if (demande.getHoraire().getHour() == 13 && demande.getHoraire().getMinute() > 0) {
            return "Vous pouvez réserver uniquement de 12h à 13h";
        }
        if (demande.getNombreCouverts() > 6) {
            return "Nous n'avons pas de table de plus de 6 personnes";
        }

        for (Table table : tables) {
            if (table.getNombreCouverts() >= demande.getNombreCouverts()) {

                boolean tableDejaReservee = false;
                for (Reservation reservation : reservations) {
                    if (reservation.getHoraire().equals(demande.getHoraire())
                            && (reservation.getTable().getNumeroTable() == table.getNumeroTable()))
                        tableDejaReservee = true;
                }
                if (tableDejaReservee) {
                    continue;
                } else {
                    //OK : on peut réserver cette table
                    //int nombreCouverts, LocalDateTime horaire, String prenom, String nom
                    Reservation reservation = new Reservation(demande.getNombreCouverts(),
                            demande.getHoraire(),
                            demande.getPrenom(),
                            demande.getNom());
                    reservation.setTable(table);
                    ajouterReservation(reservation);
                    return "OK: réservation enregistrée";
                }
            }
        }
        return "Désolé, il n'y a plus de table disponible";
    }

}
