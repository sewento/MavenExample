import org.junit.jupiter.api.Test;
import scooter.Scooter;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ScooterRentalTest {

    @Test
    void addScooter() {
        ArrayList<Scooter> rental = new ArrayList<>();
        Scooter scooter1 = new Scooter(1);
        Scooter scooter2 = new Scooter(2);
        rental.add(scooter1);
        rental.add(scooter2);

        assertEquals(2,rental.size());
    }

    @Test
    void rentScooter() {
    }

    @Test
    void returnScooter() {
    }

    @Test
    void update() {
    }
}