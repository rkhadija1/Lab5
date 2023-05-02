import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardSquareTest{
    /** This class tests the methods in the BoardSquare class
     * @author TaraLennon & Khadija Mohammadi
     * @verison 1
     */

    @Test
    public void testingBoardSpace()  {
        /**
         * Tests the methods in the BoardSpace class
         */
        System.out.println("Testing Board Square Class");

        BoardSquare testSquare11 = new BoardSquare("Black");
        BoardSquare testSquare12 = new BoardSquare("White");

        // getColor
        assertEquals("Black",testSquare11.getSquareColor());
        assertEquals("White",testSquare12.getSquareColor());

        // isEmpty
        assertTrue(testSquare11.isEmptySpace());
        assertTrue(testSquare12.isEmptySpace());

        //toString
        assertEquals("-------",testSquare11.toString());
        assertEquals("-------",testSquare12.toString());

        //getUnit - none
        assertNull(testSquare11.getThisUnit());
        assertNull(testSquare12.getThisUnit());

        //setUnit
        // place some Units on the GameBoard
        Unit tj = new TomJerryUnit();
        tj.setTeamColor("Blu");
        Unit bart = new BartSimpsonUnit();
        bart.setTeamColor("Red");

        testSquare11.setThisUnit(tj);
        testSquare12.setThisUnit(bart);

        //toString
        assertEquals("-Blu T-",testSquare11.toString());
        assertEquals("-Red B-",testSquare12.toString());

        //getUnit - returns Unit but doesn't remove it from space
        assertSame(tj,testSquare11.getThisUnit());
        assertSame(bart,testSquare12.getThisUnit());

        //isEmpty
        assertFalse(testSquare11.isEmptySpace());
        assertFalse(testSquare12.isEmptySpace());

        // removeUnit - returns Unit and removes it from space
        assertSame(tj,testSquare11.removeUnit());
        assertSame(bart,testSquare12.removeUnit());

        //isEmpty
        assertTrue(testSquare11.isEmptySpace());
        assertTrue(testSquare12.isEmptySpace());

        //toString
        assertEquals("-------",testSquare11.toString());
        assertEquals("-------",testSquare12.toString());
    }
}
