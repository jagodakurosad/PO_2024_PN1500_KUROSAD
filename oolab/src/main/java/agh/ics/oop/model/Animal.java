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

    void move (MoveDirection direction) {

        Vector2d myNextPosition;

        if (direction == MoveDirection.RIGHT) {
            this.myDirection = myDirection.next();
        }
        if (direction == MoveDirection.LEFT) {
            this.myDirection = myDirection.previous();
        }
        if (direction == MoveDirection.FORWARD) {
            myNextPosition = this.positionOnMap.add(myDirection.toUnitVector());
        } else {
            myNextPosition = this.positionOnMap.add((myDirection.toUnitVector()).opposite());
        }
        if (myNextPosition.getX() >= 0 && myNextPosition.getX() <= 4 && myNextPosition.getY() >= 0 && myNextPosition.getY() <= 4) {
            this.positionOnMap = myNextPosition;
        }
    }
}
