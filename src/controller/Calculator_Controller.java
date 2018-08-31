package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Created $(DATE)
 */
public class Calculator_Controller
{
    /**
     * Zmienne operacyjne
     * textInFieldResult   - Tekst wyświetlany w oknie wyniku
     * operation           - Zmienna pomocna do obliczeń i wyświetlania
     * egzystencjaKropki   - Zmienna przechowująca informacje o egzystencji kropki
     */

    String textInFieldResult = "0";
    String operation;
    boolean egzystencjaKropki = false;
    boolean wynik = false;

    double liczba_1 = 0, liczba_2 = 0;

    @FXML
    private Main_Controller mainController;

    @FXML
    Label result = new Label(textInFieldResult);


    @FXML
    public void insert(ActionEvent eventKey)
    {
        Button sourceButton = (Button) eventKey.getSource();
        switch (sourceButton.getText())
        {
            case "0":{
                operation = result.getText();
                sprawdzCzyZero(operation, "0");
            }break;

            case "1":{
                operation = result.getText();
                sprawdzCzyZero(operation, "1");
            }break;

            case "2":{
                operation = result.getText();
                sprawdzCzyZero(operation,"2");
            }break;

            case "3":{
                operation = result.getText();
                sprawdzCzyZero(operation,"3");
            }break;

            case "4":{
                operation = result.getText();
                sprawdzCzyZero(operation,"4");
            }break;

            case "5":{
                operation = result.getText();
                sprawdzCzyZero(operation,"5");
            }break;

            case "6":{
                operation = result.getText();
                sprawdzCzyZero(operation,"6");
            }break;

            case "7":{
                operation = result.getText();
                sprawdzCzyZero(operation,"7");
            }break;

            case "8":{
                operation = result.getText();
                sprawdzCzyZero(operation,"8");
            }break;

            case "9":{
                operation = result.getText();
                sprawdzCzyZero(operation,"9");
            }break;

            /**
             * Wprowadzenie operacji matematycznych
             */

            case "+":{
                if(wynik)
                {
                    System.out.println("send to compute");
                    compute();
                }
                else
                {
                    wynik = true;
                    System.out.println("ChangeWynik");
                }
                System.out.println("outside");
                operation = result.getText();
                checkSign(operation.charAt(operation.length()-1),"+");
            }break;

            case "-":{
                if(wynik)
                {
                    compute();
                }
                operation = result.getText();
                checkSign(operation.charAt(operation.length()-1),"-");
            }break;

            case "*":{

                operation = result.getText();
                checkSign(operation.charAt(operation.length()-1),"*");
            }break;

            case "/":{
                operation = result.getText();
                checkSign(operation.charAt(operation.length()-1),"/");
            }break;

            case ".":{
                if(egzystencjaKropki != true && textInFieldResult.charAt(textInFieldResult.length()-1) != '/' &&
                        textInFieldResult.charAt(textInFieldResult.length()-1) != '+' &&
                        textInFieldResult.charAt(textInFieldResult.length()-1) != '-' &&
                        textInFieldResult.charAt(textInFieldResult.length()-1) != '*')
                {
                    textInFieldResult += ".";
                    result.setText(textInFieldResult);
                    egzystencjaKropki = true;
                }
            }break;
        }
    }

    public void clear()
    {
        textInFieldResult = "0";
        result.setText(textInFieldResult);
        egzystencjaKropki = false;
    }

    /**
     * Moduł obliczający
     */

    public void compute()
    {
        wynik = false;
        System.out.println("compute");
    }

    /**
     * Sprawdzenie czy w polu result znajduję sie 0
     * @param containResult
     * @param zrodlo
     */
    private void sprawdzCzyZero(String containResult, String zrodlo)
    {
        if(textInFieldResult == "0")
        {
            textInFieldResult = zrodlo;
            result.setText(textInFieldResult);
        }
        else  {
            operation += zrodlo;
            textInFieldResult = operation;
            result.setText(textInFieldResult);
        }
    }

    /**
     * Sprawdzenie ostatniego znaku i ewentualne dodanie go.
     * @param lastSign
     */

    private void checkSign(char lastSign, String sign)
    {
        if(lastSign == '.')
        {
            textInFieldResult += "0";
            result.setText(textInFieldResult);
        }
        if(lastSign != '+' && lastSign != '-' && lastSign != '*' && lastSign != '/')
        {
            egzystencjaKropki=false;
            textInFieldResult += sign;
            result.setText(textInFieldResult);
        }
    }

    /**
     * Nawigacja
     */
    @FXML
    public void wstecz()
    {
        mainController.inicjalizujMenu();
    }

    public void setMainController(Main_Controller mainController) {
        this.mainController = mainController;
    }
}
