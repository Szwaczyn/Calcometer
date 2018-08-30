package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.awt.event.ActionEvent;

/**
 * Created $(DATE)
 */
public class Calculator_Controller
{

    @FXML
    private Main_Controller mainController;

    @FXML
    public void insert()
    {
        System.out.println("ok");
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
