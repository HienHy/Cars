package entities;

import java.sql.Date;

public class OderDetails {
    private Integer id;
String status;
    public String carBrand;
    public String carName;
    public String carNumber;
    public Date  nkt;
    public String cusName;
    private String tel;
    private Integer cmt;
    private String gl;
    public Date  ntx;
    private Integer phisuachua;
    private Integer phithuexe;
    public Integer carDeposit;
    public Integer total;
    private Integer carId;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OderDetails() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OderDetails(Integer id, String carBrand, String carName, String carNumber, Date nkt, String cusName, String tel, Integer cmt, String gl, Date ntx, Integer phisuachua, Integer phithuexe, Integer carDeposit, Integer total,String status,Integer carId) {
        this.carBrand = carBrand;
        this.id=id;
        this.carName = carName;
        this.carNumber = carNumber;
        this.nkt = nkt;
        this.cusName = cusName;
        this.tel = tel;
        this.cmt = cmt;
        this.gl = gl;
        this.ntx = ntx;
        this.phisuachua = phisuachua;
        this.phithuexe = phithuexe;
        this.carDeposit = carDeposit;
        this.total = total;
        this.status=status;
this.carId=carId;
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

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Date getNkt() {
        return nkt;
    }

    public void setNkt(Date nkt) {
        this.nkt = nkt;
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

    public Integer getCmt() {
        return cmt;
    }

    public void setCmt(Integer cmt) {
        this.cmt = cmt;
    }

    public String getGl() {
        return gl;
    }

    public void setGl(String gl) {
        this.gl = gl;
    }

    public Date getNtx() {
        return ntx;
    }

    public void setNtx(Date ntx) {
        this.ntx = ntx;
    }

    public Integer getPhisuachua() {
        return phisuachua;
    }

    public void setPhisuachua(Integer phisuachua) {
        this.phisuachua = phisuachua;
    }

    public Integer getPhithuexe() {
        return phithuexe;
    }

    public void setPhithuexe(Integer phithuexe) {
        this.phithuexe = phithuexe;
    }

    public Integer getCarDeposit() {
        return carDeposit;
    }

    public void setCarDeposit(Integer carDeposit) {
        this.carDeposit = carDeposit;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
