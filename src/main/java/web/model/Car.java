package web.model;

public class Car {

    private String brand;

    private int series;

    private String name;

    public Car() { }

    public Car(String brand, int series, String name) {
        this.brand = brand;
        this.series = series;
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}