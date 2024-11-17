package agh.ics.oop.model;

public class Grass implements WorldElement {
    private final Vector2d grassPosition;
    public Grass(Vector2d grassPosition){
        this.grassPosition = grassPosition;
    }

    @Override
    public Vector2d getPositionOnMap(){
        return grassPosition; }
    @Override
    public String toString() {
        return "*";
    }
}
