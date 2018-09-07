package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bmi_Controller
{
    private Main_Controller mainController;

    Image niedowaga = new Image("/icon/alert.png");
    Image prawidlowa = new Image("/icon/success.png");
    Image nadwaga = new Image("/icon/error.png");
    Image start = new Image("/icon/question.png");
    Image wrong = new Image("/icon/hold.png");

    double progress = 0;

    @FXML
    Label result = new Label();

    @FXML
    RadioButton woman = new RadioButton();
    @FXML
    RadioButton man = new RadioButton();

    @FXML
    TextField waga = new TextField();
    @FXML
    TextField wzrost = new TextField();

    @FXML
    ImageView imageOnScreen = new ImageView();

    @FXML
    public void oblicz()
    {
        sprawdzPoprawnosc();

        double dWaga = checkNumber(waga.getText());
        double dWzrost = checkNumber(wzrost.getText()) / 100;
        if(dWaga == 0.0 || dWzrost == 0.0)
        {
            result.setText("Błąd danych");
            imageOnScreen.setImage(wrong);
        }
        else
        {
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
                result.setText("Masz niedowagę");
                imageOnScreen.setImage(niedowaga);
            }
            else if(bmiWynik <max)
            {
                result.setText("Masz prawidłową wagę");
                imageOnScreen.setImage(prawidlowa);
            }
            else
            {
                result.setText("Masz nadwagę");
                imageOnScreen.setImage(nadwaga);
            }
        }
    }

    private void sprawdzPoprawnosc()
    {
        if(woman.isSelected() == false && man.isSelected() == false)
        {
            result.setText("Należy zaznaczyć płeć!");
        }

    }

    private static Double checkNumber(String inputText)
    {
        try {
            return Double.parseDouble(inputText);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    @FXML
    public void wyczysc()
    {
        man.setSelected(false);
        woman.setSelected(false);
        waga.setText("");
        wzrost.setText("");
        imageOnScreen.setImage(start);
        result.setText("Oblicz swoje BMI");
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
