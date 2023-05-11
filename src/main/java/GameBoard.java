import java.util.Random;
public class GameBoard {

    /** This class creates a GameBoard
     * @author TaraLennon & Khadija Mohammadi
     * @verison 1
     */
    private int numRows;
    //the number of rows on the game board
    private int numColumns;
    //the number of columns on the game board
    private BoardSquare[][] squares;
    //2D array that represents all the spaces on the gameboard

    public GameBoard (int numRows, int numColumns){
        //two parameter constructor
        this.numRows = numRows;
        this.numColumns = numColumns;
        squares = new BoardSquare[numRows][numColumns];
        setUpEmptyBoard();
    }

    /**
     * Gets the number of rows on the game board
     * @return int representing the number of rows
     */
    public int getRowsNum() {
        return numRows;
    }
    /**
     * Gets the number of columns on the game board
     * @return int representing the number of columns
     */
    public int getColumnsNum() {
        return numColumns;
    }
    /**
     * Gets the array of spaces on the gameboard
     * @return BoardSquare 2D array that represents all the spaces
     */
    public BoardSquare[][] getSquares() {
        return squares;
    }

    /**
     * Determines whether a specific row and column index is in bounds in the game board
     * @return boolean representing whether the index is in bounds
     */
    public boolean inBounds (int rowIndex, int columnIndex){
        if (((rowIndex + 1) <= numRows) && ((columnIndex + 1) <= numColumns) && (rowIndex >= 0) && (columnIndex >= 0)){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Creates an empty board of board squares
     */
    private void setUpEmptyBoard (){
        for (int i = 0; i < squares.length; i++){
            for (int j = 0; j <squares[i].length; j++){
                if ((i % 2 == 0) && (j % 2 == 0) || (i % 2 == 1) && (j % 1 == 1)) {
                    BoardSquare newBoardSquareObj = new BoardSquare("red");
                    squares[i][j] = newBoardSquareObj;
                }
                else {
                    BoardSquare newBoardSquareObj = new BoardSquare("white");
                    squares[i][j] = newBoardSquareObj;
                }
            }
        }
    }

    /**
     * Finds an empty space on the game board randomly
     * @return BoardSquare on the board that is empty
     */

    public BoardSquare findRandomEmptySpace (){
        Random rand = new Random();
        int randRow = rand.nextInt(numRows);
        int randCol = rand.nextInt(numColumns);
        while (!squares[randRow][randCol].isEmptySpace()){
            randRow = rand.nextInt(numRows);
            randCol = rand.nextInt(numColumns);
        }
        return squares[randRow][randCol];
    }

    /**
     * Overrides toString
     * @return String that represents the GameBoard
     */

    @Override
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}
