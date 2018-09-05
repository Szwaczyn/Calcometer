package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * Created $(DATE)
 */
public class Bmi_Controller
{
    private Main_Controller mainController;

    @FXML
    RadioButton woman = new RadioButton();
    @FXML
    RadioButton man = new RadioButton();

    @FXML
    TextField waga = new TextField();
    @FXML
    TextField wzrost = new TextField();

    @FXML
    Label komunikat = new Label();

    @FXML
    public void oblicz()
    {
        sprawdzPoprawnosc();
    }

    private void sprawdzPoprawnosc()
    {
        if(woman.isSelected() == false && man.isSelected() == false)
        {
            komunikat.setText("Należy zaznaczyć płeć!");
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
