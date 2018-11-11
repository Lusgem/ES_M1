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

    public String chainageAvant(Fait objectif){
        ArrayList<Regle> baseDeRegle = new ArrayList<Regle>(_baseDeRegles);
        ArrayList<Fait> baseDeFaits = new ArrayList<Fait>(_baseDeFaits);
        String trace = "";

        while(!baseDeFaits.contains(objectif)&&existeUneReglePossible(baseDeRegle, baseDeFaits)){
            Regle reglePossible = null;

            for(Regle r : baseDeRegle){
                if(r.estPossible(baseDeFaits)){
                    reglePossible = r;
                    trace+=reglePossible.toString()+"\n";
                    break;
                }

            }

            baseDeRegle.remove(reglePossible);
            baseDeFaits.add(reglePossible.get_conclusion());

        }

        if(baseDeFaits.contains(objectif)){
            trace+="SUCCES";
            return trace;
        }

        trace+="ECHEC";
        return trace;
    }

    public boolean existeUneReglePossible(ArrayList<Regle> bdr, ArrayList<Fait> bdf){
        for(Regle r :bdr){
            if(r.estPossible(bdf)){
                return true;
            }
        }
        return false;
    }



}
