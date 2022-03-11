package sample.errors;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.*;

public class Error2 {
    @FXML
    private Button ok;

    public void initialize(){
        ok.setOnAction(event -> {
            ((Stage) ok.getScene().getWindow()).close();
        });
    }
}
