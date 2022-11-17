package entities;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Date;

public class Order {
    private Integer cusId;
    private String cusName;
    private String tel;
    private String email;
    private Integer time;
    private String gl;
    private Integer cmt;
    private Integer total;

    private Button pay;


    public String carBrand;
    public String carName;
    public Integer carPrice;
    public Date nbd;
    public Date nkt;

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

    public Order(Integer cusId, String cusName, String tel, String email, Integer time,String gl,Integer cmt,Integer total,String carBrand,String carName,Integer carPrice,Date nbd,Date nkt) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.tel = tel;
        this.email = email;
        this.time = time;
        this.gl=gl;
        this.cmt=cmt;
        this.total=total;
        this.carBrand=carBrand;
        this.carName=carName;
        this.carPrice=carPrice;
        this.nbd=nbd;
        this.nkt=nkt;
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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer status) {
        this.time = status;
    }
    public Button getPay() {
        return pay;
    }

    public void setPay(Button pay) {
        this.pay = pay;
    }
}
