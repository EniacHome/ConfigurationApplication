package com.EniacDevelopment.Configuration_Application;

import com.EniacDevelopment.Configuration_Application.Controller.Root_Layout_controller;
import com.EniacDevelopment.Configuration_Application.util.Scene_Navigator;
import com.EniacDevelopment.Configuration_Application.util.Time_Out;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;


import java.io.IOException;
/**
 * Created by nickd on 12/27/2016.
 */
public class Application extends javafx.application.Application{
    private static Stage mainStage; /*Static copy of the stage that's set on startup and is used for creating overlay_stages*/

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Configuration Application"); /*Set the title of the stage*/
        stage.initStyle(StageStyle.UNDECORATED); /*Remove the default windows menubar*/
        stage.setScene(createScene(loadRootLayout())); /*Create the start (Main) scene*/
        mainStage = stage; /*Copy the stage into mainStage*/
        stage.show();


        //Stage_Navigator.open_stage(Stage_Navigator.LOGIN_SCREEN); /*Open the login screen*/
        //stage.setOpacity(0); /*Hide the main stage till an successful login has been occurred*/


        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });

        Time_Out.set_default_timeout(1); /*Set the default timeout on 1 minute*/
        Time_Out.set_timer_timeout_time(1); /*Set the currently used timer on 1 minute*/
        //Time_Out.activate_timer(); /*Activate the timer*/
    }

    /*
    Loads the rootLayout fxml layout.
    Sets up the scene switching com.EniacDevelopment.ControlClient.view.SceneNavigator.
    Loads the first scene into the fxml layout.
     */
    private Pane loadRootLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane rootLayout = (Pane) loader.load(getClass().getResourceAsStream(Scene_Navigator.ROOT_LAYOUT)); /*Load the fxml file 'RootLayout' in the loader*/

        Root_Layout_controller rootLayoutController = loader.getController(); /*Init the controller*/

        Scene_Navigator.set_Root_layout_controller(rootLayoutController); /*Set the default Rootlayout controller*/
        Scene_Navigator.load_Scene(Scene_Navigator.SENSOR); /*Load the status scene*/

        return rootLayout;
    }


    //Creates the main application scene.
    private Scene createScene(Pane rootLayout){
        Scene scene = new Scene(rootLayout); /*Create a new Scene with the RootLayout pane as body*/

       /*
        //Handle any events that may occur.
        scene.addEventFilter(Event.ANY, new EventHandler<Event>() {
            public void handle(Event event) {
                Time_Out.resetTimer(); //Reset the timer with the default_timeout value
            }
        });
        */

        scene.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Time_Out.reset_timer(); //Reset the timer with the default_timeout value
            }
        });

        //This won't work because maven is a fucker
        //scene.getStylesheets().setAll(getClass().getResource("/Eniac/Home/view/Vista.css").toExternalForm());

        return scene;
    }

    /*
    Get the primary stage.
     */
    public static Stage getPrimaryStage(){
        return mainStage;
    }

    public static void main(String[] args) { launch(args);}
}
