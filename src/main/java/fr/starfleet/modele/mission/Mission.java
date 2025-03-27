package main.java.fr.starfleet.modele.mission;
import main.java.fr.starfleet.modele.vaisseau.Vaisseau;
import main.java.fr.starfleet.modele.reservation.Reservation;
import java.util.Date;
import java.util.List;

public class Mission {
    private String code ;
    private String description ;
    private Date dateDepart ;
    private Date dateRetour;
    private String destination ;
    private Vaisseau vaisseau;
    private List<Reservation> reservations;
    private int capaciteMaximale;

    public Mission(String code, String description, Date dateDepart, Date dateRetour, String destination, Vaisseau vaisseau, int capaciteMaximale) {
        this.code = code;
        this.description = description;
        this.dateDepart = dateDepart;
        this.dateRetour = dateRetour;
        this.destination = destination;
        this.vaisseau = vaisseau;
        this.capaciteMaximale = capaciteMaximale;
    }

    public String getCode() {
        return code;
    }
    public String getDescription(){
        return description ;
    }

    public String getDestination(){
        return destination ;
    }

    public Date getDateDepart() {
        return dateDepart;
    }
    public Date getDateRetour() {
        return dateRetour;
    }
    public Vaisseau getVaisseau() {
        return vaisseau;
    }
    public int getCapaciteMaximale() {
        return capaciteMaximale;
    }


    public void setCode(String code) {
        this.code = code;
    }
    public void setDescription(){
        this.description = description ;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setVaisseau(Vaisseau vaisseau) {
        this.vaisseau = vaisseau;
    }

    public void setCapaciteMaximale(int capaciteMaximale) {
        this.capaciteMaximale = capaciteMaximale;
    }


    //add reservation
    public boolean ajouterReservation(Reservation reservation){
        if (reservations.size()<capaciteMaximale){
            reservations.add(reservation);
            return true;

        }else {
            return false;
        }

    }

    public boolean annulerReservation(String idReservation){
        for (Reservation reservation : reservations ){
            if (reservation.getIdReservation().equals(idReservation)){
                reservations.remove(idReservation);
                return true;
            }
        }
        return false;
    }

    public int getNombrePlacesDisponibles(){
        return reservations.size();

    }



}
