package main.java.fr.starfleet.modele.reservation;
import java.util.Date;
import main.java.fr.starfleet.modele.personne.Personne ;
import main.java.fr.starfleet.modele.mission.Mission ;
import java.io.Serializable;

/**
 * La classe Reservation représente une réservation effectuée par un passager pour une mission spécifique.
 * Elle inclut des informations comme l'identifiant de la réservation, le passager, la mission, la date de réservation,
 * ainsi que l'état de confirmation et d'annulation de la réservation.
 */

public class Reservation implements Serializable{
    private String idReservation;
    private Personne passager ;
    private Mission mission ;
    private Date dateReservation ;
    private boolean confirmee;// ajout de boolean Confirmer pour methode confirmer
    private boolean annulee;// ajout de boolean annuler pour methode annuler


    /**
     * Constructeur pour initialiser une réservation.
     *
     * @param idReservation L'identifiant de la réservation.
     * @param passager Le passager effectuant la réservation.
     * @param mission La mission pour laquelle la réservation est effectuée.
     * @param dateReservation La date de la réservation.
     * @param confirme Indique si la réservation est confirmée ou non.
     */
    public Reservation(String idReservation, Personne passager, Mission mission, Date dateReservation ,  boolean confirme) {
        this.idReservation = idReservation;
        this.passager = passager;
        this.mission = mission;
        this.dateReservation = dateReservation;
        this.confirmee = confirmee;
    }


    /**
     * Obtient l'identifiant de la réservation.
     *
     * @return L'identifiant de la réservation.
     */
    public String getIdReservation() {
        return idReservation;
    }

    /**
     * Obtient le passager associé à cette réservation.
     *
     * @return Le passager de la réservation.
     */
    public Personne getPassager() {
        return passager;
    }

    /**
     * Obtient la mission associée à cette réservation.
     *
     * @return La mission de la réservation.
     */
    public Mission getMission() {
        return mission;
    }

    /**
     * Obtient la date de réservation.
     *
     * @return La date de la réservation.
     */
    public Date getDateReservation() {
        return dateReservation;
    }

    /**
     * Définit la date de réservation.
     *
     * @param dateReservation La nouvelle date de réservation.
     */
    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    /**
     * Définit le passager pour cette réservation.
     *
     * @param passager Le passager à associer à cette réservation.
     */
    public void setPassager(Personne passager) {
        this.passager = passager;
    }

    /**
     * Définit la mission associée à cette réservation.
     *
     * @param mission La mission à associer à la réservation.
     */
    public void setMission(Mission mission) {
        this.mission = mission;
    }


    /**
     * Définit l'identifiant de la réservation.
     *
     * @param idReservation L'identifiant de la réservation à définir.
     */
    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
    }


    /**
     * Confirme cette réservation si elle n'est pas déjà confirmée.
     * Si la réservation est déjà confirmée, un message sera affiché.
     */
    public void confirmer() {
        if (this.confirmee) {
            System.out.println("La réservation est déjà confirmée.");
            return;
        }
        this.confirmee = true;
        System.out.println("Réservation confirmée avec succès.");
    }

    /**
     * Annule cette réservation si elle n'est pas déjà annulée et si elle n'est pas confirmée.
     * Si la réservation a déjà été annulée ou confirmée, un message sera affiché.
     */
    public void annuler() {
        if (this.annulee) {
            System.out.println("La réservation est déjà annulée.");
            return;
        }
        if (this.confirmee) {
            System.out.println("La réservation ne peut pas être annulée car elle a déjà été confirmée.");
            return;
        }
        this.annulee = true;
        System.out.println("Réservation annulée avec succès.");
    }
}