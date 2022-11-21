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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
    public static Order listCar;

    private ObservableList<Order> ls = FXCollections.observableArrayList();
    public void initialize(URL location, ResourceBundle resources) {
        cCusName.setCellValueFactory(new PropertyValueFactory<>("cusName"));
        cTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        cGl.setCellValueFactory(new PropertyValueFactory<>("gl"));
        cCMT.setCellValueFactory(new PropertyValueFactory<>("cmt"));
        cTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
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
}
