/**  This class represents an action the user can take where
 * they move their own unit from the ‘from square’ on the board
 * to the ‘to square’ on the board.
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */
public class ActionMove extends Action {

    public ActionMove (Game theGame, int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo){
        super(theGame, rowNumsFrom, columnNumsFrom, rowNumsTo, columnsNumsTo);

    }

    public void performAction(){
        if (!(theGame.getGameBoard().getSquares()[rowNumsFrom][columnNumsFrom].isEmptySpace())){
            Unit originalUnit = theGame.getGameBoard().getSquares()[rowNumsFrom][columnNumsFrom].removeUnit();
            theGame.getGameBoard().getSquares()[rowNumsTo][columnsNumsTo].setThisUnit(originalUnit);
            theGame.changeTurn();
        }
    }


}
