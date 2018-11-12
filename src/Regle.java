import java.util.ArrayList;

public class Regle {

    private ArrayList<Fait> _conditions = new ArrayList<>();
    private Fait _conclusion = new Fait();

    private boolean _deja_teste = false;

    public Regle() {

    }
    public Regle(ArrayList<Fait> _conditions, Fait _conclusion) {
        this._conditions = _conditions;
        this._conclusion = _conclusion;
    }


    public ArrayList<Fait> get_conditions() {
        return _conditions;
    }

    public Fait get_conclusion() {
        return _conclusion;
    }

    public void set_conclusion(Fait _conclusion) {
        this._conclusion = _conclusion;
    }


    public void ajoutCondition(Fait condition){
        _conditions.add(condition);
    }
    public boolean est_deja_test() {
        return _deja_teste;
    }

    public void set_deja_teste(boolean _test) {
        this._deja_teste = _test;
    }

    public boolean estPossible(ArrayList<Fait> base_de_faits) {
        boolean possible = true;
        for (Fait f : _conditions) {
            if (!base_de_faits.contains(f)) {
                possible = false;
                break;
            }
        }

        return possible;

    }

    @Override
    public String toString() {
        return "Regle :" +
                " Conditions=" + _conditions.toString() +
                ", Conclusion=" + _conclusion.toString();
    }
}
