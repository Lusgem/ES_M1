import java.util.Objects;

public class Fait {

    private String _attribut = new String();
    private String _valeur= new String();
    private String _operateur = new String();

    public Fait() {

    }


    public String get_operateur() {
        return _operateur;
    }

    public void set_operateur(String _operateur) {
        this._operateur = _operateur.replaceAll(" ", "");
    }



    public Fait(String _attribut, String _valeur, String _operateur) {
        this._attribut = _attribut.replaceAll(" ", "");
        this._valeur = _valeur.replaceAll(" ", "");
        this._operateur = _operateur.replaceAll(" ", "");
    }

    public String get_attribut() {
        return _attribut;
    }

    public void set_attribut(String _attribut) {
        this._attribut = _attribut.replaceAll(" ", "");
    }

    public String get_valeur() {
        return _valeur;
    }

    public void set_valeur(String _valeur) {
        this._valeur = _valeur;
    }

    public boolean verificationNum(Fait fait){
        String operateur = get_operateur();
        if(operateur.equalsIgnoreCase("="))
            return false;
        if(!fait.get_attribut().equalsIgnoreCase("age"))
            return false;
        int num = Integer.parseInt(get_valeur());
        int numcourant = Integer.parseInt(fait.get_valeur());
        if(get_attribut().equalsIgnoreCase(fait.get_attribut())){
            switch (operateur){
                case "<=":
                    return numcourant<=num;
                case ">=":
                    return numcourant>=num;
                case "=":
                    return true;
                case "<":
                    return numcourant<num;
                case ">":
                    return numcourant>num;

            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Fait(" +
                "Attribut='" + _attribut + '\'' +
                ", Valeur='" + _valeur + '\'' +
                ", Operateur='" + _operateur + '\''+')';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fait)) return false;
        Fait fait = (Fait) o;
        return fait.get_operateur().equalsIgnoreCase(_operateur) &&
                fait.get_attribut().equalsIgnoreCase(_attribut) &&
                fait.get_valeur().equalsIgnoreCase(_valeur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_attribut(), get_valeur(), get_operateur());
    }
}
