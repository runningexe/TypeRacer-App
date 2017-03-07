package application.controllers;

import application.LoginMain;
import application.models.LoginModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by RunningEXE on 3/1/2017.
 */
public class LoginController implements Initializable {

    private LoginMain loginMain = new LoginMain();
    public LoginModel loginModel = new LoginModel();

    @FXML
    private Label isConnected;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnLogin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (loginModel.isDbConnected()) {
            isConnected.setText("Connected");
        } else {
            isConnected.setText("Not Connected");
        }
    }

    public void Login(ActionEvent event) {
        try {
            if (loginModel.isLogin(txtUsername.getText(), txtPassword.getText())) {
                isConnected.setText("Login Successful!");

                ((Node)event.getSource()).getScene().getWindow().hide();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/mainview.fxml"));
                Pane pane = (Pane) fxmlLoader.load();
                Stage stage = new Stage();
                MainController mainController = (MainController) fxmlLoader.getController();
                mainController.GetUser(txtUsername.getText());
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Type Racer");
                stage.setScene(new Scene(pane));
                stage.show();

            } else {
                isConnected.setText("Username and Password Incorrect.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
