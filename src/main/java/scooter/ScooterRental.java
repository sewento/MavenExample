package scooter;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ScooterRental {
    private ArrayList<Scooter> rental = new ArrayList<>();

    public ArrayList<Scooter> getRental() {
        return rental;
    }

    public void addScooter(Scooter scooter) {
        rental.add(scooter);
    }

    public Scooter rentScooter(int id, LocalDateTime startTime) {
        Scooter toRent = null;
        for (Scooter scooter : rental) {
            if (scooter.getId() == id && (!scooter.isBlocked() || !scooter.isRented())) {
                toRent = scooter;
                scooter.setStart(startTime);
                scooter.setRented(true);
            }
        }
        return toRent;
    }

    public double returnScooter(int id, LocalDateTime current) {
        double cost = 0;
        for (Scooter scooter : rental) {
            if (scooter.getId() == id && scooter.isRented()) {
                scooter.setRented(false);
                cost = getCost(current, scooter);
                scooter.setStart(null);
            }
        }
        return cost;
    }

    public int getCost(LocalDateTime current, Scooter scooter) {
        return ((current.getHour() * 60) + current.getMinute()) - (scooter.getStart().getHour() * 60 + scooter.getStart().getMinute());
    }

    public void update(LocalDateTime current) {
        for (Scooter scooter : rental) {
            if (!scooter.isBlocked() && (current.isAfter(scooter.getStart().plusMinutes(120)))) {
                scooter.setBlocked(true);
            }
        }

    }

}
