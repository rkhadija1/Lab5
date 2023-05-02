
/** This class creates the Rules for the game
     * @author TaraLennon & Khadija Mohammadi
     * @verison 1
     */
public class Rules {
    /**
     * checks if an action is valid
     * @param thisGame game being played
     * @param rowNumFrom index of from unit
     * @param columnNumFrom col index of from unit
     * @param rowNumTo row number of to unit
     * @param columnNumTo coll number of to unit
     * @param action char representing the action
     * @return boolean representing if its a valid action
     */
    public static boolean checkValidAction(Game thisGame, int rowNumFrom, int columnNumFrom,
                                           int rowNumTo, int columnNumTo, char action) {

        if (!thisGame.getGameBoard().inBounds(rowNumFrom, columnNumFrom)
                || !thisGame.getGameBoard().inBounds(rowNumTo, columnNumTo)) {
            System.out.println("The location was invalid!");
            return false;
        }
        if (thisGame.getGameBoard().getSquares()[rowNumFrom][columnNumFrom].isEmptySpace()) {
            System.out.println("No piece on the from square.");
            return false;
        }
        Unit fromPiece = thisGame.getGameBoard().getSquares()[rowNumFrom][columnNumFrom].getThisUnit();
        if (!thisGame.getCurrentPlayer().getTeam().getTeamUnits().contains(fromPiece)) {
            System.out.println("This is not on the team.");
            return false;
        }
        Unit toPiece = thisGame.getGameBoard().getSquares()[rowNumTo][columnNumTo].getThisUnit();
        boolean toPieceEmpty = thisGame.getGameBoard().getSquares()[rowNumTo][columnNumTo].isEmptySpace();


        if (action == 'M') {
            if (!toPieceEmpty) {
                System.out.println("there is a piece on the space you are moving to.");
                return false;
            } else if (!fromPiece.validMovePath()) {
                System.out.print("The path is not valid to move.");
                return false;
            } else {
                return true;
            }
        }
        else if (action == 'S') {
            if (!toPieceEmpty) {
                System.out.println("there is a piece on the space you are spawning to.");
                return false;
            }
            else if (!fromPiece.validSpawnPath()) {
                System.out.print("The path is not valid to spawn.");
                return false;
            }
            else if(!fromPiece.canSpawn()){
                System.out.println("the piece can not spawn.");
                return false;
            }
            else {
                return true;
            }
        }
        else if (action == 'R') {
            if(fromPiece instanceof TomJerryUnit){
                System.out.println("it cannot recruit.");
                return false;
            }
            if (toPieceEmpty) {
                System.out.println("there is not a piece on the board that  you are trying to recruit.");
                return false;
            }
            else if (!fromPiece.validRecruitPath()) {
                System.out.print("The path is not valid to recruit.");
                return false;
            }
            if (!thisGame.getOpponentPlayer().getTeam().getTeamUnits().contains(toPiece)) {
                System.out.println("This is not on the opponent team.");
                return false;
            }
            else {
                return true;
            }
        } else if (action == 'A') {

            if (toPieceEmpty) {
                System.out.println("there is not a piece on the board that  you are trying to attack.");
                return false;
            }else if (fromPiece instanceof BartSimpsonUnit) {
                System.out.println("it cannot recruit.");
                return false;

            }
            Attacker fromAttacker = (Attacker) fromPiece;
            if (!fromAttacker.validAttackPath(rowNumFrom, columnNumFrom, rowNumTo, columnNumTo)) {
                System.out.print("The path is not valid to attack.");
                return false;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
