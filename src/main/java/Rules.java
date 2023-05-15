/**
 * In this class, checkValidAction is a method that checks if a given action is valid in a game by
 * checking various conditions.
 * It returns true if all conditions are met and false otherwise, along with an error message.
 *
 * * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */
public class Rules {
    // initializes hasRemovedHappened
    private static boolean hasRemovedHappened = false;
    public static boolean checkValidAction(Game thisGame, int rowNumFrom, int columnNumFrom,
                                        int rowNumTo, int columnNumTo, char action) {
        // the new rule is to not allow action 'D' (remove) more than once in the entire game.
        //FIXME i'd come up with a better variable name than "lastActionWasRemove" because it's not really
        //about what the last action was, but about that remove already happened. how about "hasRemovedHappened"
        if (action == 'D') {
            if (hasRemovedHappened) {
                System.out.println("You cannot remove more than once in the entire game.");
                return false;
            } else {
                hasRemovedHappened = true;
                return true;
            }
        }


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
            } else if (!fromPiece.validMovePath(rowNumFrom,columnNumFrom,rowNumTo,columnNumTo)) {
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
            else if (!fromPiece.validSpawnPath(rowNumFrom,columnNumFrom,rowNumTo,columnNumTo)) {
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
                System.out.println("it can't recruit.");
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
                System.out.println("there is not a piece on the board that you are trying to attack.");
                return false;
            }else if (fromPiece instanceof BartSimpsonUnit) {
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

        System.out.println("Enter a valid action: ");
        return false;
    }
}
