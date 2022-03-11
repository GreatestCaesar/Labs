package sample.edit;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;
import sample.Document;
import sample.DocumentDAO;
import sample.DocumentDAOImp;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Edit {
    private ArrayList<String> dep = new ArrayList<>();
    private ArrayList<String> res = new ArrayList<>();
    private ArrayList<String> listType = new ArrayList<>();
    private final DocumentDAO documentDAO = new DocumentDAOImp();

    @FXML
    private AnchorPane window;

    @FXML
    private ChoiceBox<String> departments1;

    @FXML
    private ChoiceBox<String> respon1;

    @FXML
    private ChoiceBox<String> type1;

    @FXML
    private TextField name1;

    @FXML
    private Button edit;

    @FXML
    private Button update;

    @FXML
    private DatePicker date;

    private Document doc;

    public void setID(Document doc){
        this.doc = doc;
    }

    public Document getID(){
        return doc;
    }

    public void initialize() throws SQLException {
        initDepartment();
        initRespon();
        initType();
        edit();
        update();
    }

    private void initDepartment(){
        dep.add("Бухгалтерия");
        dep.add("Отдел продаж");
        dep.add("Отдел маркетинга");
        dep.add("Отдел кадров");
        dep.add("Секретарь");
        departments1.setItems(FXCollections.observableList(dep));
    }

    public void initRespon(){
        res.add("Иванов");
        res.add("Петров");
        res.add("Сидоров");
        res.add("Бурнов");
        respon1.setItems(FXCollections.observableList(res));
    }

    public void initType(){
        listType.add("Отчет");
        listType.add("Ведомость");
        listType.add("Анкета");
        listType.add("Приказ");
        listType.add("ИнструкциЯ");
        type1.setItems(FXCollections.observableList(listType));
    }

    public void initChoice(){
        String[] d = doc.getDate().split("-");
        name1.setText(doc.getName());
        departments1.getSelectionModel().select(indexDep());
        respon1.getSelectionModel().select(indexRes());
        type1.getSelectionModel().select(indexTyp());
        date.setValue(LocalDate.of(Integer.parseInt(d[0]),cropDate(d[1]),cropDate(d[2])));
    }

    public int cropDate(String t){
        if(t.charAt(0)=='0'){
            return Integer.parseInt(String.valueOf(t.charAt(1)));
        }else{
            return Integer.parseInt(String.valueOf(t.charAt(0)));
        }
    }

    public int indexDep(){
        int x = 0;
        for(int i=0;i<dep.size();i++){
            if(doc.getDepartment().equals(dep.get(i))){
                x = i;
            }
        }
        return x;
    }

    public int indexRes(){
        int x = 0;
        for(int i=0;i<res.size();i++){
            if(doc.getResponsible().equals(res.get(i))){
                x = i;
            }
        }
        return x;
    }

    public int indexTyp(){
        int x = 0;
        for(int i=0;i<listType.size();i++){
            if(doc.getType().equals(listType.get(i))){
                x = i;
            }
        }
        return x;
    }

    public void edit() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        edit.setOnAction(evt -> {
            if(departments1.getSelectionModel().getSelectedItem()==null || respon1.getSelectionModel().getSelectedItem()==null || type1.getSelectionModel().getSelectedItem()==null || date.getValue()==null || name1.getText()==null){
                window.setDisable(true);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/errors/error.fxml"));
                Stage stage = new Stage();
                try {
                    stage.setScene(new Scene(loader.load()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.showAndWait();
                window.setDisable(false);
            }else{
                Document document = new Document();
                document.setId(doc.getId());
                document.setName(name1.getText());
                document.setDepartment(departments1.getSelectionModel().getSelectedItem());
                document.setResponsible(respon1.getSelectionModel().getSelectedItem());
                document.setType(type1.getSelectionModel().getSelectedItem());
                document.setDate(dateFormatter.format(date.getValue()));
                try {
                    documentDAO.edit(document);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                ((Stage) edit.getScene().getWindow()).close();
            }
        });
    }

    public void update(){
        update.setOnAction(evt -> {
            initChoice();
        });
    }
}
