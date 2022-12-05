package entities;

import enums.RepoType;
import factory.Factory;
import impls.CarRepository;
import javafx.car.listBill.ListBillController;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Order {
    private Integer cusId;
    private Integer carId;
    private Boolean status;

    private String tel;
    private String email;

    private String gl;
    private Integer cmt;
    private Integer total;



    private Button pay;

    public String carBrand;
    public String carName;
    public Integer carPrice;
    public Date nbd;
    public Date nkt;
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    private String cusName;

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

    public Order(Integer cusId, String cusName, String tel, String email,String gl,Integer cmt,Integer total,String carBrand,String carName,Integer carPrice,Date nbd,Date nkt,Integer carId,boolean status) {
        this.cusId = cusId;
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
        this.pay = new Button("Pay");
        this.pay.setOnAction(event -> {
            try {




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

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
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
}
