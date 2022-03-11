package sample;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.edit.Edit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Controller{
    private final DocumentDAO documentDAO = new DocumentDAOImp();

    private ArrayList<String> dep = new ArrayList<>();
    private ArrayList<String> res = new ArrayList<>();
    private ArrayList<String> listType = new ArrayList<>();
    private ArrayList<String> find = new ArrayList<>();

    @FXML
    private AnchorPane window;

    @FXML
    private TextField name1;

    @FXML
    private TextField findText;

    @FXML
    private DatePicker date;

    @FXML
    private Button add;

    @FXML
    private Button toFile;

    @FXML
    private Button delete;

    @FXML
    private Button about;

    @FXML
    private Button findBut;

    @FXML
    private Button edit;

    @FXML
    private ChoiceBox<String> departments;

    @FXML
    private ChoiceBox<String> respon;

    @FXML
    private ChoiceBox<String> type;

    @FXML
    private ChoiceBox<String> findCh;

    @FXML
    private TableView<Document> table;

    @FXML
    private TableColumn<Document, Integer> id;

    @FXML
    private TableColumn<Document, String> name;

    @FXML
    private TableColumn<Document, String> depar;

    @FXML
    private TableColumn<Document, String> resp;

    @FXML
    private TableColumn<Document, String> ty;

    @FXML
    private TableColumn<Document, String> dat;

    private ObservableList<Document> documents;

    public void initialize() throws SQLException {
        new Create();
        documents = FXCollections.observableList(documentDAO.getAll());
        add();
        delete();
        edit();
        find();
        fillTable();
        initDepartment();
        initRespon();
        initType();
        initFind();
        toFile();
        about();
    }

    private void fillTable(){
        id.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getId()));
        name.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getName()));
        depar.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDepartment()));
        resp.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getResponsible()));
        ty.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getType()));
        dat.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDate()));
        table.setItems(documents);
    }

    private void initDepartment(){
        dep.add("Бухгалтерия");
        dep.add("Отдел продаж");
        dep.add("Отдел маркетинга");
        dep.add("Отдел кадров");
        dep.add("Секретарь");
        departments.setItems(FXCollections.observableList(dep));
    }

    public void initRespon(){
        res.add("Иванов");
        res.add("Петров");
        res.add("Сидоров");
        res.add("Бурнов");
        respon.setItems(FXCollections.observableList(res));
    }

    public void initType(){
        listType.add("Отчет");
        listType.add("Ведомость");
        listType.add("Анкета");
        listType.add("Приказ");
        listType.add("ИнструкциЯ");
        type.setItems(FXCollections.observableList(listType));
    }

    public void initFind(){
        find.add("Название");
        find.add("Отдел");
        find.add("Ответственный");
        find.add("Тип");
        find.add("Дата");
        findCh.setItems(FXCollections.observableList(find));
    }

    public void find(){
        findBut.setOnAction(evt -> {
            if(findCh.getSelectionModel().getSelectedItem()==null || findText.getText().equals("")){
                window.setDisable(true);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/errors/error2.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Ошибка");
                try {
                    stage.setScene(new Scene(loader.load()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.showAndWait();
                window.setDisable(false);
            }else{
                String condition = findCh.getSelectionModel().getSelectedItem();
                String name = findText.getText();
                switch (condition){
                    case "Название":{
                        try {
                            if(documentDAO.search("name",name).size()==0){
                                documents = FXCollections.observableList(documentDAO.getAll());
                                fillTable();
                            }else{
                                try {
                                    documents = FXCollections.observableList(documentDAO.search("name",name));
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                                fillTable();
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        break;
                    }
                    case "Отдел":{
                        try {
                            if(documentDAO.search("department",name).size()==0){
                                documents = FXCollections.observableList(documentDAO.getAll());
                                fillTable();
                            }else{
                                try {
                                    documents = FXCollections.observableList(documentDAO.search("department",name));
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                                fillTable();
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        break;
                    }
                    case "Ответственный":{
                        try {
                            if(documentDAO.search("responsible",name).size()==0){
                                documents = FXCollections.observableList(documentDAO.getAll());
                                fillTable();
                            }else{
                                try {
                                    documents = FXCollections.observableList(documentDAO.search("responsible",name));
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                                fillTable();
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        break;
                    }
                    case "Тип":{
                        try {
                            if(documentDAO.search("type",name).size()==0){
                                documents = FXCollections.observableList(documentDAO.getAll());
                                fillTable();
                            }else{
                                try {
                                    documents = FXCollections.observableList(documentDAO.search("type",name));
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                                fillTable();
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        break;
                    }
                    case "Дата":{
                        try {
                            if(documentDAO.search("date",name).size()==0){
                                documents = FXCollections.observableList(documentDAO.getAll());
                                fillTable();
                            }else{
                                try {
                                    documents = FXCollections.observableList(documentDAO.search("date",name));
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                                fillTable();
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        break;
                    }
                }
            }
        });
    }

    public void edit(){
        edit.setOnAction(evt ->{
            Document editDoc = table.getSelectionModel().getSelectedItem();
            if(editDoc==null){
                window.setDisable(true);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/errors/error1.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Ошибка");
                try {
                    stage.setScene(new Scene(loader.load()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.showAndWait();
                window.setDisable(false);
            }else{
                window.setDisable(true);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/edit/eddit.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Редактирование");
                try {
                    stage.setScene(new Scene(loader.load()));
                    loader.<Edit>getController().setID(editDoc);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.showAndWait();
                window.setDisable(false);
            }
            try {
                documents = FXCollections.observableList(documentDAO.getAll());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            fillTable();
        });
    }

    public void delete(){
        delete.setOnAction(evt -> {
            Document deleteDoc = table.getSelectionModel().getSelectedItem();
            if(deleteDoc==null){
                window.setDisable(true);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/errors/error1.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Ошибка");
                try {
                    stage.setScene(new Scene(loader.load()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.showAndWait();
                window.setDisable(false);
            }else{
                try {
                    documentDAO.delete(deleteDoc);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            try {
                documents = FXCollections.observableList(documentDAO.getAll());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            fillTable();
        });
    }

    public void add(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        add.setOnAction(evt -> {
            if(departments.getSelectionModel().getSelectedItem()==null || respon.getSelectionModel().getSelectedItem()==null || type.getSelectionModel().getSelectedItem()==null || date.getValue()==null || name1.getText().equals("")){
                window.setDisable(true);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/errors/error.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Ошибка");
                try {
                    stage.setScene(new Scene(loader.load()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.showAndWait();
                window.setDisable(false);
            }else{
                Document document = new Document();
                document.setName(name1.getText());
                document.setDepartment(departments.getSelectionModel().getSelectedItem());
                document.setResponsible(respon.getSelectionModel().getSelectedItem());
                document.setType(type.getSelectionModel().getSelectedItem());
                document.setDate(dateFormatter.format(date.getValue()));
                try {
                    documentDAO.add(document);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                name1.setText("");
            }
            try {
                documents = FXCollections.observableList(documentDAO.getAll());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            fillTable();
        });
    }

    public void toFile(){
        toFile.setOnAction(evt -> {
            File file = new File("src/sample/result.txt");

            if(!file.exists()){
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                PrintWriter out = new PrintWriter(file);
                for (Document item : documents) {
                    out.print(item.getId() + "\t");
                    out.print(item.getName() + "\t");
                    out.print(item.getDepartment() + "\t");
                    out.print(item.getResponsible() + "\t");
                    out.print(item.getType() + "\t");
                    out.print(item.getDate() + "\n");
                }
                out.close();
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
            }
        });
    }

    public void about(){
        about.setOnAction(evt -> {
            window.setDisable(true);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/about/about.fxml"));
            Stage stage = new Stage();
            stage.setTitle("О программе");
            try {
                stage.setScene(new Scene(loader.load()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.showAndWait();
            window.setDisable(false);
        });
    }
}
