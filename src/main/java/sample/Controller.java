package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

public class Controller implements Initializable{
    LinkedList<String> listHistory = new LinkedList<String>() {
    };
    @FXML
    public Button btSearch;

    @FXML
    public Button btAdd;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btClear.setOnMouseClicked(event -> {
            tfSearch.clear();
        });

        btAdd.setOnMouseClicked(event -> {
            try {
                Stage stage = new Stage();

                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addWindow.fxml"));
                stage.setTitle("AddController");
                stage.setScene(new Scene(root, 300, 100));
                stage.show();
            }
            catch (Exception e) {

            }
        });

        btSearch.setOnMouseClicked(event -> {
            String tmp = tfSearch.getText();
            taMean.setText(Main.dic.get(tmp));
        });

        tfSearch.setContextMenu(cmSearch);

        tfSearch.setContextMenu(cmSearch);
        tfSearch.setOnKeyTyped(keyEvent -> {
            int d = 0;
            String tmp = tfSearch.getText();
            cmSearch.getItems().clear();
            cmSearch.hide();
            for (String key : Main.dic.keySet()) {
                if (key.length() >= tmp.length() && key.substring(0, tmp.length()).equals(tmp)) {
                    d++;
                    if(d <= 5){
                        cmSearch.getItems().add(new MenuItem(key));
                    }
                }
            }
            cmSearch.show(tfSearch, Side.BOTTOM, 0, 0);
        });

        tfSearch.setOnMouseClicked(event -> {
            tfSearch.clear();
        });

        cmSearch.setOnAction(actionEvent -> {
            String s = ((MenuItem) actionEvent.getTarget()).getText();
            tfSearch.setText(s);
            taMean.setText(Main.dic.get(s));
            listHistory.addFirst(s);
            lvHistory.getItems().clear();

            lvHistory.getItems().addAll(listHistory);
        });

        btVoice.setOnMouseClicked(event -> {
            try {
                String old_text = btVoice.getText();
                btVoice.setDisable(false);
                GoogleUtilities.speak(taMean.getText(), "vi-VN", "tmp/output.mp3");
                btVoice.setDisable(false);
                btVoice.setText(old_text);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


}

