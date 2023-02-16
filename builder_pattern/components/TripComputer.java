package exercises.design_pattern.builder_pattern.components;

import exercises.design_pattern.builder_pattern.cars.Car;

public class TripComputer{
    private Car car;
    private Engine engine;
    private radioStation radioStation;
    private int distance = 0;
    public void setCar(Car car) {
        this.car = car;
    }

    public String showFuelLevel() {
        return "Fuel level is: " + car.getFuelLevel();
    }

    public void showStatus() {
        if (this.car.getEngine().isStarted()) {
            System.out.println("Car is started.");
        } else {
            System.out.println("Car isn't started.");
        }
    }

    public String showDistanceLimit() {
        if (car.getFuelLevel() > 0){
            return "You're able to follow " + car.getMaxDistanceLimit() + " miles";
        }else{
            return "The tank is empty!";
        }
    }

    public exercises.design_pattern.builder_pattern.components.radioStation getRadioStation() {
        return radioStation;
    }

    public void setRadioStation(exercises.design_pattern.builder_pattern.components.radioStation radioStation) {
        this.radioStation = radioStation;
    }

    public exercises.design_pattern.builder_pattern.components.radioStation radio(){
        return getRadioStation();
    }

    public int showDistance(String city){
        for (int i = 0; i < city.length(); i++) {
            distance += 100;
        }
        return distance;
    }

    public boolean checkIfUHaveEnoughFuel(){
        if(distance < car.getFuelLevel()*100){
            return true;
        }else{
            return false;
        }
    }
}
