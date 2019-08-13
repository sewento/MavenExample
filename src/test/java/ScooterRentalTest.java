import org.junit.jupiter.api.Test;
import scooter.Scooter;
import scooter.ScooterRental;

import java.time.DayOfWeek;
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

        assertEquals(2, rental.getRental().size());
    }

    @Test
    void rentScooter() {
        ScooterRental rental = new ScooterRental();
        Scooter scooter1 = new Scooter(1);
        rental.addScooter(scooter1);
        rental.rentScooter(1, LocalDateTime.of(2019, 8, 12, 13, 2));

        assertTrue(scooter1.isRented());
    }

    @Test
    void returnScooter() {
        ScooterRental rental = new ScooterRental();
        Scooter scooter1 = new Scooter(1);
        rental.addScooter(scooter1);
        rental.rentScooter(1, LocalDateTime.of(2019, 8, 12, 13, 2));

        double cost = rental.returnScooter(1,LocalDateTime.of(2019, 8, 12, 14, 7));

        assertEquals(65.0, cost);
        assertFalse(scooter1.isRented());
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

    @Test
    void getCostDoubleTariff() {
        ScooterRental scooterRental = new ScooterRental();
        Scooter scooter1 = new Scooter(1);
        scooter1.setStart(LocalDateTime.of(2019, 8, 12, 8, 2));
        double cost = scooterRental.getCost(LocalDateTime.of(2019, 8, 12, 9, 22), scooter1);

        assertEquals(160.0, cost);

    }

    @Test
    void getCostNormalTariff() {
        ScooterRental scooterRental = new ScooterRental();
        Scooter scooter1 = new Scooter(1);
        scooter1.setStart(LocalDateTime.of(2019, 8, 12, 11, 2));
        double cost = scooterRental.getCost(LocalDateTime.of(2019, 8, 12, 12, 22), scooter1);

        assertEquals(80.0, cost);

    }

    @Test
    void getCostWeekendTariff() {
        ScooterRental scooterRental = new ScooterRental();
        Scooter scooter1 = new Scooter(1);
        scooter1.setStart(LocalDateTime.of(2019, 8, 17, 8, 2));
        double cost = scooterRental.getCost(LocalDateTime.of(2019, 8, 17, 9, 22), scooter1);

        assertEquals(40.0, cost);

    }

    @Test
    void normalTarrif(){
        ScooterRental scooterRental = new ScooterRental();
        Scooter scooter1 = new Scooter(1);
        scooter1.setStart(LocalDateTime.of(2019, 8, 12, 11, 2));

        double cost = scooterRental.tariff(scooter1);

        assertEquals(1.0, cost);
    }

    @Test
    void weekendTarrif(){
        ScooterRental scooterRental = new ScooterRental();
        Scooter scooter1 = new Scooter(1);
        scooter1.setStart(LocalDateTime.of(2019, 8, 18, 11, 2));

        double cost = scooterRental.tariff(scooter1);

        assertEquals(0.5, cost);
        assertEquals(DayOfWeek.SUNDAY, scooter1.getStart().getDayOfWeek());
    }

    @Test
    void doubleTarrif(){
        ScooterRental scooterRental = new ScooterRental();
        Scooter scooter1 = new Scooter(1);
        scooter1.setStart(LocalDateTime.of(2019, 8, 12, 8, 2));

        double cost = scooterRental.tariff(scooter1);

        assertEquals(2.0, cost);
    }


}