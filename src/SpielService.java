import touple.*;

import java.util.LinkedList;
import java.util.List;

class SpielService {
    private SetService _setService;

    public SpielService(){
        _setService = new SetService();
    }

    public SetService getSets(){
        return _setService;
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

        SetService.fuegeNichtDoppeltHinzu(_setService.getEindeutig(),t);
    }

    /**
     * Fall 2
     */
    public void spielerZeigtKarteGeheim(Spieler spieler, Ort ort, Waffe waffe, Taeter taeter) {
        FourTouple t = new FourTouple(taeter, waffe, ort, spieler);
        SetService.fuegeNichtDoppeltHinzu(_setService.getMehrdeutig(),t);
    }

    /**
     * Fall 3
     */
    public void spielerHatKeineKarte(Spieler spieler, Ort ort, Waffe waffe, Taeter taeter) {
        FourTouple t1 = new FourTouple(taeter, null, null, spieler);
        FourTouple t2 = new FourTouple(null, waffe, null, spieler);
        FourTouple t3 = new FourTouple(null, null, ort, spieler);


        List<FourTouple> temp =  new LinkedList<>();
        temp.add(t1);
        temp.add(t2);
        temp.add(t3);
        SetService.fuegeNichtDoppeltHinzu(_setService.getNegational(), temp);
    }



    public void substituiereDurchEindeutige(){

        List<FourTouple> temp = new LinkedList<>();

        for(FourTouple ftM : _setService.getMehrdeutig())
        {
            for(FourTouple ftE : _setService.getEindeutig())
            {
                if(!ftE._spieler.equals(ftM._spieler)){
                    FourTouple newFT = new FourTouple(ftM._taeter,ftM._waffe, ftM._ort, ftM._spieler);
                    if(ftE._ort == ftM._ort)
                    {
                        newFT._ort=null;
                    }
                    else if(ftE._taeter == ftM._taeter)
                    {
                        newFT._taeter = null;
                    }
                    else if(ftE._waffe == ftM._waffe){
                        newFT._waffe = null;
                    }
                    temp.add(newFT);
                }

            }
        }
        SetService.fuegeNichtDoppeltHinzu(_setService.getMehrdeutig(), temp);

    }

    public void entferneWertloses(){
        List<FourTouple> temp = new LinkedList<>();

        for(FourTouple ftM : _setService.getMehrdeutig())
        {
            for(FourTouple ftE : _setService.getEindeutig())
            {
                if(ftE._spieler.equals(ftM._spieler)){
                    if(ftM._waffe == ftE._waffe || ftM._taeter == ftE._taeter || ftM._ort == ftE._ort) {
                        temp.add(ftM);
                    }
                }

            }
        }
        _setService.getMehrdeutig().removeAll(temp);
    }

    public void substituiereDurchNegationale(){
        List<FourTouple> temp = new LinkedList<>();

        for(FourTouple ftM : _setService.getMehrdeutig())
        {
            for(FourTouple ftN : _setService.getNegational())
            {

               if(ftM._spieler.equals(ftN._spieler)){
                   FourTouple newMt = ftM.getCopy();

                   if (ftM._taeter == ftN._taeter) {
                       newMt._taeter = null;
                   }

                   if (ftM._ort == ftN._ort) {
                       newMt._ort = null;
                   }

                   if (ftM._waffe == ftN._waffe) {
                       newMt._waffe = null;
                   }

                   temp.add(newMt);
               }

            }
        }
        SetService.fuegeNichtDoppeltHinzu(_setService.getMehrdeutig(), temp);
    }

    public void ueberfuehreMnachE(){
        List<FourTouple> temp = new LinkedList<>();

        for(FourTouple ftM : _setService.getMehrdeutig())
        {
            if(nullCount(ftM) >= 2){
                temp.add(ftM);
            }
        }
        _setService.getMehrdeutig().removeAll(temp);
        SetService.fuegeNichtDoppeltHinzu(_setService.getEindeutig(), temp);
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

    


}
