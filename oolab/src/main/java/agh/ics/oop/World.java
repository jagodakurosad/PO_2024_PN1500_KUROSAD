package agh.ics.oop;

public class World {
    public static void run(String[] args){
        for (String arg : args){
           switch (arg) {
                case "f" -> System.out.println("zwierzak idzie do przodu");
                case "b" -> System.out.println("zwierzak idzie do tyłu");
                case "l" -> System.out.println("zwierzak skręca w lewo");
                case "r" -> System.out.println("zwierzak skręca w prawo");
           }
        }

    }
    public static void main(String[] args) {
        System.out.println("System wystartował");
        run(args);
        System.out.println("System zakończył działanie");

    }
}
