package exercises.design_pattern.builder_pattern.director;

import exercises.design_pattern.builder_pattern.builders.CarBuilder;
import exercises.design_pattern.builder_pattern.cars.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static exercises.design_pattern.builder_pattern.components.radioStation.ROCK;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SportCarTest {
    private Car car;
    @BeforeEach
    public void createSportCar(){
        Director director = new Director();
        CarBuilder builder = new CarBuilder();
        director.constructorSportsCar(builder);
        car = builder.getResult();
    }

    @Test
    void shouldCheckIfSeatsEquals2(){
        assertThat(car.getSeats(), is(2));
    }

    @Test
    void shoulcCheckIfCarIsStarted(){
        car.getEngine().on();
        assertThat(car.getEngine().isStarted(), is(true));
    }

    @Test
    void shouldRefuelCar(){
        car.refuel(4);
        assertThat(car.getFuelLevel(), is(4.0));
    }

    @Test
    void shouldChangeRadioStation(){
        car.getTripComputer().setRadioStation(ROCK);
        assertThat(car.getTripComputer().radio(), is(ROCK));
    }

    @Test//TODO
    void shouldCheckIfYouHaveEnoughFuelToGetToToronto(){
        assertThat(car.getTripComputer().showDistance("TORONTO"), is(700));
        assertThat(car.getTripComputer().checkIfUHaveEnoughFuel(), is(false));
    }

    @Test //todo
    void shouldCheckIfYouHaveEnoughFuelToGetToLASVEGAS(){
        assertThat(car.getTripComputer().showDistance("LASVEGAS"), is(800));
        car.refuel(9.0);
        assertThat(car.getTripComputer().checkIfUHaveEnoughFuel(), is(true));
    }

    @Test//todo check max distance
    void shouldCheckFuelLevel(){
        car.setFuelLevel(5.0);
        assertThat(car.getFuelLevel(), is(5.0));
    }

    @Test
    void shouldCheckDistanceLimit(){
        car.refuel(10.0);
        assertThat(car.getMaxDistanceLimit(), is(200.0));
        assertThat(car.getTripComputer().showDistanceLimit(), is("You're able to follow 200.0 miles"));
    }

    @Test
    void shouldCheckHowMuchFuelIsGone() throws Exception {
        car.getEngine().on();
        car.refuel(10.0);
        car.go(200);
        assertThat(car.getFuelLevel(), is(0.0));
    }
}