package com.example.booking_android_handin.model;

public class Hotel {
    private static  long id= 0;
    private String name;
    private String country;
    private String city;
    private String address;
    private double averagePrice;
    private Rooms rooms;

    public Hotel() {
        id++;
        rooms= new Rooms();
    }

    public Hotel(String name, String country) {
        id++;
        this.name = name;
        this.country = country;
        rooms= new Rooms();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static long getId() {
        return id;
    }

    public static void setId(long id) {
        Hotel.id = id;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", averagePrice=" + averagePrice +
                '}';
    }
}
