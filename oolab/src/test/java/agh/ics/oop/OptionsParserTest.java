package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void testParseCorrectDirections() {
        // given
        String[] directions = {"f", "b", "l", "r"};
        // when
        List<MoveDirection> myDirections = OptionsParser.parse(directions);
        // then
        assertEquals(List.of(
                MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.LEFT, MoveDirection.RIGHT), myDirections);
    }

    @Test
    void testParseIncorrectDirections() {
        // given
        String[] directions = {"i", "j", "k"};
        // when
        List<MoveDirection> myDirections = OptionsParser.parse(directions);
        // then
        assertEquals(List.of(), myDirections);
    }

    @Test
    public void testParseBothCorrectAndIncorrectDirections() {
        // given
        String[] directions = {"f", "j", "b", "k", "l", "i", "r"};
        // when
        List<MoveDirection> myDirections = OptionsParser.parse(directions);
        // then
        assertEquals(List.of(
                MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.LEFT, MoveDirection.RIGHT), myDirections);
    }

    @Test
    public void testParseEmptyArray() {
        // given
        String[] directions = {};
        // when
        List<MoveDirection> myDirections = OptionsParser.parse(directions);
        // then
        assertEquals(List.of(), myDirections);
    }
}
