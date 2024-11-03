package agh.ics.oop.model;

public class Animal {
    private Vector2d positionOnMap;
    private MapDirection myDirection;
    public Animal(){
        this(new Vector2d(2,2));
    }
    public Animal(Vector2d positionOnMap){
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
    public String toString(){
        return "position: %s, direction: %s".formatted(this.positionOnMap, this.myDirection);
    }

    boolean isAt(Vector2d position){
        return this.positionOnMap.equals(position);
    }

    public void move (MoveDirection direction) {

        Vector2d myNextPosition = this.positionOnMap;

        switch(direction) {
            case LEFT -> this.myDirection = myDirection.previous();
            case RIGHT -> this.myDirection = myDirection.next();
            case FORWARD -> myNextPosition = this.positionOnMap.add(myDirection.toUnitVector());
            case BACKWARD -> myNextPosition = this.positionOnMap.subtract(myDirection.toUnitVector());
        }

        if (myNextPosition.getX() >= 0 && myNextPosition.getX() <= 4 && myNextPosition.getY() >= 0 && myNextPosition.getY() <= 4) {
            this.positionOnMap = myNextPosition;
        }
    }
}
