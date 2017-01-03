package com.EniacDevelopment.Configuration_Application.Model.Sensors;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.Observable;

/**
 * Created by nickd on 12/29/2016.
 */
public class Sensor_List {
    private static ObservableList<Sensor> sensor_list;

    {
        sensor_list = FXCollections.observableArrayList();
    }

    public Sensor_List(){
        sensor_list = FXCollections.observableArrayList();
    }

    public void update_data(Sensor sensor){
        if(sensor_list.contains(sensor)){
            sensor_list.set(sensor_list.indexOf(sensor), sensor);
        }
    }

    public static void add_data(Sensor sensor){
        sensor_list.add(sensor);
    }

    public static ObservableList<Sensor> get_data(){
        return sensor_list;
    }

    public static  void clear_list(){
        sensor_list.clear();
    }

    public static void fill_from_xml_file(String xml_file){

    }

    public static void save_to_xml_file(String lcation){

    }
}
