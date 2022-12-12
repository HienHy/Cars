package javafx.car.pay;

import entities.OderDetails;
import entities.Order;
import enums.RepoType;
import factory.Factory;
import helper.ComboBoxItem;
import impls.CarRepository;
import impls.DetailsRepository;

import impls.OrderRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;


import static helper.RootStage.rootStage;
import static javafx.car.create.CreateController.rentCar;

public class PayController implements Initializable {
    public static Order order;
    public TextField cusName;
    public TextField tel;
    public TextField deposit;
    public TextField tsdb;
    public TextField cmt;
    public TextField carBrand;
    public TextField carName;
    public TextField carNumber;
    public TextField nkt;
    public TextField suaChua;
    public ComboBox<ComboBoxItem> cbBgr;
    public DatePicker ntx;
    public TextField phiThue;
    public TextField total;
    public ComboBox<ComboBoxItem> cbNoiThat;
    public ComboBox<ComboBoxItem> cbDen;
    public ComboBox<ComboBoxItem> cbMam;
    public Integer noithat = 0;
    public Integer mamxe = 0;

    public Integer getSonxe() {
        return sonxe;
    }

    public void setSonxe(Integer sonxe) {
        this.sonxe = sonxe;
    }

    public Integer getDen() {
        return den;
    }

    public void setDen(Integer den) {
        this.den = den;
    }

    public Integer sonxe = 0;
    public Integer den = 0;

    public Integer getNoithat() {
        return noithat;
    }

    public void setNoithat(Integer noithat) {
        this.noithat = noithat;
    }

    public Integer getMamxe() {
        return mamxe;
    }

