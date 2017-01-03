package com.EniacDevelopment.Configuration_Application.View;

import com.EniacDevelopment.Configuration_Application.Application;
import com.EniacDevelopment.Configuration_Application.Model.Sensors.Sensor;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDateTime;

/**
 * Created by nickd on 01/02/2017.
 */
public class Sensor_Edit_Dialog_Controller {
    @FXML
    private TextField sensor_name;
    @FXML
    private ChoiceBox<Sensor.Sensor_Type> sensor_type = new ChoiceBox<>();
    @FXML
    private ChoiceBox<Sensor.Sensor_Status> sensor_status = new ChoiceBox<>();

    @FXML
    private Button ok_button;
    @FXML
    private Button cancel_button;

    private Stage dialog_stage;
    private Sensor sensor;
    private Sensor_Controller controller;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        sensor_type.getItems().setAll(Sensor.Sensor_Type.values());
        sensor_status.getItems().setAll(Sensor.Sensor_Status.values());

        set_sensor(Sensor_Controller.get_selected_Sensor());
    }

    /**
     * Sets the stage of this dialog.
     */
    public void set_dialog_stage(Stage dialog_stage) {
        this.dialog_stage = dialog_stage;
    }

    /**
     * Sets the Sensor to be edited in the dialog
     * */
    public void set_sensor(Sensor sensor){
        this.sensor = sensor;

        this.sensor_name.setText(sensor.get_Sensor_name());
        this.sensor_type.getSelectionModel().select(sensor.get_Sensor_type());
        this.sensor_status.getSelectionModel().select(sensor.get_Sensor_status());
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handle_ok() {
        if(is_input_valid()){
            sensor.set_Sensor_name(this.sensor_name.getText());
            sensor.set_Sensor_status(this.sensor_status.getValue());
            sensor.set_Sensor_type(this.sensor_type.getValue());
            sensor.set_Sensor_update_time(LocalDateTime.now());
            sensor.set_Sensor_value(0);
            sensor.set_Sensor_signal_status(Sensor.Sensor_Signal_Status.Invallid);



            Scene_Navigator.load_Scene(Scene_Navigator.SENSOR);
            Stage_Navigator.close_stage();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handle_cancel() {
        Stage_Navigator.close_stage();
    }

    /**
     * Validates the user input in the text fields.
     */
    private boolean is_input_valid(){
        String error_message = "";

        if(this.sensor_name.getText() == null || this.sensor_name.getText().length() == 0){
            error_message += "No valid sensor name!\n";
        }

        if (error_message.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialog_stage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(error_message);

            alert.showAndWait();

            return false;
        }
    }
}
