package agh.ics.oop;

import agh.ics.oop.model.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<Animal> myAnimals;
    private final List<MoveDirection> myDirections;
    private final WorldMap map;

    public Simulation(WorldMap map, List<Vector2d> myPositions, List<MoveDirection> myDirections) {

        this.myAnimals = new ArrayList<>();
        this.myDirections = myDirections;
        this.map = map;

        for (Vector2d position : myPositions) {
            myAnimals.add(new Animal(position));
            map.place(new Animal(position));
        }
    }

    public void run(){
        int numberOfAnimals = myAnimals.size();
        int numberOfDirections = myDirections.size();

        for (int i = 0; i < numberOfDirections; i++) {

            int numberOfCurrentAnimal = i % numberOfAnimals;
            Animal myCurrentAnimal = myAnimals.get(numberOfCurrentAnimal);

            map.move(myCurrentAnimal, myDirections.get(i));
            System.out.println(myCurrentAnimal.getPositionOnMap());
            System.out.println(map.toString());
        }

    }
}