    public void setMamxe(Integer mamxe) {
        this.mamxe = mamxe;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        cusName.setText(order.getCusName());
        tel.setText(order.getTel());
        deposit.setText(order.getCarDeposit().toString());
        tsdb.setText(order.getGl());
        cmt.setText(order.getCmt().toString());
        carBrand.setText(order.getCarBrand());
        carName.setText(order.getCarName());
        carNumber.setText(order.getNumber());
        nkt.setText(order.getNkt().toString());

        ObservableList<ComboBoxItem> bgr = FXCollections.observableArrayList();
        bgr.add(new ComboBoxItem("Bình thường", 0));
        bgr.add(new ComboBoxItem("Hỏng", 1));
        cbBgr.setItems(bgr);
        cbBgr.setValue(new ComboBoxItem("Bình thường", 0));
        cbBgr.setConverter(new StringConverter<ComboBoxItem>() {

            @Override
            public String toString(ComboBoxItem object) {
                return object.getText();
            }

            @Override
            public ComboBoxItem fromString(String string) {
                return cbBgr.getItems().stream().filter(ap ->
                        ap.getText().equals(string)).findFirst().orElse(null);
            }

        });
        cbBgr.valueProperty().addListener((obs, oldval, newval) -> {
            if (newval.getValue() == 1) {
                if (Objects.equals(order.getCarName(), "X6")) {
                    setSonxe(1000000);
                } else if (Objects.equals(order.getCarName(), "CRV")) {
                    setSonxe(700000);
                } else if (Objects.equals(order.getCarName(), "K5")) {
                    setSonxe(600000);
                } else if (Objects.equals(order.getCarName(), "Camry 2.5Q")) {
                    setSonxe(800000);
                } else if (Objects.equals(order.getCarName(), "Lux A2.0")) {
                    setSonxe(500000);
                }
            }

            if (newval.getValue() == 0) {
                setSonxe(newval.getValue());

            }

            ;
            suaChua.setText(this.sum().toString());


        });

        ObservableList<ComboBoxItem> nt = FXCollections.observableArrayList();
        nt.add(new ComboBoxItem("Bình thường", 0));
        nt.add(new ComboBoxItem("Hỏng", 1));
        cbNoiThat.setItems(nt);
        cbNoiThat.setValue(new ComboBoxItem("Bình thường", 0));
        cbNoiThat.setConverter(new StringConverter<ComboBoxItem>() {

            @Override
            public String toString(ComboBoxItem object) {
                return object.getText();
            }

            @Override
            public ComboBoxItem fromString(String string) {
                return cbNoiThat.getItems().stream().filter(ap ->
                        ap.getText().equals(string)).findFirst().orElse(null);
            }

        });
        cbNoiThat.valueProperty().addListener((obs, oldval, newval) -> {
            if (newval.getValue() == 1) {
                if (Objects.equals(order.getCarName(), "X6")) {
                    setNoithat(10000000);
                } else if (Objects.equals(order.getCarName(), "CRV")) {
                    setNoithat(5000000);
                } else if (Objects.equals(order.getCarName(), "K5")) {
                    setNoithat(3000000);
                } else if (Objects.equals(order.getCarName(), "Camry 2.5Q")) {
                    setNoithat(6000000);
                } else if (Objects.equals(order.getCarName(), "Lux A2.0")) {
                    setNoithat(4000000);
                }
            }


            if (newval.getValue() == 0) {

                setNoithat(newval.getValue());
            }


            ;
            suaChua.setText(this.sum().toString());

        });


        ObservableList<ComboBoxItem> den = FXCollections.observableArrayList();
        den.add(new ComboBoxItem("Bình thường", 0));
        den.add(new ComboBoxItem("Hỏng", 1));
        cbDen.setItems(den);
        cbDen.setValue(new ComboBoxItem("Bình thường", 0));
        cbDen.setConverter(new StringConverter<ComboBoxItem>() {
            @Override
            public String toString(ComboBoxItem object) {
                return object.getText();
            }

            @Override
            public ComboBoxItem fromString(String string) {
                return cbDen.getItems().stream().filter(ap ->
                        ap.getText().equals(string)).findFirst().orElse(null);
            }

        });
        cbDen.valueProperty().addListener((obs, oldval, newval) -> {
            if (newval.getValue() == 1) {
                if (Objects.equals(order.getCarName(), "X6")) {
                    setDen(30000000);
                } else if (Objects.equals(order.getCarName(), "CRV")) {
                    setDen(10500000);
                } else if (Objects.equals(order.getCarName(), "K5")) {
                    setDen(6000000);
                } else if (Objects.equals(order.getCarName(), "Camry 2.5Q")) {
                    setDen(8000000);
                } else if (Objects.equals(order.getCarName(), "Lux A2.0")) {
                    setDen(5000000);
                }
            }

            ;
            if (newval.getValue() == 0)
                setDen(newval.getValue());

            suaChua.setText(this.sum().toString());
        });


        ObservableList<ComboBoxItem> mam = FXCollections.observableArrayList();
        mam.add(new ComboBoxItem("Bình thường", 0));
        mam.add(new ComboBoxItem("Hỏng", 1));
        cbMam.setItems(mam);
        cbMam.setValue(new ComboBoxItem("Bình thường", 0));
        cbMam.setConverter(new StringConverter<ComboBoxItem>() {

            @Override
            public String toString(ComboBoxItem object) {
                return object.getText();
            }

            @Override
            public ComboBoxItem fromString(String string) {
                return cbMam.getItems().stream().filter(ap ->
                        ap.getText().equals(string)).findFirst().orElse(null);
            }

        });
        cbMam.valueProperty().addListener((obs, oldval, newval) -> {
            if (newval.getValue() == 1) {
                if (Objects.equals(order.getCarName(), "X6")) {
                    setMamxe(20000000);
                } else if (Objects.equals(order.getCarName(), "CRV")) {
                    setMamxe(15000000);
                } else if (Objects.equals(order.getCarName(), "K5")) {
                    setMamxe(6000000);
                } else if (Objects.equals(order.getCarName(), "Camry 2.5Q")) {
                    setMamxe(8000000);
                } else if (Objects.equals(order.getCarName(), "Lux A2.0")) {
                    setMamxe(5500000);
                }
            }

            ;

            if (newval.getValue() == 0)
                setMamxe(newval.getValue());

            ;
            suaChua.setText(this.sum().toString());


        });


    }

    public Integer sum() {
        return this.mamxe + this.sonxe + this.den + this.noithat;
    }

