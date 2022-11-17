package javafx.car.create;

import entities.Car;
import entities.Order;
import enums.RepoType;
import factory.Factory;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class CreateController implements Initializable {

    public static Car rentCar;

    public TextField txtName;
    public TextField txtEmail;

    public TextField txtTel;
    public TextField txtTime;
    public TextField txtGl;
    public TextField txtCMT;
    public TextField carBrand;
    public TextField carName;
    public TextField carPrice;
    public DatePicker nbd;
    public DatePicker nkt;

    public static boolean patternMatchesEmail(String emailAddress) {
        return Pattern.compile("^(.+)@(\\S+)$")
                .matcher(emailAddress)
                .matches();
    }
    public void initialize(URL location, ResourceBundle resources) {
        carBrand.setText(rentCar.getBrand());
        carName.setText(rentCar.getName());
        carPrice.setText(rentCar.getPrice().toString());


    }
    public void submit(ActionEvent actionEvent) {
        try {
            if (!patternMatchesEmail(txtEmail.getText())) throw new Exception("Email không hợp lệ");
            Integer cmt =Integer.parseInt(txtCMT.getText());
            Integer cpc =Integer.parseInt(carPrice.getText());
            Integer t=Integer.parseInt(txtTime.getText());
            Integer k = rentCar.getPrice()*t;
            if (txtTel.getText().startsWith("0")|| txtTel.getText().startsWith("+84")) {
                LocalDate d = nbd.getValue();
                LocalDate kt = nkt.getValue();
                Date dd = Date.valueOf(d);
                Date ntt = Date.valueOf(kt);
                System.out.println(ntt);
                Order s = new Order(null, txtName.getText(),txtTel.getText(),txtEmail.getText(),t,txtGl.getText(),cmt,k,carBrand.getText(),carName.getText(),cpc,dd,ntt);
                OrderRepository cs =(OrderRepository) Factory.createRepository(RepoType.ORDER);
                if (cs.create(s)) {
                    backToList(null);
                    return;
                }

            }else {

                throw new Exception("Nhập số điện thoại bắt đầu bằng 0 hoặc +84");
            }

            throw new Exception("Không thêm được dữ liệu");

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    public void backToList(ActionEvent actionEvent) throws Exception{
        Parent listScene = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Scene sc = new Scene(listScene,1280,800);
        Main.rootStage.setTitle("List Cars");
        Main.rootStage.setScene(sc);
    }

}
