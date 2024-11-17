package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap{

    protected final HashMap<Vector2d, Animal> animals = new HashMap<>();
    protected final MapVisualizer visualizer;

    public AbstractWorldMap(){
        this.visualizer = new MapVisualizer(this);
    }

    @Override
    public boolean place(Animal animal) {

        if (canMoveTo(animal.getPositionOnMap())) {
            animals.put(animal.getPositionOnMap(), animal);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean canMoveTo(Vector2d position) { return !animals.containsKey(position); }
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
    public boolean isOccupied(Vector2d position){
        return objectAt(position)!=null;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public Collection<WorldElement> getElements(){
        return new ArrayList<>(animals.values());
    }
}
