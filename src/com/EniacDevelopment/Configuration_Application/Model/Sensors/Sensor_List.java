package com.EniacDevelopment.Configuration_Application.Model.Sensors;

import com.EniacDevelopment.Configuration_Application.View.Scene_Navigator;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.Observable;

/**
 * Created by nickd on 12/29/2016.
 */
public class Sensor_List {
    private static ObservableList<Sensor> sensor_list;

    static{
        sensor_list = FXCollections.observableArrayList();
    }

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
        if(sensor_list != null)
            return sensor_list;
        else
            return null;
    }

    public static void clear_list(){
        sensor_list.clear();
    }

    public static void fill_from_xml_file(String xml_file){

    }

    public static void save_to_xml_file(String lcation){

    }
}
