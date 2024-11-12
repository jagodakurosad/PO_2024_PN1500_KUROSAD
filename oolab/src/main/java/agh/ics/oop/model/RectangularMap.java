package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import agh.ics.oop.model.util.MapVisualizer;

public class RectangularMap implements WorldMap{
    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final int width;
    private final int height;
    private final MapVisualizer visualizer;
    private final Vector2d lowerLeftCorner = new Vector2d(0,0);
    private final Vector2d upperRightCorner;

//    private final Vector2d beginningOfMap;
//    public Vector2d getBeginningOfMap() {
//        return beginningOfMap;
//    }
public RectangularMap(int width, int height) {
        this.height = height;
        this.width = width;
        this.visualizer = new MapVisualizer(this);
        this.upperRightCorner = lowerLeftCorner.add(new Vector2d(width-1,height-1));

//        this.beginningOfMap = beginningOfMap;
    }
    public Vector2d getLowerLeftCorner() {
        return lowerLeftCorner;
    }
    public Vector2d getUpperRightCorner() {
        return upperRightCorner;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
//        return (position.precedes(upperRight) && position.follows(lowerLeft));
        if (!(upperRightCorner.follows(position) && lowerLeftCorner.precedes(position))) {
            return false;
        } else {
            if (!isOccupied(position)) {
                return true;
            }
            return false;
        }
    }
    @Override
    public boolean place(Animal animal) {
        Vector2d currentPosition = animal.getPositionOnMap();

        if (canMoveTo(currentPosition)){
            animals.put(currentPosition,animal);
            return true;
        }
        else {
            return false;
        }

    }
    @Override
    public void move(Animal animal, MoveDirection direction) {
        if (animal == null || direction == null) { return; }
        Vector2d currentPosition = animal.getPositionOnMap();
        animal.move(this, direction);
        Vector2d nextPosition = animal.getPositionOnMap();

        if (!nextPosition.equals(currentPosition)){
            if (!animals.containsKey(nextPosition)) {
                animals.remove(currentPosition);
                this.place(animal);
            }
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
        return visualizer.draw(lowerLeftCorner,upperRightCorner);
    }
}
