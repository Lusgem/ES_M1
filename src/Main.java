import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Fait> base_de_faits;
        ArrayList<Regle> base_de_regles;

        String fichier = "src/test.txt";


        /*System.out.println("Entrez le nom d'un fichier (Si il ne se trouve pas à la racine, entrez son adresse relative ou absolue");
        Scanner scan1 = new Scanner(System.in);
        fichier = scan1.next();*/

        BasedeRegles.Initialisation(fichier);

        System.out.println("Exploration ? ");
        System.out.println("1: Chainage avant");
        System.out.println("2: Chaine arrière");

        Scanner scan = new Scanner(System.in);
        int reponse = scan.nextInt();
        System.out.println(reponse);
        scan.close();
        switch(reponse){
            case 1:
                //System.out.println(m.chainageAvant(but));
                break;
            case 2:
                //System.out.println(m.chainageArriere(but));
                break;
            case 3:
                break;
            default:
                System.out.println("Erreur");
                break;
        }



    }
}
