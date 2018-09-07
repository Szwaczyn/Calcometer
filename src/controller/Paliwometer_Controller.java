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
        double iloscKilometrowInt = sprawdzPoprawnosc(ilosc_kilometrow.getText());
        double srednieSpalanieInt = sprawdzPoprawnosc(srednie_spalanie.getText());
        double cenaPaliwaInt = sprawdzPoprawnosc(cena_paliwa.getText());

        if(iloscKilometrowInt == 0.0 || srednieSpalanieInt == 0.0 || cenaPaliwaInt == 0.0)
        {
            wynik.setText("Błędna wartość");
        }
        else
        {
            double obliczenia = srednieSpalanieInt / 100 * cenaPaliwaInt * iloscKilometrowInt;
            obliczenia *= 100;
            obliczenia = Math.round(obliczenia);
            obliczenia /= 100;

            wynik.setText("Koszt podróży: " + obliczenia + " zł");
        }
    }

    @FXML
    public void iloscKilometrow()
    {
        double budzetD = sprawdzPoprawnosc(budzet.getText());
        double srednieSpalanieD = sprawdzPoprawnosc(srednie_spalanie_2.getText());
        double cenaPaliwaD = sprawdzPoprawnosc(cena_paliwa_2.getText());

        if(budzetD == 0.0 || srednieSpalanieD == 0.0 || cenaPaliwaD == 0.0)
        {
            wynik.setText("Błędna wartość");
        }
        else
        {
            wynik.setText("Ilosc kilometrow: " + Math.round(budzetD / (srednieSpalanieD / 100 * cenaPaliwaD)) + " km");
        }
    }

    /**
     * To Do
     */

    private Double sprawdzPoprawnosc(String inputText)
    {
        try {
            return Double.parseDouble(inputText);
        } catch (NumberFormatException e) {
            return 0.0;
        }
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
