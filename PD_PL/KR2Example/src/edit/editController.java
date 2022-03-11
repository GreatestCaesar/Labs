package edit;

import classes.Const;
import classes.Controls;
import classes.Sale;
import com.sun.xml.internal.bind.v2.TODO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class editController {

    @FXML
    private AnchorPane editAnchor;

    @FXML
    private Button buttonEdit;

    @FXML
    private ChoiceBox<String> choiceModel;

    @FXML
    private ChoiceBox<String> choiceSeller;

    @FXML
    private TextField fieldCost;

    @FXML
    private DatePicker fieldDate;

    @FXML
    void initialize(){
        SetChoices();
        buttonEdit.setOnAction(event -> {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String model=choiceModel.getSelectionModel().getSelectedItem();
            String seller = choiceSeller.getSelectionModel().getSelectedItem();
            String cost=fieldCost.getText();
            LocalDate date=fieldDate.getValue();
            boolean numOnly=true;
            for (int i = 0;i<cost.length();i++){
                if (cost.charAt(i)<'0' || cost.charAt(i)>'9'){
                    numOnly=false;
                }
            }
            if (numOnly){
            }
            ((Stage)buttonEdit.getScene().getWindow()).close();


        });
    }

    private void SetChoices() {
        choiceSeller.setItems(FXCollections.observableList(Const.getInstance().sellers));
        choiceModel.setItems(FXCollections.observableList(Const.getInstance().models));
        choiceSeller.getSelectionModel().selectFirst();
        choiceModel.getSelectionModel().selectFirst();
        fieldDate.setValue(LocalDate.of(2016, 7, 25));
    }

}
