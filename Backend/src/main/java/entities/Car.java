package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
    @Table(name = "car")
    public class Car implements Serializable {

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
    @Column(name = "brand")
    private String brand;

    @Basic(optional = false)
    @NotNull
    @Column(name = "make")
    private String make;

    @Basic(optional = false)
    @NotNull
    @Column(name = "year")
    private String year;

    @OneToMany(mappedBy = "car", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Driver> driverList;

    @ManyToMany
    @JoinTable(
            name = "Joined table",
            joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "race_id", referencedColumnName = "id"))
    private List<Race> races;

    public Car() {
    }

    public Car(int id, String name, String brand, String make, String year) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.make = make;
        this.year = year;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
