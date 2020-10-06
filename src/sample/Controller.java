package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    public Button btSearch;

    @FXML
    public TextField tfSearch;

    @FXML
    public TextField tfHistory;

    @FXML
    public TextArea taMean;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btSearch.setOnMouseClicked(mouseEvent -> {
            String tmp = tfSearch.getText();
            taMean.setText(Main.dic.get(tmp));
        });
    }
}