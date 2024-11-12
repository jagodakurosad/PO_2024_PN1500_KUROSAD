package agh.ics.oop.model;

public class Animal {
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

    public Vector2d getPositionOnMap() {
        return positionOnMap;
    }

    @Override
    public String toString() {
        MapDirection currentDirection = this.myDirection;
        switch (currentDirection) {
            case EAST -> {
                return "E";
            }
            case WEST -> {
                return "W";
            }
            case NORTH -> {
                return "N";
            }
            case SOUTH -> {
                return "S";
            }
        }
        return null;
    }
//        return "position: %s, direction: %s".formatted(this.positionOnMap, this.myDirection);
//    }

    public boolean isAt(Vector2d position) {
        return this.positionOnMap.equals(position);
    }

    public void newmove(MoveDirection direction) {

        final Vector2d bottomCorner = new Vector2d(0, 0);
        final Vector2d upperCorner = new Vector2d(4, 4);
        Vector2d myNextPosition = this.positionOnMap;

        switch (direction) {
            case LEFT -> this.myDirection = myDirection.previous();
            case RIGHT -> this.myDirection = myDirection.next();
            case FORWARD -> myNextPosition = this.positionOnMap.add(myDirection.toUnitVector());
            case BACKWARD -> myNextPosition = this.positionOnMap.subtract(myDirection.toUnitVector());
        }
        if (myNextPosition.precedes(upperCorner) && myNextPosition.follows(bottomCorner)) {
            this.positionOnMap = myNextPosition;
        }
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
