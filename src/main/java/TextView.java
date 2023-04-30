import java.util.Scanner;

/**  This class provides a text based interface
 * to the players so that they can play the game.
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */
public class TextView {
    int rowIndexFromSquare;
    //represents row index of board square with Unit making Action (From Square)
    int colIndexFromSquare;
    //represents column index of board square with Unit making Action (From Square)
    int rowIndexToSquare;
    //represents row index of the board square to be receiving the Action (To Square)
    int colIndexToSquare;
    //represents column index of the board square to be receiving the Action (To Square)
    char actionType;
    //action type chosen by player


    public int getRowIndexFromSquare() {
        return rowIndexFromSquare;
    }

    public void setRowIndexFromSquare(int rowIndexFromSquare) {
        this.rowIndexFromSquare = rowIndexFromSquare;
    }

    public int getColIndexFromSquare() {
        return colIndexFromSquare;
    }

    public void setColIndexFromSquare(int colIndexFromSquare) {
        this.colIndexFromSquare = colIndexFromSquare;
    }

    public int getRowIndexToSquare() {
        return rowIndexToSquare;
    }

    public void setRowIndexToSquare(int rowIndexToSquare) {
        this.rowIndexToSquare = rowIndexToSquare;
    }

    public int getColIndexToSquare() {
        return colIndexToSquare;
    }

    public void setColIndexToSquare(int colIndexToSquare) {
        this.colIndexToSquare = colIndexToSquare;
    }

    public char getActionType() {
        return actionType;
    }

    public void setActionType(char actionType) {
        this.actionType = actionType;
    }

    /**
     * Gets users next action type based on input
     *@param scannerObject scanner object in order to use the scanner class
     *@return a char representing the user's next desired action
     */

    public static char getUsersNextActionType(Scanner scannerObject) {
        char firstChar = 'X';
        // initial assignment for firstChar, which represents the first character in the user's input

        while (!(firstChar == 'A') && !(firstChar == 'M') && !(firstChar == 'R') && !(firstChar == 'S') &&
                !(firstChar == 'a') && !(firstChar == 'm') && !(firstChar == 'r') && !(firstChar == 's')){
            // while loop which keeps asking the user to input if they don't input a designated character
            String userInput = scannerObject.nextLine();
            firstChar = userInput.charAt(0);
        }

        firstChar = Character.toUpperCase(firstChar);
        return firstChar;
    }

    /**
     * Gets a valid integer from a user within a range
     *@param numberMin the minimum number in the designated range
     *@param numberMax the maximum number in the designated range
     *@param scannerObject scanner object in order to use the Scanner class
     *@return an integer representing a user's chosen number within a given range
     */

    public static int getValidInt (int numberMin, int numberMax, Scanner scannerObject){
        boolean userInput = scannerObject.hasNextInt();
        // boolean representing whether or not a user has inputted an integer
        String userInputStr = scannerObject.nextLine();
        // string representing a user's input
        while (!userInput || (Integer.parseInt(userInputStr)) < numberMin || (Integer.parseInt(userInputStr)) > numberMax){
            // while loop that keeps asking a user for input if they input not an integer, or not an integer within the range
            userInput = scannerObject.hasNextInt();
            userInputStr = scannerObject.nextLine();
        }

        return Integer.parseInt(userInputStr);
    }

    public void getNextPlayersAction(Game game){
        System.out.println("Enter action type");
        Scanner scnr = new Scanner(System.in);
        char nextAction = getUsersNextActionType(scnr);
        this.actionType = nextAction;

        System.out.println("Enter the row index of the from square");
        int maxNumRows = game.getGameBoard().getRowsNum();
        int userInputRowFrom = getValidInt(0, maxNumRows, scnr);
        rowIndexFromSquare = userInputRowFrom;

        System.out.println("Enter the column index of the from square");
        int maxNumCols = game.getGameBoard().getColumnsNum();
        int userInputColFrom = getValidInt(0, maxNumCols, scnr);
        colIndexFromSquare = userInputColFrom;

        System.out.println("Enter the row index of the to square");
        int userInputRowTo = getValidInt(0, maxNumRows, scnr);
        rowIndexToSquare = userInputRowTo;

        System.out.println("Enter the column index of the to square");
        int userInputColTo = getValidInt(0, maxNumCols, scnr);
        colIndexToSquare = userInputColTo;



    }

    public void updateView (Game game){
        System.out.println(game);
    }

    public void printEndOfGameMessage (Game game){
        if (game.isGameEnded()) {
            System.out.println("The game ended.");
            if (game.isAWinner()){
                System.out.println(game.getWinner() + " won the game.");
            }
        }
    }
}
