package sample;

import classes.Const;

import classes.Controls;
import classes.Sale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class mainController {

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private TableView<Sale> tableSales;

    @FXML
    private TableColumn<Sale, Integer> idColumn;

    @FXML
    private TableColumn<Sale, String> modelCol;

    @FXML
    private TableColumn<Sale, String> sellerCol;

    @FXML
    private TableColumn<Sale, Integer> costCol;

    @FXML
    private TableColumn<Sale, String> dateCol;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonEdit;

    @FXML
    private ChoiceBox<String> choiceModel;

    @FXML
    private CheckBox checkAdd;

    @FXML
    private ChoiceBox<String> choiceSeller;

    @FXML
    private TextField fieldCost;

    @FXML
    private DatePicker fieldDate;

    @FXML
    private Button writeIntoFile;


    @FXML
    void initialize() throws SQLException {

        ObservableList<Sale> sales = SetTable();
        SetChoices();

        buttonAdd.setOnAction(event -> {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String model = choiceModel.getSelectionModel().getSelectedItem();
            String seller = choiceSeller.getSelectionModel().getSelectedItem();
            String cost = fieldCost.getText();
            LocalDate date = fieldDate.getValue();
            boolean numOnly = true;
            for (int i = 0; i < cost.length(); i++) {
                if (cost.charAt(i) < '0' || cost.charAt(i) > '9') {
                    numOnly = false;
                }
            }
            if (numOnly && checkAdd.isSelected()) {
            }
            try {
                SetTable();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        buttonEdit.setOnAction(event -> {
            if (tableSales.getSelectionModel().getSelectedItem() != null) {
                Controls.saleToEdit = tableSales.getSelectionModel().getSelectedItem();
                mainAnchor.setDisable(true);

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/edit/edit.fxml"));
                try {
                    loader.load();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
                mainAnchor.setDisable(false);
                try {
                    SetTable();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        });

        buttonDelete.setOnAction(event -> {
            Sale saleToDelete = tableSales.getSelectionModel().getSelectedItem();

            if (saleToDelete != null) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/delete/deleteConfirm.fxml"));
                try {
                    loader.load();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();

                if (Controls.toDelete) {
                    try {
                        SetTable();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }

            }
        });

//TODO не записывает в файл
        writeIntoFile.setOnAction(event -> {
            File file = new File("C:\\0000_Файлы\\учеба\\универ\\5 семестр\\ПСП\\Зализунь\\3 лаба\\GUI\\result.txt");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }

            try {
                PrintWriter out = new PrintWriter(file);
                for (Sale item : sales) {
                    out.print(item.getIdsales() + "\t");
                    out.print(item.getModel() + "\t");
                    out.print(item.getSeller() + "\t");
                    out.print(item.getCost() + "\t");
                    out.print(item.getDate() + "\n");
                }
                out.close();
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
            }
        });
    }

    private void SetChoices() {
        choiceSeller.setItems(FXCollections.observableList(Const.getInstance().sellers));
        choiceModel.setItems(FXCollections.observableList(Const.getInstance().models));
        choiceSeller.getSelectionModel().selectFirst();
        choiceModel.getSelectionModel().selectFirst();
        fieldDate.setValue(LocalDate.of(2016, 7, 25));


    }

    private ObservableList<Sale> SetTable() throws SQLException {
        tableSales.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        idColumn.setCellValueFactory(new PropertyValueFactory<Sale, Integer>("idsales"));
        modelCol.setCellValueFactory(new PropertyValueFactory<Sale, String>("model"));
        sellerCol.setCellValueFactory(new PropertyValueFactory<Sale, String>("seller"));
        costCol.setCellValueFactory(new PropertyValueFactory<Sale, Integer>("cost"));
        dateCol.setCellValueFactory(new PropertyValueFactory<Sale, String>("date"));


        return null;
    }
}
