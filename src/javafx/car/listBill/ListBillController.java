package javafx.car.listBill;

import entities.Car;
import entities.Order;
import impls.OrderRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static helper.RootStage.rootStage;


public class ListBillController implements Initializable {
    public static Order details;
    public TableView<Order> tbBill;
    public TableColumn<Order,String> cCusName;
    public TableColumn<Order,String> cTel;
    public TableColumn<Order,String> cEmail;
    public TableColumn<Order,String> cGl;
    public TableColumn<Order,Integer> cCMT;
    public TableColumn<Order,Integer> cTotal;
    public TextField txtSearch;
    public TableColumn<Order, Date> cTime;
    public TableColumn<Car, Button> cAction1;
    public TableColumn<Car,Button> cAction2;



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
        cAction2.setCellValueFactory(new PropertyValueFactory<>("chitiet"));





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
        Parent listScene = FXMLLoader.load(getClass().getResource("../list/List.fxml"));
        Scene sc = new Scene(listScene,860,800);
        rootStage.setTitle("List Cars");
        rootStage.setScene(sc);

    }

    public void search(ActionEvent actionEvent) {
        try {
            String s = txtSearch.getText();
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

    public void onSearch() {
        txtSearch.textProperty().addListener((ob,old,newvl)->{
            try {
                String s = txtSearch.getText();
                if (s.isEmpty()) {
                    tbBill.setItems(ls);
                    throw new Exception("Vui lòng nhập từ cần tìm kiếm");
                }
                ObservableList<Order> results = ls.stream()
                        .filter(order -> order.getTel().toLowerCase().contains(newvl.toLowerCase())
                                        || order.getCarBrand().toLowerCase().contains(newvl.toLowerCase())
                                        || order.getStatus().toLowerCase().contains(newvl.toLowerCase())
                                        || order.getEmail().toLowerCase().contains(newvl.toLowerCase())

//                                || student.getScore().equals(Integer.parseInt(newvl))
                        )
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));
                tbBill.setItems(results);

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
            }
        });
    }
}
