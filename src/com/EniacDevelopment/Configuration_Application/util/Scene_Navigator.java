package com.EniacDevelopment.Configuration_Application.util;

import com.EniacDevelopment.Configuration_Application.Controller.Root_Layout_controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

/**
 * Utility class for controlling navigation between different scenes.
 *
 * All methods on the navigator are static to facilitate,
 * simple access from anywhere in the application.
 *
 * Created by nickd on 12/28/2016.
 */
public class Scene_Navigator {
    /*Constants that contain the file location off the *.fxml Scene file*/
    public static final String ROOT_LAYOUT =            "/com/EniacDevelopment/Configuration_Application/View/Root_Layout.fxml";
    public static final String STATUS =                 "/com/EniacDevelopment/Configuration_Application/View/Status.fxml";
    public static final String SENSOR =                 "/com/EniacDevelopment/Configuration_Application/View/Sensor.fxml";
    public static final String SENSOR_STATISTICS =      "/com/EniacDevelopment/Configuration_Application/View/Sensor_Statistics.fxml";
    public static final String USERS =                  "/com/EniacDevelopment/Configuration_Application/View/Users.fxml";
    public static final String CONFIGURATION =          "/com/EniacDevelopment/Configuration_Application/View/Configuration.fxml";
    public static final String ALARM =                  "/com/EniacDevelopment/Configuration_Application/View/Alarm.fxml";

    /*The main application layout controller*/
    private static Root_Layout_controller root_layout_controller;

    /*Stores the main controller for later use in navigation tasks*/
    public static void set_Root_layout_controller(Root_Layout_controller root_layout_controller) {
        Scene_Navigator.root_layout_controller = root_layout_controller;
    }

    /*Sceneholder pane of the main application layout.*/
    /*Previously loaded scenes for the same fxml file are not cached.*/
    /*The fxml is loaded anew and a new scene node hierarchy is generated*/
    /*every time this method is invoked.*/
    public static void load_Scene(String fxml){
        try{
            root_layout_controller.set_scene((Node) FXMLLoader.load(Scene_Navigator.class.getResource(fxml)));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
