package ait.elevator.task;

import ait.elevator.model.Elevator;

public class Truck implements Runnable{
    private  static Object monitor_0=new Object();
    private  static Object monitor_1=new Object();
    private int nRaces;
    private int capacity;
    private Elevator [] elevators;

    public Truck(int nRaces, int capacity, Elevator... elevators) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevators = elevators;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            synchronized (monitor_0){
                elevators[0].add(capacity/2);
            }
            synchronized (monitor_1){
                elevators[1].add(capacity/2);
            }

        }
    }

}
