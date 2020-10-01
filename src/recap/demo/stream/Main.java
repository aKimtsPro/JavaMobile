package recap.demo.stream;

import recap.exo.genericite.Competition;
import recap.exo.genericite.CoureurF1;
import recap.exo.genericite.Sportif;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Competition<CoureurF1> compet = new Competition<>();
        compet.getParticipants().add( new CoureurF1("luc", "vroomMobile") );
        compet.getParticipants().add( new CoureurF1("marie", "pouetMachine") );

        compet.getParticipants().add( new CoureurF1("luc", "pouetMachine") );
        compet.getParticipants().add( new CoureurF1("marie", "vroomMobile") );

        // Methodes intermediaires

        // Filter

        List<CoureurF1> coureurPertinants = compet.getParticipants()
                .stream()
                .filter( (coureurF1) -> coureurF1.getMarqueVehicule().equals("vroomMobile") )
                .filter( (coureurF1) -> coureurF1.getNom().equals("luc") )
                .collect(Collectors.toList());

        for (CoureurF1 coureurPertinant :
                coureurPertinants) {
            System.out.println( coureurPertinant.getNom() + " - " + coureurPertinant.getMarqueVehicule() );
        }

        // Map - Distinct

        System.out.println("Recuperation des noms de coureurs :");

        List<String> listNom = compet.getParticipants()
                .stream()
                .map( CoureurF1::getNom )
                .distinct()
                .collect(Collectors.toList());

        for (String nom :
                listNom) {
            System.out.println( nom );
        }

        // limit - skip

        System.out.println("Recupération des 2 premiers coureurs");

        List<CoureurF1> limit2 = compet.getParticipants()
                .stream()
                .limit(2)
                .collect(Collectors.toList());

        for (CoureurF1 premiersCourreurs :
                limit2) {
            System.out.println( premiersCourreurs.getNom() + " - " + premiersCourreurs.getMarqueVehicule() );
        }

        System.out.println("Passer les 2 premiers : ");

        limit2 = compet.getParticipants()
                .stream()
                .skip(2)
                .collect(Collectors.toList());

        for (CoureurF1 premiersCourreurs :
                limit2) {
            System.out.println( premiersCourreurs.getNom() + " - " + premiersCourreurs.getMarqueVehicule() );
        }




        // Terminales

        // count
        System.out.println(" Nombre de nom distinct : ");
        long nbrNomDistinct = compet.getParticipants()
                .stream()
                .map( CoureurF1::getNom )
                .distinct()
                .count();
        System.out.println( nbrNomDistinct );

        // foreach
        System.out.println("Modif du nom de chaque conducteur de vroomMobile");
        compet.getParticipants().stream()
                .filter( (coureurF1) -> coureurF1.getMarqueVehicule().equals("vroomMobile") )
                .forEach( coureurF1 -> coureurF1.setNom( "jean-" + coureurF1.getNom() ) );

        compet.getParticipants().forEach( (participant) -> System.out.println( participant.getNom() ) );


        // anyMatch / allMatch / noneMatch

        System.out.println(" Verification qu'au moins un 'luc' conduit une vroomMobile : ");
        boolean isThereALuc = compet.getParticipants().stream()
                .filter( (coureurF1) -> coureurF1.getMarqueVehicule().equals("vroomMobile") )
                .anyMatch( (coureurF1) -> coureurF1.getNom().equals("luc") );
        System.out.println(isThereALuc);

        // findFirst - findAny

        System.out.println("Recuperer le premier element (attention aux Optional): ");
        Optional<CoureurF1> c = compet.getParticipants().stream().findFirst();
        if(c.isPresent())
            System.out.println("il existe un premier element :"+ c.get().getNom());
        else
            System.out.println("Il n'existe pas de premier element");


        // reduce

        System.out.println("Récupération de la concaténation des noms :");

        Optional<String> concatDesNoms = compet.getParticipants().stream()
                .map( CoureurF1::getNom )
                .reduce( (string1, string2) -> string1 + " - " + string2);

        if(concatDesNoms.isPresent())
            System.out.println(concatDesNoms.get());
        else
            System.out.println("pas de participants");


        // collect

        List<CoureurF1> conducteurVroom = compet.getParticipants().stream()
                .filter( (coureurF1) -> coureurF1.getMarqueVehicule().equals("vroomMobile") )
                .collect(Collectors.toList());

    }
}
