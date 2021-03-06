package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import Dictionary.*;

public class AddController implements Initializable {
    @FXML
    public TextField newWord;

    @FXML
    public TextField meaning;

    @FXML
    public Button confirm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        WordManager wordManager = new WordManager();

        confirm.setOnMouseClicked(event -> {
            String s1 = newWord.getText();
            String s2 = meaning.getText();

            wordManager.addWord(s1, s2);

            Main.dic.put(s1, s2);
            ((Stage) confirm.getScene().getWindow()).close();
        });

    }
}
