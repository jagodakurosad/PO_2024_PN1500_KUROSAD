package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.List;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d, Grass> turtsOfGrass = new HashMap<>();
    public GrassField(int NumberOfTurtsOfGrass) {
        super();

        while(turtsOfGrass.size() < NumberOfTurtsOfGrass){
            Random random = new Random();
            Vector2d turtOfGrassPosition = new Vector2d(random.nextInt(0,(int) sqrt(10*NumberOfTurtsOfGrass) +1), random.nextInt(0,(int) sqrt(10*NumberOfTurtsOfGrass) +1));
            if(!turtsOfGrass.containsKey(turtOfGrassPosition)){
                turtsOfGrass.put(turtOfGrassPosition,new Grass(turtOfGrassPosition));
            }
        }
    }
    @Override
    public WorldElement objectAt (Vector2d position){
        WorldElement element = super.objectAt(position);
        if(element != null) { return element; }
        return turtsOfGrass.get(position);
    }

    @Override
    public List<WorldElement> getElements() {
        List<WorldElement> elementsOnMap = super.getElements();
        elementsOnMap.addAll(turtsOfGrass.values());

        return elementsOnMap;
    }

    @Override
    public String toString(){
        Vector2d upperRightCorner = new Vector2d((int) NEGATIVE_INFINITY, (int) NEGATIVE_INFINITY);
        Vector2d lowerLeftCorner = new Vector2d((int) POSITIVE_INFINITY, (int) POSITIVE_INFINITY);

        if(animals.isEmpty() && turtsOfGrass.isEmpty()){
            return visualizer.draw(new Vector2d(0,0),new Vector2d(0,0));
        }
        for(Vector2d currentTurtOfGrass : turtsOfGrass.keySet()){
            upperRightCorner = upperRightCorner.upperRight(currentTurtOfGrass);
            lowerLeftCorner = lowerLeftCorner.lowerLeft(currentTurtOfGrass);
        }
        for(Vector2d currentAnimal : animals.keySet()){
            upperRightCorner = upperRightCorner.upperRight(currentAnimal);
            lowerLeftCorner = lowerLeftCorner.lowerLeft(currentAnimal);
        }

        return visualizer.draw(lowerLeftCorner,upperRightCorner);
    }
}
