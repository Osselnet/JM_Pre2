package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService{

    private List<Car> cars = new ArrayList<>();

    public CarServiceImpl() {
        addCar("Mitsubisi", 1, "Padgero");
        addCar("Kia", 2, "Rio");
        addCar("Lada", 3, "Granta");
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public void addCar(String brand, int series, String name) {
        cars.add(new Car(brand, series, name));
    }
}
