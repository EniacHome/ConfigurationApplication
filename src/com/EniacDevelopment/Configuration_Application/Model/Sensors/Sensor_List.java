package com.EniacDevelopment.Configuration_Application.Model.Sensors;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 * Singleton List that contains the local sensor values
 *
 * Created by nickd on 12/29/2016.
 */
public class Sensor_List {

    /*Singleton Sensor_List object*/
    private static ObservableList<Sensor> sensor_list = FXCollections.observableArrayList();

    static {
        sensor_list.addListener(new ListChangeListener<Sensor>() {
            @Override
            public void onChanged(Change<? extends Sensor> c) {

            }
        });
    }

    private Sensor_List(){}

    public static void update_sensor_list(Sensor sensor){
        if(sensor_list.contains(sensor)){
            sensor_list.set(sensor_list.indexOf(sensor), sensor);
        }
        else{
            add_data(sensor);
        }
    }

    public static void add_data(Sensor sensor){
        sensor_list.add(sensor);
    }

    public static ObservableList<Sensor> get_list(){
        return sensor_list;
    }

    public static void clear_list(){
        sensor_list.clear();
    }

    public static void fill_list_from_REST(){

    }

    public static void send_list_to_REST(){

    }
}
