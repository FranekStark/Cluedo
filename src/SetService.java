import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import touple.*;

import java.util.*;

class SetService {
    public ObservableList<FourTouple> getEindeutig() {
        return _eindeutig;
    }

    public ObservableList<FourTouple> getMehrdeutig() {
        return _mehrdeutig;
    }

    public ObservableList<FourTouple> getNegational() {
        return _negational;
    }

    public ObservableList<Taeter> get_uebrigTeater() {
        return _uebrigTeater;
    }

    public ObservableList<Ort> get_uebrigOrt() {
        return _uebrigOrt;
    }

    public ObservableList<Waffe> get_uebrigWaffe() {
        return _uebrigWaffe;
    }



    private ObservableList<FourTouple> _eindeutig;
    private ObservableList<FourTouple> _mehrdeutig;
    private ObservableList<FourTouple> _negational;



    private ObservableList<Taeter> _uebrigTeater;
    private ObservableList<Ort> _uebrigOrt;
    private ObservableList<Waffe> _uebrigWaffe;


    public SetService(){
        _eindeutig = FXCollections.observableList(new LinkedList<FourTouple>());
        _mehrdeutig = FXCollections.observableList(new LinkedList<FourTouple>());
        _negational = FXCollections.observableList(new LinkedList<FourTouple>());

        _uebrigOrt = FXCollections.observableList(new ArrayList<>());
        _uebrigTeater = FXCollections.observableList(new ArrayList<>());
        _uebrigWaffe = FXCollections.observableList(new ArrayList<>());

        calcUebrige();

    }

    public static void fuegeNichtDoppeltHinzu(List<FourTouple> list, List<FourTouple> touple)
    {
        for (FourTouple t : touple) {
            if (!list.contains(t)) {
                list.add(t);
            }
        }
    }

    public static void fuegeNichtDoppeltHinzu(List<FourTouple> list, FourTouple touple)
    {

            if (!list.contains(touple)) {
                list.add(touple);
            }



    }

    public void calcUebrige(){
        _uebrigOrt.clear();
        _uebrigWaffe.clear();
        _uebrigTeater.clear();
        _uebrigOrt.addAll(Ort.values());
        _uebrigWaffe.addAll(Waffe.values());
        _uebrigTeater.addAll(Taeter.values());

        for(FourTouple ft: _eindeutig){
            _uebrigTeater.removeAll(ft._taeter);
            _uebrigWaffe.removeAll(ft._waffe);
            _uebrigOrt.removeAll(ft._ort);
        }

        HashMap<Karte, Integer> hasNot = new HashMap<>();


    }




}
