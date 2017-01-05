package com.EniacDevelopment.Configuration_Application.Controller;

import com.EniacDevelopment.Configuration_Application.util.Stage_Navigator;
import com.EniacDevelopment.Configuration_Application.util.Date_to_String;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDateTime;
import java.util.Optional;

import com.EniacDevelopment.Configuration_Application.Application;
import com.EniacDevelopment.Configuration_Application.Model.Sensors.Sensor;
import com.EniacDevelopment.Configuration_Application.Model.Sensors.Sensor_List;

import javafx.stage.StageStyle;

/**
 * Created by nickd on 12/29/2016.
 */
public class Sensor_Controller {
    @FXML
    private TableView<Sensor> sensor_table;
    @FXML
    private TableColumn<Sensor, String> sensor_type_column;
    @FXML
    private TableColumn<Sensor, String> sensor_name_column;

    @FXML
    private Label sensor_type;
    @FXML
    private Label sensor_id;
    @FXML
    private Label sensor_name;
    @FXML
    private Label sensor_value;
    @FXML
    private Label sensor_update_time;
    @FXML
    private Label sensor_reading_time;
    @FXML
    private Label sensor_status;
    @FXML
    private Label sensor_value_status;

    @FXML
    private Button add_button;
    @FXML
    private Button edit_button;
    @FXML
    private Button delete_button;
    @FXML
    private Button reset_button;
    @FXML
    private Button save_button;

    private static boolean is_used;

    private static Sensor selected_sensor;

    /*
    * The constructor
    * The constructor is called before the initialize() method.
    */
    public Sensor_Controller() {
    }

    @FXML
    public void initialize() {
        /*Initialize the sensor table with the two columns*/
        sensor_name_column.setCellValueFactory(cell_data -> cell_data.getValue().get_Sensor_name_property());
        sensor_type_column.setCellValueFactory(cell_data -> cell_data.getValue().get_Sensor_type_property().asString());

        /*Clear sensor details*/
        show_sensor_details(null);

        if(!is_used) {
            fill_list();
            is_used = true;
        }

        show_sensor_details(Sensor_List.get_list().get(0));

        /*Listen for selection changes and show the sensor details when changed*/
        sensor_table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> show_sensor_details(newValue));

        /*Handle double clicks on rows*/
        sensor_table.setRowFactory(double_click -> {
            TableRow<Sensor> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Sensor row_data = row.getItem();
                    handle_edit_button();
                }
            });
            return row;
        });

        sensor_table.setItems(Sensor_List.get_list());
    }

    private void fill_list() {
        Sensor_List.add_data(new Sensor(Sensor.Sensor_Type.Contatc_Sensor, "Check_Test", 0));
        Sensor_List.add_data(new Sensor(Sensor.Sensor_Type.Contatc_Sensor, "TEST", 0));

        Sensor test_sensor = new Sensor(Sensor.Sensor_Type.Infrared_Sensor, "TIMETEST", 22);
        test_sensor.set_Sensor_reading_time(LocalDateTime.now());
        test_sensor.set_Sensor_signal_status(Sensor.Sensor_Signal_Status.OK);
        test_sensor.set_Sensor_update_time(LocalDateTime.now());
        test_sensor.set_Sensor_value(20);
        test_sensor.set_Sensor_id(20);
        test_sensor.set_Sensor_status(Sensor.Sensor_Status.Enabled);

        Sensor_List.add_data(test_sensor);
    }

    private void show_sensor_details(Sensor sensor) {
        this.selected_sensor = sensor;
        if (sensor != null) {
            /*Fill the labels with info from the Sensor object*/
            this.sensor_name.setText(sensor.get_Sensor_name());
            this.sensor_type.setText(sensor.get_Sensor_type().toString());
            this.sensor_id.setText(Integer.toString(sensor.get_Sensor_Id()));
            this.sensor_value.setText(Integer.toString(sensor.get_Sensor_value()));
            this.sensor_status.setText(sensor.get_Sensor_status().toString());
            this.sensor_value_status.setText(sensor.get_Sensor_signal_status().toString());

            this.sensor_reading_time.setText(Date_to_String.format(sensor.get_Sensor_reading_time()));
            this.sensor_update_time.setText(Date_to_String.format(sensor.get_Sensor_update_time()));

            //this.sensor_reading_time.setText(sensor.get_Sensor_reading_time().toString());
            //this.sensor_update_time.setText(sensor.get_Sensor_update_time().toString());
        } else {
            /*Sensor is null, remove all the text*/
            this.sensor_name.setText("");
            this.sensor_value.setText("");
            this.sensor_type.setText("");
            this.sensor_id.setText("");
            this.sensor_update_time.setText("");
            this.sensor_value_status.setText("");
            this.sensor_reading_time.setText("");
            this.sensor_status.setText("");
        }
    }

    /*
    Called when the user clicks on the delete button

    Note: This deletes only the list item. Not the actual sensor
    */
    @FXML
    private void handle_delete_button() {
        int selected_sensor_index = sensor_table.getSelectionModel().getSelectedIndex();

        /*Check if there is an sensor selected*/
        if (selected_sensor_index >= 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(Application.getPrimaryStage());
            alert.initStyle(StageStyle.UNDECORATED);
            alert.setTitle("Confirm Deletion");
            alert.setHeaderText("Delete");
            alert.setContentText("Do you really wan't to delete the selected sensor?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                sensor_table.getItems().remove(selected_sensor_index);
            } else {
                return;
            }
        } else {
            /*Noting selected*/
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Application.getPrimaryStage());
            alert.initStyle(StageStyle.UNDECORATED);
            alert.setTitle("No selection");
            alert.setHeaderText("No Sensor Selected");
            alert.setContentText("Please select a sensor in the table.");

            alert.showAndWait();
        }
    }

    public static Sensor get_selected_Sensor() {
        return selected_sensor;
    }


    public Sensor_Controller get_sensor_controller() {
        return this;
    }

    @FXML
    private void handle_reset_button() {
        Sensor_List.clear_list();
        is_used = false;
        initialize();
    }

    @FXML
    private void handle_edit_button() {
        try {
            int selected_sensor_index = sensor_table.getSelectionModel().getSelectedIndex();
            if (selected_sensor_index >= 0) {
                Stage_Navigator.open_stage(Stage_Navigator.EDIT_USER);
                show_sensor_details(get_selected_Sensor());
            } else {
                /*Noting selected*/
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(Application.getPrimaryStage());
                alert.initStyle(StageStyle.UNDECORATED);
                alert.setTitle("No selection");
                alert.setHeaderText("No Sensor Selected");
                alert.setContentText("Please select a sensor in the table.");

                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handle_add_button() {
        Sensor temp_sensor = new Sensor();
        selected_sensor = temp_sensor;
        Stage_Navigator.open_stage(Stage_Navigator.EDIT_USER);
    }
}
