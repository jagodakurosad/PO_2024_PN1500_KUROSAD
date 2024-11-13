package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    void checkIfMoveToGivenPositionIsPossible(){
        //given
        WorldMap map = new RectangularMap(4,5);
        Vector2d position1 = new Vector2d(3,4);
        Vector2d position2 = new Vector2d(4,5);
        Vector2d position3 = new Vector2d(-1,3);
        Vector2d position4 = new Vector2d(0,3);
        Vector2d position5 = new Vector2d(0,0);
        //when

        //then
        assertTrue(map.canMoveTo(position1));
        assertFalse(map.canMoveTo(position2));
        assertFalse(map.canMoveTo(position3));
        assertTrue(map.canMoveTo(position4));
        assertTrue(map.canMoveTo(position5));
    }

    @Test
    void checkIfMapActualizeAfterCorrectMovement(){
        //given
        WorldMap mapForAnimals = new RectangularMap(4,5);

        Vector2d position1 = new Vector2d(1,3);
        Vector2d position2 = new Vector2d(0,3);
        Vector2d position3 = new Vector2d(3,3);

        Animal animal1 = new Animal(position1);
        Animal animal2 = new Animal(position2);
        Animal animal3 = new Animal(position3);

        mapForAnimals.place(animal1);
        mapForAnimals.place(animal2);
        mapForAnimals.place(animal3);

        //when
        mapForAnimals.move(animal1, MoveDirection.RIGHT);

        mapForAnimals.move(animal2, MoveDirection.LEFT);
        mapForAnimals.move(animal2, MoveDirection.FORWARD);

        mapForAnimals.move(animal3, MoveDirection.BACKWARD);

        //then
        assertEquals(position1, animal1.getPositionOnMap());
        assertEquals(position2, animal2.getPositionOnMap());
        assertEquals(new Vector2d(3,2), animal3.getPositionOnMap());
    }
    @Test
    void checkIfPlacingAnimalsOnMapWorksCorrectly() {
        // given
        WorldMap mapForAnimals = new RectangularMap(4, 5);

        Vector2d position1 = new Vector2d(0, 0);
        Vector2d position2 = new Vector2d(0, 3);
        Vector2d position3 = new Vector2d(1, 2);
        Vector2d position4 = new Vector2d(3, 4);
        Vector2d position5 = new Vector2d(0, 5);
        Vector2d position6 = new Vector2d(7, 8);
        Vector2d position7 = new Vector2d(-1, 2);

        Animal animal1 = new Animal(position1);
        Animal animal2 = new Animal(position2);
        Animal animal3 = new Animal(position3);
        Animal animal4 = new Animal(position4);
        Animal animal5 = new Animal(position5);
        Animal animal6 = new Animal(position6);
        Animal animal7 = new Animal(position7);

        Vector2d position8 = new Vector2d(1, 3);
        Vector2d position9 = new Vector2d(0, 3);
        Vector2d position10 = new Vector2d(3, 3);

        Animal animal8 = new Animal(position8);
        Animal animal9 = new Animal(position9);
        Animal animal10 = new Animal(position10);

        mapForAnimals.place(animal8);
        mapForAnimals.place(animal9);
        mapForAnimals.place(animal10);

        //then
        assertTrue(mapForAnimals.place(animal1));
        assertFalse(mapForAnimals.place(animal2));
        assertTrue(mapForAnimals.place(animal3));
        assertTrue(mapForAnimals.place(animal4));
        assertFalse(mapForAnimals.place(animal5));
        assertFalse(mapForAnimals.place(animal6));
        assertFalse(mapForAnimals.place(animal7));


        assertFalse(mapForAnimals.place(animal8));
        assertFalse(mapForAnimals.place(animal9));
    }

    @Test
    void checkIfPositionOnMapIsOccupied() {
        //given
        WorldMap mapForAnimals = new RectangularMap(4, 5);

        Vector2d position1 = new Vector2d(3,4);

        Animal animal1 = new Animal(position1);

        //when
        mapForAnimals.place(animal1);

        //then
        assertTrue(mapForAnimals.isOccupied(position1));
        assertFalse(mapForAnimals.isOccupied(new Vector2d(1,2)));
    }

    @Test
    void checkWhereOnMapIsChosenAnimal(){
        //given
        WorldMap mapForAnimals = new RectangularMap(4, 5);

        Vector2d position1 = new Vector2d(3,4);
        Vector2d position2 = new Vector2d(1,2);

        Animal animal1 = new Animal(position1);

        //when
        mapForAnimals.place(animal1);

        //then
        assertEquals(animal1,mapForAnimals.objectAt(position1));
        assertNull(mapForAnimals.objectAt(position2));
    }

}
