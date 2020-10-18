package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.Stack;

import Dictionary.*;

public class Controller implements Initializable {
    Word activeWord = new Word();

    WordManager wordManager = new WordManager();

    LinkedList<String> listHistory = new LinkedList<String>() {
    };
    @FXML
    public Button btSearch;

    @FXML
    public Button btAdd;

    @FXML
    public Button btFix;

    @FXML
    public Button btClear;

    @FXML
    public Button btVoice;

    @FXML
    public TextField tfSearch;

    @FXML
    public ListView<String> lvHistory;

    @FXML
    public TextArea taMean;

    @FXML
    public ContextMenu cmSearch;

    private void searchWord(String word) {
        String definition = wordManager.getWordDefinition(word);
        this.activeWord.setWord(word);
        this.activeWord.setDefinition(definition);
        taMean.setText(definition);
        listHistory.addFirst(word);
        lvHistory.getItems().clear();
        lvHistory.getItems().addAll(listHistory);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // add word
        btAdd.setOnMouseClicked(event -> {
            try {
                Stage stage = new Stage();

                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addWindow.fxml"));
                stage.setTitle("AddController");
                stage.setScene(new Scene(root, 300, 100));
                stage.show();
            } catch (Exception e) {
                System.out.println(e);
            }
        });

        // change word definition
        btFix.setOnMouseClicked(event -> {
            try {
                btFix.setDisable(true);

                String newDefinition = taMean.getText();
                wordManager.updateWordDefinition(activeWord.getWord(), newDefinition);
                btFix.setDisable(false);

            } catch (Exception e) {

            }
        });

        btSearch.setOnMouseClicked(event -> {
            String query = tfSearch.getText();
            this.searchWord(query);
        });


        tfSearch.setContextMenu(cmSearch);

        tfSearch.setOnKeyPressed(keyEvent -> {
            String tmp = tfSearch.getText();

            cmSearch.getItems().clear();
            cmSearch.hide();

            int d = 0;

            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                this.searchWord(tmp);
            }

            for (String key : Main.dic.keySet()) {
                if (key.length() >= tmp.length() && key.substring(0, tmp.length()).equals(tmp)) {
                    d++;
                    if (d <= 5) {
                        cmSearch.getItems().add(new MenuItem(key));
                    }
                }
            }

            cmSearch.show(tfSearch, Side.BOTTOM, 0, 0);

        });

        tfSearch.setOnMouseClicked(event -> {
            tfSearch.clear();
            taMean.clear();
            activeWord.reset();
        });

        btVoice.setOnMouseClicked(event -> {
            try {
                String old_text = btVoice.getText();
                btVoice.setDisable(false);
                GoogleUtilities.speak(this.activeWord.getWord(), "en-GB", "output.mp3");
                btVoice.setDisable(false);
                btVoice.setText(old_text);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        lvHistory.setOnMouseClicked(event -> {
            String s = lvHistory.getSelectionModel().getSelectedItem();
            this.searchWord(s);
        });
    }


}

