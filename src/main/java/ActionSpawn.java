/**  This class represents an action the player can take where
 * they create a copy of their own unit on the ‘from square’ and
 * put it on the ‘to square’.
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */
public class ActionSpawn extends Action {
    //5 parameter constructor
    public ActionSpawn (Game theGame, int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo){
        super(theGame, rowNumsFrom, columnNumsFrom, rowNumsTo, columnsNumsTo);

    }

    /**
     * Overrides to string to display details of a specific action
     * @return String representing the action
     */

    @Override
    public String toString() {

        return theGame.getCurrentPlayer().getTeam().getTeamColor() + " teams " +theGame.getBoardSquare()[rowNumsTo][columnsNumsTo]
                .getThisUnit().getName() + " unit spawns onto " + rowNumsTo + "," + columnsNumsTo;
    }

    /**
     * performs specific action for player
     */

    public void performAction() {
        if (!(theGame.getGameBoard().getSquares()[rowNumsFrom][columnNumsFrom].isEmptySpace())) {
            if (theGame.getGameBoard().getSquares()[rowNumsFrom][columnNumsFrom].getThisUnit().canSpawn()) {
                Unit spawnUnit = theGame.getGameBoard().getSquares()[rowNumsFrom][columnNumsFrom].getThisUnit().spawn();
                theGame.getCurrentPlayer().getTeam().addUnitsToTeam(spawnUnit);
                theGame.getGameBoard().getSquares()[rowNumsTo][columnsNumsTo].setThisUnit(spawnUnit);
                theGame.changeTurn();
            }
        }
    }
}
