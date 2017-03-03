package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by RunningEXE on 3/2/2017.
 */
public class MainController implements Initializable {

    @FXML
    private Label lblUsername;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void GetUser(String user){
        lblUsername.setText("Welcome, " + user + "!");
    }

    public void SignOut(ActionEvent event){

        ((Node)event.getSource()).getScene().getWindow().hide();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/login.fxml"));
        Pane pane = null;
        try {
            pane = (Pane) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Yeeeeeeaaaahh boiiiiiiiiii");
        stage.setScene(new Scene(pane));
        stage.show();
    }
}
