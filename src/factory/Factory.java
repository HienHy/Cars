package factory;

import enums.RepoType;
import impls.CarRepository;

import impls.DetailsRepository;
import impls.OrderRepository;

import interfaces.IRepository;

public class Factory {
    public static IRepository createRepository(RepoType type) {
        switch (type) {
            case ORDER:
                return new OrderRepository();
            case CAR:
                return new CarRepository();
            case ORDERDETAILS:
                return new DetailsRepository();
            default:
                throw new IllegalArgumentException("Class not fount");

        }
    }
}
