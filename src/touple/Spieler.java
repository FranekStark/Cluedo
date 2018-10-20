package touple;

public class Spieler {
    public final String _name;


    public Spieler(String name) {
        _name = name;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        char[] letter = _name.toCharArray();
        for (int i=0; i < letter.length; i++) {
            hash += letter[i] * Math.pow(10,i);
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Spieler) {
            Spieler that = (Spieler) obj;
            return this._name.equals(that._name);
        }
        return false;
    }

    @Override
    public String toString() {
        return _name;
    }
}
