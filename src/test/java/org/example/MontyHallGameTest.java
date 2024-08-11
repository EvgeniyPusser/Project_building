package org.example;

import org.testng.annotations.Test;
import static org.junit.Assert.*;

public class MontyHallGameTest {
    @Test
    public void testSwitching() {
        MontyHallGame game = new MontyHallGame();
        game.simulate(1000, true);
        assertTrue(game.getResults().values().stream().filter(result -> result).count() > 500);
    }

    @Test
    public void testNotSwitching() {
        MontyHallGame game = new MontyHallGame();
        game.simulate(1000, false);
        assertTrue(game.getResults().values().stream().filter(result -> result).count() < 500);
    }
}

