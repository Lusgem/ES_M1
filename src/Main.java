import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String fichier = "regles.txt";
        ArrayList<Fait> base_de_faits = new ArrayList<>();
        ArrayList<Regle> base_de_regles = BasedeRegles.Initialisation(fichier);

        System.out.println("Entrez votre age : ");
        Scanner scan1 = new Scanner(System.in);
        String age = scan1.next();

        base_de_faits.add(new Fait("age",age,"="));
        base_de_faits.add(new Fait("editeur","konami","="));
        base_de_faits.add(new Fait("style","horreur","="));
        base_de_faits.add(new Fait("pegi","18","="));
        Fait objectif = new Fait("jeu","Silent_Hill","=");




        /*System.out.println("Entrez le nom d'un fichier (Si il ne se trouve pas à la racine, entrez son adresse relative ou absolue");
        Scanner scan1 = new Scanner(System.in);
        fichier = scan1.next();*/



        Moteur m = new Moteur(base_de_regles,base_de_faits);

        System.out.println("Exploration en chainage avant ou arriere ? ");
        System.out.println("1: Chainage avant");
        System.out.println("2: Chaine arrière");

        Scanner scan = new Scanner(System.in);
        int reponse = scan.nextInt();
        System.out.println(reponse);
        scan.close();
        switch(reponse){
            case 1:
                System.out.println(m.chainageAvant(objectif));
                break;
            case 2:
                //System.out.println(m.chainageArriere(objectif));
                break;
            case 3:
                break;
            default:
                System.out.println("Erreur");
                break;
        }



    }
}
