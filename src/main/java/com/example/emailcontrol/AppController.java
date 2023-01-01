package com.example.emailcontrol;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AppController {


    @FXML
    private TextField emailField;

    @FXML
    private Label emailLabel;

    @FXML
    private TextField passwordField;

    @FXML
    private Label passwordLabel;


    MailControl mail = new MailControl();

    @FXML
    protected void onControlButtonClick() {
        if (mail.obMail(emailField.getText())) {
            emailLabel.setText("girişiniz başarılı");
            passwordLabel.setText("password giriniz");
        } else {
            emailLabel.setText("tekrar giriniz");
            emailField.setText("");
        }
    }

    @FXML
    protected void onPasswordButtonClick() {
        if (mail.obPassword(passwordField.getText())) {
            passwordLabel.setText("girişiniz başarılı");
            infoBox("Hoş geldiniz",emailField.getText(),"Başarı ile giriş yaptınız");
        } else {
            passwordLabel.setText("tekrar giriniz");
            passwordField.setText("");
        }
    }
    public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }


}