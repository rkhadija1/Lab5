/**  This class represents an action the user can take where
 * they move their own unit from the ‘from square’ on the board
 * to the ‘to square’ on the board.
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */
public class ActionMove extends Action {

    public ActionMove (Game theGame, int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo){
        //5 parameter constructor
        super(theGame, rowNumsFrom, columnNumsFrom, rowNumsTo, columnsNumsTo);

    }

    /**
     * performs specific action for player
     */
        // modifications for specialSquare: the code below moves a unit from one square to another on the
       //game board and changes the turn if necessary.
    public void performAction(){
        if (!(theGame.getGameBoard().getSquares()[rowNumsFrom][columnNumsFrom].isEmptySpace())){
            System.out.println("from " + theGame.getGameBoard().getSquares()[rowNumsFrom][columnNumsFrom].isSpecialSquare());
            System.out.println("to " + theGame.getGameBoard().getSquares()[rowNumsTo][columnsNumsTo].isSpecialSquare());
                if (theGame.getGameBoard().getSquares()[rowNumsTo][columnsNumsTo].isSpecialSquare()) {
                    Unit originalUnit = theGame.getGameBoard().getSquares()[rowNumsFrom][columnNumsFrom].removeUnit();
                    theGame.getGameBoard().getSquares()[rowNumsTo][columnsNumsTo].setThisUnit(originalUnit);

                    theGame.getCurrentPlayer().getTeam().removeUnitsFromTeam(originalUnit);
                    theGame.getOpponentPlayer().getTeam().addUnitsToTeam(originalUnit);
                    theGame.changeTurn();
                }
                else {
                    Unit originalUnit = theGame.getGameBoard().getSquares()[rowNumsFrom][columnNumsFrom].removeUnit();
                    theGame.getGameBoard().getSquares()[rowNumsTo][columnsNumsTo].setThisUnit(originalUnit);
                    theGame.changeTurn();
                }
        }
    }


}
