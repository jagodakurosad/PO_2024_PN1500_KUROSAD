package agh.ics.oop;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine {
    private final List<Simulation> mySimulations;
    private final List<Thread> mapActualizationsThreads = new ArrayList<>();
    public SimulationEngine(List<Simulation> mySimulations){

        this.mySimulations = mySimulations;
        for(Simulation simulation : mySimulations){
            mapActualizationsThreads.add(new Thread(simulation));
        }
    }

    public void runSync() {
        for(Simulation simulation : mySimulations){
            simulation.run();
        }
    }

    public void runAsync() {
        for(Thread mapThread : mapActualizationsThreads){
            mapThread.start();
        }
    }

    public void awaitSimulationsEnd() throws InterruptedException{
        for(Thread mapThread : mapActualizationsThreads){
            mapThread.join();
        }
    }
}