package impls;


import helper.Connector;
import entities.Order;
import interfaces.IRepository;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;



public class OrderRepository implements IRepository<Order>{
    @Override
    public ArrayList<Order> all() {
        ArrayList<Order> ls=new ArrayList<>();
        try {
            Connector connector = Connector.getInstance();
            String sql = "select * from orders";
            ResultSet rs = connector.query(sql);
            while (rs.next()){
                int oderID = rs.getInt("oderID");
                String name = rs.getString("cusName");
                String tel = rs.getString("tel");
                String email = rs.getString("email");
                String gl = rs.getString("gl");
                int cmt = rs.getInt("cmt");
                int total = rs.getInt("total");
                String carBrand = rs.getString("carBrand");
                String carName = rs.getString("carName");
                int carPrice = rs.getInt("carPrice");
                Date nbd = rs.getDate("nbd");
                Date nkt = rs.getDate("nkt");
                int carId = rs.getInt("id");
                String status = rs.getString("status");
                String number = rs.getString("number");
                String address = rs.getString("address");
                int carDeposit = rs.getInt("carDeposit");


                Order s = new Order(oderID,name,tel,email,gl,cmt,total,carBrand,carName,carPrice,nbd,nkt,carId,status,number,address,carDeposit);
                ls.add(s);
            }

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
        return ls;


    }

    @Override
    public boolean create(Order s) {
        try {
            Connector connector = Connector.getInstance();
            String sql_txt = "insert into orders(cusName,tel,email,gl,cmt,total,carBrand,carName,carPrice,nbd,nkt,id,status,number,address,carDeposit) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ArrayList parameters = new ArrayList();
            parameters.add(s.getCusName());
            parameters.add(s.getTel());
            parameters.add(s.getEmail());
            parameters.add(s.getGl());
            parameters.add(s.getCmt());
            parameters.add(s.getTotal());
            parameters.add(s.getCarBrand());
            parameters.add(s.getCarName());
            parameters.add(s.getCarPrice());
            parameters.add(s.getNbd());
            parameters.add(s.getNkt());
            parameters.add(s.getCarId());
            parameters.add(s.getStatus());
            parameters.add(s.getNumber());
            parameters.add(s.getAddress());
            parameters.add(s.getCarDeposit());





            return connector.execute(sql_txt, parameters);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Order s) {
        try {
            Connector connector = Connector.getInstance();
            String sql = "UPDATE `orders` SET `status` = ? WHERE `orders`.`oderID` = ?";

            ArrayList parameters = new ArrayList();
            parameters.add(s.getStatus());
            parameters.add(s.getOderId());

            return connector.execute(sql, parameters);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }


        return false;
    }

    @Override
    public boolean delete(Order s) {
        try {
            Connector connector = Connector.getInstance();
            String sql = "DELETE FROM `orders` WHERE `orders`.`oderID`  = ?";

            ArrayList parameters = new ArrayList();
            parameters.add(s.getOderId());

            return connector.execute(sql, parameters);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }

        return false;
    }


    @Override
    public Order find(int id) {
        return null;
    }


}
