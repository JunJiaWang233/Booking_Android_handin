package com.example.booking_android_handin.model;

import java.util.ArrayList;
import java.util.List;

public class Rooms {
    private List<Room> rooms;

    public Rooms() {
        rooms= new ArrayList<>();
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void removeRoom(Room room){
        rooms.remove(room);
    }

    public String printRooms(){
        String s= "";
        for (Room r: rooms){
            s+= rooms.toString()+"/n";
        }
        return s;
    }
}
