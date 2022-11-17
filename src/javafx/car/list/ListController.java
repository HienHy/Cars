package javafx.car.list;

import entities.Car;
import impls.CarRepository;
import javafx.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ListController implements Initializable {

    public TableView<Car> tbCar;
    public TableColumn<Car,String> cName;
    public TableColumn<Car,String> cBrand;
    public TableColumn<Car,Integer> cDeposit;
    public TableColumn<Car,Integer> cPrice;
    public TableColumn<Car,Boolean> cStatus;

    public TableColumn<Car, Button> cAction;



    public TextField txtSearch;

    private ObservableList<Car> ls = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cDeposit.setCellValueFactory(new PropertyValueFactory<>("deposit"));
        cPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        cStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        cAction.setCellValueFactory(new PropertyValueFactory<>("Rent"));




        try {
            CarRepository sr = new CarRepository();
            ls.addAll(sr.all());
            tbCar.setItems(ls);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }



    public void search(ActionEvent actionEvent) {
        try {
            String s = txtSearch.getText();
            if(s.isEmpty()){
                tbCar.setItems(ls);
                throw new Exception("Vui lòng nhập từ cần tìm kiếm");
            }

            ObservableList<Car> results = ls.stream()
                    .filter(car -> car.getName().toLowerCase().contains(s.toLowerCase()))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));
            tbCar.setItems(results);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    public void backToList(ActionEvent actionEvent) throws IOException {
        Parent listScene = FXMLLoader.load(getClass().getResource("../listBill/orderList.fxml"));
        Scene sc = new Scene(listScene,1280,800);
        Main.rootStage.setTitle("List Bill");
        Main.rootStage.setScene(sc);
    }
}
