/**  This class represents an action the player can take where
 * they attack another unit on the ‘to square’ with their own unit
 * on the ‘from square’.
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */
public class ActionAttack extends Action {

    public ActionAttack (Game theGame, int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo){
        //5 parameter constructor
        super(theGame, rowNumsFrom, columnNumsFrom, rowNumsTo, columnsNumsTo);

    }

    /**
     * Overrides to string to display details of a specific action
     * @return String representing the action
     */

    @Override
    public String toString() {

        return theGame.getCurrentPlayer().getTeam().getTeamColor() + " teams " +theGame.getBoardSquare()[rowNumsTo][columnsNumsTo]
                .getThisUnit().getName() + " unit attacks" + theGame.getOpponentPlayer().getTeam().getTeamColor() + " teams " + theGame.getBoardSquare()[rowNumsTo][columnsNumsTo]
                .getThisUnit().getName() + " unit.";
    }

    /**
     * performs specific action for player
     */

    public void performAction(){
        if (!(theGame.getGameBoard().getSquares()[rowNumsFrom][columnNumsFrom].isEmptySpace())){
            if (theGame.getGameBoard().getSquares()[rowNumsFrom][columnNumsFrom].getThisUnit() instanceof TomJerryUnit){
                if (!(theGame.getGameBoard().getSquares()[rowNumsTo][columnsNumsTo].isEmptySpace())){
                    if (theGame.getGameBoard().getSquares()[rowNumsTo][columnsNumsTo].getThisUnit() instanceof TomJerryUnit){
                        double dam = ((TomJerryUnit) theGame.getGameBoard().getSquares()[rowNumsTo][columnsNumsTo].getThisUnit()).dealDamage();
                        theGame.getGameBoard().getSquares()[rowNumsTo][columnsNumsTo].getThisUnit().takeDamage(dam);
                        if (theGame.getGameBoard().getSquares()[rowNumsTo][columnsNumsTo].getThisUnit().getHealth() <= 0){
                            Unit deadUnit = theGame.getGameBoard().getSquares()[rowNumsTo][columnsNumsTo].removeUnit();
                            theGame.getOpponentPlayer().getTeam().removeUnitsFromTeam(deadUnit);
                            Unit originalUnit = theGame.getGameBoard().getSquares()[rowNumsFrom][columnNumsFrom].removeUnit();
                            theGame.getGameBoard().getSquares()[rowNumsTo][columnsNumsTo].setThisUnit(originalUnit);
                        }

                    }
                    else if (theGame.getGameBoard().getSquares()[rowNumsTo][columnsNumsTo].getThisUnit() instanceof BartSimpsonUnit){
                        Unit deadUnit = theGame.getGameBoard().getSquares()[rowNumsTo][columnsNumsTo].removeUnit();
                        theGame.getOpponentPlayer().getTeam().removeUnitsFromTeam(deadUnit);
                        Unit originalUnit = theGame.getGameBoard().getSquares()[rowNumsFrom][columnNumsFrom].removeUnit();
                        theGame.getGameBoard().getSquares()[rowNumsTo][columnsNumsTo].setThisUnit(originalUnit);


                    }
                }

            }
            theGame.changeTurn();
        }

    }
}
