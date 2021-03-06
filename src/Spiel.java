import touple.*;

import java.util.HashSet;
import java.util.Set;

public class Spiel {
    Set<FourTouple> _eindeutig;
    Set<FourTouple> _mehrdeutig;
    Set<FourTouple> _negational;

    public Spiel() {
        _eindeutig = new HashSet<>();
        _mehrdeutig = new HashSet<>();
        _negational = new HashSet<>();
    }


    /**
     * Fall 1
     */
    public void spielerZeigtKarteSichtbar(Spieler spieler, Karte karte) {
        FourTouple t = new FourTouple(null, null, null, spieler);

        if (karte instanceof Ort) {
            t._ort = (Ort) karte;
        } else if (karte instanceof Taeter) {
            t._taeter = (Taeter) karte;
        } else if (karte instanceof Waffe) {
            t._waffe = (Waffe) karte;
        }

        _mehrdeutig.add(t);
    }

    /**
     * Fall 2
     */
    public void spielerZeigtKarteGeheim(Spieler spieler, Ort ort, Waffe waffe, Taeter taeter) {
        FourTouple t = new FourTouple(taeter, waffe, ort, spieler);
        _mehrdeutig.add(t);
    }

    /**
     * Fall 3
     */
    public void spielerHatKeineKarte(Spieler spieler, Ort ort, Waffe waffe, Taeter taeter) {
        FourTouple t1 = new FourTouple(taeter, null, null, spieler);
        FourTouple t2 = new FourTouple(null, waffe, null, spieler);
        FourTouple t3 = new FourTouple(null, null, ort, spieler);

        _negational.add(t1);
        _negational.add(t2);
        _negational.add(t3);
    }

    ///////////////////////////////////////////////////////////////////////

    public void substituiereDurchEindeutige() {
        for (FourTouple mehrdeutig : _mehrdeutig) {
            for (FourTouple eindeutig : _eindeutig) {
                if (!mehrdeutig._spieler.equals(eindeutig._spieler)) {

                    FourTouple newMehrdeutig = mehrdeutig.getCopy();
                    if (mehrdeutig._taeter == eindeutig._taeter) {
                        newMehrdeutig._taeter = null;
                    }

                    if (mehrdeutig._ort == eindeutig._ort) {
                        newMehrdeutig._ort = null;
                    }

                    if (mehrdeutig._waffe == eindeutig._waffe) {
                        newMehrdeutig._waffe = null;
                    }
                    _mehrdeutig.add(newMehrdeutig);
                }
            }
        }
    }

    public void entferneWertloseInfos() {
        for (FourTouple mehrdeutig : _mehrdeutig) {
            for (FourTouple eindeutig : _eindeutig) {
                if (mehrdeutig._spieler.equals(eindeutig._spieler)) {
                    if (mehrdeutig._taeter == eindeutig._taeter
                            || mehrdeutig._ort == eindeutig._ort
                            || mehrdeutig._waffe == eindeutig._waffe) {
                        _mehrdeutig.remove(mehrdeutig);
                    }
                }
            }
        }
    }

    public void substitutionDurchNegativeInfos() {
        for (FourTouple mehrdeutig : _mehrdeutig) {
            for (FourTouple negational : _negational) {
                if (mehrdeutig._spieler.equals(negational._spieler)) {
                    FourTouple newMehrdeutig = mehrdeutig.getCopy();

                    if (mehrdeutig._taeter == negational._taeter) {
                        newMehrdeutig._taeter = null;
                    }

                    if (mehrdeutig._ort == negational._ort) {
                        newMehrdeutig._ort = null;
                    }

                    if (mehrdeutig._waffe == negational._waffe) {
                        newMehrdeutig._waffe = null;
                    }

                    _mehrdeutig.add(newMehrdeutig);

                }
            }
        }
    }


    public void ueberfuehreMnachE() {
        for (FourTouple mehrdeutig :
                _mehrdeutig) {


            if (nullCount(mehrdeutig) >= 2) {
                _eindeutig.add(mehrdeutig);
                _mehrdeutig.remove(mehrdeutig);
            }
        }
    }

    public void reduktion() {
        for (FourTouple mehrdeutig1 : _mehrdeutig) {
            for (FourTouple mehrdeutig2 : _mehrdeutig) {
                if (mehrdeutig1._spieler.equals(mehrdeutig2._spieler)) {
                    if (mehrdeutig1._taeter == mehrdeutig2._taeter
                            || mehrdeutig1._ort == mehrdeutig2._ort
                            || mehrdeutig1._ort == mehrdeutig2._ort
                    ){
                        if(nullCount(mehrdeutig1) > nullCount(mehrdeutig2))
                        {
                            _mehrdeutig.remove(mehrdeutig2);
                        }
                    }
                }
            }
        }
    }

    private int nullCount(FourTouple t)
    {
        int nullCnt = 0;
        if (t._taeter == null) {
            nullCnt++;
        }
        if (t._ort == null) {
            nullCnt++;
        }
        if (t._waffe == null) {
            nullCnt++;
        }
        return nullCnt;
    }

    //////////////////////////////////////////////////////////////////////
    public String toupleSetToString(Set<FourTouple> set) {
        String s = "(Täter,\t Waffe,\t Ort,\t Spieler)\n";
        s += "------------------------------------------\n";
        for (FourTouple t : set) {
            s += t.toString();
            s += "\n";
        }

        return s;
    }

    
    public void printAll()
    {
         System.out.println("\n\nEindeutig");
     System.out.println(toupleSetToString(_eindeutig));
     System.out.println("\n\nMehrdeutig");
      System.out.println(toupleSetToString(_mehrdeutig));
      System.out.println("\n\n Negational");
       System.out.println(toupleSetToString(_negational));
    }

}
