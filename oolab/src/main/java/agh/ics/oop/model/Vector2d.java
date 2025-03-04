package agh.ics.oop.model;

import java.util.Objects;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Vector2d {
    private final int x;
    private final int y;

    public Vector2d(int x, int y) {
        this.x=x;
        this.y=y;
    }

    public int getX() {

        return x;
    }
    public int getY() {

        return y;
    }
    @Override
    public String toString(){
        return "(%s, %s)".formatted(x,y);
    }

    public boolean precedes(Vector2d other){

        return other.x >= this.x && other.y >= this.y;
    }
    boolean follows(Vector2d other){

        return other.x <= this.x && other.y <= this.y;
    }
    public Vector2d add(Vector2d other){

        return new Vector2d(this.x + other.x, this.y + other.y);
    }
    Vector2d subtract(Vector2d other){

        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    Vector2d upperRight(Vector2d other){

        return new Vector2d(max(this.x, other.x) , max(this.y, other.y));
    }

    Vector2d lowerLeft(Vector2d other){
        return new Vector2d(min(this.x, other.x), min(this.y, other.y));
    }

    Vector2d opposite() {
        return new Vector2d(-this.x , -this.y);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Vector2d)) return false;
        Vector2d myVector2d = (Vector2d) other;
        return x == myVector2d.x && y == myVector2d.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }
}
