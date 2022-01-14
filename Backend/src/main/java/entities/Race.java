package entities;

import dtos.RaceDTO;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "race")
public class Race implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private int id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    private String date;

    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    private String time;

    @Basic(optional = false)
    @NotNull
    @Column(name = "location")
    private String location;

    public Race() {
    }

    public Race(int id, String name, String date, String time, String location) {
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

    public Race updateFromDto(RaceDTO r) {
        this.name = r.getName();
        this.date = r.getDate();
        this.location = r.getLocation();
        return this;
    }

}
