package exercises.design_pattern.builder_pattern.director;

import exercises.design_pattern.builder_pattern.builders.Builder;
import exercises.design_pattern.builder_pattern.cars.CarType;
import exercises.design_pattern.builder_pattern.components.Engine;
import exercises.design_pattern.builder_pattern.components.GPSNavigator;
import exercises.design_pattern.builder_pattern.components.Transmission;
import exercises.design_pattern.builder_pattern.components.TripComputer;

public class Director {

    //for all cars add additional parameter fuel usage

    public void constructorSportsCar(Builder builder){
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(5.0, 0));
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGpsNavigator(new GPSNavigator());
    }

    public void constructorCityCar(Builder builder){
        builder.setCarType(CarType.CITY_CAR);
        builder.setSeats(5);
        builder.setEngine(new Engine(1.6, 0));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGpsNavigator(new GPSNavigator());
    }

    public void constructorSUV(Builder builder){
        builder.setCarType(CarType.SUV);
        builder.setSeats(4);
        builder.setEngine(new Engine(3.0, 0));
        builder.setTransmission(Transmission.MANUAL);
        builder.setTripComputer(new TripComputer());
    }
}
