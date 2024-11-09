package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> parse(String[] directionToParse) {
        List<MoveDirection> myDirections = new ArrayList<>();
        for (String direction : directionToParse) {
            MoveDirection toAdd =  switch(direction) {
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "l" -> MoveDirection.LEFT;
                case "r" -> MoveDirection.RIGHT;
                default -> null;
            };
            if (toAdd != null) {
                myDirections.add(toAdd);
            }
        }
        return myDirections;
    }
}
