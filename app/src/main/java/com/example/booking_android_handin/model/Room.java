package com.example.booking_android_handin.model;

public class Room {
    private int roomNo;
    private boolean isAvailable= true;

    public Room(int roomNo, boolean isAvailable) {
        this.roomNo = roomNo;
        this.isAvailable = isAvailable;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNo=" + roomNo +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
