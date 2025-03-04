package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void comparingEqualityOfTwoVectors2d() {
        //when
        Vector2d vector1 = new Vector2d(4,3);
        Vector2d vector2 = new Vector2d(7,8);
        Vector2d vector3 = new Vector2d(7,8);
        Vector2d vector4 = new Vector2d(0,0);
        Vector2d vector5 = new Vector2d(0,0);
        Vector2d vector6 = new Vector2d(-5,-6);
        Vector2d vector7 = new Vector2d(-5,-6);
        Vector2d vector8 = new Vector2d(-4,3);
        Vector2d vector9 = new Vector2d(-4,3);

        //then
        assertFalse(vector1.equals(vector2));
        assertFalse(vector1.equals(vector8));

        assertTrue(vector2.equals(vector3));
        assertTrue(vector4.equals(vector5));
        assertTrue(vector6.equals(vector7));
        assertTrue(vector8.equals(vector9));

    }

    @Test
    void isToStringOK() {
        //when
        Vector2d vector1 = new Vector2d(1,3);
        //then
        assertEquals("(1, 3)",vector1.toString());
        assertNotEquals("(1,3)", vector1.toString());
    }

    @Test
    void oneVectorPrecedesOther(){
        //when
        Vector2d vector1 = new Vector2d(1,3);
        Vector2d vector2 = new Vector2d(1,2);
        Vector2d vector3 = new Vector2d(3,3);
        Vector2d vector4 = new Vector2d(8,8);
        Vector2d vector5 = new Vector2d(1,4);
        Vector2d vector6 = new Vector2d(0,3);
        Vector2d vector7 = new Vector2d(0,0);
        Vector2d vector8 = new Vector2d(-4,-4);

        //then

        assertTrue(vector1.precedes(vector3));
        assertTrue(vector1.precedes(vector4));
        assertTrue(vector1.precedes(vector5));
        assertTrue(vector8.precedes(vector1));

        assertFalse(vector1.precedes(vector6));
        assertFalse(vector1.precedes(vector7));
        assertFalse(vector1.precedes(vector2));
        assertFalse(vector1.precedes(vector7));
    }

    @Test
    void oneVectorFollowsOther(){
        //when
        Vector2d vector1 = new Vector2d(1,3);
        Vector2d vector2 = new Vector2d(1,2);
        Vector2d vector3 = new Vector2d(3,3);
        Vector2d vector4 = new Vector2d(8,8);
        Vector2d vector5 = new Vector2d(1,4);
        Vector2d vector6 = new Vector2d(0,3);
        Vector2d vector7 = new Vector2d(0,0);
        Vector2d vector8 = new Vector2d(-4,-4);

        //then

        assertFalse(vector1.follows(vector3));
        assertFalse(vector1.follows(vector4));
        assertFalse(vector1.follows(vector5));
        assertFalse(vector8.follows(vector1));

        assertTrue(vector1.follows(vector6));
        assertTrue(vector1.follows(vector7));
        assertTrue(vector1.follows(vector2));
        assertTrue(vector1.follows(vector7));
    }

    @Test
    void findUpperRight(){
        //given
        Vector2d vector1 = new Vector2d(1,3);
        Vector2d vector2 = new Vector2d(2,-1);
        Vector2d vector3 = new Vector2d(0,0);
        Vector2d vector4 = new Vector2d(-4,-1);
        //when
        Vector2d upperRightVector1And2 = vector1.upperRight(vector2);
        Vector2d upperRightVector1And3 = vector1.upperRight(vector3);
        Vector2d upperRightVector1And4 = vector1.upperRight(vector4);
        //then
        assertEquals(new Vector2d(2,3), upperRightVector1And2);
        assertEquals(new Vector2d(1,3), upperRightVector1And3);
        assertEquals(new Vector2d(1,3), upperRightVector1And4);

    }

    @Test
    void findLowerLeft(){
        //given
        Vector2d vector1 = new Vector2d(1,3);
        Vector2d vector2 = new Vector2d(2,-1);
        Vector2d vector3 = new Vector2d(0,0);
        Vector2d vector4 = new Vector2d(-4,-1);
        //when
        Vector2d lowerLeftVector1And2 = vector1.lowerLeft(vector2);
        Vector2d lowerLeftVector1And3 = vector1.lowerLeft(vector3);
        Vector2d lowerLeftVector1And4 = vector1.lowerLeft(vector4);
        //then
        assertEquals(new Vector2d(1,-1), lowerLeftVector1And2);
        assertEquals(new Vector2d(0,0),lowerLeftVector1And3);
        assertEquals(new Vector2d(-4,-1), lowerLeftVector1And4);

    }

    @Test
    void areVectorsOpposite(){
        //given
        Vector2d vector1 = new Vector2d(1,3);
        Vector2d vector2 = new Vector2d(-2,-1);
        Vector2d vector3 = new Vector2d(0,0);
        Vector2d vector4 = new Vector2d(-1,5);
        //when
        Vector2d vector1Opposite = vector1.opposite();
        Vector2d vector2Opposite = vector2.opposite();
        Vector2d vector3Opposite = vector3.opposite();
        Vector2d vector4Opposite = vector4.opposite();
        //then
        assertEquals(new Vector2d(-1,-3), vector1Opposite);
        assertEquals(new Vector2d(2,1), vector2Opposite);
        assertEquals(new Vector2d(0,0), vector3Opposite);
        assertEquals(new Vector2d(1, -5), vector4Opposite);
        assertNotEquals(new Vector2d(-1,3), vector1Opposite);
    }

    @Test
    void addTwoVectors() {
        //when
        Vector2d vector1 = new Vector2d(1,3);
        Vector2d vector2 = new Vector2d(-2,-1);
        Vector2d vector3 = new Vector2d(0,0);
        Vector2d vector4 = new Vector2d(-1,5);

        //then
        assertEquals(new Vector2d(-1,2), vector1.add(vector2));
        assertEquals(new Vector2d(1,3), vector1.add(vector3));
        assertEquals(new Vector2d(0,8), vector1.add(vector4));
        assertEquals(new Vector2d (-4,-2), vector2.add(vector2));
    }

    @Test
    void subtractTwoVectors() {
        //when
        Vector2d vector1 = new Vector2d(1,3);
        Vector2d vector2 = new Vector2d(-2,-1);
        Vector2d vector3 = new Vector2d(0,0);
        Vector2d vector4 = new Vector2d(-1,5);

        //then
        assertEquals(new Vector2d(3,4), vector1.subtract(vector2));
        assertEquals(new Vector2d(1,3), vector1.subtract(vector3));
        assertEquals(new Vector2d(2,-2),vector1.subtract(vector4));
        assertEquals(new Vector2d (0,0), vector2.subtract(vector2));
    }

}