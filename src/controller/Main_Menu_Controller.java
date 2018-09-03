package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 * Created $(DATE)
 */
public class Main_Menu_Controller
{

    private Main_Controller mainController;

    /**
     * Nawigacja
     */
    @FXML
    public void kalkulator()
    {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/layout/calculator.fxml"));

        try {
            Pane pane = loader.load();
            Calculator_Controller calcController = loader.getController();
            calcController.setMainController(mainController);
            mainController.setScreen(pane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void paliwomierz()
    {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/layout/paliwomierz.fxml"));

        try {
            Pane pane = loader.load();
            Paliwometer_Controller palController = loader.getController();
            palController.setMainController(mainController);
            mainController.setScreen(pane);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void waluty()
    {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/layout/waluty.fxml"));

        try {
            Pane pane = loader.load();
            Waluty_Controller walController = loader.getController();
            walController.setMainController(mainController);
            mainController.setScreen(pane);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void wyjscie()
    {
        System.exit(0);
    }

    /**
     * Setery
     * @param mainController
     */
    public void setMainController(Main_Controller mainController) {
        this.mainController = mainController;
    }

}
