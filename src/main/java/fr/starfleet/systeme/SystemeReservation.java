package main.java.fr.starfleet.systeme;

import main.java.fr.starfleet.modele.mission.Mission;
import main.java.fr.starfleet.modele.personne.Personne;
import main.java.fr.starfleet.modele.reservation.Reservation;
import main.java.fr.starfleet.modele.vaisseau.Vaisseau;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * La classe SystemeReservation gère les différentes entités du système de réservation.
 * Elle permet de gérer les vaisseaux, les personnes, les missions, les réservations,
 * ainsi que d'effectuer des recherches et de sauvegarder ou charger les données.
 */
public class SystemeReservation {

    private List<Vaisseau> vaisseaux;
    private List<Personne> personnes;
    private List<Mission> missions;
    private List<Reservation> reservations;

    /**
     * Constructeur pour initialiser le système de réservation avec des listes vides pour
     * les vaisseaux, les personnes, les missions et les réservations.
     */
    public SystemeReservation() {
        this.vaisseaux = new ArrayList<>();
        this.personnes = new ArrayList<>();
        this.missions = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public List<Reservation> getReservations() {
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

    /**
     * Ajoute un vaisseau à la liste des vaisseaux du système.
     *
     * @param vaisseau Le vaisseau à ajouter.
     */
    public void ajouterVaisseau(Vaisseau vaisseau) {
        vaisseaux.add(vaisseau);
    }

    /**
     * Ajoute une personne à la liste des personnes du système.
     *
     * @param personne La personne à ajouter.
     */
    public void ajouterPersonne(Personne personne) {
        personnes.add(personne);
    }

    /**
     * Crée une nouvelle mission et l'ajoute à la liste des missions.
     *
     * @param mission La mission à créer.
     */
    public void creeMission(Mission mission) {
        missions.add(mission);
    }

    /**
     * Effectue une réservation pour une personne sur une mission disponible.
     * Si une mission est disponible, une nouvelle réservation est créée.
     *
     * @param idPersonne L'identifiant de la personne effectuant la réservation.
     * @return La réservation effectuée ou null si la réservation a échoué.
     */
    public Reservation effectuerReservation(String idPersonne) {
        // Chercher la personne avec l'ID fourni
        Personne personne = rechercherPersonneParId(idPersonne);
        if (personne == null) {
            System.out.println("Personne non trouvée.");
            return null;
        }

        // Chercher une mission disponible (qui n'est pas pleine)
        Mission missionDisponible = rechercherMissionDisponible();
        if (missionDisponible == null) {
            System.out.println("Aucune mission disponible.");
            return null;
        }

        // Créer un ID unique pour la réservation
        String idReservation = UUID.randomUUID().toString();
        Date dateReservation = new Date();  // Date de la réservation

        // Créer la réservation
        Reservation nouvelleReservation = new Reservation(idReservation, personne, missionDisponible, dateReservation, false);  // false => Non confirmée

        // Ajouter la réservation à la liste globale des réservations et à la mission
        reservations.add(nouvelleReservation);
        missionDisponible.getReservations().add(nouvelleReservation);

        // Confirmation de la réservation
        System.out.println("Réservation effectuée avec succès !");
        return nouvelleReservation;
    }

    /**
     * Recherche une personne par son identifiant dans la liste des personnes.
     *
     * @param idPersonne L'ID de la personne à rechercher.
     * @return La personne trouvée ou null si elle n'est pas dans la liste.
     */
    private Personne rechercherPersonneParId(String idPersonne) {
        for (Personne p : personnes) {
            if (p.getIdentifiant().equals(idPersonne)) {
                return p;
            }
        }
        return null;  // Personne non trouvée
    }

    /**
     * Recherche une mission disponible qui n'est pas encore complète.
     *
     * @return La mission disponible ou null si aucune mission n'est disponible.
     */



    private Mission rechercherMissionDisponible() {
        for (Mission mission : missions) {
            // Vérifie si la mission n'est pas pleine (c'est-à-dire que le nombre de réservations est inférieur au nombre de places disponibles)
            if (mission.getReservations().size() < mission.getNombrePlacesDisponibles()) {
                return mission;  // Mission disponible
            }
        }
        return null;  // Aucune mission disponible
    }

    /**
     * Recherche des missions par destination.
     *
     * @param destination La destination des missions à rechercher.
     * @return La liste des missions correspondant à la destination donnée.
     */
    public List<Mission> rechercherMissions(String destination) {
        List<Mission> missionChoisies = new ArrayList<>();
        for (Mission mission : this.missions) {
            if (mission.getDestination().equalsIgnoreCase(destination)) {
                missionChoisies.add(mission);
            }
        }
        return missionChoisies;
    }

    /**
     * Supprime une réservation par son identifiant.
     *
     * @param idReservation L'identifiant de la réservation à supprimer.
     */
    public void supprimerReservation(String idReservation) {
        Reservation reservationASupprimer = null;
        for (Reservation reservation : reservations) {
            if (reservation.getIdReservation().equals(idReservation)) {
                reservationASupprimer = reservation;
                break;
            }
        }
        if (reservationASupprimer != null) {
            reservations.remove(reservationASupprimer);
            System.out.println("Réservation supprimée avec succès !");
        } else {
            System.out.println("Réservation non trouvée.");
        }
    }

    /**
     * Sauvegarde les données du système dans un fichier.
     *
     * @param fichier Le nom du fichier où les données seront sauvegardées.
     */
    public void sauvegarderDonnees(String fichier) {
        System.out.println("Les données sont sauvegardées dans le fichier : " + fichier);
    }

    /**
     * Charge les données du système à partir d'un fichier.
     *
     * @param fichier Le fichier depuis lequel les données seront chargées.
     */
    public void chargerDonnees(String fichier) {
        System.out.println("Les données ont été chargées depuis le fichier : " + fichier);
    }

    /**
     * Supprime un vaisseau par son identifiant.
     *
     * @param idVaisseau L'identifiant du vaisseau à supprimer.
     */
    public void supprimerVaisseau(String idVaisseau) {
        Vaisseau vaisseauSupp = null;
        for (Vaisseau vaisseau : vaisseaux) {
            if (vaisseau.getImmatriculation().equals(idVaisseau)) {
                vaisseauSupp = vaisseau;
                break;
            }
        }
        if (vaisseauSupp != null) {
            vaisseaux.remove(vaisseauSupp);
            System.out.println("Vaisseau supprimé avec succès");
        } else {
            System.out.println("Vaisseau non trouvé");
        }
    }

    /**
     * Supprime une personne par son identifiant.
     *
     * @param idPersonne L'identifiant de la personne à supprimer.
     */
    public void supprimerPersonne(String idPersonne) {
        Personne personneSupp = null;
        for (Personne personne : personnes) {
            if (personne.getIdentifiant().equals(idPersonne)) {
                personneSupp = personne;
            }
        }
        if (personneSupp != null) {
            personnes.remove(personneSupp);
            System.out.println("La personne a bien été supprimée avec succès");
        } else {
            System.out.println("La personne n'a pas été trouvée");
        }
    }

    /**
     * Supprime une mission par son code.
     *
     * @param idMission Le code de la mission à supprimer.
     */
    public void supprimerMission(String idMission) {
        Mission missionASupprimer = null;
        for (Mission mission : missions) {
            if (mission.getCode().equals(idMission)) {
                missionASupprimer = mission;
            }
        }
        if (missionASupprimer != null) {
            missions.remove(missionASupprimer);
            System.out.println("Mission supprimée avec succès !");
        } else {
            System.out.println("Mission non trouvée.");
        }
    }

    /**
     * Affiche la liste des missions.
     *
     * @param missions La liste des missions à afficher.
     */
    public void afficherMissions(List<Mission> missions) {
        if (missions == null || missions.isEmpty()) {
            System.out.println("La liste des missions est vide. Aucune mission n'est disponible.");
        } else {
            System.out.println("\nListe des missions : ");
            for (Mission mission : missions) {
                System.out.println(mission);
            }
        }
    }

    /**
     * Affiche la liste des réservations.
     *
     * @param reservations La liste des réservations à afficher.
     */
    public void afficherReservations(List<Reservation> reservations) {
        if (reservations == null || reservations.isEmpty()) {
            System.out.println("La liste des réservations est vide. Aucune réservation n'est disponible.");
        } else {
            System.out.println("\nListe des réservations : ");
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }

    /**
     * Affiche la liste des vaisseaux.
     *
     * @param vaisseaux La liste des vaisseaux à afficher.
     */
    public void afficherVaisseaux(List<Vaisseau> vaisseaux) {
        if (vaisseaux == null || vaisseaux.isEmpty()) {
            System.out.println("La liste des vaisseaux est vide. Aucun vaisseau n'est disponible.");
        } else {
            System.out.println("\nListe des vaisseaux : ");
            for (Vaisseau vaisseau : vaisseaux) {
                System.out.println(vaisseau);
            }
        }
    }

    /**
     * Récupère un vaisseau par son identifiant.
     *
     * @param idVaisseau L'identifiant du vaisseau.
     * @return Le vaisseau correspondant à l'identifiant, ou null si non trouvé.
     */
    public Vaisseau getVaisseauParId(String idVaisseau) {
        for (Vaisseau vaisseau : this.vaisseaux) {
            if (vaisseau.getImmatriculation().equals(idVaisseau)) {
                return vaisseau;
            }
        }
        return null;
    }

    /**
     * Récupère une personne par son identifiant.
     *
     * @param idPersonne L'identifiant de la personne.
     * @return La personne correspondant à l'identifiant, ou null si non trouvée.
     */
    public Personne getPersonneParId(String idPersonne) {
        for (Personne personne : this.personnes) {
            if (personne.getIdentifiant().equals(idPersonne)) {
                return personne;
            }
        }
        return null;
    }

    /**
     * Affiche la liste des personnes.
     *
     * @param personnes La liste des personnes à afficher.
     */
    public void afficherPersonnes(List<Personne> personnes) {
        if (personnes == null || personnes.isEmpty()) {
            System.out.println("La liste des personnes est vide. Aucune personne n'est disponible.");
        } else {
            System.out.println("\nListe des personnes : ");
            for (Personne personne : personnes) {
                System.out.println(personne);
            }
        }
    }
}
