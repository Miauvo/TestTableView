import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLTestViewController implements Initializable {

    @FXML
    private TextField textNumber;

    @FXML
    private TableView<TestClass> grid;

    @FXML
    private TextField textText;

    @FXML
    private Button btn;

//    @FXML
//    void btnOnAction(ActionEvent event) {
//
//    }

    public static class TestClass {
        private final SimpleIntegerProperty number;
        private final SimpleStringProperty text;

        private TestClass(int number, String text) {
            this.number = new SimpleIntegerProperty(number);
            this.text = new SimpleStringProperty(text);

        }

        public int getNumber() {
            return number.get();
        }

        public SimpleIntegerProperty numberProperty() {
            return number;
        }

        public void setNumber(int number) {
            this.number.set(number);
        }

        public String getText() {
            return text.get();
        }

        public SimpleStringProperty textProperty() {
            return text;
        }

        public void setText(String text) {
            this.text.set(text);
        }
    }

    private final ObservableList<TestClass> data =
            FXCollections.observableArrayList(
                    new TestClass(40, "Smith"),
                    new TestClass(-5, "Smith2"),
                    new TestClass(808, "Smith3")
            );


    public void initialize(URL location, ResourceBundle resources) {

        grid.getColumns().clear();

        TableColumn firstNameCol = new TableColumn("Number");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("number"));

        TableColumn lastNameCol = new TableColumn("Text");
        lastNameCol.setMinWidth(200);


        //Nested
        TableColumn firstNested = new TableColumn("Nested1");
        firstNested.setCellValueFactory(
                new PropertyValueFactory<>("text"));
        TableColumn secondNested = new TableColumn("Nested2");

        //addNested
        lastNameCol.getColumns().addAll(firstNested,secondNested);

        //addAll
        grid.setItems(data);
        grid.getColumns().addAll(firstNameCol, lastNameCol);



        btn.setOnAction((ActionEvent e) -> {
            data.add(new TestClass(
                    Integer.parseInt(textNumber.getText()),
                    textText.getText()
            ));
            textNumber.clear();
            textText.clear();

        });




    }

}

