package entities;

import javafx.car.create.CreateController;
import javafx.car.listBill.ListBillController;
import javafx.car.pay.PayController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Date;
import java.util.Objects;

import static helper.RootStage.rootStage;

public class Order {

    private Integer oderId;
    private String cusName;
    private String tel;
    private String email;
    private String gl;
    private Integer cmt;
    private Integer total;
    private Button pay;
    private Button chitiet;
    public String carBrand;
    public String carName;
    public Integer carPrice;

    public Integer getCarDeposit() {
        return carDeposit;
    }

    public void setCarDeposit(Integer carDeposit) {
        this.carDeposit = carDeposit;
    }

    public Integer carDeposit;
    private Integer carId;
    private String status;
    public Date nbd;
    public Date nkt;
    public String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTypeT() {
        return typeT;
    }

    public void setTypeT(String typeT) {
        this.typeT = typeT;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String typeT;
    public String address;




    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Integer getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Integer carPrice) {
        this.carPrice = carPrice;
    }

    public Date getNbd() {
        return nbd;
    }

    public void setNbd(Date nbd) {
        this.nbd = nbd;
    }

    public Date getNkt() {
        return nkt;
    }

    public void setNkt(Date nkt) {
        this.nkt = nkt;
    }

    public Order() {
    }

    public Order(Integer oderId, String cusName, String tel, String email,String gl,Integer cmt,Integer total,String carBrand,String carName,Integer carPrice,Date nbd,Date nkt,Integer carId,String status,String number,String address,Integer carDeposit) {
        this.oderId = oderId;
        this.cusName = cusName;
        this.tel = tel;
        this.email = email;
        this.gl=gl;
        this.cmt=cmt;
        this.total=total;
        this.carBrand=carBrand;
        this.carName=carName;
        this.carPrice=carPrice;
        this.nbd=nbd;
        this.nkt=nkt;
        this.carId =carId;
        this.status=status;
        this.number=number;
        this.carDeposit=carDeposit;

        this.address=address;

        this.chitiet = new Button("Chi tiết");
        this.chitiet.setOnAction(event -> {
            try {
                ListBillController.details=this;
//                FXMLLoader loader = new FXMLLoader(Main.class.getResource("/javafx/car/bill/BillDetails.fxml"));

                Pane root = new Pane();
                Text a = new Text("Tên khách hàng:"+this.cusName);
                Text v = new Text("Chi Tiết");
                Text b = new Text("Số điện thoại: "+this.tel);
                Text c = new Text("Địa chỉ :"+this.address);
                Text d = new Text("Email:"+this.email);
                Text e = new Text("Tên xe:"+this.carBrand+" "+this.carName);
                Text f = new Text("Biển số:"+this.number);
                Text g = new Text("Giá/Ngày:"+this.carPrice);
                Text h = new Text("Ngày trả dự kiến:"+this.nkt);
                Text y = new Text("Tài sản đảm bảo:"+this.gl);
                Text k = new Text("Đặt cọc:"+this.carDeposit);
                Text l = new Text("Ngày thuê:"+this.nbd);
                Text n = new Text("Số tiền thanh toán dự kiến:"+this.total);
                Text m = new Text("(Chưa trừ  cọc)");
                a.setLayoutX(50.0);
                a.setLayoutY(95.0);
                b.setLayoutX(50.0);
                b.setLayoutY(120.0);
                root.setStyle("-fx-font: 16 arial;");
                c.setLayoutX(50.0);
                c.setLayoutY(145.0);
                d.setLayoutX(50.0);
                d.setLayoutY(175.0);
                e.setLayoutX(50.0);
                e.setLayoutY(200.0);
                f.setLayoutX(50.0);
                f.setLayoutY(225.0);
                g.setLayoutX(50.0);
                g.setLayoutY(250.0);
                h.setLayoutX(50.0);
                h.setLayoutY(300.0);
                y.setLayoutX(50.0);
                y.setLayoutY(325.0);
                k.setLayoutX(50.0);
                k.setLayoutY(350.0);
                l.setLayoutX(50.0);
                l.setLayoutY(275.0);
                n.setLayoutX(50.0);
                n.setLayoutY(400.0);
                m.setLayoutX(50.0);
                m.setLayoutY(413.0);
                v.setLayoutX(130.0);
                v.setLayoutY(34.0);
                v.setFill(Color.BLACK);
                v.setStyle("-fx-font: 24 arial;");
                root.getChildren().addAll(a,b,c,d,e,f,g,h,y,k,l,n,m,v
                );
                Scene scene = new Scene(root, 350, 500);
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(rootStage);
                stage.setTitle("CarBareezy");
                stage.setScene(scene);
                stage.showAndWait();




            }catch (Exception e){

            }

        });
        this.pay = new Button("Thanh Toán");
        if (!Objects.equals(this.status, "Khả Dụng"))
            this.pay.setVisible(false);
        this.pay.setOnAction(event -> {
            try {

                PayController.order = this;
                Parent createForm = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("/javafx/car/pay/Pay.fxml"))));
                Scene sc = new Scene(createForm, 820, 800);
                rootStage.setScene(sc);
                rootStage.setTitle("CarBareezy");
//                Pane root = new Pane();
//                root.setPrefWidth(800.0);
//                root.setPrefHeight(600.0);
//                Text title=new Text("Hoá Đơn");
//                title.setLayoutX(485.0);
//                title.setLayoutY(60.0);
//                title.setStyle("-fx-font: 50 arial;");
//                root.getChildren().addAll(title);
//
//                Scene scene = new Scene(root, 800, 600);
//                Stage stage = new Stage();
//                stage.initModality(Modality.WINDOW_MODAL);
//                stage.initOwner(rootStage);
//                stage.setTitle("CarBareezy");
//                stage.setScene(scene);
//                stage.showAndWait();


            }catch (Exception e){

            }

        });
    }


    public String getGl() {
        return gl;
    }

    public void setGl(String gl) {
        this.gl = gl;
    }

    public Integer getCmt() {
        return cmt;
    }

    public void setCmt(Integer cmt) {
        this.cmt = cmt;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getOderId() {
        return oderId;
    }

    public void setOderId(Integer oderId) {
        this.oderId = oderId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Button getPay() {
        return pay;
    }

    public void setPay(Button pay) {
        this.pay = pay;
    }

    public Button getChitiet() {
        return chitiet;
    }

    public void setChitiet(Button chitiet) {
        this.chitiet = chitiet;
    }
}

