package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    private int numberOfEvents = 0;
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        numberOfEvents +=1;
        System.out.println(message);
        System.out.println(worldMap);
        System.out.println("Liczba aktalizacji: " + numberOfEvents);
        System.out.println("Zmiany dotyczą mapy: " + worldMap.getMapUUID());

    }
}
