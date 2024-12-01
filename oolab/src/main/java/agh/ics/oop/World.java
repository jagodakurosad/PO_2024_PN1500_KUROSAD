package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.RandomPositionGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;

public class World {
//    public static void run(MoveDirection[] args){
//        for (MoveDirection arg : args){
//           switch (arg) {
//               case MoveDirection.FORWARD -> System.out.println("zwierzak idzie do przodu");
//               case MoveDirection.BACKWARD -> System.out.println("zwierzak idzie do tyłu");
//               case MoveDirection.LEFT -> System.out.println("zwierzak skręca w lewo");
//               case MoveDirection.RIGHT -> System.out.println("zwierzak skręca w prawo");
//           }
//        }
//
//    }
    public static void main(String[] args) {

        //GrassField grassMap = new GrassField(10);
//        RectangularMap rectangularMap = new RectangularMap(5,5);
//        grassMap.addListener(new ConsoleMapDisplay());
//        rectangularMap.addListener(new ConsoleMapDisplay());



        try {
            List<MoveDirection> directions = OptionsParser.parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
            List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
            List<Simulation> simulations = new ArrayList<>();
            ConsoleMapDisplay mapDisplay = new ConsoleMapDisplay();

            for(int i=0; i < 400; i++){
                GrassField grassMap = new GrassField(5);
                grassMap.addListener(mapDisplay);
                simulations.add(new Simulation(grassMap,positions,directions));
            }
            for(int i=0; i < 600; i++){
                RectangularMap rectangularMap = new RectangularMap(4,4);
                rectangularMap.addListener(mapDisplay);
                simulations.add(new Simulation(rectangularMap,positions,directions));
            }
            SimulationEngine simulationEngine = new SimulationEngine(simulations);

            simulationEngine.runAsync();
            //simulationEngine.runSync();

            simulationEngine.awaitSimulationsEnd();
        }
        catch(IllegalArgumentException e){
            e.printStackTrace(System.err);
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("System zakończył działanie");
    }
}
