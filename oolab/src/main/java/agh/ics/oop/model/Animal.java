package agh.ics.oop.model;

public class Animal {
    private static final MapDirection DEFAULT_START_DIRECTION = MapDirection.NORTH;
    private Vector2d positionOnMap;
    private MapDirection myDirection;
    public Animal(){
        this.positionOnMap = new Vector2d(2,2);
        this.myDirection=DEFAULT_START_DIRECTION;
    }
    public Animal(Vector2d positionOnMap){
        this.positionOnMap = positionOnMap;
        this.myDirection= DEFAULT_START_DIRECTION;
    }
    @Override
    public String toString(){
        return "Animal's position: %s, direction: %s".formatted(this.positionOnMap, this.myDirection);
    }

    boolean isAtPosition(Vector2d currentPosition, MapDirection currentDirection){
        return this.positionOnMap.equals(currentPosition);
    }

}
