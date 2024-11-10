package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

import agh.ics.oop.model.util.MapVisualizer;

public class RectangularMap implements WorldMap{
    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final int width;
    private final int height;
    private final MapVisualizer visualizer;
    private final Vector2d lowerLeft = new Vector2d(0,0);
    private final Vector2d upperRight;

//    private final Vector2d beginningOfMap;
//    public Vector2d getBeginningOfMap() {
//        return beginningOfMap;
//    }
public RectangularMap(int height, int width) {
        this.height = height;
        this.width = width;
        this.visualizer = new MapVisualizer(this);
        this.upperRight=lowerLeft.add(new Vector2d(width,height));

//        this.beginningOfMap = beginningOfMap;
    }
    public Vector2d getLowerLeft() {
        return lowerLeft;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(new Vector2d(lowerLeft.getX() + width, lowerLeft.getY() + height)) && position.follows(lowerLeft);
    }

    @Override
    public boolean place(Animal animal) {
        for(Vector2d currentPosition : animals.keySet()){
            if (animals.get(currentPosition)== animal){
                return canMoveTo(currentPosition);
            }
        }
        return false;
    }
    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d nextPosition = animal.getPositionOnMap();
        Vector2d currentPosition = animal.getPositionOnMap();
        MapDirection currentDirection = animal.getMyDirection();

        switch(direction) {
            case LEFT -> animal.setMyDirection(currentDirection.previous());
            case RIGHT -> animal.setMyDirection(currentDirection.next());
            case FORWARD -> nextPosition = currentPosition.add(currentDirection.toUnitVector());
            case BACKWARD -> nextPosition = currentPosition.subtract(currentDirection.toUnitVector());
        }
        if (canMoveTo(nextPosition) && !isOccupied(nextPosition)) {
            animal.setPositionOnMap(nextPosition);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        if (animals.containsKey(position)){
            return animals.get(position);
        }
        return null;
    }
    @Override
    public String toString() {
        return visualizer.draw(lowerLeft,upperRight);
    }
}
