package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    public Button btSearch;

    @FXML
    public Button btclear;
    @FXML
    public TextField tfSearch;

    @FXML
    public TextArea tasuggest;

    @FXML
    public TextArea taMean;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btclear.setOnMouseClicked(mouseEvent -> {
            tfSearch.clear();
        });

        btSearch.setOnMouseClicked(this::handle);

    }

    public void handle(MouseEvent mouseEvent) {
        tfSearch.clear();// xoa van ban
        String tmp = tfSearch.getText();

    }
}

