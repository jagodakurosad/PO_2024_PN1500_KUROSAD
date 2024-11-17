package agh.ics.oop.model;

import java.util.List;

public class RectangularMap extends AbstractWorldMap{
    private final Vector2d lowerLeftCorner = new Vector2d(0,0);
    private final Vector2d upperRightCorner;

    public RectangularMap(int width, int height) {
        super();
        this.upperRightCorner = lowerLeftCorner.add(new Vector2d(width-1,height-1));
    }
    public Vector2d getLowerLeftCorner() {
        return lowerLeftCorner;
    }
    public Vector2d getUpperRightCorner() {
        return upperRightCorner;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (upperRightCorner.follows(position) && lowerLeftCorner.precedes(position) && super.canMoveTo(position));
    }
    @Override
    public String toString() {
        return visualizer.draw(lowerLeftCorner,upperRightCorner);
    }

    @Override
    public List getELements() {
        return null;
    }
}
