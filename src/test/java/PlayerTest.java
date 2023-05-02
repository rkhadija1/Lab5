
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class PlayerTest {

    /** This class tests the Player Class
     * @author TaraLennon & Khadija Mohammadi
     * @verison 1
     */

    /** This method tests the player class with a no parameter constructor
     *
     */

    @Test
    public void testingPlayerNoParameter() {
        System.out.println("Testing No Parameter Constructor");
        Player newPlayer = new Player();
        System.out.println("-- Testing Player Number");
        assertEquals(1, newPlayer.getPlayerNumber());
        newPlayer.setPlayerNumber(2);
        assertEquals(2, newPlayer.getPlayerNumber());
        System.out.println("-- Testing Turn");
        assertFalse(newPlayer.isTurn());
        newPlayer.setTurn(true);
        assertTrue(newPlayer.isTurn());
        System.out.println("-- Testing Team");
        ArrayList<Unit> teamUnits = new ArrayList<Unit>();
        Team newTeam = new Team("blue", teamUnits);
        newPlayer.setTeam(newTeam);
        assertSame(newTeam, newPlayer.getTeam());

    }

    /** This method tests the player class with a two and three parameter constructor
     *
     */

    @Test
    public void testingPlayerParameterConstructor() {
        System.out.println("Testing two parameter constructor");
        ArrayList<Unit> teamUnit = new ArrayList<Unit>();
        Team newTeam3 = new Team("green", teamUnit);
        Player newPlayer5 = new Player(123, newTeam3);
        System.out.println("-- Testing Player Number");
        assertEquals(123, newPlayer5.getPlayerNumber());
        newPlayer5.setPlayerNumber(5);
        assertEquals(5, newPlayer5.getPlayerNumber());
        System.out.println("-- Testing Turn");
        assertFalse(newPlayer5.isTurn());
        newPlayer5.setTurn(true);
        assertTrue(newPlayer5.isTurn());
        System.out.println("-- Testing Team");
        assertSame(newTeam3, newPlayer5.getTeam());
        Team newTeam6 = new Team("orange", teamUnit);
        newPlayer5.setTeam(newTeam6);
        assertSame(newTeam6, newPlayer5.getTeam());
        System.out.println("Testing Three Parameter Constructor");
        ArrayList<Unit> teamU = new ArrayList<Unit>();
        Team newTeam1 = new Team("green", teamU);
        Player newPlayer = new Player(123, true, newTeam1);
        System.out.println("-- Testing Player Number");
        assertEquals(123, newPlayer.getPlayerNumber());
        newPlayer.setPlayerNumber(5);
        assertEquals(5, newPlayer.getPlayerNumber());
        System.out.println("-- Testing Turn");
        assertTrue(newPlayer.isTurn());
        newPlayer.setTurn(false);
        assertFalse(newPlayer.isTurn());
        System.out.println("-- Testing Team");
        assertSame(newTeam1, newPlayer.getTeam());
        Team newTeam2 = new Team("red", teamU);
        newPlayer.setTeam(newTeam2);
        assertSame(newTeam2, newPlayer.getTeam());

    }
}
