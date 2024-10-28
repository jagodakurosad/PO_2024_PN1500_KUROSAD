package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] directionToParse) {
        MoveDirection[] result = new MoveDirection[directionToParse.length];
        int i = 0;
        for (String direction : directionToParse) {
            MoveDirection toAdd =  switch(direction) {
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "l" -> MoveDirection.LEFT;
                case "r" -> MoveDirection.RIGHT;
                default -> null;
            };
            if (toAdd != null) {
                result[i++] = toAdd;
            }
        }
        return Arrays.copyOfRange(result, 0, i);
    }
}
