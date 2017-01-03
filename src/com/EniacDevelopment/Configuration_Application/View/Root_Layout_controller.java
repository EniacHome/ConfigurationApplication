package com.EniacDevelopment.Configuration_Application.View;

import com.EniacDevelopment.Configuration_Application.Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;

import java.awt.*;
import java.awt.MenuBar;
import java.awt.MenuItem;

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

    //Handle mouse input.
    @FXML
    private void handleEvent(ActionEvent event){
        if(event.getSource() == Application.getPrimaryStage().getScene())
            System.out.println("TEST");
    }
}