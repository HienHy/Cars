package impls;

import helper.Connector;
import entities.Car;
import interfaces.IRepository;
import javafx.scene.control.Alert;

import java.sql.Blob;
import java.sql.ResultSet;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;


public class CarRepository implements IRepository<Car>{

    @Override
    public ArrayList<Car> all() {
        ArrayList<Car> cas=new ArrayList<>();

        try {
            Connector connector = Connector.getInstance();
            String sql = "select * from car";
            ResultSet rs = connector.query(sql);


            while (rs.next()){
                int id = rs.getInt("id");
                String brand = rs.getString("brand");
                String name = rs.getString("name");
                String numbers= rs.getString("numbers");
                int deposit = rs.getInt("deposit");
                int price = rs.getInt("price");
                String status = rs.getString("status");

                //(assuming you have a ResultSet named RS)
                Blob blob = rs.getBlob("img");
                int blobLength = (int) blob.length();
                byte[] imgByte = blob.getBytes(1, blobLength);
                Car cs = new Car(id,brand,name,numbers,deposit,price,status,imgByte);
                cas.add(cs);
            }

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
        return cas;
    }

    @Override
    public boolean create(Car s) {
        return false;
    }

    @Override
    public boolean update(Car s) {
        try {
            Connector connector = Connector.getInstance();
            String sql = "update car set status = ? where id = ?";

            ArrayList parameters = new ArrayList();
            parameters.add(s.getStatus());
            parameters.add(s.getId());

            return connector.execute(sql, parameters);
        }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(e.getMessage());
                alert.show();
        }

            return false;
    }

    @Override
    public boolean delete(Car s) {
        return false;
    }

    @Override
    public Car find(int id) {
        return null;
    }
}
