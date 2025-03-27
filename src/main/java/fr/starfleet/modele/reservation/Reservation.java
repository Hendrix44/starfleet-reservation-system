package main.java.fr.starfleet.modele.reservation;
import java.util.Date;
import main.java.fr.starfleet.modele.personne.Personne ;
import main.java.fr.starfleet.modele.mission.Mission ;

public class Reservation {
    private String idReservation;
    private Personne passager ;
    private Mission mission ;
    private Date dateReservation ;
    private boolean confirmee;// ajout de boolean Confirmer pour methode confirmer
    private boolean annulee;// ajout de boolean annuler pour methode annuler

    public Reservation(String idReservation, Personne passager, Mission mission, Date dateReservation) {
        this.idReservation = idReservation;
        this.passager = passager;
        this.mission = mission;
        this.dateReservation = dateReservation;
    }
    public String getIdReservation() {
        return idReservation;
    }
    public Personne getPassager() {
        return passager;
    }
    public Mission getMission() {
        return mission;
    }
    public Date getDateReservation() {
        return dateReservation;
    }
    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }
    public void setPassager(Personne passager) {
        this.passager = passager;
    }
    public void setMission(Mission mission) {
        this.mission = mission;
    }
    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
    }

    public void confirmer (){
        if (this.confirmee) {
            System.out.println("La réservation est déjà confirmée ");
            return; // Quitte la méthode si elle est déjà confirmée
        }
        this.confirmee = true; // Confirme la réservation
        System.out.println("Réservation confirmée avec succès ");


    }
    public void annuler (){
        if (this.annulee) {
            System.out.println("La réservation est déjà annulée ");
            return; // La réservation a déjà été annulée
        }
        if (this.confirmee) {
            System.out.println("La réservation ne peut pas être annulée car elle a déjà été confirmée ");
            return; // Une réservation confirmée ne peut pas être annulée
        }
        this.annulee = true; // Marque la réservation comme annulée
        System.out.println("Réservation annulée avec succès ");


    }


}
