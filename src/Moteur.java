import java.util.ArrayList;

/**
 * Classe où sont définies les méthodes des différents moteurs (Chainage avant ou arrière)
 *
 */

public class Moteur {
    private ArrayList<Regle> _baseDeRegles;
    private ArrayList<Fait> _baseDeFaits;

    public Moteur(ArrayList<Regle> _baseDeRegles, ArrayList<Fait> _baseDeFaits) {
        this._baseDeRegles = _baseDeRegles;
        this._baseDeFaits = _baseDeFaits;
    }

    public boolean existeUneReglePossible(ArrayList<Regle> bdr, ArrayList<Fait> bdf){
        for(Regle r :bdr){
            if(r.estPossible(bdf)){
                return true;
            }
        }
        return false;
    }

    public String chainageAvant(Fait objectif){
        ArrayList<Regle> baseDeRegle = new ArrayList<Regle>(_baseDeRegles);
        ArrayList<Fait> baseDeFaits = new ArrayList<Fait>(_baseDeFaits);
        String trace = "";
        Fait reponse = new Fait();
        System.out.println("Début du chainage avant !");
        while(!baseDeFaits.contains(objectif)&&existeUneReglePossible(baseDeRegle, baseDeFaits)){
            System.out.println("Base de faits : \n"+baseDeFaits.toString());
            Regle reglePossible = null;
            for(Regle r : baseDeRegle){
                if(r.estPossible(baseDeFaits)){
                    reglePossible = r;
                    System.out.println(reglePossible.toString()+"\n");
                    if(r.get_conclusion().get_attribut().equalsIgnoreCase("jeu")){
                        reponse = r.get_conclusion();
                    }
                    break;
                }

            }


            baseDeRegle.remove(reglePossible);
            if(!baseDeFaits.contains(reglePossible.get_conclusion()))
                baseDeFaits.add(reglePossible.get_conclusion());

        }
        if(reponse!=objectif && reponse.get_attribut().equalsIgnoreCase("jeu")){
            return reponse+" SUCCES";
        }

        if(baseDeFaits.contains(objectif)){
            return "SUCCES";
        }

        return "ECHEC";
    }



    public String chainageArriere(Fait objectif){
        ArrayList<Regle> baseDeRegle= new ArrayList<>(_baseDeRegles);
        ArrayList<Fait> baseDeFaits = new ArrayList<>(_baseDeFaits);
        ArrayList<Fait> faitsRecherchees = new ArrayList<>();

        if(!faitsRecherchees.contains(objectif))
            faitsRecherchees.add(objectif);
        System.out.println("Début du chainage arriere !");
        int tour = 1;
        while(!baseDeFaits.contains(objectif)&&tour<100000){
            System.out.println("Base de faits : \n"+baseDeFaits.toString());
            ArrayList<Regle> reglesValides = new ArrayList<>();
            System.out.println("Base de faits, tour "+tour);
            for(Fait f : baseDeFaits){
                System.out.println(f);
            }
            System.out.println("\n");
            System.out.println("Fait recherchés");
            for(Fait f : faitsRecherchees){
                System.out.println(f);
            }
            System.out.println("\n");

            for(Regle r : baseDeRegle){
                if(faitsRecherchees.contains(r.get_conclusion())){
                    reglesValides.add(r);
                    System.out.println("Règle dont la conclusion est recherchée : "+r);
                }
            }
            if(reglesValides.isEmpty()){
                System.out.println("Il n'y a pas de règles valides");
                break;
            }

            for(Regle regleValide : reglesValides){
                if(baseDeFaits.containsAll(regleValide.get_conditions())){
                    if(!baseDeFaits.contains(regleValide.get_conclusion())) {
                        System.out.println("On ajoute : " + regleValide.get_conclusion() + " de la base de faits");
                        baseDeFaits.add(regleValide.get_conclusion());
                    }

                    System.out.println("On retire : "+regleValide+" de la base de règles");
                    baseDeRegle.remove(regleValide);

                    faitsRecherchees.remove(regleValide.get_conclusion());
                }
                else{
                    for(Fait conditionRV : regleValide.get_conditions()){
                        if(!faitsRecherchees.contains(conditionRV)){
                            faitsRecherchees.add(conditionRV);
                        }
                    }

                }
            }
            tour++;

        }

        if(baseDeFaits.contains(objectif)){
            return "SUCCES";
        }
        else{
            return "ECHEC";
        }
    }






}
