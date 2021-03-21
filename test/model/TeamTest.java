package model;

import example.Monpoke.model.Monpoke;
import example.Monpoke.model.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    private static Team team;
    private static final String TEAM_NAME = "Rocket";

    private static Monpoke meekachu;
    private static final String MEEKACHU_NAME = "Meekachu";
    private static final int MEEKACHU_HIT_POINTS = 3;
    private static final int MEEKACHU_ATTACK_POINTS = 1;

    private static Monpoke rastly;
    private static String RASTLY_NAME = "Rastly";
    private static final int RASTLY_HIT_POINTS = 5;
    private static final int RASTLY_ATTACK_POINTS = 6;

    @BeforeEach
    public void setup() {
        team = new Team(TEAM_NAME);

        meekachu = new Monpoke(MEEKACHU_NAME, MEEKACHU_HIT_POINTS, MEEKACHU_ATTACK_POINTS);

        rastly = new Monpoke(RASTLY_NAME, RASTLY_HIT_POINTS, RASTLY_ATTACK_POINTS);
    }

    @Test
    public void isActiveTest() {
        assertFalse(team.isActive());

        team.addMonpoke(meekachu);

        assertTrue(team.isActive());
    }

    @Test
    public void chosenMonpokeRequiredTest() {
        team.addMonpoke(meekachu);

        assertTrue(team.isChooseRequired());

        team.setChosenMonpoke(MEEKACHU_NAME);

        assertFalse(team.isChooseRequired());
    }

    @Test
    public void chosenMonpokeStatusTest() {
        team.addMonpoke(rastly);

        assertNull(team.getChosenMonpoke());

        team.setChosenMonpoke(RASTLY_NAME);

        team.getChosenMonpoke().setHitPoints(RASTLY_HIT_POINTS);

        team.chosenMonpokeStatus();

        assertNull(team.getChosenMonpoke());
    }

    @Test
    public void validMonpokeTest() {
        assertFalse(team.isActive());

        Monpoke monpoke = new Monpoke("MoMo", 0, 3);
        team.addMonpoke(monpoke);

        assertFalse(team.isActive());

        team.addMonpoke(meekachu);

        assertTrue(team.isActive());
    }
}