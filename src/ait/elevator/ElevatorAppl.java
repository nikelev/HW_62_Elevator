package ait.elevator;

import ait.elevator.model.Elevator;
import ait.elevator.task.Truck;

import java.util.Arrays;

public class ElevatorAppl {
    private static final int N_TRUCK = 1000;
    private static final int N_RACES = 10;
    private static final int CAPACITY = 20;

    public static void main(String[] args) throws InterruptedException {
        Elevator lenin = new Elevator("V. I. Lenin");
        Elevator marks = new Elevator("K. Marks");
        Truck[] trucks = new Truck[N_TRUCK];
        for (int i = 0; i < trucks.length; i++) {
            trucks[i] = new Truck(N_RACES, CAPACITY, lenin,marks);

        }
        Thread[] threads = new Thread[N_TRUCK];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(trucks[i]);
            threads[i].start();
        }
//        for (Thread thread : threads    ) {
//            thread.join();
//        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("Elevator " + lenin.getName() + " has " + lenin.getCurrentVolume());
        System.out.println("Elevator " + marks.getName() + " has " + marks.getCurrentVolume());
    }
}
