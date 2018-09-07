package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * Created $(DATE)
 */
public class Waluty_Controller
{
    private Main_Controller mainController;

    @FXML
    RadioButton euroToZloty = new RadioButton();
    @FXML
    RadioButton zlotyToEuro = new RadioButton();
    @FXML
    RadioButton dolarToZloty = new RadioButton();
    @FXML
    RadioButton zlotyToDolar = new RadioButton();
    @FXML
    RadioButton funtToZloty = new RadioButton();
    @FXML
    RadioButton zlotyToFunt = new RadioButton();

    @FXML
    TextField inputText = new TextField();

    @FXML
    Label currency = new Label();
    @FXML
    Label result = new Label();

    double kurs = 0.0;
    double amount = 0.0;
    String targetCurrency ="";

    @FXML
    public void compute()
    {
        amount = checkCorrect(inputText.getText());
        if(amount == 0.0 || kurs == 0.0)
        {
            result.setText("Błędne dane!");
        }
        else
        {
            amount = (amount * kurs) * 100;
            amount = Math.round(amount);
            amount = amount / 100;

            result.setText(Double.toString(amount) + " " + targetCurrency);
        }
    }

    @FXML
    private void setRate(ActionEvent eventKey)
    {
        RadioButton source = (RadioButton) eventKey.getSource();

        switch(source.getText())
        {
            case "Euro / Złoty": {
                kurs = 4.3;
                currency.setText("€");
                targetCurrency = "Zł";
            }break;
            case "Złoty / Euro": {
                kurs = 0.23;
                currency.setText("Zł");
                targetCurrency = "€";
            }break;
            case "Dolar / Złoty":{
                kurs = 3.7;
                currency.setText("$");
                targetCurrency = "Zł";
            }break;
            case "Złoty / Dolar":{
                kurs = 0.27;
                currency.setText("Zł");
                targetCurrency = "$";
            }break;
            case "Funt / Złoty":{
                kurs = 4.8;
                currency.setText("£");
                targetCurrency = "Zł";
            }break;
            case "Złoty / Funt":{
                kurs = 0.2;
                currency.setText("Zł");
                targetCurrency = "£";
            }break;
            default:{
                kurs = 0.0;
            }
        }
    }

    private Double checkCorrect(String inputText)
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
