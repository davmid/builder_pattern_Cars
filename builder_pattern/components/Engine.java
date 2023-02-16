package exercises.design_pattern.builder_pattern.components;

import exercises.design_pattern.builder_pattern.cars.Car;

public class Engine {
    private final double volume;
    private double mileage;
    private boolean started;

    public Engine(double volume, double mileage){
        this.volume = volume;
        this.mileage = mileage;
    }

    public void on(){
        started = true;
    }

    public void off(){
        started = false;
    }

    public boolean isStarted(){
        return started;
    }

    public double getVolume() {
        return volume;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }
}
