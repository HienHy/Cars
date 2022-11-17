package javafx.car.create;

import entities.Car;
import entities.Order;
import enums.RepoType;
import factory.Factory;
import impls.OrderRepository;
import javafx.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.regex.Pattern;

public class CreateController {

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
    public TextField nbd;
    public TextField nkt;

    public static boolean patternMatchesEmail(String emailAddress) {
        return Pattern.compile("^(.+)@(\\S+)$")
                .matcher(emailAddress)
                .matches();
    }

    public void submit(ActionEvent actionEvent) {
        try {
            if (!patternMatchesEmail(txtEmail.getText())) throw new Exception("Email không hợp lệ");
            Integer cmt =Integer.parseInt(txtCMT.getText());
            Integer t=Integer.parseInt(txtTime.getText());
            Integer k = rentCar.getPrice()*t;
            if (txtTel.getText().startsWith("0")|| txtTel.getText().startsWith("+84")) {
                Order s = new Order(null, txtName.getText(), txtTel.getText(), txtEmail.getText(),t,txtGl.getText(),cmt,k);
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
