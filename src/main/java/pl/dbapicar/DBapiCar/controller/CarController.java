package pl.dbapicar.DBapiCar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dbapicar.DBapiCar.models.CarNews;
import pl.dbapicar.DBapiCar.services.CarService;

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



}
