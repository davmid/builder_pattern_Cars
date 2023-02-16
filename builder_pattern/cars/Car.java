package exercises.design_pattern.builder_pattern.cars;

import exercises.design_pattern.builder_pattern.components.Engine;
import exercises.design_pattern.builder_pattern.components.GPSNavigator;
import exercises.design_pattern.builder_pattern.components.Transmission;
import exercises.design_pattern.builder_pattern.components.TripComputer;

public class Car {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final TripComputer tripComputer;
    private final GPSNavigator gpsNavigator;
    private double fuelLevel = 0;
    private double maxDistance = 0;


    public Car(CarType carType, int seats, Engine engine, Transmission transmission, TripComputer tripComputer, GPSNavigator gpsNavigator) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.tripComputer = tripComputer;
        if (this.tripComputer != null) {
            this.tripComputer.setCar(this);
        }
        this.gpsNavigator = gpsNavigator;
    }

    public CarType getCarType() {
        return carType;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public double setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
        return fuelLevel;
    }

    public double refuel(double refuelValue) {
        fuelLevel = fuelLevel + refuelValue;
        return fuelLevel;
    }

    public int getSeats() {
        return seats;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public TripComputer getTripComputer() {
        return tripComputer;
    }

    public GPSNavigator getGpsNavigator() {
        return gpsNavigator;
    }

    //todo fuel usage
    public double go(double mileage) throws Exception {
        if (this.engine.isStarted() && mileage / 100 * engine.getVolume() >= fuelLevel) {
            this.engine.setMileage(mileage);
            this.setFuelLevel(getFuelLevel() - mileage / 100 * engine.getVolume());
        } else {
            throw new Exception("Cannot go(), you must start engine first!");
        }

        return mileage;
    }

    public String byeFuel(double mileage) {
        if (engine.getMileage() > 0) {
            setFuelLevel(getFuelLevel() - getFuelLevel() / (mileage / 100 * this.engine.getVolume()));
            return "There is: " + getFuelLevel() + " of fuel";
        } else {
            return "Road not set";
        }
    }

    //todo fuel usage
    public double getMaxDistanceLimit() {
        if (getFuelLevel() != 0) {
            maxDistance = getFuelLevel() / this.engine.getVolume() * 100;
        } else {
            maxDistance = 0;
        }

        return maxDistance;
    }
}
