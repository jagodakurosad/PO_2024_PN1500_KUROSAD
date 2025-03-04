package agh.ics.oop.model;

import agh.ics.oop.model.util.IncorrectPositionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class GrassFieldTest {

    @Test
    void checkIfPlacingAnimalsOnGrassFieldWorksCorrectly() {
        //given
        WorldMap mapForAnimals = new GrassField(5);
        Animal animal1 = new Animal(new Vector2d(2, 2));
        Animal animal2 = new Animal(new Vector2d(2, 2));
        Animal animal3 = new Animal(new Vector2d(-1,8));

        //then
        assertDoesNotThrow(() -> mapForAnimals.place(animal1));
        assertThrows(IncorrectPositionException.class, () -> mapForAnimals.place(animal2));
        assertDoesNotThrow(() -> mapForAnimals.place(animal3));
    }

    @Test
    void checkIfNumberOfTuftsOfGrassOnMapIsCorrect() {
        //given
        WorldMap mapForAnimals = new GrassField(5);
        int tuftsOfGrassCounter = 0;

        //when
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (mapForAnimals.isOccupied(new Vector2d(i, j))) {
                    tuftsOfGrassCounter += 1;
                }
            }
        }

        //then
        assertEquals(5, tuftsOfGrassCounter);
    }

    @Test
    void checkIfMapActualizeAfterCorrectMovement() {
        //given
        WorldMap mapForAnimals = new GrassField(10);

        Vector2d position1 = new Vector2d(1, 3);
        Vector2d position2 = new Vector2d(0, 3);
        Vector2d position3 = new Vector2d(3, 3);

        Animal animal1 = new Animal(position1);
        Animal animal2 = new Animal(position2);
        Animal animal3 = new Animal(position3);

        try {
            mapForAnimals.place(animal1);
        }
        catch(IncorrectPositionException e){
            fail("Exception: " + e.getMessage());
        }

        try {
            mapForAnimals.place(animal2);
        }
        catch (IncorrectPositionException e){
            fail("Exception: " + e.getMessage());
        }

        try {
            mapForAnimals.place(animal3);
        }
        catch (IncorrectPositionException e){
            fail("Exception: " + e.getMessage());
        }

        //when
        mapForAnimals.move(animal1, MoveDirection.RIGHT);

        mapForAnimals.move(animal2, MoveDirection.LEFT);
        mapForAnimals.move(animal2, MoveDirection.FORWARD);

        mapForAnimals.move(animal3, MoveDirection.BACKWARD);

        //then
        assertEquals(position1, animal1.getPositionOnMap());
        assertEquals(new Vector2d(-1, 3), animal2.getPositionOnMap());
        assertEquals(new Vector2d(3, 2), animal3.getPositionOnMap());
    }

    @Test
    void checkIfPositionOnMapIsOccupied() {
        //given
        WorldMap mapForAnimals = new GrassField(1);

        boolean flag = false;
        Vector2d notOccupiedPosition = new Vector2d(-1,-1);
        Vector2d occupiedPosition = new Vector2d(-1,-1);

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(mapForAnimals.isOccupied(new Vector2d(i,j))){
                    occupiedPosition = new Vector2d(i,j);
                }
                else{
                    if(!flag){
                        flag=true;
                        notOccupiedPosition = new Vector2d(i,j);
                    }
                }
            }
        }

        //when
        boolean occupied1 = mapForAnimals.isOccupied(occupiedPosition);
        boolean occupied2 = mapForAnimals.isOccupied(notOccupiedPosition);

        //then
        assertTrue(occupied1);
        assertFalse(occupied2);
    }

    @Test
    void checkWhichObjectIsAtGivenPosition() {
        //given
        WorldMap mapForAnimals = new GrassField(1);

        int tuftsOfGrassCounter = 0;
        boolean flag = false;
        Vector2d notOccupiedPosition = new Vector2d(-1,-1);
        Vector2d occupiedPosition = new Vector2d(-1,-1);

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(mapForAnimals.isOccupied(new Vector2d(i,j))){
                    tuftsOfGrassCounter+=1;
                    occupiedPosition = new Vector2d(i,j);
                }
                else{
                    if(!flag){
                        flag=true;
                        notOccupiedPosition = new Vector2d(i,j);
                    }
                }
            }
        }
        //when

        //then
        assertEquals(1, tuftsOfGrassCounter);
        assertNull(mapForAnimals.objectAt(notOccupiedPosition));
        assertTrue(mapForAnimals.objectAt(occupiedPosition) instanceof Grass);
    }

    @Test
    void checkIfMoveToGivenPositionIsPossible() {
        //given
        WorldMap mapForAnimals = new GrassField(5);

        Vector2d position1 = new Vector2d(8,8);
        Vector2d position2 = new Vector2d(2,2);

        Animal animal1 = new Animal(position1);
        try {
            mapForAnimals.place(animal1);
        }
        catch(IncorrectPositionException e) {
            fail("Exception: " + e.getMessage());
        }

        //when
        boolean canMoveToEmptyPosition = mapForAnimals.canMoveTo(position2);
        boolean canMoveToOccupiedPosition = mapForAnimals.canMoveTo(position1);

        //then
        assertTrue(canMoveToEmptyPosition);
        assertFalse(canMoveToOccupiedPosition);
    }
}

