package entities;


import javafx.Main;
import javafx.car.create.CreateController;
import javafx.car.list.ListController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.util.Objects;

public class Car {
    private Integer id;
    private String brand;
    private String name;

    private Integer deposit;
    private Integer price;
    private boolean status;
    private Button rent;


    public Car() {
    }

    public Button getRent() {
        return rent;
    }

    public void setRent(Button rent) {
        this.rent = rent;
    }


    public Car(Integer id,  String brand,String name, Integer deposit, Integer price, boolean status) {
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
                if (this.status=false){

                }
                Parent createForm = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("/javafx/car/create/create.fxml"))));
                Scene sc = new Scene(createForm, 1280, 800);

                Main.rootStage.setScene(sc);
                Main.rootStage.setTitle("Create Bill");
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
