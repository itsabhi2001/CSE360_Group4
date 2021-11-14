package com.example.phase3;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.Console;
import java.io.IOException;
import java.sql.*;

public class VitalsController {
    @FXML
    private TextField Height;
    @FXML
    private TextField Weight;
    @FXML
    private TextField Temperature;
    @FXML
    private TextField Bloodpressure;
    @FXML
    private TextArea Prescription;
    @FXML
    private TextArea Notes;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    public void Submit_OnClick(ActionEvent event) throws IOException, SQLException {
        String heightField = Height.getText();
        String weightField = Weight.getText();
        String bodyTemperatureField = Temperature.getText();
        String bloodPressureField = Bloodpressure.getText();
        String prescriptionField = Prescription.getText();
        String notesField = Notes.getText();
        DatabaseConnection connectionClass = new DatabaseConnection();
        Connection connection = connectionClass.getConnection();

        String sql = "INSERT INTO vitals VALUES('" + heightField + "', '" + weightField + "', '" + bodyTemperatureField + "', '" + bloodPressureField + "', '" + notesField + "', '" + prescriptionField + "')";
        //String sql = "select count(1) from patientlogin where firstName = '" + userField + "' AND lastName = '" + passwordField + "'";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        //ResultSet queryResult = statement.executeQuery(sql);

    }
    @FXML
    public void go_OnClick(ActionEvent event) throws IOException, SQLException {
        root = FXMLLoader.load(getClass().getResource("PatientVitalsDoctorView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}