package edu;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class Listview extends Application {
    // Declare an array of Strings for flag titles
    private String[] flagTitles = { "Ha Noi", "Hai Phong",
    "Nha Trang", "Thua Thien-Hue", "Ho Chi Minh City"};

    // Declare an ImageView array for the national flags of 9 countries
    private ImageView[] ImageViews = {
        new javafx.scene.image.ImageView("edu\\Image\\hanoi.jpg"),
            new javafx.scene.image.ImageView("edu\\Image\\haiphong.jpg"),
            new javafx.scene.image.ImageView("edu\\Image\\nhatrang.jpg"),
            new javafx.scene.image.ImageView("edu\\Image\\tth.jpg"),
            new javafx.scene.image.ImageView("edu\\Image\\hcm.jpg")};

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        ListView<String> lv = new ListView<>(FXCollections.observableArrayList(flagTitles));
        lv.setPrefSize(200, 400);
        lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // Create a pane to hold image views
        FlowPane imagePane = new FlowPane(10, 10);
        BorderPane pane = new BorderPane();
        pane.setLeft(new ScrollPane(lv));
        pane.setCenter(imagePane);

        lv.getSelectionModel().selectedItemProperty().addListener(
                ov -> {
                    imagePane.getChildren().clear();
                    for (Integer i : lv.getSelectionModel().getSelectedIndices()) {
                        imagePane.getChildren().add(ImageViews[i]);
                    }
                });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 1400, 700);
        primaryStage.setTitle("ListViewDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args){
        launch(args);
    }    
}