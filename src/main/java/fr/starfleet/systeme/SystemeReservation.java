package main.java.fr.starfleet.systeme;

import main.java.fr.starfleet.modele.mission.Mission;
import main.java.fr.starfleet.modele.personne.Personne;
import main.java.fr.starfleet.modele.reservation.Reservation;
import main.java.fr.starfleet.modele.vaisseau.Vaisseau;
import java.util.List;

public class SystemeReservation {
    private List<Vaisseau> vaisseaux;
    private List<Personne> personnes;
    private List<Mission> missions;
    private List<Reservation> reservations;

    public SystemeReservation() {

    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public List<Mission> getMissions() {
        return missions;
    }
    public List<Reservation>getReservations(){
        return reservations;
    }
    public List<Vaisseau> getVaisseaux() {
        return vaisseaux;
    }

    public void setVaisseaux(List<Vaisseau> vaisseaux) {
        this.vaisseaux = vaisseaux;
    }
    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }
    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void ajouterVaisseau(Vaisseau vaisseau){
        vaisseaux.add(vaisseau);
    }
    public void ajouterPersonne(Personne personne){
        personnes.add(personne);
    }
    public void creeMission(Mission mission){
        missions.add(mission);
    }
   // public Reservation effectuerReservation(Reservation reservation){

   // }


}
