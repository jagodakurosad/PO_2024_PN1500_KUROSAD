package agh.ics.oop;

public class World {
    public static void run(String[] args){
        System.out.println("Zwierzak idzie do przodu");
        String wynik ="";
        int dlugosc = args.length;
        int obecnaDlugosc = 0;
        for(String arg : args) {
            obecnaDlugosc += 1;
            if (dlugosc == obecnaDlugosc){
                wynik = wynik + arg;
            }
            else {
                wynik = wynik + arg + ", ";
            }
        }

    }
    public static void main(String[] args) {
        System.out.println("System wystartował");
        run(args);
        System.out.println("System zakończył działanie");

    }
}
