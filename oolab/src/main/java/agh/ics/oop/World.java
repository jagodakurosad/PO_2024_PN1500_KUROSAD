package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

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
        MoveDirection[] result = parse(args);
        System.out.println("System wystartował");
        run(result);
        System.out.println("System zakończył działanie");

    }
}
