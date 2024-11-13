package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimulationTest {

    @Test
    void checkIfBasicSimulationWorksCorrectly() {
        // given
        WorldMap mapForAnimals = new RectangularMap(5,5);

        Vector2d position1 = new Vector2d(1,1);
        Vector2d position2 = new Vector2d(2, 2);
        List<Vector2d> startingPositions = List.of(position1,position2);

        List<MoveDirection> directions = List.of(
                MoveDirection.FORWARD, MoveDirection.RIGHT,
                MoveDirection.RIGHT, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.LEFT,
                MoveDirection.BACKWARD
        );

        Simulation simulation = new Simulation(mapForAnimals, startingPositions, directions);

        // when
        simulation.run();

        // then
        Animal animal1 = mapForAnimals.objectAt(new Vector2d(1, 2));
        Animal animal2 = mapForAnimals.objectAt(new Vector2d(3, 2));

        //assertNotNull(animal1);
        assertEquals(MapDirection.EAST, animal1.getMyDirection());

        assertNotNull(animal2);
        assertEquals(MapDirection.NORTH, animal2.getMyDirection());
    }

    @Test
    void checkIfNothingIncorrectHappensNearBoundary() {
        // given
        WorldMap mapForAnimals = new RectangularMap(4,5);

        Vector2d position = new Vector2d(3,4);

        List<Vector2d> initialPositions = List.of(position);

        List<MoveDirection> directions = List.of(
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD
        );

        Simulation simulation = new Simulation(mapForAnimals, initialPositions, directions);

        // when
        simulation.run();

        // then
        Animal animal = mapForAnimals.objectAt(position);

        assertNotNull(animal);
        assertEquals(position, animal.getPositionOnMap());
    }

    @Test
    void checkIfSimulationWorksWithOccupiedPosition() {
        // given
        WorldMap mapForAnimals = new RectangularMap(4,5);

        Vector2d position1 = new Vector2d(1,1);
        Vector2d position2 = new Vector2d(1,2);

        List<Vector2d> initialPositions = List.of(position1,position2);

        List<MoveDirection> directions = List.of(
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD
        );

        Simulation simulation = new Simulation(mapForAnimals, initialPositions, directions);

        // when
        simulation.run();

        // then
        Animal animal1 = mapForAnimals.objectAt(new Vector2d(1, 1));
        Animal animal2 = mapForAnimals.objectAt(new Vector2d(1, 2));

        assertNotNull(animal1);
        assertNotNull(animal2);
    }
}
