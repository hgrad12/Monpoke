package model;

import example.Monpoke.model.Monpoke;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonpokeTest {
    private static final String MONPOKE_NAME = "Meekachu";
    private static final int MONPOKE_HIT_POINTS = 3;
    private static final int MONPOKE_ATTACK_POINTS = 1;

    private static Monpoke monpoke;

    @BeforeEach
    public void setup(){
        monpoke = new Monpoke(MONPOKE_NAME, MONPOKE_HIT_POINTS, MONPOKE_ATTACK_POINTS);
    }

    @Test
    public void nameTest() {
        assertEquals(MONPOKE_NAME, monpoke.getName());

        String name = "Rastly";
        assertNotEquals(name, monpoke.getName());
    }

    @Test
    public void hitPointsTest() {
        assertEquals(MONPOKE_HIT_POINTS, monpoke.getHitPoints());

        monpoke.setHitPoints(1);

        assertNotEquals(MONPOKE_HIT_POINTS, monpoke.getHitPoints());

        assertTrue(MONPOKE_HIT_POINTS > monpoke.getHitPoints());
    }

    @Test
    public void isActiveTest() {
        assertTrue(monpoke.isActive());

        monpoke.setHitPoints(MONPOKE_HIT_POINTS);

        assertFalse(monpoke.isActive());
    }

    @Test
    public void equalsTest() {
        Monpoke m = new Monpoke(MONPOKE_NAME, MONPOKE_HIT_POINTS, MONPOKE_ATTACK_POINTS);

        assertTrue(monpoke.equals(m));

        m = new Monpoke("Rastly", 3, 1);

        assertFalse(monpoke.equals(m));
    }
}