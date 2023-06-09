import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameBoardTest {
    /** This class tests the methods in the GameBoard class
     * @author TaraLennon & Khadija Mohammadi
     * @verison 1
     */

    public static String boardString(int numRows, int numColumns){
        /**
         * Builds a string that represents the game board
         * @param numRows the number of rows in the board
         * @param numColumns the number of columns in the board
         * @return String that represents the game board
         */

        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < numColumns; col++){

            boardString.append(col + "        ");

        }
        boardString.append("\n");
        for(int row = 0; row < numRows; row++){

            boardString.append("Row : " + row + "   ");

            for(int col = 0; col < numColumns; col++){

                boardString.append("-------" + "  ");

            }

            boardString.append("\n");
        }

        return boardString.toString();

    }

    @Test
    public void testingBoard()  {
        /**
         * Tests the game board class
         */

        System.out.println("Testing Board Class");

        int numRows = 6;
        int numCols = 10;

        GameBoard testGameBoard = new GameBoard(numRows,numCols);
        // print the GameBoard all spaces should be empty
        System.out.println(testGameBoard.toString());

        assertEquals(boardString(numRows,numCols),testGameBoard.toString());

        assertEquals(numRows,testGameBoard.getRowsNum());
        assertEquals(numCols,testGameBoard.getColumnsNum());

        assertTrue(testGameBoard.inBounds(0,0));
        assertTrue(testGameBoard.inBounds(numRows-1, numCols-1));
        assertFalse(testGameBoard.inBounds(numRows, numCols));
        assertFalse(testGameBoard.inBounds(-1,-1));

        // place some Units on the GameBoard
        Unit tj = new TomJerryUnit();
        testGameBoard.getSquares()[0][0].setThisUnit(tj);

        Unit bart = new BartSimpsonUnit();
        testGameBoard.getSquares()[numRows-1][numCols-1].setThisUnit(bart);

        System.out.println(testGameBoard.toString());

        // testing random empty space method
        BoardSquare emptySpace = testGameBoard.findRandomEmptySpace();

        assertTrue(emptySpace.isEmptySpace());
        assertNull(emptySpace.getThisUnit());

        emptySpace.setThisUnit(tj);
        emptySpace = testGameBoard.findRandomEmptySpace();

        assertTrue(emptySpace.isEmptySpace());
        assertNull(emptySpace.getThisUnit());

        emptySpace.setThisUnit(bart);
        System.out.println(testGameBoard.toString());

        //spawn a Unit and place on the GameBoard
        Unit lilbart = bart.spawn();
        assertTrue(lilbart instanceof Unit);
        testGameBoard.getSquares()[numRows-3][numCols-3].setThisUnit(lilbart);

        System.out.println(testGameBoard.toString());

    }

}
