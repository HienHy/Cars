package impls;

import database.Connector;
import entities.Student;
import interfaces.IRepository;

import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentRepository implements IRepository<Student> {
    @Override
    public ArrayList<Student> all() {
        ArrayList<Student> ls = new ArrayList<>();
        try {
            Connector connector = Connector.getInstance();
            String sql = "select * from students";
            ResultSet rs = connector.query(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int mark = rs.getInt("mark");
                String gender = rs.getString("gender");
                Student s = new Student(id, name, email, mark, gender);
                ls.add(s);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ls;
    }

    @Override
    public Boolean create(Student s) {
        try {
            Connector connector = Connector.getInstance();
            String sql_txt = "insert into students(name,email,mark,gender) values(?,?,?,?)";
            ArrayList parameters = new ArrayList();
            parameters.add(s.getName());
            parameters.add(s.getEmail());
            parameters.add(s.getMark());
            parameters.add(s.getGender());
            return connector.execute(sql_txt,parameters);
        }catch (Exception e){
        }
        return false;
    }

    @Override
    public Boolean update(Student s) {
        try {
            Connector connector = Connector.getInstance();
            String sql_txt = "update students set name=?,email=?,mark=?,gender=? where id=?;";
            ArrayList parameters = new ArrayList();
            parameters.add(s.getName());
            parameters.add(s.getEmail());
            parameters.add(s.getMark());
            parameters.add(s.getGender());
            parameters.add(s.getId());
            return connector.execute(sql_txt,parameters);
        }catch (Exception e){
        }
        return false;
    }

    @Override
    public Boolean delete(Student s) {
        try {
            Connector connector = Connector.getInstance();
            String sql_txt = "delete from students where id=?;";
            ArrayList parameters = new ArrayList();
            parameters.add(s.getId());
            return connector.execute(sql_txt,parameters);
        }catch (Exception e){
        }
        return false;
    }

    @Override
    public Student find(int id) {
        try {
            Connector connector = Connector.getInstance();
            String sql_txt = "select * from student where id=?;";
            ArrayList parameters = new ArrayList();
            parameters.add(id);
            ResultSet rs = connector.query(sql_txt,parameters);
            while (rs.next()) {
                return new Student(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getInt("mark"),
                        rs.getString("gender"));
            }
        }catch (Exception e){
        }
        return null;
    }
}
