package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage primaryStage;
    private BorderPane rootLayout;

    public static BorderPane getMazeLayout() {
        return mazeLayout;
    }

    public static void setMazeLayout(BorderPane mazeLayout) {
        Main.mazeLayout = mazeLayout;
    }

    private static BorderPane mazeLayout;

    public BorderPane getRootLayout() {
        return rootLayout;
    }

    public void setRootLayout(BorderPane rootLayout) {
        this.rootLayout = rootLayout;
    }


//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        this.primaryStage = primaryStage;
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 800, 800));
//        primaryStage.show();
//    }

    @Override
    public void start(Stage primaryStage) {
        Main.primaryStage = primaryStage;
        Main.primaryStage.setTitle("Bomberman");

        initRootLayout();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Menu.fxml"));
            rootLayout = (BorderPane) loader.load();
            rootLayout.getChildren().addAll(getOverlay());
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout, 800, 800);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Pane getOverlay() {
        StackPane p = new StackPane();
        Rectangle r = RectangleBuilder.create()
                .height(1000).width(1000)
                .arcHeight(40).arcWidth(40)
                .stroke(Color.RED)
                .fill(Color.web("red", 0.1))
                .build();

        Text txt= TextBuilder.create().text("Overlay")
                .font(Font.font("Arial", FontWeight.BOLD, 18))
                .fill(Color.BLUE)
                .build();
        p.getChildren().addAll(r, txt);
        return p;
    }

    /**
     * Returns the main stage.
     *
     * @return
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    public static void setPrimaryStage(Stage stage){
        primaryStage = stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}