import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class PlayerTest {
    @Test
    public void testSetPlayerNumber() {
        Player playerNew = new Player();
        assertEquals(3, playerNew.getPlayerNumber());
        playerNew.setPlayerNumber(1);
        assertEquals(1, playerNew.getPlayerNumber());

    }
    @Test
    public void testTurn() {
        Player playerNew = new Player();
        assertEquals(false, playerNew.isTurn());
        playerNew.setTurn(true);
        assertEquals(true, playerNew.isTurn());
    }
    @Test
    public void testTeam() {
        ArrayList<Unit> element= new ArrayList<>();
        element.add(new TomJerryUnit());
        Team teamA = new Team("pink",  element);
        Player playerNew = new Player(1, teamA);
        assertEquals(teamA, playerNew.getTeam());
        Team teamB = new Team("black", element);
        playerNew.setTeam(teamB);
        assertEquals(teamB, playerNew.getTeam());
    }
}
