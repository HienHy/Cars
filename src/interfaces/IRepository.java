package interfaces;

import java.util.ArrayList;

public interface IRepository<E> {
    ArrayList<E> all();
    boolean create(E s);
    boolean update(E s);
    boolean delete(E s);
    E find(int id);

}
