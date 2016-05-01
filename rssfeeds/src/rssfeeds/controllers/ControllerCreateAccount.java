package rssfeeds.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import rssfeeds.ComREST;
import rssfeeds.Main;
import rssfeeds.connectStatus;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by alexa on 27/04/2016.
 */
public class ControllerCreateAccount extends GridPane implements Initializable {
    @FXML private TextField loginField;
    @FXML private PasswordField passField;
    @FXML private PasswordField passConfirmField;
    @FXML private Label badFields;

    private Main application;

    public void setApp(Main application){
        this.application = application;
    }

    public ControllerCreateAccount(){
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    protected void doCreate() {
        String login = loginField.getText();
        String pass = passField.getText();
        String passConfirm = passConfirmField.getText();

        badFields.setVisible(false);

        if (login.isEmpty()
                || pass.isEmpty()
                || passConfirm.isEmpty()) {
            badFields.setText("All fields are required");
            badFields.setVisible(true);
        } else if (!pass.equals(passConfirm)) {
            badFields.setText("Passwords are not equals");
            badFields.setVisible(true);
        } else {
            ComREST req = new ComREST();
            connectStatus ret = req.createUser(login, pass);
            System.out.println(ret);
            if (ret != connectStatus.OK) {
                switch (ret) {
                    case ERR_SERVER:
                        badFields.setText("Impossible to contact the server.\nPlease try again");
                        break;
                    case ERR_USER_ALREADY_EXIST:
                        badFields.setText("This user already exist");
                        break;
                    default:
                        badFields.setText("Unknow error : " + ret);
                        break;
                }
                badFields.setVisible(true);
            } else {
                if (this.application != null)
                    application.goToMainWindow();
            }
        }
    }

    @FXML
    protected void goToLogin()  {
        if (application != null)
            application.goToLogin();
    }
}
