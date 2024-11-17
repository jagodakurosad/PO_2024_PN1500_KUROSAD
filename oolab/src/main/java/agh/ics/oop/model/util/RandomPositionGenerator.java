package agh.ics.oop.model.util;

import agh.ics.oop.model.Grass;
import agh.ics.oop.model.GrassField;
import agh.ics.oop.model.Vector2d;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class RandomPositionGenerator implements Iterable<Vector2d> {

    private final int maxWidth;
    private final int maxHeight;
    private final int tuftsOfGrassCount;

    private final int[][] listOfNumbersToDraw;

    public RandomPositionGenerator(int maxWidth, int maxHeight, int tuftsOfGrassCount){
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.tuftsOfGrassCount = tuftsOfGrassCount;
        this.listOfNumbersToDraw = new int[maxWidth*maxHeight][2];

        for(int i=0; i<maxWidth; i++){
            for(int j=0; j<maxHeight; j++){
                listOfNumbersToDraw[i*maxWidth + j] = new int[]{i, j};
            }
        }
    }

    @Override
    public Iterator<Vector2d> iterator() {
        return new GrassIterator(maxWidth, maxHeight, listOfNumbersToDraw, tuftsOfGrassCount);
    }
}
class GrassIterator implements Iterator<Vector2d>{
    private final int maxWidth;
    private final int maxHeight;
    private final int tuftsOfGrassCount;
    private final int[][] listOfNumbersToDraw;
    private int currentNumberOfDrawnTuftsOfGrass = 0;
    Random random = new Random();

    public GrassIterator(int maxWidth, int maxHeight, int[][] listOfNumbersToDraw, int tuftsOfGrassCount){
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.tuftsOfGrassCount = tuftsOfGrassCount;
        this.listOfNumbersToDraw = listOfNumbersToDraw;
    }

    @Override
    public boolean hasNext() {
        return currentNumberOfDrawnTuftsOfGrass < tuftsOfGrassCount;
    }
    @Override
    public Vector2d next() {
        int randomIndex = random.nextInt(maxHeight*maxWidth - currentNumberOfDrawnTuftsOfGrass);
        Vector2d currentTuftOfGrassPosition = new Vector2d(listOfNumbersToDraw[randomIndex][0], listOfNumbersToDraw[randomIndex][1]);

        int[] temporaryTable = listOfNumbersToDraw[maxHeight*maxWidth - currentNumberOfDrawnTuftsOfGrass -1];
        listOfNumbersToDraw[maxHeight*maxWidth - currentNumberOfDrawnTuftsOfGrass -1] = listOfNumbersToDraw[randomIndex];
        listOfNumbersToDraw[randomIndex] = temporaryTable;
        currentNumberOfDrawnTuftsOfGrass += 1;
        return currentTuftOfGrassPosition;
    }
}
