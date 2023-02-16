package exercises.design_pattern.builder_pattern.builders;

import exercises.design_pattern.builder_pattern.cars.CarType;
import exercises.design_pattern.builder_pattern.components.Engine;
import exercises.design_pattern.builder_pattern.components.GPSNavigator;
import exercises.design_pattern.builder_pattern.components.Transmission;
import exercises.design_pattern.builder_pattern.components.TripComputer;

public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGpsNavigator(GPSNavigator gpsNavigator);
}
