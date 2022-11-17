package impls;

import database.Connector;
import entities.Order;
import interfaces.IRepository;
import javafx.scene.control.Alert;
import java.sql.ResultSet;
import java.util.ArrayList;



public class OrderRepository implements IRepository<Order>{
    @Override
    public ArrayList<Order> all() {
        ArrayList<Order> ls=new ArrayList<>();
        try {
            Connector connector = Connector.getInstance();
            String sql = "select * from orders";
            ResultSet rs = connector.query(sql);
            while (rs.next()){
                int id = rs.getInt("cusId");
                String name = rs.getString("cusName");
                String tel = rs.getString("tel");
                String email = rs.getString("email");
                int time = rs.getInt("time");
                String gl = rs.getString("gl");
                int cmt = rs.getInt("cmt");
                int total = rs.getInt("total");

                Order s = new Order(id,name,tel,email,time,gl,cmt,total);
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
            String sql_txt = "insert into orders(cusName,tel,email,time,gl,cmt,total) values(?,?,?,?,?,?,?)";
            ArrayList parameters = new ArrayList();
            parameters.add(s.getCusName());
            parameters.add(s.getTel());
            parameters.add(s.getEmail());
            parameters.add(s.getTime());
            parameters.add(s.getGl());
            parameters.add(s.getCmt());
            parameters.add(s.getTotal());
            return connector.execute(sql_txt, parameters);

        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean update(Order s) {
        return false;
    }

    @Override
    public boolean delete(Order s) {
        return false;
    }


    @Override
    public Order find(int id) {
        return null;
    }


}
