package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    ArrayList<Animal> myAnimals;
    private List<MoveDirection> myDirections;

    public Simulation(List<Vector2d> myPositions, List<MoveDirection> myDirections) {
        myAnimals = new ArrayList<Animal>();
        this.myDirections=myDirections;
        for (Vector2d position : myPositions) {
            myAnimals.add(new Animal(position));
        }
    }
    public void run(){
        int numberOfAnimals = myAnimals.size();
        int numberOfDirections = myDirections.size();

        for (int i = 0; i < numberOfDirections; i++){
            int numberOfCurrentAnimal = i % numberOfAnimals;
            Animal myCurrentAnimal = myAnimals.get(numberOfCurrentAnimal);
            myCurrentAnimal.move(myDirections.get(i));
            System.out.println("Animal %s : %s".formatted(numberOfCurrentAnimal, myCurrentAnimal.toString()));
        }

    }
}
