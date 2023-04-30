/**  This class represents an action the player can take where they
 * recruit an opponent’s unit on the ‘to square’ with their own unit
 * on the ‘from square’.
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */
public class ActionRecruit extends Action {
    public ActionRecruit (Game theGame, int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo){
        super(theGame, rowNumsFrom, columnNumsFrom, rowNumsTo, columnsNumsTo);

    }

    public void performAction(){
        if (!(theGame.getGameBoard().getSquares()[rowNumsFrom][columnNumsFrom].isEmptySpace())) {
            Unit unitRecruited = theGame.getGameBoard().getSquares()[rowNumsTo][columnsNumsTo].getThisUnit();
            theGame.getOpponentPlayer().getTeam().removeUnitsFromTeam(unitRecruited);
            theGame.getCurrentPlayer().getTeam().addUnitsToTeam(unitRecruited);
            theGame.changeTurn();
        }

    }
}
