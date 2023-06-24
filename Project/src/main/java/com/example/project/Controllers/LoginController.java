package com.example.project.Controllers;

import com.example.project.Useless.Login_model;
import com.example.project.Useless.PasswordMismatchException;
import com.example.project.Useless.UsernameNotFoundException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController implements Initializable {
    public Login_model loginModel = new Login_model();


    @FXML
    private Button sign_in_button;
    @FXML
    private TextField txt_username;
    @FXML
    private TextField txt_password_visible;
    @FXML
    private PasswordField txt_password_hidden;
    @FXML
    private RadioButton shoe_Pass_button;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sign_in_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            }
        });
    }

    public void CheckVisibility(ActionEvent event) {
        if (shoe_Pass_button.isSelected()) {
            txt_password_visible.setText(txt_password_hidden.getText());
            txt_password_visible.setVisible(true);
            txt_password_hidden.setVisible(false);
            return;
        }
        txt_password_hidden.setText(txt_password_visible.getText());
        txt_password_hidden.setVisible(true);
        txt_password_visible.setVisible(false);
    }
}