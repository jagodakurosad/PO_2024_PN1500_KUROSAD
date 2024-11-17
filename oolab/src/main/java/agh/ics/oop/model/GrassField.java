package agh.ics.oop.model;

import agh.ics.oop.model.util.RandomPositionGenerator;

import java.util.*;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d, Grass> tuftsOfGrass = new HashMap<>();
    public GrassField(int NumberOfTuftsOfGrass) {
        super();

        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator((int) sqrt(10*NumberOfTuftsOfGrass), (int) sqrt(10*NumberOfTuftsOfGrass), NumberOfTuftsOfGrass);
        Iterator<Vector2d> positionsIterator = randomPositionGenerator.iterator();

        while(positionsIterator.hasNext()) {
            Vector2d tuftOfGrassPosition = positionsIterator.next();
            tuftsOfGrass.put(tuftOfGrassPosition, new Grass(tuftOfGrassPosition));
        }
//        while(tuftsOfGrass.size() < NumberOfTuftsOfGrass){
//            Random random = new Random();
//            Vector2d tuftOfGrassPosition = new Vector2d(random.nextInt(0,(int) sqrt(10*NumberOfTuftsOfGrass) +1), random.nextInt(0,(int) sqrt(10*NumberOfTuftsOfGrass) +1));
//            if(!tuftsOfGrass.containsKey(tuftOfGrassPosition)){
//                tuftsOfGrass.put(tuftOfGrassPosition,new Grass(tuftOfGrassPosition));
//            }
//        }
    }
    @Override
    public WorldElement objectAt (Vector2d position){
        WorldElement element = super.objectAt(position);
        if(element != null) { return element; }
        return tuftsOfGrass.get(position);
    }

    @Override
    public Collection<WorldElement> getElements() {
        Collection<WorldElement> elementsOnMap = super.getElements();
        elementsOnMap.addAll(tuftsOfGrass.values());

        return elementsOnMap;
    }

    @Override
    public String toString(){
        Vector2d upperRightCorner = new Vector2d((int) NEGATIVE_INFINITY, (int) NEGATIVE_INFINITY);
        Vector2d lowerLeftCorner = new Vector2d((int) POSITIVE_INFINITY, (int) POSITIVE_INFINITY);

        if(animals.isEmpty() && tuftsOfGrass.isEmpty()){
            return visualizer.draw(new Vector2d(0,0),new Vector2d(0,0));
        }
        for(Vector2d currentTuftOfGrass : tuftsOfGrass.keySet()){
            upperRightCorner = upperRightCorner.upperRight(currentTuftOfGrass);
            lowerLeftCorner = lowerLeftCorner.lowerLeft(currentTuftOfGrass);
        }
        for(Vector2d currentAnimal : animals.keySet()){
            upperRightCorner = upperRightCorner.upperRight(currentAnimal);
            lowerLeftCorner = lowerLeftCorner.lowerLeft(currentAnimal);
        }

        return visualizer.draw(lowerLeftCorner,upperRightCorner);
    }
}
