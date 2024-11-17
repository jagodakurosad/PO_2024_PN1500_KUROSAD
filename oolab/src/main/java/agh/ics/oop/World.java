package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;

public class World {
    public static void run(MoveDirection[] args){
        for (MoveDirection arg : args){
           switch (arg) {
               case MoveDirection.FORWARD -> System.out.println("zwierzak idzie do przodu");
               case MoveDirection.BACKWARD -> System.out.println("zwierzak idzie do tyłu");
               case MoveDirection.LEFT -> System.out.println("zwierzak skręca w lewo");
               case MoveDirection.RIGHT -> System.out.println("zwierzak skręca w prawo");
           }
        }

    }
    public static void main(String[] args) {

//        Animal myAnimal = new Animal();
//        System.out.println(myAnimal.toString());
        WorldMap map = new GrassField(10);
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"f","b", "r", "l","f","f", "r", "r", "f", "f", "f", "f", "f", "f", "f","f"});
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(map,positions, directions);
        simulation.run();
    }
}
