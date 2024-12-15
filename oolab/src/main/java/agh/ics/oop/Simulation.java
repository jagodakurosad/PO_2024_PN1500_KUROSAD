package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.IncorrectPositionException;

import java.util.ArrayList;
import java.util.List;

public class Simulation implements Runnable{
    private final List<Animal> myAnimals;
    private final List<MoveDirection> myDirections;
    private final WorldMap map;

    public Simulation(WorldMap map, List<Vector2d> myPositions, List<MoveDirection> myDirections) {

        this.myAnimals = new ArrayList<>();
        this.myDirections = myDirections;
        this.map = map;

        for (Vector2d position : myPositions) {
            Animal animal = new Animal(position);

            try {
                map.place(animal);
                myAnimals.add(animal);
            } catch (IncorrectPositionException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void run(){
        int numberOfAnimals = myAnimals.size();
        int numberOfDirections = myDirections.size();

        for (int i = 0; i < numberOfDirections; i++) {

            int numberOfCurrentAnimal = i % numberOfAnimals;
            Animal myCurrentAnimal = myAnimals.get(numberOfCurrentAnimal);

            map.move(myCurrentAnimal, myDirections.get(i));
            //System.out.println(map);
        }

    }
}
