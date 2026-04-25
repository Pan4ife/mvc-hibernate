package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarsService {
    public List<Car> getCarsByCount(int count){
        List <Car> carList = new ArrayList<>();
        carList.add(new Car("BMW", 3, 2002));
        carList.add(new Car("Hyundai", 3000, 1970));
        carList.add(new Car("Mercedes", 45, 2005));
        carList.add(new Car("Lada", 666, 2020));
        carList.add(new Car("Honda", 50, 2026));
        if(count >= 5){
            return carList;
        } else {
            return carList.subList(0, count);
        }
    }
}
