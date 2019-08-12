package scooter;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Scooter sc1 = new Scooter(10);

        ScooterRental sr1 = new ScooterRental();

        sr1.addScooter(sc1);

        Scooter srented = sr1.rentScooter(10, LocalDateTime.of(2019,8,12,10,57));
        sr1.update(LocalDateTime.of(2019,8,12,12,2));
        System.out.println(sc1.isBlocked());
        double cost = sr1.returnScooter(10,LocalDateTime.of(2019,8,12,13,2));
        System.out.println(cost);
    }
}
