package com.EniacDevelopment.Configuration_Application.Model.Configuration;

import com.EniacDevelopment.Configuration_Application.Model.Sensors.Sensor;
import com.EniacDevelopment.Configuration_Application.Model.Sensors.Sensor_List;

/**
 * Created by nickd on 1/5/2017.
 */
public class Configuration {
    private static Configuration current_configuration = new Configuration();

    private enum application_satus{
        OK, ERROR
    }



    private int default_timeout;

    private Configuration(){
    }


}
