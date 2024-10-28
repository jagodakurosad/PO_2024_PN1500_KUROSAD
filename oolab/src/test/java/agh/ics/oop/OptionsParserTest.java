package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void testParseCorrectDirections() {
        // given
        String[] directions = {"f", "b", "l", "r"};
        // when
        MoveDirection[] result = OptionsParser.parse(directions);
        // then
        assertArrayEquals(new MoveDirection[]{
                MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.LEFT, MoveDirection.RIGHT}, result);
    }

    @Test
    void testParseIncorrectDirections() {
        // given
        String[] directions = {"i", "j", "k"};
        // when
        MoveDirection[] result = OptionsParser.parse(directions);
        // then
        assertArrayEquals(new MoveDirection[]{}, result);
    }

    @Test
    public void testParseBothCorrectAndIncorrectDirections() {
        // given
        String[] directions = {"f", "j", "b", "k", "l", "i", "r"};
        // when
        MoveDirection[] result = OptionsParser.parse(directions);
        // then
        assertArrayEquals(new MoveDirection[]{
                MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.LEFT, MoveDirection.RIGHT}, result);
    }

    @Test
    public void testParseEmptyArray() {
        // given
        String[] directions = {};
        // when
        MoveDirection[] result = OptionsParser.parse(directions);
        // then
        assertArrayEquals(new MoveDirection[]{}, result);
    }
}
