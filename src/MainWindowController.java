
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import touple.*;

public class MainWindowController {

    private List<Spieler> getSpieler()
    {
        List<Spieler> spieler = new LinkedList<Spieler>();
        spieler.add(new Spieler("Andrea"));
        spieler.add(new Spieler("Franek"));
        spieler.add(new Spieler("Jarno"));

        return spieler;
    }

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="_ComboSpielerup"
    private ComboBox<Spieler> _ComboSpielerup; // Value injected by FXMLLoader

    @FXML // fx:id="_ComboOrt"
    private ComboBox<Ort> _ComboOrt; // Value injected by FXMLLoader

    @FXML // fx:id="_tableUebrige"
    private TableColumn<?, ?> _tableUebrige; // Value injected by FXMLLoader

    @FXML // fx:id="_ComboWaffre"
    private ComboBox<Waffe> _ComboWaffre; // Value injected by FXMLLoader

    @FXML // fx:id="_ButtonSubstituiere"
    private Button _ButtonSubstituiere; // Value injected by FXMLLoader

    @FXML // fx:id="_ButtonHatNicht"
    private Button _ButtonHatNicht; // Value injected by FXMLLoader

    @FXML // fx:id="_ButtonReduziere"
    private Button _ButtonReduziere; // Value injected by FXMLLoader

    @FXML // fx:id="_ComboCard"
    private ComboBox<Karte> _ComboCard; // Value injected by FXMLLoader


    @FXML // fx:id="_ButtonOk"
    private Button _ButtonOk; // Value injected by FXMLLoader


    @FXML // fx:id="_ComboSpielerDown"
    private ComboBox<Spieler> _ComboSpielerDown; // Value injected by FXMLLoader

    @FXML // fx:id="_ButtonZeigtVerdeckt"
    private Button _ButtonZeigtVerdeckt; // Value injected by FXMLLoader


    @FXML // fx:id="_ButtonMnachE"
    private Button _ButtonMnachE; // Value injected by FXMLLoader

    @FXML // fx:id="_ComboTaeter"
    private ComboBox<Taeter> _ComboTaeter; // Value injected by FXMLLoader



    @FXML //fx:id="_tableViewEindeutige"
    private TableView<FourTouple> _tableViewEindeutige;

    @FXML //fx:id="_tableViewMehrdeutige"
    private TableView<FourTouple> _tableViewMehrdeutige;

    @FXML //fx:id="_tableViewNegationale"
    private TableView<FourTouple> _tableViewNegationale;

    @FXML
    private TableView<Taeter> _tableViewUebrigTaeter;

    @FXML
    private TableView<Ort> _tableViewUebrigOrt;

    @FXML
    private TableView<Waffe> _tableViewUebrigWaffe;


    @FXML // fx:id="_tableNegationale"
    private TableColumn<FourTouple, FourTouple> _tableNegationale; // Value injected by FXMLLoader
    @FXML // fx:id="_tableMehrdeutige"
    private TableColumn<FourTouple, FourTouple> _tableMehrdeutige; // Value injected by FXMLLoader
    @FXML // fx:id="_tableEindeutige"
    private TableColumn<FourTouple, FourTouple> _tableEindeutige; // Value injected by FXMLLoader

    @FXML // fx:id="_tableEindeutigeTaeter"
    private TableColumn<FourTouple, Taeter> _tableEindeutigeTaeter; // Value injected by FXMLLoader
    @FXML // fx:id="_tableEindeutigeWaffe"
    private TableColumn<FourTouple, Waffe> _tableEindeutigeWaffe; // Value injected by FXMLLoader
    @FXML // fx:id="_tableEindeutigeOrt"
    private TableColumn<FourTouple, Ort> _tableEindeutigeOrt; // Value injected by FXMLLoader
    @FXML // fx:id="_tableEindeutigeSpieler"
    private TableColumn<FourTouple, Spieler> _tableEindeutigeSpieler; // Value injected by FXMLLoader

    @FXML // fx:id="_tableMehrdeutigeTaeter"
    private TableColumn<FourTouple, Taeter> _tableMehrdeutigeTaeter; // Value injected by FXMLLoader
    @FXML // fx:id="_tableMehrdeutigeWaffe"
    private TableColumn<FourTouple, Waffe> _tableMehrdeutigeWaffe; // Value injected by FXMLLoader
    @FXML // fx:id="_tableMehrdeutigeOrt"
    private TableColumn<FourTouple, Ort> _tableMehrdeutigeOrt; // Value injected by FXMLLoader
    @FXML // fx:id="_tableMehrdeutigeSpieler"
    private TableColumn<FourTouple, Spieler> _tableMehrdeutigeSpieler; // Value injected by FXMLLoader

