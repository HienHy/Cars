package interfaces;

<<<<<<< HEAD
=======
import entities.Student;
>>>>>>> 75bc8c22af599ea9c1bcff8f5203f649d4cd4af5

import java.util.ArrayList;

public interface IRepository<E> {
    ArrayList<E> all();
<<<<<<< HEAD
    boolean create(E s);
    boolean update(E s);
    boolean delete(E s);
    E find(int id);

=======
    Boolean create(E s);
    Boolean update(E s);
    Boolean delete(E s);
    E find(int id);
>>>>>>> 75bc8c22af599ea9c1bcff8f5203f649d4cd4af5
}
