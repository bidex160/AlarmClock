package com.example.alarmclock;

public class Array {
    int id;
    int hours;
    int min;

    public Array(int id, int hours, int min) {
        this.id = id;
        this.hours = hours;
        this.min = min;
    }

    public int getId() {
        return id;
    }

    public int getHours() {
        return hours;
    }

    public int getMin() {
        return min;
    }
}
