package main.java.fr.starfleet.modele.mission;

import main.java.fr.starfleet.modele.vaisseau.Vaisseau;
import main.java.fr.starfleet.modele.reservation.Reservation;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * La classe Mission représente une mission spatiale avec des informations telles que le code de la mission,
 * la description, les dates de départ et de retour, la destination, le vaisseau utilisé pour la mission,
 * la capacité maximale de la mission et les réservations associées à cette mission.
 */

public class Mission implements Serializable {
    private String code;
    private String description;
    private Date dateDepart;
    private Date dateRetour;
    private String destination;
    private Vaisseau vaisseau;
    private List<Reservation> reservations;
    private int capaciteMaximale;



    /**
     * Constructeur pour initialiser une mission.
     *
     * @param code Le code de la mission.
     * @param description La description de la mission.
     * @param dateDepart La date de départ de la mission.
     * @param dateRetour La date de retour de la mission.
     * @param destination La destination de la mission.
     * @param vaisseau Le vaisseau qui sera utilisé pour la mission.
     * @param capaciteMaximale La capacité maximale de la mission (nombre de réservations possibles).
     */

    public Mission(String code, String description, Date dateDepart, Date dateRetour, String destination, Vaisseau vaisseau, int capaciteMaximale) {
        this.code = code;
        this.description = description;
        this.dateDepart = dateDepart;
        this.dateRetour = dateRetour;
        this.destination = destination;
        this.vaisseau = vaisseau;
        this.capaciteMaximale = capaciteMaximale;
        this.reservations = new ArrayList<>();
    }



    /**
     * Obtient le code de la mission.
     *
     * @return Le code de la mission.
     */
    public String getCode() {
        return code;
    }

    /**
     * Obtient la description de la mission.
     *
     * @return La description de la mission.
     */
    public String getDescription(){
        return description;
    }

    /**
     * Obtient la destination de la mission.
     *
     * @return La destination de la mission.
     */
    public String getDestination(){
        return destination;
    }

    /**
     * Obtient la date de départ de la mission.
     *
     * @return La date de départ de la mission.
     */
    public Date getDateDepart() {
        return dateDepart;
    }

    /**
     * Obtient la date de retour de la mission.
     *
     * @return La date de retour de la mission.
     */
    public Date getDateRetour() {
        return dateRetour;
    }

    /**
     * Obtient le vaisseau utilisé pour la mission.
     *
     * @return Le vaisseau utilisé pour la mission.
     */
    public Vaisseau getVaisseau() {
        return vaisseau;
    }

    /**
     * Obtient la capacité maximale de la mission.
     *
     * @return La capacité maximale de la mission.
     */
    public int getCapaciteMaximale() {
        return capaciteMaximale;
    }



    /**
     * Définit le code de la mission.
     *
     * @param code Le nouveau code de la mission.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Définit la description de la mission.
     *
     * @param description La nouvelle description de la mission.
     */
    public void setDescription(String description) { // Correction ici
        this.description = description;
    }

    /**
     * Définit la date de départ de la mission.
     *
     * @param dateDepart La nouvelle date de départ de la mission.
     */
    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    /**
     * Définit la date de retour de la mission.
     *
     * @param dateRetour La nouvelle date de retour de la mission.
     */
    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }


    /**
     * Définit la destination de la mission.
     *
     * @param destination La nouvelle destination de la mission.
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }


    /**
     * Définit le vaisseau utilisé pour la mission.
     *
     * @param vaisseau Le nouveau vaisseau utilisé pour la mission.
     */
    public void setVaisseau(Vaisseau vaisseau) {
        this.vaisseau = vaisseau;
    }

    /**
     * Définit la capacité maximale de la mission.
     *
     * @param capaciteMaximale La nouvelle capacité maximale de la mission.
     */
    public void setCapaciteMaximale(int capaciteMaximale) {
        this.capaciteMaximale = capaciteMaximale;
    }

    /**
     * Ajoute une réservation à la mission, si la capacité maximale n'est pas atteinte.
     *
     * @param reservation La réservation à ajouter.
     * @return true si la réservation a été ajoutée avec succès, false sinon.
     */
    public boolean ajouterReservation(Reservation reservation) {
        if (reservations.size() < capaciteMaximale) {
            reservations.add(reservation);
            return true;
        }
        return false;
    }

    /**
     * Annule une réservation existante en fonction de l'ID de la réservation.
     *
     * @param idReservation L'ID de la réservation à annuler.
     * @return true si la réservation a été annulée avec succès, false sinon.
     */
    public boolean annulerReservation(String idReservation) {
        for (Reservation reservation : reservations) {
            if (reservation.getIdReservation().equals(idReservation)) {
                reservations.remove(reservation); // Correction ici
                return true;
            }
        }
        return false;
    }

    /**
     * Obtient le nombre de places disponibles pour la mission.
     *
     * @return Le nombre de places disponibles.
     */
    public int getNombrePlacesDisponibles() {
        return capaciteMaximale - reservations.size(); // Correction ici
    }

    /**
     * Obtient la liste des réservations associées à la mission.
     *
     * @return La liste des réservations.
     */
    public List<Reservation> getReservations() {
        return this.reservations;
    }


}
