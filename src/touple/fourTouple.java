package touple;

public class fourTouple {

    public Taeter _taeter;
    public Waffe _waffe;
    public Ort _ort;
    public Spieler _spieler;

    public fourTouple(Taeter taeter, Waffe waffe, Ort ort, Spieler spieler) {
        _taeter = taeter;
        _waffe = waffe;
        _ort = ort;
        _spieler = spieler;
    }

    @Override
    public int hashCode() {
        int r= 0;
        r += (1000 * _spieler.hashCode());
        if(_taeter != null){
        r += (100 * _taeter.ordinal());}
        if(_waffe != null){
        r += (10 * _waffe.ordinal());}
        if(_ort != null){
        r += (1 * _ort.ordinal());}
        
        return r;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof fourTouple) {
            fourTouple that = (fourTouple) obj;
            return this._taeter == that._taeter
                    && this._waffe == that._waffe
                    && this._ort == that._ort
                    && this._spieler.equals(that._spieler);
        }
        return false;
    }

    @Override
    public String toString() {
        String teaterString = "-";
        String waffeString = "-";
        String ortString = "-";
        String spielerString = "-";

        if (_taeter != null) {
            teaterString = _taeter.toString();
        }

        if (_waffe != null) {
            waffeString = _waffe.toString();
        }

        if (_ort != null) {
            ortString = _ort.toString();
        }

        if (_spieler != null) {
            spielerString = _spieler.toString();
        }

        return "(" + teaterString + ",\t " + waffeString + ",\t " + ortString + ",\t " + spielerString + ")";
    }

    public fourTouple getCopy() {
        return new fourTouple(_taeter, _waffe, _ort, _spieler);
    }
}
