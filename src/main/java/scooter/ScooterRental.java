package scooter;

import java.time.LocalDateTime;
import java.util.ArrayList;

 class ScooterRental {
    private ArrayList<Scooter> rental = new ArrayList<>();

    void addScooter(Scooter scooter) {
        rental.add(scooter);
    }

     Scooter rentScooter(int id, LocalDateTime startTime) {
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

     double returnScooter(int id, LocalDateTime current) {
        double cost = 0;
        for (Scooter scooter : rental) {
            if (scooter.getId() == id && scooter.isRented()) {
                scooter.setRented(false);
                cost = getCost(current, scooter);
            }
        }
        return cost;
    }

    private int getCost(LocalDateTime current, Scooter scooter) {
        return ((current.getHour() * 60) + current.getMinute()) - (scooter.getStart().getHour() * 60 + scooter.getStart().getMinute());
    }

     void update(LocalDateTime current) {
        for (Scooter scooter : rental) {
            if (!scooter.isBlocked() && (current.isAfter(scooter.getStart().plusMinutes(120)))) {
                scooter.setBlocked(true);
            }
        }

    }

}
