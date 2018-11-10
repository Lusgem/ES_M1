import java.util.ArrayList;

/**
 * Classe où sont définies les méthodes des différents moteurs (Chainage avant ou arrière)
 *
 */
 public class Moteurv2 {/*
 public boolean chainageAvant (Fait F){
	boolean verif; //true si les condtions sont dans la base de faits, false sinon 
	ArrayList <Regle> reglesParcourues=new ArrayList<>();
	while (!this._baseDeFaits.contains(F)){
		if (this._baseDeRegles.size()==reglesParcourues.size())return false;
		for (Regle r : this._baseDeRegles){
			if (!reglesParcourues.contains(this._baseDeRegles.indexOf(r))){
				verif=true;
				for (Fait cond : r._conditions)
					verif&=this._baseDeFaits.contains(cond);
				if (verif){
					if (!this._baseDeFaits.contains(r._conclusion))
						this._baseDeFaits.add(r.conclusion);
						reglesParcourues.add(this._baseDeRegles.indexOf(r));
						break;
				}
			}
		}
	}
	return true;
 }
 public boolean chainageArriere (Fait F){
	boolean verif; //true si les condtions sont dans la base de faits, false sinon 
	ArrayList <int> reglesParcourues=new ArrayList<Regles>();
	while (!this._baseDeFaits.contains(F)){ //Tant que le fait recherché n'est pas dans la base de fait
		if (this._baseDeRegles.size()==reglesParcourues.size())return false;	//Si toutes les regles ont ete parcourues
		for (Regle r : this._baseDeRegles)
			if (!reglesParcourues.contains(this._baseDeRegles.indexOf(r))){	
				if (this._baseDeFaits.contains(r._conclusion){
					verif=true;
					for (Fait cond : r._conditions)
						verif&=this._baseDeFaits.contains(cond);
					if (verif){
						this._baseDeFaits.add(r.conclusion);
						reglesParcourues.add(this._baseDeRegles.indexOf(r));
						break;
					}
				}
			}
	}
	return true;
 }



    private ArrayList<Regle> _baseDeRegles;
    private ArrayList<Fait> _baseDeFaits;

    public Moteurv2(ArrayList<Regle> _baseDeRegles, ArrayList<Fait> _baseDeFaits) {
        this._baseDeRegles = _baseDeRegles;
        this._baseDeFaits = _baseDeFaits;
    }


*/

}
