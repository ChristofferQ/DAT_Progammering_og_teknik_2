package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "driver")
public class Driver implements Serializable {

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
    @Column(name = "birthYear")
    private String birthYear;

    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private String gender;

    @Basic(optional = false)
    @NotNull
    @Column(name = "location")
    private String location;

    @ManyToOne
    private Car car;

    public Driver() {
    }

    public Driver(int id, String name, String birthYear, String gender) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
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

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
