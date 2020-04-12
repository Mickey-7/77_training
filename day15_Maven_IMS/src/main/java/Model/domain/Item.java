package Model.domain;

import java.time.LocalDate;
import java.time.LocalTime;



public class Item {
    private long id;
    private String name;
    private double price;
    private boolean active;
    private LocalDate dateAdded;
    private LocalTime timeAdded;
    private LocalDate dateUpdated;
    private LocalTime timeUpdated;

    public Item(){}



    public Item(long id, String name, double price, boolean active, LocalDate dateAdded, LocalTime timeAdded, LocalDate dateUpdated, LocalTime timeUpdated) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.active = active;
        this.dateAdded = dateAdded;
        this.timeAdded = timeAdded;
        this.dateUpdated = dateUpdated;
        this.timeUpdated = timeUpdated;
    }

    public Item(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public LocalTime getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(LocalTime timeAdded) {
        this.timeAdded = timeAdded;
    }

    public LocalDate getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public LocalTime getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(LocalTime timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", active=" + active +
                ", dateAdded=" + dateAdded +
                ", timeAdded=" + timeAdded +
                ", dateUpdated=" + dateUpdated +
                ", timeUpdated=" + timeUpdated +
                '}';
    }
}
