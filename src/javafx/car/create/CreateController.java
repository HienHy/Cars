package javafx.car.create;

import entities.Car;
import entities.Order;
import enums.RepoType;
import factory.Factory;
import helper.ComboBoxItem;
import impls.CarRepository;
import impls.OrderRepository;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;


import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import static helper.RootStage.rootStage;


public class CreateController implements Initializable {

    public static Car rentCar;

    public TextField txtName;
    public TextField txtEmail;

    public TextField txtTel;
    public TextField txtGl;
    public TextField txtCMT;
    public TextField carBrand;
    public TextField carName;
    public TextField carPrice;
    public Integer carPriceOrigin = 0;
    public DatePicker nbd;
    public DatePicker nkt;
    
    public ComboBox<ComboBoxItem> cbKieuthue;
    public TextField indexGiaoxe;
    public TextField indexCus;
    public TextField carNumber;

    public TextField getIndexGiaoxe() {
        return indexGiaoxe;
    }

    public void setIndexGiaoxe(TextField indexGiaoxe) {
        this.indexGiaoxe = indexGiaoxe;
    }

    public static boolean patternMatchesEmail(String emailAddress) {
        return Pattern.compile("^(.+)@(\\S+)$")
                .matcher(emailAddress)
                .matches();
    }
    public void initialize(URL location, ResourceBundle resources) {
        carBrand.setText(rentCar.getBrand());
        carName.setText(rentCar.getName());
        carPrice.setText(rentCar.getPrice());
        carNumber.setText(rentCar.getNumbers());
        this.setCarPriceOrigin(rentCar.getPrice_origin());
//        carPriceOrigin.setText(rentCar.getPrice_origin().toString());


        ObservableList< ComboBoxItem> kieuthue = FXCollections.observableArrayList();
        kieuthue.add(new ComboBoxItem("Thuê theo ngày",0));
        kieuthue.add(new ComboBoxItem( "Thuê theo tháng",1));
        cbKieuthue.setItems(kieuthue);
        cbKieuthue.setValue(new ComboBoxItem("Thuê theo ngày",0));
        cbKieuthue.setConverter(new StringConverter<ComboBoxItem>() {

            @Override
            public String toString(ComboBoxItem object) {
                return object.getText();
            }

            @Override
            public ComboBoxItem fromString(String string) {
                return cbKieuthue.getItems().stream().filter(ap ->
                        ap.getText().equals(string)).findFirst().orElse(null);
            }

        });
        cbKieuthue.valueProperty().addListener((obs, oldval, newval) -> {
            if(newval.getValue() == 1) {
                carPrice.setText(new Car().convertCurrency(rentCar.getPrice_origin() * 80 / 100));
                this.setCarPriceOrigin(rentCar.getPrice_origin() * 80 / 100);
            }


            if(newval.getValue() == 0) {
                carPrice.setText(new Car().convertCurrency(rentCar.getPrice_origin()));
                this.setCarPriceOrigin(rentCar.getPrice_origin());
            }



        });



    }
    public void submit(ActionEvent actionEvent) {
        try {
            if (!patternMatchesEmail(txtEmail.getText()))throw new Exception("Email không hợp lệ");

            Integer cmt = Integer.parseInt(txtCMT.getText());
            Integer cpc = carPriceOrigin;

            LocalDate d = nbd.getValue();
            Date dd = Date.valueOf(d);
            LocalDate kt = nkt.getValue();
            Date ntt = Date.valueOf(kt);
            long noDay =Math.abs((ntt.getTime() - dd.getTime()) / (24 * 3600 * 1000));
            Integer k = cpc * Math.toIntExact(noDay);


            if (txtTel.getText().startsWith("0")|| txtTel.getText().startsWith("+84")) {
                Order s = new Order(
                        null, txtName.getText(),txtTel.getText(),txtEmail.getText(),
                        txtGl.getText(),cmt,k,carBrand.getText(),
                        carName.getText(),cpc,dd,ntt, rentCar.getId(),rentCar.getStatus(),rentCar.getNumbers(),indexCus.getText(),rentCar.getDeposit_origin());
                OrderRepository csc =(OrderRepository) Factory.createRepository(RepoType.ORDER);
                CarRepository car =(CarRepository) Factory.createRepository(RepoType.CAR);
                rentCar.setStatus("Không Khả Dụng");
                if (csc.create(s) && car.update(rentCar)) {
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
        Parent listScene = FXMLLoader.load(getClass().getResource("../list/List.fxml"));
        Scene sc = new Scene(listScene,860,800);
        rootStage.setTitle("CarBareezy");
        rootStage.setScene(sc);
    }

    public Integer getCarPriceOrigin() {
        return carPriceOrigin;
    }

    public void setCarPriceOrigin(Integer carPriceOrigin) {
        this.carPriceOrigin = carPriceOrigin;
    }
}

