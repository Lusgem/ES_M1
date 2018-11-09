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




}
