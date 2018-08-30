package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Main_Controller
{
    @FXML
    private StackPane mainStackPane;

    @FXML
    public void initialize()
    {
        inicjalizujMenu();
    }

    public void inicjalizujMenu()
    {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/layout/main_menu.fxml"));
        try {
            Pane gridPane = loader.load();
            Main_Menu_Controller mainMenuController = loader.getController();
            mainMenuController.setMainController(this);
            mainStackPane.getChildren().clear();
            mainStackPane.getChildren().add(gridPane);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setScreen(Pane pane) {
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(pane);
    }
}
