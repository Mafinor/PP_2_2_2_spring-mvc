package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
@Component
public class CarService {
    private static int CAR_COUNT;
    private final List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car(++CAR_COUNT, "Ford", "Focus"));
        cars.add(new Car(++CAR_COUNT, "Dodge", "Viper"));
        cars.add(new Car(++CAR_COUNT, "Lada", "Granta"));
        cars.add(new Car(++CAR_COUNT, "BMW", "X3"));
        cars.add(new Car(++CAR_COUNT, "Renault", "Megane"));
    }

    public List<Car> getCars(Integer count) {
        if (count > 5 || count < 0) {
            return new ArrayList<>(cars.stream().toList());
        }
        return new ArrayList<>(cars.stream().limit(count).toList());
    }
}
