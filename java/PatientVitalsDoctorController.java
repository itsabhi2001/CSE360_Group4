package com.example.phase3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class PatientVitalsDoctorController {
    @FXML
    private Label height;
    @FXML
    private Label weight;
    @FXML
    private Label temperature;
    @FXML
    private Label pressure;
    @FXML
    private Label notes;
    @FXML
    private Label prescription;

    public void Load_OnClick(ActionEvent event) throws IOException, SQLException {

        String patientID = "4";
        DatabaseConnection connectionClass = new DatabaseConnection();
        Connection connection = connectionClass.getConnection();

        //String sql = "INSERT INTO vitals VALUES('" + heightField + "', '" + weightField + "', '" + bodyTemperatureField + "', '" + bloodPressureField + "', '" + notesField + "', '" + prescriptionField + "')";
        String sql = "select height, weight, bodytemperature, bloodpressure, notes, prescription from vitals where patientID = '" + patientID + "'";
        Statement statement = connection.createStatement();
        //statement.executeUpdate(sql);
        ResultSet queryResult = statement.executeQuery(sql);
        while(queryResult.next())
        {
            height.setText(String.valueOf(queryResult.getInt(1)));
            weight.setText(String.valueOf(queryResult.getInt(2)));
            temperature.setText(String.valueOf(queryResult.getInt(3)));
            pressure.setText(String.valueOf(queryResult.getInt(4)));
            notes.setText(String.valueOf(queryResult.getInt(5)));
            prescription.setText(String.valueOf(queryResult.getInt(6)));
        }

    }
}
