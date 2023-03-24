package web.dao;
import web.model.Car;
import java.util.List;

public interface CarRepository {
    List<Car> getCars(Integer limit);
}