    public void submit(ActionEvent actionEvent) {
        try {

            LocalDate d = ntx.getValue();
            Date dd = Date.valueOf(d);
            Date ntt = Date.valueOf(order.getNkt().toLocalDate());
            long noDay = ((dd.getTime() - ntt.getTime()) / (24 * 3600 * 1000));
            if (Math.toIntExact(noDay) >= 0) {
                Integer k = (order.carPrice) * Math.toIntExact(noDay) + order.getTotal();
                phiThue.setText(k.toString());

                Integer phi = Integer.parseInt(phiThue.getText());
                Integer phisua = Integer.parseInt(suaChua.getText());

                Integer t = phi + phisua - order.getCarDeposit();
                total.setText(t.toString());
                Integer tong = Integer.parseInt(total.getText());

                OderDetails s = new OderDetails(null, carBrand.getText(), carName.getText(), carNumber.getText(), dd, order.getCusName(), order.getTel(), order.getCmt(), order.getGl(), dd, phisua, phi, order.getCarDeposit(), tong, order.getStatus(), order.getCarId());
                DetailsRepository csc = (DetailsRepository) Factory.createRepository(RepoType.ORDERDETAILS);
                CarRepository car = (CarRepository) Factory.createRepository(RepoType.CAR);

//                   rentCar.setStatus("Khả Dụng");
                if (csc.create(s)) {
                    Pay();
                    return;
                }
            }
            throw new Exception("Ngày trả xe phải bằng hoặc sau khi hết hạn hợp đồng");


        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }

    }


    public void backToList(ActionEvent actionEvent) throws IOException {
        Parent listScene = FXMLLoader.load(getClass().getResource("../list/List.fxml"));
        Scene sc = new Scene(listScene, 860, 800);
        rootStage.setTitle("CarBareezy");
        rootStage.setScene(sc);
    }

    public void Pay() {

        try {
            Pane root = new Pane();
            Text a = new Text("Tên khách hàng:" + this.cusName.getText());
            Text v = new Text("Hoá Đơn");
            Text b = new Text("Số điện thoại: " + this.tel.getText());
            Text c = new Text("Địa chỉ :" + order.getAddress());
            Text d = new Text("Email:" + order.getEmail());
            Text e = new Text("Tên xe:" + this.carBrand.getText() + " " + this.carName.getText());
            Text f = new Text("Biển số:" + this.carNumber.getText());
            Text g = new Text("Giá/Ngày:" + order.carPrice);
            Text h = new Text("Ngày trả dự kiến:" + this.nkt.getText());
            Text y = new Text("Tài sản đảm bảo:" + this.tsdb.getText());
            Text k = new Text("Đặt cọc:" + this.deposit.getText());
            Text l = new Text("Ngày trả:" + this.ntx.getValue());
            Text m = new Text("Tổng phí sửa chữa:" + this.suaChua.getText());
            Text i = new Text("Tổng phí thuê xe:" + this.phiThue.getText());
            Text n = new Text("Số tiền cần thanh toán:" + this.total.getText());
            Button tienmat = new Button("Tiền Mặt");
            tienmat.setLayoutX(75.0);
            tienmat.setLayoutY(500.0);
            tienmat.setOnAction(event -> {
                try {
                    OrderRepository csc = (OrderRepository) Factory.createRepository(RepoType.ORDER);
                    CarRepository car = (CarRepository) Factory.createRepository(RepoType.CAR);
                    order.setStatus("Đã Thanh Toán");
                    rentCar.setStatus("Khả Dụng");
                    if (car.update(rentCar) && csc.update(order)) {
                        backToList(null);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setContentText("Thanh toán thành công");
     alert.show();
                    } else {
                        throw new Exception("Thanh toán Không thành công");
                    }


                } catch (Exception exception) {

                }


            });

            Button the = new Button("Thẻ");
            the.setLayoutX(225.0);
            the.setLayoutY(500.0);
            the.setOnAction(event -> {


            });
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
            h.setLayoutY(275.0);
            y.setLayoutX(50.0);
            y.setLayoutY(325.0);
            k.setLayoutX(50.0);
            k.setLayoutY(350.0);
            l.setLayoutX(50.0);
            l.setLayoutY(300.0);
            n.setLayoutX(50.0);
            n.setLayoutY(450.0);
            m.setLayoutX(50.0);
            m.setLayoutY(405.0);
            i.setLayoutX(50.0);
            i.setLayoutY(375.0);

            v.setLayoutX(130.0);
            v.setLayoutY(34.0);
            v.setFill(Color.BLACK);
            v.setStyle("-fx-font: 24 arial;");
            root.getChildren().addAll(a, b, c, d, e, f, g, h, y, k, l, n, v, m, i, tienmat, the
            );
            Scene scene = new Scene(root, 350, 600);
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(rootStage);
            stage.setTitle("CarBareezy");
            stage.setScene(scene);
            stage.showAndWait();


        } catch (Exception e) {

        }


    }


}
