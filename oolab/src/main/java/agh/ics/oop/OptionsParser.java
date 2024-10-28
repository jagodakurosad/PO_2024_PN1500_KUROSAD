package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        MoveDirection[] result = new MoveDirection[args.length];
        int i = 0;
        for (String arg : args) {
            MoveDirection toAdd =  switch(arg) {
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
