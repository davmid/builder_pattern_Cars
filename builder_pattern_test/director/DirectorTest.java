package exercises.design_pattern.builder_pattern.director;

import exercises.design_pattern.builder_pattern.builders.CarBuilder;
import exercises.design_pattern.builder_pattern.cars.Car;
import exercises.design_pattern.builder_pattern.components.radioStation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static exercises.design_pattern.builder_pattern.components.radioStation.POP;
import static exercises.design_pattern.builder_pattern.components.radioStation.ROCK;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class DirectorTest {

    Director director = new Director();
    CarBuilder builder = new CarBuilder();

    @Test
    void shouldCreateSportCar(){
        director.constructorSportsCar(builder);
        Car car = builder.getResult();

        car.getEngine().on();
        car.setFuelLevel(2);
    }

    @Test
    void test() {
        Director director = new Director();

        CarBuilder builder = new CarBuilder();
        director.constructorSportsCar(builder);
        Car car = builder.getResult();

        car.refuel(5);
        car.byeFuel(100);

        assertThat(car.getFuelLevel(), is(0.0));
        assertThat(car.getMaxDistanceLimit(), is(0.0));


        System.out.println(car.getTripComputer().showDistanceLimit());
    }
}