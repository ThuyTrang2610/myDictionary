package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    public Button btSearch;

    @FXML
    public Button btClear;
    @FXML
    public TextField tfSearch;

    @FXML
    public TextArea tasuggest;

    @FXML
    public TextArea taMean;

    @FXML
    public ContextMenu cmSearch;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btClear.setOnMouseClicked(event -> {
            tfSearch.clear();
        });

       btSearch.setOnMouseClicked(event -> {
            String tmp = tfSearch.getText();
            taMean.setText(Main.dic.get(tmp));
        });

        tfSearch.setContextMenu(cmSearch);
        tfSearch.setOnKeyTyped(keyEvent -> {
            String tmp = tfSearch.getText();
            MenuItem a = new MenuItem(tmp);
            cmSearch.getItems().add(a);
            cmSearch.show(tfSearch, Side.BOTTOM, 0, 0);
        });
    }


}

