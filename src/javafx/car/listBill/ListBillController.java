package javafx.car.listBill;

import entities.Car;
import entities.Order;
import impls.CarRepository;
import impls.OrderRepository;
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
import java.sql.Date;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static helper.RootStage.rootStage;


public class ListBillController implements Initializable {
    public TableView<Order> tbBill;
    public TableColumn<Order,String> cCusName;
    public TableColumn<Order,String> cTel;
    public TableColumn<Order,String> cEmail;
    public TableColumn<Order,String> cGl;
    public TableColumn<Order,Integer> cCMT;
    public TableColumn<Order,Integer> cTotal;
    public TableColumn<Car, Button> cAction1;
    public TextField txtSearchNumber;
    public TableColumn<Order, Date> cTime;


    private ObservableList<Order> ls = FXCollections.observableArrayList();
    public void initialize(URL location, ResourceBundle resources) {
        cCusName.setCellValueFactory(new PropertyValueFactory<>("cusName"));
        cTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cGl.setCellValueFactory(new PropertyValueFactory<>("gl"));
        cCMT.setCellValueFactory(new PropertyValueFactory<>("cmt"));
        cTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        cTime.setCellValueFactory(new PropertyValueFactory<>("nkt"));
        cAction1.setCellValueFactory(new PropertyValueFactory<>("Pay"));



        try {
            OrderRepository sr = new OrderRepository();

            ls.addAll(sr.all());
            tbBill.setItems(ls);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }


    public void backToList(ActionEvent actionEvent) throws IOException {
        Parent listScene = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Scene sc = new Scene(listScene,1280,800);
        rootStage.setTitle("List Cars");
        rootStage.setScene(sc);

    }

    public void search(ActionEvent actionEvent) {
        try {
            String s = txtSearchNumber.getText();
            if(s.isEmpty()){
                tbBill.setItems(ls);
                throw new Exception("Vui lòng nhập từ cần tìm kiếm");
            }

            ObservableList<Order> results = ls.stream()
                    .filter(order -> order.getTel().contains(s))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));
            tbBill.setItems(results);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }
}
