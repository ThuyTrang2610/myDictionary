package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.TreeMap;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));
        primaryStage.setTitle("Dictionary");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public static TreeMap<String, String> dic = new TreeMap<String, String>();
    public static void main(String[] args) {

        dic.put("hi", "chào");
        dic.put("high", "cao");
        dic.put("highlight", "Điểm nổi bật");
        dic.put("hi1", "chào");
        dic.put("high1", "cao");
        dic.put("highlight1", "Điểm nổi bật");
        launch(args);


    }
}
