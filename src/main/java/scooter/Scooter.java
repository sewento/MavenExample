package scooter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


public class Scooter {
    private int id;
    private LocalDateTime start;
    private boolean blocked;
    private boolean rented;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public Scooter(int id) {
        this.id = id;
        this.blocked = false;
        this.rented = false;
    }
}
