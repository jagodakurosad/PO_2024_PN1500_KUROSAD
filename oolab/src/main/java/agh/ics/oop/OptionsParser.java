package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> parse(String[] directionToParse) {
        List<MoveDirection> myDirections = new ArrayList<>();
        for (String direction : directionToParse) {
            switch(direction) {
                case "f" -> myDirections.add(MoveDirection.FORWARD);
                case "b" -> myDirections.add(MoveDirection.BACKWARD);
                case "l" -> myDirections.add(MoveDirection.LEFT);
                case "r" -> myDirections.add(MoveDirection.RIGHT);
                default -> throw new IllegalArgumentException(direction + " is not legal move specification");
            };
        }
        return myDirections;
    }
}
