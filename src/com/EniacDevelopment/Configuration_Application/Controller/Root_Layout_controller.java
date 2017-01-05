package com.EniacDevelopment.Configuration_Application.Controller;

import com.EniacDevelopment.Configuration_Application.util.Scene_Navigator;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 * Created by nickd on 12/28/2016.
 */
public class Root_Layout_controller {
    //Holder of a switchable scene.
    @FXML
    private StackPane sceneHolder;

    @FXML
    private javafx.scene.control.MenuBar menu_bar;

    @FXML
    private javafx.scene.control.Menu sensors_menu;
    @FXML
    private javafx.scene.control.MenuItem sensor_status_tab;
    @FXML
    private javafx.scene.control.MenuItem sensor_statistics_tab;

    @FXML
    private javafx.scene.control.Menu alarm_menu;
    @FXML
    private javafx.scene.control.MenuItem alarm_tab;

    @FXML
    private javafx.scene.control.Menu user_menu;
    @FXML
    private javafx.scene.control.MenuItem user_tab;

    @FXML
    private javafx.scene.control.Menu application_menu;
    @FXML
    private javafx.scene.control.MenuItem configuration_tab;
    @FXML
    private javafx.scene.control.MenuItem log_out_tab;
    @FXML
    private javafx.scene.control.MenuItem exit_tab;

    @FXML
    public void initialize(){

    }

    //Replace the scene displayed in the sceneHolder with a new scene.
    public void set_scene(Node node){
        sceneHolder.getChildren().setAll(node);
    }

    @FXML
    private void handle_exit_tab(){
        System.exit(0);
    }

    @FXML
    private void handle_sensor_status_tab(){
        Scene_Navigator.load_Scene(Scene_Navigator.SENSOR);
    }

    @FXML
    private void handle_configuration_tab(){
        Scene_Navigator.load_Scene(Scene_Navigator.CONFIGURATION);
    }
}