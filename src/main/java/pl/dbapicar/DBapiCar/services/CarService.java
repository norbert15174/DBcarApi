package pl.dbapicar.DBapiCar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.dbapicar.DBapiCar.Repository.CarDBInterface;
import pl.dbapicar.DBapiCar.models.Car;
import pl.dbapicar.DBapiCar.models.CarNews;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class CarService implements CarDBInterface {

    JdbcTemplate jdbcTemplate;


    @Autowired
    public CarService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void check(){
        LocalDate localDate = LocalDate.of(1994,5,25);
    }


    public boolean addCar(Car car){

        String q = "INSERT INTO Cars VALUES (?,?,?,?)";
        String idq = "SELECT id FROM Cars ORDER BY DESC LIMIT 1";
        Car carId = jdbcTemplate.queryForObject(idq,Car.class);

        if(carId != null){
            jdbcTemplate.update(q,carId.getId(), car.getBrand(),car.getColor(),car.getDate());
            return true;
        }
        return false;

    };

    public boolean updateCar(Car car){
        String q = "UPDATE Cars SET id=? , brand=? , color=? , date=? WHERE id=?";
        String idq = "SELECT id FROM Cars WHERE id=?";
        Car carId = jdbcTemplate.queryForObject(idq,Car.class,car.getId());
        if(carId != null){
            jdbcTemplate.update(q,carId.getId(), car.getBrand(),car.getColor(),car.getDate());
            return true;
        }
        return false;
    };

    public Car findCarById(int id){
        String idq = "SELECT id FROM Cars WHERE id=?";
        Car carId = jdbcTemplate.queryForObject(idq,Car.class,id);
        return carId;
    };

    private List<Car> getCarsData(List<Map<String,Object>> maps){
        List<Car> carList = new ArrayList<>();
        maps.stream().forEach(element -> carList.add(new Car(
                Integer.parseInt(String.valueOf(element.get("id"))),
                String.valueOf(element.get("brand")),
                String.valueOf(element.get("color")),
                LocalDate.parse(String.valueOf(element.get("dateCol")))
                )));
        return carList;
    }

    public List<Car> findAllCars(){
        String sql = "SELECT * FROM Cars";
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);

        return getCarsData(maps);
    };

    public List<Car> findCarsByBrand(String brand){
        String sql = "SELECT * FROM Cars WHERE brand=?";
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql,brand);
        return getCarsData(maps);
    };

    public List<Car> findCarsByColor(String color){
        String sql = "SELECT * FROM Cars WHERE color=?";
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql,color);
        return getCarsData(maps);
    };

    public List<Car> findCarsByDate(LocalDate date){
        String sql = "SELECT * FROM Cars WHERE dateCol=?";
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql,date);
        return getCarsData(maps);
    };

    public List<Car> findCarsByDate(LocalDate from, LocalDate to){
        String sql = "SELECT * FROM Cars WHERE dateCol>? AND dataCol<?";
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql,from,to);
        return getCarsData(maps);
    };



    private List<CarNews> getCarsNewsData(List<Map<String,Object>> maps){
        List<CarNews> carNewsList = new ArrayList<>();
        maps.stream().forEach(element -> carNewsList.add(new CarNews(

                String.valueOf(element.get("author")),
                String.valueOf(element.get("title")),
                String.valueOf(element.get("description")),
                String.valueOf(element.get("url")),
                String.valueOf(element.get("urlToImage")),
                String.valueOf(element.get("content")),
                Integer.parseInt(String.valueOf(element.get("id")))
                )));
        return carNewsList;
    }


    public List<CarNews> findAllCarNews(){
        String sql = "SELECT * FROM CarNews";
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);
        return getCarsNewsData(maps);
    };

    public CarNews findCarNewsById(int id){
        String idq = "SELECT * FROM CarNews WHERE id=?";
        CarNews carNews = jdbcTemplate.queryForObject(idq,(rs,rownum) ->
                new CarNews(rs.getNString(1)
                ,rs.getNString(2)
                ,rs.getNString(3)
                ,rs.getNString(4)
                ,rs.getNString(5)
                ,rs.getNString(6)
                ,rs.getInt(7)),id);
        return carNews;
    };



    public List<CarNews> findCarNewsByName(String name){
        String sql = "SELECT * FROM CarNews WHERE title LIKE ?";
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql,"%" + name + "%");
        return getCarsNewsData(maps);
    };



}
