package entities;

import javafx.scene.control.Button;

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


    public Order() {
    }

    public Order(Integer cusId, String cusName, String tel, String email, Integer time,String gl,Integer cmt,Integer total) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.tel = tel;
        this.email = email;
        this.time = time;
        this.gl=gl;
        this.cmt=cmt;
        this.total=total;
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
