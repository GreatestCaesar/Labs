package sample.about;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class About {

    @FXML
    private Button ok;

    public void initialize(){
        ok.setOnAction(event -> {
            ((Stage) ok.getScene().getWindow()).close();
        });
    }
}
