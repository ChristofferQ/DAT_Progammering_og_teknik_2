package dtos;

import entities.Race;

public class RaceDTO {

    private int id;
    private String name;
    private String date;
    private String time;
    private String location;

    public RaceDTO() { }

    public RaceDTO(Race r) {
        this.id = r.getId();
        this.name = r.getName();
        this.date = r.getDate();
        this.time = r.getTime();
        this.location = r.getLocation();
    }

    public RaceDTO(int id, String name, String date, String time, String location) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
