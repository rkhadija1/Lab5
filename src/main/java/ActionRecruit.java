/**  This class represents an action the player can take where they
 * recruit an opponent’s unit on the ‘to square’ with their own unit
 * on the ‘from square’.
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */
public class ActionRecruit extends Action {
    //5 parameter constructor
    public ActionRecruit (Game theGame, int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo){
        super(theGame, rowNumsFrom, columnNumsFrom, rowNumsTo, columnsNumsTo);

    }

    /**
     * Overrides to string to display details of a specific action
     * @return String representing the action
     */

    @Override
    public String toString() {

        return theGame.getCurrentPlayer().getTeam().getTeamColor() + " teams " +theGame.getBoardSquare()[rowNumsTo][columnsNumsTo]
                .getThisUnit().getName() + " unit recruits " + theGame.getOpponentPlayer().getTeam().getTeamColor() + " teams " + theGame.getBoardSquare()[rowNumsTo][columnsNumsTo]
                .getThisUnit().getName() + " unit on row " + rowNumsTo + ", column " + columnNumsFrom;
    }

    /**
     * performs specific action for player
     */
    public void performAction(){
        if (!(theGame.getGameBoard().getSquares()[rowNumsFrom][columnNumsFrom].isEmptySpace())) {
            Unit unitRecruited = theGame.getGameBoard().getSquares()[rowNumsTo][columnsNumsTo].getThisUnit();
            theGame.getOpponentPlayer().getTeam().removeUnitsFromTeam(unitRecruited);
            theGame.getCurrentPlayer().getTeam().addUnitsToTeam(unitRecruited);
            theGame.changeTurn();
        }

    }
}
