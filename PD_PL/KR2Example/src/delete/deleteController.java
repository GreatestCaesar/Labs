package delete;

import classes.Controls;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class deleteController {

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonOk;

    @FXML
    void initialize(){
        buttonCancel.setOnAction(event -> {
            Controls.toDelete=false;
            ((Stage)buttonCancel.getScene().getWindow()).close();
        });

        buttonOk.setOnAction(event -> {
            Controls.toDelete=true;
            ((Stage)buttonOk.getScene().getWindow()).close();
        });
    }

}
