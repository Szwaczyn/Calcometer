package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * To DO
 *
 * Sprawdzanie poprawnosci wprowadzonych danych
 */
public class Paliwometer_Controller
{

    private Main_Controller mainController;

    @FXML
    TextField ilosc_kilometrow = new TextField();
    @FXML
    TextField srednie_spalanie = new TextField();
    @FXML
    TextField cena_paliwa = new TextField();

    @FXML
    TextField budzet = new TextField();
    @FXML
    TextField srednie_spalanie_2 = new TextField();
    @FXML
    TextField cena_paliwa_2 = new TextField();

    @FXML
    Label wynik = new Label("Wynik");

    @FXML
    public void obliczKoszt()
    {
        sprawdzPoprawnosc();
        double iloscKilometrowInt = Integer.parseInt(ilosc_kilometrow.getText());
        double srednieSpalanieInt = Integer.parseInt(srednie_spalanie.getText());
        double cenaPaliwaInt = Integer.parseInt(cena_paliwa.getText());

        double obliczenia = srednieSpalanieInt / 100 * cenaPaliwaInt * iloscKilometrowInt;
        obliczenia *= 100;
        obliczenia = Math.round(obliczenia);
        obliczenia /= 100;

        wynik.setText("Koszt podróży: " + obliczenia + " zł");
    }

    @FXML
    public void iloscKilometrow()
    {
        double budzetD = Double.parseDouble(budzet.getText());
        double srednieSpalanieD = Double.parseDouble(srednie_spalanie_2.getText());
        double cenaPaliwaD = Double.parseDouble(cena_paliwa_2.getText());

        wynik.setText("Ilosc kilometrow: " + Math.round(budzetD / (srednieSpalanieD / 100 * cenaPaliwaD)) + " km");
    }

    /**
     * To Do
     */

    private void sprawdzPoprawnosc()
    {

    }

    @FXML
    public void wstecz()
    {
        mainController.inicjalizujMenu();
    }

    public void setMainController(Main_Controller mainController) {
        this.mainController = mainController;
    }

}
