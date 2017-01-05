package com.EniacDevelopment.Configuration_Application.Model.User;

import com.eniacdevelopment.EniacHome.DataModel.User.UserRole;
import javafx.beans.property.*;

import java.time.LocalDateTime;

/**
 * Created by nickd on 1/5/2017.
 */
public class User{
    private StringProperty user_id;
    private StringProperty user_name;
    private StringProperty user_password;
    private StringProperty first_name;
    private StringProperty last_name;
    private ObjectProperty<UserRole> user_role;
    private ObjectProperty<LocalDateTime> registration_date;
    private ObjectProperty<LocalDateTime> last_login_date;


    public User(){
        this(null, null);
    }

    public User(String user_id, String user_name){
        this.user_id = new SimpleStringProperty(user_id);
        this.user_name = new SimpleStringProperty(user_name);

        this.user_password = new SimpleStringProperty(null);
        this.first_name = new SimpleStringProperty(null);
        this.last_name = new SimpleStringProperty(null);
        this.user_role = new SimpleObjectProperty<>(UserRole.User);
        this.registration_date = new SimpleObjectProperty<>(LocalDateTime.now());
        this.last_login_date = new SimpleObjectProperty<>(LocalDateTime.now());
    }

    public void set_user_id(String user_id){ this.user_id.setValue(user_id);}
    public String get_user_id(){ return this.user_id.get();}
    public StringProperty get_user_id_property(){ return this.user_id;}

    public void set_user_name(String user_name){ this.user_name.set(user_name);}
    public String get_user_name(){ return this.user_name.get();}
    public StringProperty get_user_name_property(){ return this.user_name;}

    public void set_user_password(String user_password){ this.user_password.set(user_password);}
    public String get_user_password(){ return this.user_password.get();}
    public StringProperty get_user_password_property(){ return this.user_password;}

    public void set_first_name(String first_name){ this.first_name.setValue(first_name);}
    public String get_first_name(){ return this.first_name.get();}
    public StringProperty get_first_name_property(){ return this.first_name;}

    public void set_last_name(String last_name){ this.last_name.setValue(last_name);}
    public String get_last_name(){ return this.last_name.get();}
    public StringProperty get_last_name_property(){ return this.last_name;}

    public void set_user_role(UserRole user_role){ this.user_role.set(user_role);}
    public UserRole get_user_role(){ return this.user_role.get();}
    public ObjectProperty get_user_role_property(){ return this.user_role;}

    public LocalDateTime get_regristation_date(){ return this.registration_date.get();}
    public ObjectProperty get_registration_date_property(){ return this.registration_date;}

    public LocalDateTime get_last_login_date(){ return this.last_login_date.get();}
    public ObjectProperty get_last_login_date_property(){ return this.last_login_date;}
}
