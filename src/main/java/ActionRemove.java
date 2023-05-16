/**  This class represents an action the player can take where they
 * remove all opponent Units that are in a one square radius of the ‘To Square’ with their own unit
 * on the ‘from square’.
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */
public class ActionRemove extends Action {

    //5 parameter constructor
    public ActionRemove(Game theGame, int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo) {
        super(theGame, rowNumsFrom, columnNumsFrom, rowNumsTo, columnsNumsTo);

    }

    /**
     * performs specific action for player
     */
    // a new action that removes all opponent Units that are in a one square radius of the ‘To Square’
    public void performAction() {
        if (theGame.getGameBoard().inBounds(rowNumsTo -1, columnsNumsTo)&& !theGame.getBoardSquare()[rowNumsTo -1][columnsNumsTo].isEmptySpace()) {
            BoardSquare temp  = theGame.getBoardSquare()[rowNumsTo -1][columnsNumsTo];
            if(theGame.getOpponentPlayer().getTeam().getTeamUnits().contains(temp.getThisUnit())){
                theGame.getOpponentPlayer().getTeam().removeUnitsFromTeam(temp.getThisUnit());
            }
        }
        if (theGame.getGameBoard().inBounds(rowNumsTo +1, columnsNumsTo)&& !theGame.getBoardSquare()[rowNumsTo +1][columnsNumsTo].isEmptySpace()) {
            BoardSquare temp  = theGame.getBoardSquare()[rowNumsTo +1][columnsNumsTo];
            if(theGame.getOpponentPlayer().getTeam().getTeamUnits().contains(temp.getThisUnit())){
                theGame.getOpponentPlayer().getTeam().removeUnitsFromTeam(temp.getThisUnit());
            }
        }
        if (theGame.getGameBoard().inBounds(rowNumsTo, columnsNumsTo -1)&& !theGame.getBoardSquare()[rowNumsTo][columnsNumsTo -1].isEmptySpace()) {
            BoardSquare temp  = theGame.getBoardSquare()[rowNumsTo][columnsNumsTo -1];
            if(theGame.getOpponentPlayer().getTeam().getTeamUnits().contains(temp.getThisUnit())){
                theGame.getOpponentPlayer().getTeam().removeUnitsFromTeam(temp.getThisUnit());
            }
        }
        if (theGame.getGameBoard().inBounds(rowNumsTo, columnsNumsTo +1)&& !theGame.getBoardSquare()[rowNumsTo][columnsNumsTo +1].isEmptySpace()) {
            BoardSquare temp  = theGame.getBoardSquare()[rowNumsTo][columnsNumsTo +1];
            if(theGame.getOpponentPlayer().getTeam().getTeamUnits().contains(temp.getThisUnit())){
                theGame.getOpponentPlayer().getTeam().removeUnitsFromTeam(temp.getThisUnit());
            }
        }
        theGame.changeTurn();

    }
}