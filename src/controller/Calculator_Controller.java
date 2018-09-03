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
    int dlugoscPierwszejLiczby;
    char sign = '|';

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
                if(wynik == false)
                {
                    sign = '+';
                    inputVar();
                }
                else
                {
                    liczba_2 = Double.parseDouble(textInFieldResult.substring(dlugoscPierwszejLiczby, textInFieldResult.length()));
                    computeArgs();
                    sign = '+';
                    inputVar();
                }
            }break;

            case "-":{
                if(wynik == false)
                {
                    sign = '-';
                    inputVar();
                }
                else
                {
                    liczba_2 = Double.parseDouble(textInFieldResult.substring(dlugoscPierwszejLiczby, textInFieldResult.length()));
                    computeArgs();
                    sign = '-';
                    inputVar();
                }
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



    /**
     * Moduł obliczający
     *  ---------------------------- Do zrobienia --------------------------------
     */

    public void computeArgs()
    {
        double wynikObliczen = 0;
        switch (sign)
        {
            case '+':{
                wynikObliczen = liczba_1 + liczba_2;
                textInFieldResult = Double.toString(wynikObliczen);
                result.setText(textInFieldResult);
                wynik = false;
            }break;
            case '-':{
                wynikObliczen = liczba_1 - liczba_2;
                textInFieldResult = Double.toString(wynikObliczen);
                result.setText(textInFieldResult);
                wynik = false;
            }break;
            case '/':{
                if(liczba_2 != 0)
                {
                    wynikObliczen = liczba_1 / liczba_2;
                    textInFieldResult = Double.toString(wynikObliczen);
                    result.setText(textInFieldResult);
                    wynik = false;
                }
                else
                {
                    textInFieldResult = "0";
                    result.setText(textInFieldResult);
                    wynik = false;
                    liczba_2 = 0;
                    liczba_1 = 0;
                    System.out.println("ok");
                }

            }break;
            case '*':{
                wynikObliczen = liczba_1 * liczba_2;
                textInFieldResult = Double.toString(wynikObliczen);
                result.setText(textInFieldResult);
                wynik = false;
            }break;
        }
    }

    // ---------------------------------- Działające ----------------------------------

    /**
     * Metoda wprowadzkaca liczby do zmiennych
     */

    public void inputVar()
    {
        dlugoscPierwszejLiczby = textInFieldResult.length();
        liczba_1 = Double.parseDouble(textInFieldResult);
        textInFieldResult += sign;
        result.setText(textInFieldResult);
        wynik = true;
    }

    /**
     * Funkcja przycisku "C"
     */
    public void clear()
    {
        textInFieldResult = "0";
        result.setText(textInFieldResult);
        egzystencjaKropki = false;
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
