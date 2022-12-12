package impls;


import entities.OderDetails;
import helper.Connector;
import interfaces.IRepository;
import javafx.scene.control.Alert;


import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DetailsRepository implements IRepository<OderDetails> {
    @Override
    public ArrayList<OderDetails> all() {
        ArrayList<OderDetails> bill=new ArrayList<>();

        try {
            Connector connector = Connector.getInstance();
            String sql = "select * from bill";
            ResultSet rs = connector.query(sql);

            while (rs.next()){
                int id = rs.getInt("id");
                String carBrand = rs.getString("carBrand");
                String carName = rs.getString("carName");
                String carNumber= rs.getString("carNumber");
                Date nkt = rs.getDate("nkt");
                String cusName = rs.getString("cusName");
                String tel = rs.getString("tel");
                int cmt = rs.getInt("cmt");
                String gl = rs.getString("gl");
                Date ntx = rs.getDate("ntx");
                int phisuachua = rs.getInt("phisuachua");
                int phithuexe = rs.getInt("phithuexe");
                int carDeposit = rs.getInt("carDeposit");
                int total = rs.getInt("total");
                String status = rs.getString("status");
                int carId = rs.getInt("carid");





                //(assuming you have a ResultSet named RS)

                OderDetails cs = new OderDetails(id,carBrand,carName,carNumber,nkt,cusName,tel,cmt,gl,ntx,phisuachua,phithuexe,carDeposit,total,status,carId);
                bill.add(cs);
            }

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
        return bill;


    }

    @Override
    public boolean create(OderDetails s) {
        try {

            Connector connector = Connector.getInstance();
            String sql_txt = "insert into bill(carBrand,carName,carNumber,cusName,nkt,tel,cmt,gl,ntx,phisuachua,phithuexe,carDeposit,total,status,carId) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ArrayList parameters = new ArrayList();
            parameters.add(s.getCarBrand());
            parameters.add(s.getCarName());
            parameters.add(s.getCarNumber());
            parameters.add(s.getCusName());
            parameters.add(s.getNkt());
            parameters.add(s.getTel());
            parameters.add(s.getCmt());
            parameters.add(s.getGl());
            parameters.add(s.getNtx());
            parameters.add(s.getPhisuachua());
            parameters.add(s.getPhithuexe());
            parameters.add(s.getCarDeposit());
            parameters.add(s.getTotal());
            parameters.add(s.getStatus());
            parameters.add(s.getCarId());




            return connector.execute(sql_txt, parameters);

        } catch (Exception e) {

        }
        return false;


    }

    @Override
    public boolean update(OderDetails s) {

        return false;
    }

    @Override
    public boolean delete(OderDetails s) {
        return false;
    }

    @Override
    public OderDetails find(int id) {
        return null;
    }
}
