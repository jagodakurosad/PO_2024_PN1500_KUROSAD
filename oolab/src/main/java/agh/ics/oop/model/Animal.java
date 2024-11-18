package agh.ics.oop.model;

public class Animal implements WorldElement{
    private Vector2d positionOnMap;

    private MapDirection myDirection;

    public Animal() {
        this(new Vector2d(2, 2));
    }

    public Animal(Vector2d positionOnMap) {
        this.positionOnMap = positionOnMap;
        this.myDirection = MapDirection.NORTH;
    }

    public MapDirection getMyDirection() {
        return myDirection;
    }

    @Override
    public Vector2d getPositionOnMap() {
        return positionOnMap;
    }

    @Override
    public String toString() {
        return switch (this.myDirection) {
            case EAST -> "E";
            case WEST -> "W";
            case NORTH -> "N";
            case SOUTH -> "S";
        };
    }

    public boolean isAt(Vector2d position) {
        return this.positionOnMap.equals(position);
    }

    public void move(MoveValidator validator, MoveDirection direction) {
        Vector2d myNextPosition = this.positionOnMap;

        switch (direction) {
            case LEFT -> this.myDirection = myDirection.previous();
            case RIGHT -> this.myDirection = myDirection.next();
            case FORWARD -> myNextPosition = this.positionOnMap.add(myDirection.toUnitVector());
            case BACKWARD -> myNextPosition = this.positionOnMap.subtract(myDirection.toUnitVector());
        }

        if (validator.canMoveTo(myNextPosition)) {
            this.positionOnMap = myNextPosition;
        }
    }
}
