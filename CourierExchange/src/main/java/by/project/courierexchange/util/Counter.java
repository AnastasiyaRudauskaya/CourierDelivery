package by.project.courierexchange.util;

public class Counter {
    private static int id;

    private Counter() {
    }
    public static int generateId() {
        return id++;
    }
}


