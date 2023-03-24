package web.service;

import org.springframework.stereotype.Component;
import web.dao.CarRepository;
import web.model.Car;
import java.util.List;
@Component
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars(Integer limit) {
        return carRepository.getCars(limit);
    }
}
