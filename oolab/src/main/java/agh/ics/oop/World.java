package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import static agh.ics.oop.OptionsParser.parse;

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
//        MoveDirection[] result = parse(args);
//        System.out.println("System wystartował");
//        run(result);
//        System.out.println("System zakończył działanie");

//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));

//        MapDirection direction = MapDirection.SOUTH;
//        Vector2d unitVector = direction.toUnitVector();
//        System.out.println("test metody toString() dla SOUTH: " + direction);
//        System.out.println("test metody next() dla SOUTH: " + direction.next());
//        System.out.println("test metody previous() dla SOUTH: " + direction.previous());
//        System.out.println("test metody toUnitVector() dla SOUTH: " + unitVector);

        Animal myAnimal = new Animal();
        System.out.println(myAnimal.toString());

    }
}
