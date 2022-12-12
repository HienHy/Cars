package entities;


import static helper.RootStage.rootStage;

import helper.Language;
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
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;


public class Car {
    private Integer id;
    private String brand;
    private String name;
    private String numbers;
    private String deposit;
    private Integer deposit_origin;
    private String price;

    public Integer getDeposit_origin() {
        return deposit_origin;
    }

    public void setDeposit_origin(Integer deposit_origin) {
        this.deposit_origin = deposit_origin;
    }

    private Integer price_origin;
    private String status;
    private Button rent;

    public Car() {

    }

    public Integer getPrice_origin() {
        return price_origin;
    }

    public void setPrice_origin(Integer price_origin) {
        this.price_origin = price_origin;
    }

    public ReadOnlyObjectWrapper<Image> img;

    public Image getImg() {
        return img.get();
    }

    public ReadOnlyObjectProperty<Image> imageProperty() {
        return img.getReadOnlyProperty();
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


    public Car(Integer id, String brand,String name,String numbers, Integer deposit, Integer price, String status, byte[] imgByte){
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.numbers=numbers;
        this.deposit = convertCurrency(deposit);
        this.price_origin = price;
        this.deposit_origin=deposit;
        this.price = convertCurrency(price);
        this.status = status;
        this.img = new ReadOnlyObjectWrapper<>(convertToJavaFXImage(imgByte, 100, 100));
        this.rent = new Button(Language._msg.getString("rent"));
        if (!Objects.equals(this.status, "Khả Dụng")){
            this.rent.setVisible(false);
        }
        this.rent.setOnAction(event -> {
            try {
                CreateController.rentCar = this;
                Parent createForm = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("/javafx/car/create/Create.fxml"))));
                Scene sc = new Scene(createForm, 860, 800);
                rootStage.setScene(sc);
                rootStage.setTitle("CarBareezy");

            }catch (Exception e){

            }

        });

    }

    public String convertCurrency(int currency) {
        Locale lc =new Locale("vi","VN");
        NumberFormat nf = NumberFormat.getCurrencyInstance(lc);
        return nf.format(currency);
    }
    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
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

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
