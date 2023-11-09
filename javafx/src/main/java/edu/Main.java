package edu;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class Main extends javafx.application.Application {
    // Declare an array of Strings for flag titles
    private String[] cityTitles = { "Ha Noi", "Hai Phong",
            "Nha Trang", "Thua Thien-Hue", "Ho Chi Minh City"};

    // Declare an ImageView array for the national flags of 9 countries
    private javafx.scene.image.ImageView[] cityImage = { 
        new javafx.scene.image.ImageView("edu\\Image\\hanoi.jpg"),
            new javafx.scene.image.ImageView("edu\\Image\\haiphong.jpg"),
            new javafx.scene.image.ImageView("edu\\Image\\nhatrang.jpg"),
            new javafx.scene.image.ImageView("edu\\Image\\tth.jpg"),
            new javafx.scene.image.ImageView("edu\\Image\\hcm.jpg")};

    // Declare an array of strings for flag descriptions
    private String[] cityDescription = new String[5];

    // Declare and create a description pane
    private DescriptionPane descriptionPane = new DescriptionPane();

    // Create a combo box for selecting countries
    private javafx.scene.control.ComboBox<String> cbo = new javafx.scene.control.ComboBox<>(); // cityTitles;

    @Override // Override the start method in the Application class
    public void start(javafx.stage.Stage primaryStage) {
        // Set text description
        cityDescription[0] = "Thu do Ha Noi ... ";
        cityDescription[1] = "Doang Doang ... ";
        cityDescription[2] = "Nem nuong no1... ";
        cityDescription[3] = "Bun bo hue ... ";
        cityDescription[4] = "Never been here before ... ";

        // Set the first country (Canada) for display
        setDisplay(0);

        // Add combo box and description pane to the border pane
        javafx.scene.layout.BorderPane pane = new javafx.scene.layout.BorderPane();

        javafx.scene.layout.BorderPane paneForComboBox = new javafx.scene.layout.BorderPane();
        paneForComboBox.setLeft(new javafx.scene.control.Label("Select a city: "));
        paneForComboBox.setCenter(cbo);
        pane.setTop(paneForComboBox);
        cbo.setPrefWidth(400);
        cbo.setValue("Ha Noi");

        javafx.collections.ObservableList<String> items = javafx.collections.FXCollections.observableArrayList(cityTitles);
        cbo.getItems().addAll(items);
        pane.setCenter(descriptionPane);

        // Display the selected country
        cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue())));
        // Create a scene and place it in the stage
        javafx.scene.Scene scene = new javafx.scene.Scene(pane, 1400, 700);
        primaryStage.setTitle("ComboBoxDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /** Set display information on the description pane */
    public void setDisplay(int index) {
        descriptionPane.setTitle(cityTitles[index]);
        descriptionPane.setImageView(cityImage[index]);
        descriptionPane.setDescription(cityDescription[index]);
    }

    public static void main(String[] args){
        launch(args);
    }
}