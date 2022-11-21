package entities;


import static helper.RootStage.rootStage;

import javafx.car.create.CreateController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.util.Objects;

public class Car {
    private Integer id;
    private String brand;
    private String name;

    private Integer deposit;
    private Integer price;
    private Boolean status;
    private Button rent;


    public Car() {
    }

    public Button getRent() {
        return rent;
    }

    public void setRent(Button rent) {
        this.rent = rent;
    }


    public Car(Integer id,  String brand,String name, Integer deposit, Integer price, Boolean status){
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.deposit = deposit;
        this.price = price;
        this.status = status;
        this.rent = new Button("Rent");
        this.rent.setOnAction(event -> {
            try {
                CreateController.rentCar = this;
                if (!this.status ){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("Xe da cho thue");
                    alert.show();
                    return;
                }
                Parent createForm = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("/javafx/car/create/create.fxml"))));
                Scene sc = new Scene(createForm, 1280, 800);
                rootStage.setScene(sc);
                rootStage.setTitle("Create Bill");


            }catch (Exception e){



            }

        });

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
