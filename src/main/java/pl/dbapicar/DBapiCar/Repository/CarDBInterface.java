package pl.dbapicar.DBapiCar.Repository;

import pl.dbapicar.DBapiCar.models.Car;
import pl.dbapicar.DBapiCar.models.CarNews;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface CarDBInterface {

    public boolean addCar(Car car);
    public boolean updateCar(Car car);
    public Car findCarById(int id);
    public List<Car> findAllCars();
    public List<Car> findCarsByBrand(String brand);
    public List<Car> findCarsByColor(String model);
    public List<Car> findCarsByDate(LocalDate date);
    public List<Car> findCarsByDate(LocalDate from, LocalDate to);


    public List<CarNews> findAllCarNews();
    public CarNews findCarNewsById(int id);
    public List<CarNews> findCarNewsByName(String name);



}
