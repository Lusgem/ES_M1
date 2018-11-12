import java.util.ArrayList;

/**
 * Classe où sont définies les méthodes des différents moteurs (Chainage avant ou arrière)
 *
 */
 public class Moteurv2 {
	 
	private ArrayList<Regle> _baseDeRegles;
    private ArrayList<Fait> _baseDeFaits;
    
 public String chainageAvant (Fait F){
	ArrayList <int> reglesParcourues=new ArrayList<int>();
	ArrayList <Regle> reglesApplicables=new ArrayList<Regle>();
	String trace;
	while (!this._baseDeFaits.contains(F)){
		reglesApplicables.clear();
		for (Regle r : this._baseDeRegles)
			if (!reglesParcourues.contains(this._baseDeRegles.indexOf(r)))
				if r.estPossible(this._baseDeFaits)
					reglesApplicables.add(r);
		if (!reglesApplicables.isEmpty()){
			_baseDeFaits.add(reglesApplicables.get(0)._conclusion);
		}
		else{
			while (!reglesParcourues.isEmpty()){
				trace+="R"+reglesParcourues.get(reglesParcourues.size()-1)+";";
				reglesParcourues.remove(reglesParcourues.size()-1);
			}
			trace+="echec";
			return trace;
		}
	}
	while (!reglesParcourues.isEmpty()){
				trace+="R"+reglesParcourues.get(reglesParcourues.size()-1)+";";
				reglesParcourues.remove(reglesParcourues.size()-1);
			}
			trace+="succes";
			return trace;
}

 public boolean chainageArriere (Fait F){
	ArrayList <Regle> reglesApplicables=new ArrayList<Regle>;
	if (this._baseDeFaits.contains(F))
			return true;
	for (r : this._baseDeRegles)
		if (r._conclusion==F)
			reglesApplicables.add(r);
	for (r : reglesApplicables){
		if (r._conclusion==F){
			for (f : _conditions)
				return chainageArriere(f)
	}return false ;
 }


    
	
    public Moteurv2(ArrayList<Regle> _baseDeRegles, ArrayList<Fait> _baseDeFaits) {
        this._baseDeRegles = _baseDeRegles;
        this._baseDeFaits = _baseDeFaits;

    }




}
