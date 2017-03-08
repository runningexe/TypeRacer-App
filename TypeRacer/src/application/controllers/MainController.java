package application.controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * Created by RunningEXE on 3/2/2017.
 */
public class MainController implements Initializable {

    @FXML
    private Label lblUsername;

    @FXML
    private JFXTextField txtWords;

    @FXML
    private TextArea lblWordsToType;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TrackWords();
    }

    public void TrackWords() {

        /*Create array of words from sentence/paragraph*/
        String trackParagraph = lblWordsToType.getText();
        String[] words = trackParagraph.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^\\w]", "");
        }

        /*If the word entered in the textfield matches an index in the array, do something*/
        txtWords.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(Arrays.toString(words));
            }
        });
    }


    public void GetUser(String user) {
        lblUsername.setText("Welcome, " + user + "!");
    }

    public void SignOut(ActionEvent event) {

        ((Node) event.getSource()).getScene().getWindow().hide();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/login.fxml"));
        Pane pane = null;
        try {
            pane = (Pane) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Type Racer");
        stage.setScene(new Scene(pane));
        stage.show();
    }
}
