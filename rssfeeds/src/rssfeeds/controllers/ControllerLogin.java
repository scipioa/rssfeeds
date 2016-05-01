package rssfeeds.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import rssfeeds.ComREST;
import rssfeeds.Main;
import rssfeeds.connectStatus;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLogin extends GridPane implements Initializable {
    @FXML private TextField loginField;
    @FXML private Label badLogin;
    @FXML private PasswordField passwordField;
    @FXML private Label badPass;

    private Main application;

    public void setApp(Main application){
        this.application = application;
    }

    public ControllerLogin() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    @FXML
    protected void doLogin() {
        String login = loginField.getText();
        String password = passwordField.getText();
        boolean isOk = true;

        badPass.setVisible(false);
        badLogin.setVisible(false);

        if (login.isEmpty()) {
            badLogin.setVisible(true);
            isOk = false;
        }
        if (password.isEmpty()) {
            badPass.setVisible(true);
            isOk = false;
        }

        if (isOk) {
            ComREST req = new ComREST();
            connectStatus ret = req.connectUser(login, password);
            System.out.println(ret);
            if (ret != connectStatus.OK) {
                switch (ret) {
                    case ERR_SERVER:
                        badPass.setText("Impossible to contact the server.\nPlease try again");
                        break;
                    case ERR_BAD_LOGIN:
                        badPass.setText("Invalid login or password");
                        break;
                    default:
                        badPass.setText("Unknow error : " + ret);
                        break;
                }
                badPass.setVisible(true);
            } else {
                if (this.application != null)
                    application.goToMainWindow();
            }
        }
    }

    @FXML
    protected void goToCreate()  {
        if (application != null)
            application.goToCreate();
    }
}
