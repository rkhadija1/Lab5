/**  This class represents an action the player can take where
 * they create a copy of their own unit on the ‘from square’ and
 * put it on the ‘to square’.
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */
public class ActionSpawn extends Action {
    public ActionSpawn (Game theGame, int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo){
        super(theGame, rowNumsFrom, columnNumsFrom, rowNumsTo, columnsNumsTo);

    }

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
