package factory;

import enums.RepoType;
import impls.CarRepository;

import impls.OrderRepository;

import interfaces.IRepository;

public class Factory {
    public static IRepository createRepository(RepoType type) {
        switch (type) {
            case ORDER:
                return new OrderRepository();
            case CAR:
                return new CarRepository();
            default:
                throw new IllegalArgumentException("Class not fount");

        }
    }
}
