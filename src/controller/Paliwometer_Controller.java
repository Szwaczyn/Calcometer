package controller;

import javafx.fxml.FXML;

/**
 * Created $(DATE)
 */
public class Paliwometer_Controller
{

    private Main_Controller mainController;

    @FXML
    public void wstecz()
    {
        mainController.inicjalizujMenu();
    }

    public void setMainController(Main_Controller mainController) {
        this.mainController = mainController;
    }

}
