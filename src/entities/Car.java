package entities;


import static helper.RootStage.rootStage;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.car.create.CreateController;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;


public class Car {
    private Integer id;
    private String brand;
    private String name;

    private Integer deposit;
    private Integer price;
    private Boolean status;
    public ReadOnlyObjectWrapper<Image> img;

    public Image getImg() {
        return img.get();
    }

    public ReadOnlyObjectProperty<Image> imageProperty() {
        return img.getReadOnlyProperty();
    }

    private Button rent;


    public Car() {
    }

    public Button getRent() {
        return rent;
    }

    public void setRent(Button rent) {
        this.rent = rent;
    }

    private static Image convertToJavaFXImage(byte[] raw, final int width, final int height) {
        WritableImage image = new WritableImage(width, height);

        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(raw);
            BufferedImage read = ImageIO.read(bis);
            image = SwingFXUtils.toFXImage(read, null);
        } catch (IOException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }


    public Car(Integer id, String brand,String name, Integer deposit, Integer price, Boolean status, byte[] imgByte){
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.deposit = deposit;
        this.price = price;
        this.status = status;
        this.img = new ReadOnlyObjectWrapper<>(convertToJavaFXImage(imgByte, 100, 100));

        this.rent = new Button("Rent");
        if (!this.status ){
            this.rent.setVisible(false);
        }
        this.rent.setOnAction(event -> {
            try {
                CreateController.rentCar = this;
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