    @FXML // fx:id="_tableNegationaleTaeter"
    private TableColumn<FourTouple, Taeter> _tableNegationaleTaeter; // Value injected by FXMLLoader
    @FXML // fx:id="_tableNegationaleWaffe"
    private TableColumn<FourTouple, Waffe> _tableNegationaleWaffe; // Value injected by FXMLLoader
    @FXML // fx:id="_tableNegationaleOrt"
    private TableColumn<FourTouple, Ort> _tableNegationaleOrt; // Value injected by FXMLLoader
    @FXML // fx:id="_tableNegationaleSpieler"
    private TableColumn<FourTouple, Spieler> _tableNegationaleSpieler; // Value injected by FXMLLoader

    @FXML // fx:id="_tableUebrigeTaeter"
    private TableColumn<Taeter, Taeter> _tableUebrigeTaeter; // Value injected by FXMLLoader
    @FXML // fx:id="_tableUebrigeWaffe"
    private TableColumn<Waffe, Waffe> _tableUebrigeWaffe; // Value injected by FXMLLoader
    @FXML // fx:id="_tableUebrigeOrt"
    private TableColumn<Ort, Ort> _tableUebrigeOrt; // Value injected by FXMLLoader




    SpielService _spiel;

    public MainWindowController(){
        _spiel = new SpielService();
    }


    @FXML
    void handeOkButton(ActionEvent event) {
        Karte karte = _ComboCard.getSelectionModel().getSelectedItem();
        Spieler spieler = _ComboSpielerup.getSelectionModel().getSelectedItem();


        if(karte != null && spieler != null){
            _spiel.spielerZeigtKarteSichtbar(spieler, karte);
        }
        else{
            aufuellWarnung();
        }

        _spiel.getSets().calcUebrige();
    }

    @FXML
    void handleZeigtVerdecktButton(ActionEvent event) {
        Spieler spieler = _ComboSpielerDown.getSelectionModel().getSelectedItem();
        Taeter taeter = _ComboTaeter.getSelectionModel().getSelectedItem();
        Ort ort = _ComboOrt.getSelectionModel().getSelectedItem();
        Waffe waffe = _ComboWaffre.getSelectionModel().getSelectedItem();

        if(spieler!=null && taeter!=null && ort != null && waffe != null) {
            _spiel.spielerZeigtKarteGeheim(spieler, ort, waffe, taeter);
        }
        else {
            aufuellWarnung();
        }

    }

    @FXML
    void handleHatNichtButton(ActionEvent event) {
        Spieler spieler = _ComboSpielerDown.getSelectionModel().getSelectedItem();
        Taeter taeter = _ComboTaeter.getSelectionModel().getSelectedItem();
        Ort ort = _ComboOrt.getSelectionModel().getSelectedItem();
        Waffe waffe = _ComboWaffre.getSelectionModel().getSelectedItem();


        if(spieler!=null && taeter!=null && ort != null && waffe != null) {
            _spiel.spielerHatKeineKarte(spieler,ort,waffe,taeter);
        }
        else {
            aufuellWarnung();
        }

    }

    @FXML
    public void handleSubstituiereButton()
    {
        _spiel.substituiereDurchEindeutige();
        _spiel.substituiereDurchNegationale();

    }

    @FXML
    public void handleMEButton()
    {
        _spiel.ueberfuehreMnachE();
        _spiel.getSets().calcUebrige();
    }

