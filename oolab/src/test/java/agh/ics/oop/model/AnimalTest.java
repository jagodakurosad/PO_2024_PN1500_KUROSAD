package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AnimalTest {
    @Test
    void isDefaultOrientationCorrect(){
        //when
        Animal myAnimal1 = new Animal();
        Animal myAnimal2 = new Animal(new Vector2d(1,3));
        //then
        assertEquals(MapDirection.NORTH, myAnimal1.getMyDirection());
        assertEquals(MapDirection.NORTH, myAnimal2.getMyDirection());
    }

    @Test
    void isOrientationAfterOneRotationCorrect() {
        //given
        Animal myAnimal1 = new Animal();
        Animal myAnimal2 = new Animal();

        WorldMap mapForAnimals = new RectangularMap(5,5);
        //when
        ;
        myAnimal1.move(mapForAnimals, MoveDirection.LEFT);
        myAnimal2.move(mapForAnimals, MoveDirection.RIGHT);

        //then
        assertEquals(MapDirection.WEST, myAnimal1.getMyDirection());
        assertEquals(MapDirection.EAST, myAnimal2.getMyDirection());
    }

    @Test
    void isOrientationAfterTwoRotationsCorrect() {
        //given
        WorldMap mapForAnimals = new RectangularMap(5,5);

        Animal myAnimal1 = new Animal();
        Animal myAnimal2 = new Animal();
        Animal myAnimal3 = new Animal();

        //when
        myAnimal1.move(mapForAnimals, MoveDirection.LEFT);
        myAnimal1.move(mapForAnimals, MoveDirection.LEFT);
        myAnimal2.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal2.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal3.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal3.move(mapForAnimals, MoveDirection.LEFT);

        //then
        assertEquals(MapDirection.SOUTH, myAnimal1.getMyDirection());
        assertEquals(MapDirection.SOUTH, myAnimal2.getMyDirection());
        assertEquals(MapDirection.NORTH, myAnimal3.getMyDirection());
    }

    @Test
    void isOrientationAfterThreeRotationsCorrect() {
        //given
        WorldMap mapForAnimals = new RectangularMap(5,5);

        Animal myAnimal1 = new Animal();
        Animal myAnimal2 = new Animal();

        //when
        myAnimal1.move(mapForAnimals, MoveDirection.LEFT);
        myAnimal1.move(mapForAnimals, MoveDirection.LEFT);
        myAnimal1.move(mapForAnimals, MoveDirection.LEFT);
        myAnimal2.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal2.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal2.move(mapForAnimals, MoveDirection.RIGHT);


        //then
        assertEquals(MapDirection.EAST, myAnimal1.getMyDirection());
        assertEquals(MapDirection.WEST, myAnimal2.getMyDirection());
    }

    @Test
    void isOrientationAfterFourRotationsCorrect() {
        //given
        WorldMap mapForAnimals = new RectangularMap(5,5);

        Animal myAnimal1 = new Animal();
        Animal myAnimal2 = new Animal();

        //when
        myAnimal1.move(mapForAnimals, MoveDirection.LEFT);
        myAnimal1.move(mapForAnimals, MoveDirection.LEFT);
        myAnimal1.move(mapForAnimals, MoveDirection.LEFT);
        myAnimal1.move(mapForAnimals, MoveDirection.LEFT);
        myAnimal2.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal2.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal2.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal2.move(mapForAnimals, MoveDirection.RIGHT);

        //then
        assertEquals(MapDirection.NORTH, myAnimal1.getMyDirection());
        assertEquals(MapDirection.NORTH, myAnimal2.getMyDirection());
    }

    @Test
    void isPositionAfterMovementCorrectPositionNORTH() {
        //given
        WorldMap mapForAnimals = new RectangularMap(5,5);

        Animal myAnimal1 = new Animal();
        Animal myAnimal2 = new Animal();

        //when
        myAnimal1.move(mapForAnimals, MoveDirection.FORWARD);
        myAnimal2.move(mapForAnimals, MoveDirection.BACKWARD);

        //then
        assertEquals(new Vector2d(2,3), myAnimal1.getPositionOnMap());
        assertEquals(new Vector2d(2,1), myAnimal2.getPositionOnMap());
    }

    @Test
    void isPositionAfterMovementCorrectPositionEAST() {
        //given
        WorldMap mapForAnimals = new RectangularMap(5,5);

        Animal myAnimal1 = new Animal();
        Animal myAnimal2 = new Animal();

        //when
        myAnimal1.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal1.move(mapForAnimals, MoveDirection.FORWARD);
        myAnimal2.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal2.move(mapForAnimals, MoveDirection.BACKWARD);

        //then
        assertEquals(new Vector2d(3,2), myAnimal1.getPositionOnMap());
        assertEquals(new Vector2d(1,2), myAnimal2.getPositionOnMap());
    }

    @Test
    void isPositionAfterMovementCorrectPositionSOUTH() {
        //given
        WorldMap mapForAnimals = new RectangularMap(5,5);

        Animal myAnimal1 = new Animal();
        Animal myAnimal2 = new Animal();

        //when
        myAnimal1.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal1.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal1.move(mapForAnimals, MoveDirection.FORWARD);
        myAnimal2.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal2.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal2.move(mapForAnimals, MoveDirection.BACKWARD);

        //then
        assertEquals(new Vector2d(2,1), myAnimal1.getPositionOnMap());
        assertEquals(new Vector2d(2,3), myAnimal2.getPositionOnMap());
    }

    @Test
    void isPositionAfterMovementCorrectPositionWEST() {
        //given
        WorldMap mapForAnimals = new RectangularMap(5,5);

        Animal myAnimal1 = new Animal();
        Animal myAnimal2 = new Animal();

        //when
        myAnimal1.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal1.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal1.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal1.move(mapForAnimals, MoveDirection.FORWARD);
        myAnimal2.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal2.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal2.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal2.move(mapForAnimals, MoveDirection.BACKWARD);

        //then
        assertEquals(new Vector2d(1,2), myAnimal1.getPositionOnMap());
        assertEquals(new Vector2d(3,2), myAnimal2.getPositionOnMap());
    }

    @Test
    void checkIfAnimalStaysWithinMyMap() {
        //given
        RectangularMap mapForAnimals = new RectangularMap(5,5);

        Vector2d[] myVectors2d = { mapForAnimals.getUpperRightCorner(), mapForAnimals.getLowerLeftCorner()};

        Animal myAnimal1 = new Animal(myVectors2d[0]);
        Animal myAnimal2 = new Animal(myVectors2d[0]);
        Animal myAnimal3 = new Animal(myVectors2d[0]);
        Animal myAnimal4 = new Animal(myVectors2d[0]);
        Animal myAnimal5 = new Animal(myVectors2d[1]);
        Animal myAnimal6 = new Animal(myVectors2d[1]);
        Animal myAnimal7 = new Animal(myVectors2d[1]);
        Animal myAnimal8 = new Animal(myVectors2d[1]);

        //when
        myAnimal1.move(mapForAnimals, MoveDirection.FORWARD);

        myAnimal2.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal2.move(mapForAnimals, MoveDirection.FORWARD);

        myAnimal3.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal3.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal3.move(mapForAnimals, MoveDirection.BACKWARD);

        myAnimal4.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal4.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal4.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal4.move(mapForAnimals, MoveDirection.BACKWARD);

        myAnimal5.move(mapForAnimals, MoveDirection.BACKWARD);

        myAnimal6.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal6.move(mapForAnimals, MoveDirection.BACKWARD);

        myAnimal7.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal7.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal7.move(mapForAnimals, MoveDirection.FORWARD);

        myAnimal8.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal8.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal8.move(mapForAnimals, MoveDirection.RIGHT);
        myAnimal8.move(mapForAnimals, MoveDirection.FORWARD);

        //then
        assertEquals(myVectors2d[0],myAnimal1.getPositionOnMap());
        assertEquals(myVectors2d[0],myAnimal2.getPositionOnMap());
        assertEquals(myVectors2d[0],myAnimal3.getPositionOnMap());
        assertEquals(myVectors2d[0],myAnimal4.getPositionOnMap());
        assertEquals(myVectors2d[1],myAnimal5.getPositionOnMap());
        assertEquals(myVectors2d[1],myAnimal6.getPositionOnMap());
        assertEquals(myVectors2d[1],myAnimal7.getPositionOnMap());
        assertEquals(myVectors2d[1],myAnimal8.getPositionOnMap());
    }
}
