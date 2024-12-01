package agh.ics.oop;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {
    private final List<Simulation> mySimulations;
    private final List<Thread> mapActualizationsThreads = new ArrayList<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);
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
        executorService.shutdown();
        if(!executorService.awaitTermination(10, TimeUnit.SECONDS)){
            executorService.shutdownNow();
        };
    }

    public void runAsyncInThreadPool() {
        for (Thread thread : mapActualizationsThreads){
            executorService.submit(thread);
        }
    }
}