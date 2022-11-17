package factory;

import enums.RepoType;
<<<<<<< HEAD
import impls.CarRepository;

import impls.OrderRepository;

=======
import impls.ClassesRepository;
import impls.StudentRepository;
>>>>>>> 75bc8c22af599ea9c1bcff8f5203f649d4cd4af5
import interfaces.IRepository;

public class Factory {
    public static IRepository createRepository(RepoType type){
        switch (type){
<<<<<<< HEAD
            case ORDER:return new OrderRepository();
            case CAR:return new CarRepository();
            default:throw new IllegalArgumentException("Class not fount");
=======
            case STUDENT: return new StudentRepository();
            case CLASSES: return new ClassesRepository();
            default: throw new IllegalArgumentException("Class not found");
>>>>>>> 75bc8c22af599ea9c1bcff8f5203f649d4cd4af5
        }
    }
}
