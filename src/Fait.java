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

    public void set_operateur(String _signe) {
        this._operateur = _signe;
    }



    public Fait(String _attribut, String _valeur, String _signe) {
        this._attribut = _attribut;
        this._valeur = _valeur;
        this._operateur = _signe;
    }

    public String get_attribut() {
        return _attribut;
    }

    public void set_attribut(String _attribut) {
        this._attribut = _attribut;
    }

    public String get_valeur() {
        return _valeur;
    }

    public void set_valeur(String _valeur) {
        this._valeur = _valeur;
    }

    @Override
    public String toString() {
        return "Fait{" +
                "_attribut='" + _attribut + '\'' +
                ", _valeur='" + _valeur + '\'' +
                ", _operateur='" + _operateur + '\'' +
                '}';
    }

    public boolean equals(Fait f) {
                return (_attribut.equalsIgnoreCase(f.get_attribut()) &&
                        _operateur.equalsIgnoreCase(f.get_operateur()) &&
                        _valeur.equalsIgnoreCase(f.get_valeur()));
    }

}
