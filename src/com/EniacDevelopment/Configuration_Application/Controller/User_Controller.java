package com.EniacDevelopment.Configuration_Application.Controller;

import com.EniacDevelopment.Configuration_Application.Application;
import com.EniacDevelopment.Configuration_Application.Model.User.User;
import com.EniacDevelopment.Configuration_Application.util.Connection.Connection;
import com.EniacDevelopment.Configuration_Application.util.Date_to_String;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.StageStyle;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import java.util.Optional;

/**
 * Created by nickd on 1/5/2017.
 */
public class User_Controller {
    @FXML
    private TableView<User> user_table;
    @FXML
    private TableColumn<User, String> user_type_column;
    @FXML
    private TableColumn<User, String> user_name_column;

    @FXML
    private ObservableList<User> user_list;

    @FXML
    private Label user_type;
    @FXML
    private Label user_id;
    @FXML
    private Label user_name;
    @FXML
    private Label user_first_name;
    @FXML
    private Label user_last_name;
    @FXML
    private Label user_registration_date;
    @FXML
    private Label user_last_login_date;
    @FXML
    private Label user_role;

    @FXML
    private Button add_button;
    @FXML
    private Button edit_button;
    @FXML
    private Button delete_button;
    @FXML
    private Button reset_button;
    @FXML
    private Button update_button;

    private static boolean is_used;
    private WebTarget REST_connection;

    private static User selected_user;

    public User_Controller(){
        REST_connection = Connection.getWebTarger().path("user");
    }

    @FXML
    public void initialize(){
        user_name_column.setCellValueFactory(cell_data -> cell_data.getValue().get_user_name_property());
        user_type_column.setCellValueFactory(cell_data -> cell_data.getValue().get_user_role_property());

        /*Clear user details*/
        show_user_details(null);

        Iterable<com.eniacdevelopment.EniacHome.DataModel.User.User> users = this.REST_connection.request().get(new GenericType<Iterable<com.eniacdevelopment.EniacHome.DataModel.User.User>>(){});

        for (com.eniacdevelopment.EniacHome.DataModel.User.User user : users) {
            User app_user = new User();
            app_user.set_user_id(user.Id);
            app_user.set_first_name(user.Firstname);
            app_user.set_last_name(user.Lastname);

            user_list.add(app_user);
        }

//        if(!is_used){
//            fill_list();
//            is_used = true;
//        }

        show_user_details(user_list.get(0));

        user_table.getSelectionModel().selectedItemProperty().addListener(
                (observable, old_value, new_value) -> show_user_details(new_value));

        /*Handle double clicks on rows*/
        user_table.setRowFactory(double_click -> {
            TableRow<User> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    User row_data = row.getItem();
                    handle_edit_button();
                }
            });
            return row;
        });

        user_table.setItems(user_list);
    }

    private void show_user_details(User user){
        this.selected_user = user;
        if(user != null ){
            /*Fill the labels with info from the User object*/
            this.user_name.setText(user.get_user_name());
            this.user_type.setText(user.get_user_role().toString());
            this.user_first_name.setText(user.get_first_name());
            this.user_last_name.setText(user.get_last_name());
            this.user_id.setText(user.get_user_id());

            this.user_registration_date.setText(Date_to_String.format(user.get_regristation_date()));
            this.user_last_login_date.setText(Date_to_String.format(user.get_last_login_date()));
        }
        else {
            this.user_name.setText("");
            this.user_first_name.setText("");
            this.user_last_name.setText("");
            this.user_last_login_date.setText("");
            this.user_registration_date.setText("");
            this.user_id.setText("");
            this.user_type.setText("");
        }
    }

    @FXML
    private void handle_delete_button() {
        int selected_user_index = user_table.getSelectionModel().getSelectedIndex();

        /*Check if there is an sensor selected*/
        if (selected_user_index >= 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(Application.getPrimaryStage());
            alert.initStyle(StageStyle.UNDECORATED);
            alert.setTitle("Confirm Deletion");
            alert.setHeaderText("Delete");
            alert.setContentText("Do you really wan't to delete the selected sensor?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                this.REST_connection.path(user_table.getItems().get(selected_user_index).get_user_id()).request().delete();
                user_table.getItems().remove(selected_user_index);
            } else {
                return;
            }
        } else {
            /*Noting selected*/
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Application.getPrimaryStage());
            alert.initStyle(StageStyle.UNDECORATED);
            alert.setTitle("No selection");
            alert.setHeaderText("No Sensor Selected");
            alert.setContentText("Please select a sensor in the table.");

            alert.showAndWait();
        }
    }
}
