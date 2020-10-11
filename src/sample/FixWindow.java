package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Main;

import java.lang.management.BufferPoolMXBean;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class FixWindow implements Initializable {

    @FXML
    public TextField tfword;

    @FXML
    public TextField tfMeam;

    @FXML
    public Button btConfirm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        btConfirm.setOnMouseClicked(event -> {
            String sWord = tfword.getText();
            String sMean = tfMeam.getText();
            Main.dic.put(sWord, sMean);
            ((Stage) btConfirm.getScene().getWindow()).close();
        });
    }
}
