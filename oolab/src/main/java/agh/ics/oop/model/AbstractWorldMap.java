package agh.ics.oop.model;

import agh.ics.oop.model.util.Boundary;
import agh.ics.oop.model.util.IncorrectPositionException;
import agh.ics.oop.model.util.MapVisualizer;
import java.util.UUID;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap{

    protected final HashMap<Vector2d, Animal> animals = new HashMap<>();
    private final List<MapChangeListener> mapListeners = new ArrayList<>();
    private final MapVisualizer visualizer;
    private final UUID mapUUID;

    public AbstractWorldMap(){
        this.mapUUID = UUID.randomUUID();
        this.visualizer = new MapVisualizer(this);
    }

    public void addListener(MapChangeListener listener) {
        mapListeners.add(listener);
    }

    public void removeListener(MapChangeListener listener) {
        mapListeners.remove(listener);
    }
    private void mapChangedNotification(String message) {
        for (MapChangeListener listener: mapListeners){
            listener.mapChanged(this, message);
        }
    }

    @Override
    public void place(Animal animal) throws IncorrectPositionException {

        if (canMoveTo(animal.getPositionOnMap())) {
            animals.put(animal.getPositionOnMap(), animal);
            mapChangedNotification("Zwierzak został umieszczony na mapie: " + animal.getPositionOnMap());
        }
        else {
            throw new IncorrectPositionException(animal.getPositionOnMap());
        }
    }


    @Override
    public boolean canMoveTo(Vector2d position) { return !animals.containsKey(position); }
    @Override
    public void move(Animal animal, MoveDirection direction){
            if (animal == null) {
                return;
            }
            Vector2d currentPosition = animal.getPositionOnMap();
            animal.move(this, direction);
            Vector2d newPosition = animal.getPositionOnMap();
            animals.remove(currentPosition);
            animals.put(newPosition, animal);
            mapChangedNotification("Zwierzak ruszyl sie z pozycji: " + currentPosition +" na pozycje: " + newPosition );
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
    public abstract Boundary getCurrentBounds();

    public UUID getMapUUID() {
        return mapUUID;
    }

    @Override
    public String toString() {
        Boundary bounds = getCurrentBounds();
        return visualizer.draw(bounds.lowerLeftCorner(), bounds.upperRightCorner());
    }
}
