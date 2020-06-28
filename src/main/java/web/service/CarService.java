package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {
    public List<Car> getAllCars();
    public void addCar(String brand, int series, String name);
}
