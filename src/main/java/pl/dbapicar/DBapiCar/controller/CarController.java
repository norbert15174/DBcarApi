package pl.dbapicar.DBapiCar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.dbapicar.DBapiCar.models.Car;
import pl.dbapicar.DBapiCar.models.CarNews;
import pl.dbapicar.DBapiCar.services.CarService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/")
public class CarController {

    CarService carService;
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/carnews")
    public List<CarNews> findAllCarNews(){
        return carService.findAllCarNews();
    }

    @GetMapping("/carnews/{id}")
    public CarNews findCarNewsById(@PathVariable int id){
        return carService.findCarNewsById(id);
    }

    @GetMapping("/carnews/name/{name}")
    public List<CarNews> findCarNewsByName(@PathVariable String name){
        return carService.findCarNewsByName(name);
    }


    @GetMapping("/carnews/date")
    public List<Car> findCarsByDateFromTo(@RequestParam LocalDate dateFrom, @RequestParam(required = false) LocalDate dateTo){
        if(dateTo != null) return carService.findCarsByDate(dateFrom,dateTo);
        return carService.findCarsByDate(dateFrom);
    }



}
