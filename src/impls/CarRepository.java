package impls;

import helper.Connector;
import entities.Car;
import interfaces.IRepository;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.util.ArrayList;

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
                int deposit = rs.getInt("deposit");
                int price = rs.getInt("price");
                boolean status = rs.getBoolean("status");
                Car cs = new Car(id,brand,name,deposit,price,status);
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
