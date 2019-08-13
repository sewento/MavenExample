import org.junit.jupiter.api.Test;
import scooter.Scooter;
import scooter.ScooterRental;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ScooterRentalTest {

    @Test
    void addScooter() {
        ScooterRental rental = new ScooterRental();
        Scooter scooter1 = new Scooter(1);
        Scooter scooter2 = new Scooter(2);
        rental.addScooter(scooter1);
        rental.addScooter(scooter2);

        assertEquals(2,rental.getRental().size());
    }

    @Test
    void rentScooter() {
        ScooterRental rental = new ScooterRental();
        Scooter scooter1 = new Scooter(1);
        rental.addScooter(scooter1);
        rental.rentScooter(1, LocalDateTime.of(2019,8,12,13,2));

        assertTrue(scooter1.isRented());
    }

    @Test
    void returnScooter() {
    }

    @Test
    void notBlockingLessThan2HoursRent() {
        ScooterRental rental = new ScooterRental();
        Scooter scooter1 = new Scooter(1);
        rental.addScooter(scooter1);
        rental.rentScooter(1, LocalDateTime.of(2019,8,12,13,2));

        rental.update(LocalDateTime.of(2019,8,12,14,2));

        assertFalse(scooter1.isBlocked());
    }

    @Test
    void blockingOver2HoursRent() {
        ScooterRental rental = new ScooterRental();
        Scooter scooter1 = new Scooter(1);
        rental.addScooter(scooter1);
        rental.rentScooter(1, LocalDateTime.of(2019,8,12,13,2));

        rental.update(LocalDateTime.of(2019,8,12,16,2));

        assertTrue(scooter1.isBlocked());
    }

}