    @FXML
    public void handleReduziereButton()
    {
        _spiel.entferneWertloses();

    }


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert _ComboSpielerup != null : "fx:id=\"_ComboSpielerup\" was not injected: check your FXML file 'mainWindow.fxml'.";
        assert _ComboOrt != null : "fx:id=\"_ComboOrt\" was not injected: check your FXML file 'mainWindow.fxml'.";
        assert _tableUebrige != null : "fx:id=\"_tableUebrige\" was not injected: check your FXML file 'mainWindow.fxml'.";
        assert _ComboWaffre != null : "fx:id=\"_ComboWaffre\" was not injected: check your FXML file 'mainWindow.fxml'.";
        assert _ButtonSubstituiere != null : "fx:id=\"_ButtonSubstituiere\" was not injected: check your FXML file 'mainWindow.fxml'.";
        assert _ButtonHatNicht != null : "fx:id=\"_ButtonHatNicht\" was not injected: check your FXML file 'mainWindow.fxml'.";
        assert _ButtonReduziere != null : "fx:id=\"_ButtonReduziere\" was not injected: check your FXML file 'mainWindow.fxml'.";
        assert _ComboCard != null : "fx:id=\"_ComboCard\" was not injected: check your FXML file 'mainWindow.fxml'.";
        assert _tableEindeutige != null : "fx:id=\"_tableEindeutige\" was not injected: check your FXML file 'mainWindow.fxml'.";
        assert _ButtonOk != null : "fx:id=\"_ButtonOk\" was not injected: check your FXML file 'mainWindow.fxml'.";
        assert _tableMehrdeutige != null : "fx:id=\"_tableMehrdeutige\" was not injected: check your FXML file 'mainWindow.fxml'.";
        assert _ComboSpielerDown != null : "fx:id=\"_ComboSpielerDown\" was not injected: check your FXML file 'mainWindow.fxml'.";
        assert _ButtonZeigtVerdeckt != null : "fx:id=\"_ButtonZeigtVerdeckt\" was not injected: check your FXML file 'mainWindow.fxml'.";
        assert _tableNegationale != null : "fx:id=\"_tableNegationale\" was not injected: check your FXML file 'mainWindow.fxml'.";
        assert _ButtonMnachE != null : "fx:id=\"_ButtonMnachE\" was not injected: check your FXML file 'mainWindow.fxml'.";
        assert _ComboTaeter != null : "fx:id=\"_ComboTaeter\" was not injected: check your FXML file 'mainWindow.fxml'.";


        _ComboOrt.getItems().setAll(Ort.values());
        _ComboTaeter.getItems().setAll(Taeter.values());
        _ComboWaffre.getItems().setAll(Waffe.values());
        _ComboCard.getItems().addAll(Ort.values());
        _ComboCard.getItems().addAll(Taeter.values());
        _ComboCard.getItems().addAll(Waffe.values());
        _ComboSpielerup.getItems().addAll(getSpieler());
        _ComboSpielerDown.getItems().addAll(getSpieler());


        _tableEindeutigeOrt.setCellValueFactory(
                new PropertyValueFactory<FourTouple,Ort>("Ort")
        );
        _tableEindeutigeWaffe.setCellValueFactory(
                new PropertyValueFactory<FourTouple,Waffe>("Waffe")
        );
        _tableEindeutigeSpieler.setCellValueFactory(
                new PropertyValueFactory<FourTouple,Spieler>("Spieler")
        );
        _tableEindeutigeTaeter.setCellValueFactory(
                new PropertyValueFactory<FourTouple,Taeter>("Taeter")
        );

        _tableMehrdeutigeOrt.setCellValueFactory(
                new PropertyValueFactory<FourTouple,Ort>("Ort")
        );
        _tableMehrdeutigeWaffe.setCellValueFactory(
                new PropertyValueFactory<FourTouple,Waffe>("Waffe")
        );
        _tableMehrdeutigeSpieler.setCellValueFactory(
                new PropertyValueFactory<FourTouple,Spieler>("Spieler")
        );
        _tableMehrdeutigeTaeter.setCellValueFactory(
                new PropertyValueFactory<FourTouple,Taeter>("Taeter")
        );


        _tableNegationaleOrt.setCellValueFactory(
                new PropertyValueFactory<FourTouple,Ort>("Ort")
        );
        _tableNegationaleWaffe.setCellValueFactory(
                new PropertyValueFactory<FourTouple,Waffe>("Waffe")
        );
        _tableNegationaleSpieler.setCellValueFactory(
                new PropertyValueFactory<FourTouple,Spieler>("Spieler")
        );
        _tableNegationaleTaeter.setCellValueFactory(
                new PropertyValueFactory<FourTouple,Taeter>("Taeter")
        );


        _tableUebrigeTaeter.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().name()));
        _tableUebrigeOrt.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().name()));
        _tableUebrigeWaffe.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().name()));


        _tableViewEindeutige.setItems(_spiel.getSets().getEindeutig());
        _tableViewMehrdeutige.setItems(_spiel.getSets().getMehrdeutig());
        _tableViewNegationale.setItems(_spiel.getSets().getNegational());

        _tableViewUebrigOrt.setItems(_spiel.getSets().get_uebrigOrt());
        _tableViewUebrigWaffe.setItems(_spiel.getSets().get_uebrigWaffe());
        _tableViewUebrigTaeter.setItems(_spiel.getSets().get_uebrigTeater());





    }

    private void aufuellWarnung() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warnung");
        alert.setHeaderText("Die Aktion konnte nicht ausgeführt werden");
        alert.setContentText("Nicht alle nötigen Felder sind ausgefüllt");

        alert.showAndWait();
    }
}
