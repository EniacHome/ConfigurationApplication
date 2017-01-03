package com.EniacDevelopment.Configuration_Application.View;

import com.EniacDevelopment.Configuration_Application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


/**
 * Utilty class for navigating different overlay stages.
 *
 * All methods on the navigator are static to facilitate
 * simple access from anywhere in the application.
 *
 * NOTE*: Only one overlay stage at the time kan be opened.
 *
 * Created by nickd on 12/28/2016.
 */
public class Stage_Navigator {
    public static Stage overlay_stage;

    /*Constants that contain the file locations of the *.fxml Stage files*/
    public static final String LOGIN_SCREEN         = "/com/EniacDevelopment/Configuration_Application/view/Login.fxml";
    public static final String ADD_USER             = "/com/EniacDevelopment/Configuration_Application/view/Uses.fxml";
    public static final String EDIT_USER            = "/com/EniacDevelopment/Configuration_Application/view/Sensor_Edit_dialog.fxml";
    public static final String TIMER                = "/com/EniacDevelopment/Configuration_Application/view/Timer.fxml";

    /*
    Method that opens an new child stage.
    This method uses the primary stage used in the start method
    in the main Application.*/
    public static void open_stage(String fxml) {
        try{
            FXMLLoader loader = new FXMLLoader(); /*Create a new FXMLloader*/
            loader.setLocation(Stage_Navigator.class.getResource(fxml));
            Pane pane = (Pane) loader.load();

            /*Create the state*/
            overlay_stage = new Stage();
            overlay_stage.setTitle(fxml);
            overlay_stage.initModality(Modality.WINDOW_MODAL);
            overlay_stage.initStyle(StageStyle.UNDECORATED);
            overlay_stage.initOwner(Application.getPrimaryStage());
            Scene overlay_scene = new Scene(pane);
            overlay_stage.setScene(overlay_scene);

            overlay_stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Stage get_Stage(){
        if(overlay_stage != null){
            return overlay_stage;
        }
        else{
            return null;
        }
    }

    public static void close_stage(){
        if(!(overlay_stage.isShowing()))
            return;

        try{
            overlay_stage.setTitle("");
            overlay_stage.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String get_stage_title(){
        return overlay_stage.getTitle();
    }

}
