public class Rules {
    public static boolean checkValidAction(Game thisGame, int rowNumFrom, int columnNumFrom,
                                        int rowNumTo, int columnNumTo, char action) {

        if (!thisGame.getGameBoard().inBounds(rowNumFrom, columnNumFrom)
                || !thisGame.getGameBoard().inBounds(rowNumTo, columnNumTo)) {
            System.out.println("The location was invalid!");
            return false;
        }
        if (thisGame.getGameBoard().getSquares()[rowNumFrom][columnNumFrom].isEmptySpace()) {
            System.out.println("No peice on the from square.");
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
                System.out.println("there is a peice on the space you are moving to.");
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
                System.out.println("there is a peice on the space you are spawning to.");
                return false;
            }
            else if (!fromPiece.validSpawnPath()) {
                System.out.print("The path is not valid to spawn.");
                return false;
            }
            else if(!fromPiece.canSpawn()){
                System.out.println("the peice can not spawn.");
                return false;
            }
            else {
                return true;
            }
        }
        else if (action == 'R') {
            if(fromPiece instanceof TomJerryUnit){
                System.out.println("it cannt recruit.");
                return false;
            }
            if (toPieceEmpty) {
                System.out.println("there is not a peice on the board that  you are trying to recruit.");
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
                System.out.println("there is not a peice on the board that  you are trying to attack.");
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
        return false;
    }
}
