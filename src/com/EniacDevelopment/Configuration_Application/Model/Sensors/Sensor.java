package com.EniacDevelopment.Configuration_Application.Model.Sensors;

import java.time.LocalDateTime;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Sensor.
 *
 * Created by nickd on 12/29/2016.
 */
public class Sensor {

    public enum Sensor_Type{
        Contatc_Sensor, Temp_Sensor, Infrared_Sensor, Smoke_Detector, Undefined;
    }

    public enum Sensor_Status{
        Disabled, Enabled;
    }

    public enum Sensor_Signal_Status{
        OK, Alarmed, Invallid;
    }

    private final StringProperty Sensor_name;
    private final ObjectProperty<Sensor_Type> Sensor_type;
    private final ObjectProperty<Sensor_Status> Sensor_status;
    private final ObjectProperty<Sensor_Signal_Status> Sensor_signal_status;
    private final IntegerProperty Sensor_value;
    private final ObjectProperty<LocalDateTime> Sensor_reading_time;
    private final ObjectProperty<LocalDateTime> Sensor_update_time;

    /*Default constructor*/
    public Sensor(){
        this(Sensor_Type.Undefined, null);
    }

    /*
    * Constructor with some initial data.
    *
    * @param Sensor_type
    * @param Sensor_name
    */
    public Sensor(Sensor_Type Sensor_type, String Sensor_name){
        this.Sensor_type = new SimpleObjectProperty<Sensor_Type>(Sensor_type);
        this.Sensor_name = new SimpleStringProperty(Sensor_name);

        /*Default init data*/
        this.Sensor_status = new SimpleObjectProperty<Sensor_Status>(Sensor_Status.Disabled);
        this.Sensor_reading_time = new SimpleObjectProperty<LocalDateTime>();
        this.Sensor_signal_status = new SimpleObjectProperty<Sensor_Signal_Status>(Sensor_Signal_Status.Invallid);
        this.Sensor_update_time = new SimpleObjectProperty<LocalDateTime>();
        this.Sensor_value = new SimpleIntegerProperty(0);
    }

    public String get_Sensor_name(){ return this.Sensor_name.get();}
    public StringProperty get_Sensor_name_property(){ return this.Sensor_name;}
    public void set_Sensor_name(String Sensor_name){ this.Sensor_name.set(Sensor_name);}

    public Sensor_Type get_Sensor_type(){ return this.Sensor_type.get();}
    public ObjectProperty<Sensor_Type> get_Sensor_type_property(){ return this.Sensor_type;}
    public void set_Sensor_type(Sensor_Type Sensor_type){ this.Sensor_type.set(Sensor_type);}

    public Sensor_Status get_Sensor_status(){ return this.Sensor_status.get();}
    public void set_Sensor_status(Sensor_Status Sensor_status){ this.Sensor_status.set(Sensor_status);}

    public LocalDateTime get_Sensor_reading_time(){ return this.Sensor_reading_time.get();}
    public ObjectProperty<LocalDateTime> get_Sensor_reading_time_Property(){ return this.Sensor_reading_time;}
    public void set_Sensor_reading_time(LocalDateTime Sensor_reading_time){ this.Sensor_reading_time.set(Sensor_reading_time);}

    public Sensor_Signal_Status get_Sensor_signal_status(){ return this.Sensor_signal_status.get();}
    public void set_Sensor_signal_status(Sensor_Signal_Status Sensor_signal_status) { this.Sensor_signal_status.set(Sensor_signal_status);}

    public LocalDateTime get_Sensor_update_time(){ return this.Sensor_update_time.get();}
    public ObjectProperty<LocalDateTime> get_Sensor_update_time_property(){ return  this.Sensor_update_time;}
    public void set_Sensor_update_time(LocalDateTime Sensor_update_time){ this.Sensor_update_time.set(Sensor_update_time);}

    public int get_Sensor_value(){ return this.Sensor_value.get();}
    public IntegerProperty get_Sensor_value_property(){ return this.Sensor_value;}
    public void set_Sensor_value(int Sensor_value){ this.Sensor_value.set(Sensor_value);}
}
