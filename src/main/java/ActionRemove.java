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
            Unit temp  = theGame.getBoardSquare()[rowNumsTo -1][columnsNumsTo].removeUnit();
            theGame.getCurrentPlayer().getTeam().removeUnitsFromTeam(temp);
            theGame.getOpponentPlayer().getTeam().removeUnitsFromTeam(temp);
        }
        if (theGame.getGameBoard().inBounds(rowNumsTo +1, columnsNumsTo)&& !theGame.getBoardSquare()[rowNumsTo +1][columnsNumsTo].isEmptySpace()) {
            Unit temp  = theGame.getBoardSquare()[rowNumsTo +1][columnsNumsTo].removeUnit();
            theGame.getCurrentPlayer().getTeam().removeUnitsFromTeam(temp);
            theGame.getOpponentPlayer().getTeam().removeUnitsFromTeam(temp);
        }
        if (theGame.getGameBoard().inBounds(rowNumsTo, columnsNumsTo -1)&& !theGame.getBoardSquare()[rowNumsTo][columnsNumsTo -1].isEmptySpace()) {
            Unit temp  = theGame.getBoardSquare()[rowNumsTo][columnsNumsTo -1].removeUnit();
            theGame.getCurrentPlayer().getTeam().removeUnitsFromTeam(temp);
            theGame.getOpponentPlayer().getTeam().removeUnitsFromTeam(temp);
        }
        if (theGame.getGameBoard().inBounds(rowNumsTo, columnsNumsTo +1)&& !theGame.getBoardSquare()[rowNumsTo][columnsNumsTo +1].isEmptySpace()) {
            Unit temp  = theGame.getBoardSquare()[rowNumsTo][columnsNumsTo +1].removeUnit();
            theGame.getCurrentPlayer().getTeam().removeUnitsFromTeam(temp);
            theGame.getOpponentPlayer().getTeam().removeUnitsFromTeam(temp);
        }
        theGame.changeTurn();

    }
}