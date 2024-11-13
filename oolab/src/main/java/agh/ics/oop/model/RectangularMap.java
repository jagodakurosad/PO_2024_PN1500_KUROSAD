package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

import agh.ics.oop.model.util.MapVisualizer;

public class RectangularMap implements WorldMap{
    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final MapVisualizer visualizer;
    private static final Vector2d LOWER_LEFT_CORNER = new Vector2d(0,0);
    private final Vector2d upperRightCorner;

public RectangularMap(int width, int height) {
        this.visualizer = new MapVisualizer(this);
        this.upperRightCorner = LOWER_LEFT_CORNER.add(new Vector2d(width-1,height-1));
    }
    public Vector2d getLowerLeftCorner() {
        return LOWER_LEFT_CORNER;
    }
    public Vector2d getUpperRightCorner() {
        return upperRightCorner;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!(upperRightCorner.follows(position) && LOWER_LEFT_CORNER.precedes(position))) {
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
        if (animal == null) { return; }
        Vector2d currentPosition = animal.getPositionOnMap();
        animal.move(this, direction);
        Vector2d nextPosition = animal.getPositionOnMap();

        if (!nextPosition.equals(currentPosition)){
            animals.remove(currentPosition);
            this.place(animal);
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
        return visualizer.draw(LOWER_LEFT_CORNER,upperRightCorner);
    }
}
