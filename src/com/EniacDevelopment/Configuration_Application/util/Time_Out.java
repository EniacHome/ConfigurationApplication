package com.EniacDevelopment.Configuration_Application.util;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

/**
 * Created by nickd on 12/29/2016.
 */
public class Time_Out {
    private static Timeline time_line;
    private static boolean is_active = false;
    private static int default_timeout = 5;

    //setTimerTimeoutTime with an given time
    public static void set_timer_timeout_time(int minutes){
        time_line = new Timeline(new KeyFrame(Duration.minutes(minutes), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if(Stage_Navigator.get_stage_title() == Stage_Navigator.LOGIN_SCREEN){
                    return;
                }
                else {
                    Stage_Navigator.close_stage();
                    Stage_Navigator.open_stage(Stage_Navigator.LOGIN_SCREEN);
                }
            }
        }));
        time_line.setCycleCount(Timeline.INDEFINITE);
    }

    //setTimerTimeoutTime without an given time
    public static void set_timer_timeout_time(){
        time_line = new Timeline(new KeyFrame(Duration.minutes(default_timeout), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if(Stage_Navigator.get_stage_title() == Stage_Navigator.LOGIN_SCREEN){
                    return;
                }
                else {
                    Stage_Navigator.close_stage();
                    Stage_Navigator.open_stage(Stage_Navigator.LOGIN_SCREEN);
                }
            }
        }));
        time_line.setCycleCount(Timeline.INDEFINITE);
    }

    public static void activate_timer(){
        if(time_line.cycleDurationProperty() == null)
            set_timer_timeout_time();
        time_line.play();
        is_active = true;
    }

    public static void stop_timer(){
        if(!is_active) {
            return;
        }
        else{
            time_line.stop();
            is_active = false;
        }
    }

    public static void reset_timer(){
        stop_timer();
        set_timer_timeout_time();
        activate_timer();
    }

    public static void set_default_timeout(int timeout){
        default_timeout = timeout;
    }
}
