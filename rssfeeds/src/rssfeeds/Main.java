package rssfeeds;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import rssfeeds.controllers.ControllerCreateAccount;
import rssfeeds.controllers.ControllerLogin;
import rssfeeds.controllers.ControllerMainWindow;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.stage = primaryStage;
        goToLogin();
        primaryStage.show();
    }

    public void goToCreate() {
        try {
            ControllerCreateAccount createAccount = (ControllerCreateAccount) replaceSceneContent("resources/createAccount.fxml");
            stage.setTitle("Rss Feeds Aggregator - Create Account");
            createAccount.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void goToLogin() {
        try {
            ControllerLogin login = (ControllerLogin) replaceSceneContent("resources/login.fxml");
            stage.setTitle("Rss Feeds Aggregator - Login");
            login.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void goToMainWindow() {
        try {
            ControllerMainWindow mainWindow = (ControllerMainWindow) replaceSceneContent("resources/mainwindow.fxml");
            stage.setTitle("Rss Feeds Aggregator");
            mainWindow.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        Parent page;
        try {
            page = (Parent) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, 1200, 600);
        this.stage.setScene(scene);
        this.stage.sizeToScene();
        return (Initializable) loader.getController();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
