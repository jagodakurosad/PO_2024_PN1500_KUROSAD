package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void isNextDirectionCorrect() {
        //given
        MapDirection direction1 = MapDirection.WEST;
        MapDirection direction2 = MapDirection.SOUTH;
        MapDirection direction3 = MapDirection.EAST;
        MapDirection direction4 = MapDirection.NORTH;
        //when
        MapDirection nextDirection1 =  direction1.next();
        MapDirection nextDirection2 =  direction2.next();
        MapDirection nextDirection3 =  direction3.next();
        MapDirection nextDirection4 =  direction4.next();
        //then
        assertEquals(MapDirection.NORTH,nextDirection1);
        assertEquals(MapDirection.WEST,nextDirection2);
        assertEquals(MapDirection.SOUTH,nextDirection3);
        assertEquals(MapDirection.EAST,nextDirection4);

    }
    @Test
    void isPreviousDirectionCorrect() {
        //given
        MapDirection direction1 = MapDirection.WEST;
        MapDirection direction2 = MapDirection.SOUTH;
        MapDirection direction3 = MapDirection.EAST;
        MapDirection direction4 = MapDirection.NORTH;
        //when
        MapDirection nextDirection1 =  direction1.previous();
        MapDirection nextDirection2 =  direction2.previous();
        MapDirection nextDirection3 =  direction3.previous();
        MapDirection nextDirection4 =  direction4.previous();
        //then
        assertEquals(MapDirection.SOUTH,nextDirection1);
        assertEquals(MapDirection.EAST,nextDirection2);
        assertEquals(MapDirection.NORTH,nextDirection3);
        assertEquals(MapDirection.WEST,nextDirection4);
    }

}