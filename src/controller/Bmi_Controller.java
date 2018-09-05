package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created $(DATE)
 */
public class Bmi_Controller
{
    private Main_Controller mainController;

    Image niedowaga = new Image("/icon/alert.png");
    Image prawidlowa = new Image("/icon/success.png");
    Image nadwaga = new Image("/icon/error.png");

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
    ImageView imageOnScreen = new ImageView();

    @FXML
    public void oblicz()
    {
        komunikat.setText("");
        sprawdzPoprawnosc();

        double dWaga = Double.parseDouble(waga.getText());
        double dWzrost = Double.parseDouble(wzrost.getText()) / 100;
        double bmiWynik;
        dWzrost *= dWzrost;
        bmiWynik = dWaga / dWzrost;

        double min = 18;
        double max = 25;

        if(man.isSelected())
        {
            min = 19.3;
            max = 26.2;
        }
        else if(woman.isSelected())
        {
            min = 15.6;
            max = 24.7;
        }

        if(bmiWynik < min)
        {
            System.out.println("Masz niedowagę");
            imageOnScreen.setImage(niedowaga);
        }
        else if(bmiWynik <max)
        {
            System.out.println("Masz prawidłową wagę");
            imageOnScreen.setImage(prawidlowa);
        }
        else
        {
            System.out.println("Masz nadwagę");
            imageOnScreen.setImage(nadwaga);
        }
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
