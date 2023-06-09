/** This class defines a game with a game board, two players, and methods for playing the game
 * and checking for a winner.
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */
import java.util.*;
public class Game {
    private GameBoard game;
    private Player player1;
    private Player player2;
    private void initializeGameBoard(int rowsNum, int columnsNum){
        game = new GameBoard(rowsNum, columnsNum);
        for(Unit teamUnit1: player1.getTeam().getTeamUnits()){
            BoardSquare square = game.findRandomEmptySpace();
            square.setThisUnit(teamUnit1);
        }
        for(Unit teamUnit2: player2.getTeam().getTeamUnits()){
            BoardSquare square = game.findRandomEmptySpace();
            square.setThisUnit(teamUnit2);
        }

    }
    public Game(int rowsNum, int columnsNum, Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        initializeGameBoard(rowsNum, columnsNum);
    }
    public GameBoard getGameBoard(){
        return game;
    }
    public Player getCurrentPlayer(){
        if(player1.isTurn()){
            return player1;

        }
        else{
            return player2;
        }

    }
    public Player getOpponentPlayer(){
        if(!player1.isTurn()){
            return player1;

        }
        else{
            return player2;
        }
    }
    public boolean isTurn(Player player){
        return player.isTurn();
    }
    public BoardSquare[][] getBoardSquare(){
        return getGameBoard().getSquares();
    }
    public void changeTurn(){
        this.player1.setTurn(!this.player1.isTurn());
        this.player2.setTurn(!this.player2.isTurn());

    }
    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + game.getColumnsNum()*8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + game.getColumnsNum()*8, "*")))
                .append("\n" + getCurrentPlayer().getTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + game.getColumnsNum()*8, "*")))
                .append("\n" + getOpponentPlayer().getTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + game.getColumnsNum()*8, "*")))
                .append("\nIt is Player " + getCurrentPlayer().getPlayerNumber() + "'s (" + getCurrentPlayer().getTeam().getTeamColor() + "'s) turn\n");
        return retString.toString();
    }
    // a change in objective of the game:
    // returns true if one player has more points than the other
    //FIXME you need to complicate the ending of the game more. this will merely return that there is a winner anytime
    //that one player has more points than the other -- i.e. the game will end really early. I'd add some other condition. 
    //Maybe once a certain number of turns or something is taken, THEN the player with the most points win. 
    public boolean isAWinner()
    {
        return player1.getPoints() > player2.getPoints() || player1.getPoints() < player2.getPoints();
    }
    // returns the player with the most points
    public Player getWinner(){
        if(player1.getPoints() < player2.getPoints()) {
            return player2;
        }
        else if(player1.getPoints() > player2.getPoints()){
            return player1;
        }
        return null;
    }
    public boolean isGameEnded(){
        if(player1.getTeam().getTeamUnits().size() ==  0 || player2.getTeam().getTeamUnits().size() == 0){
            return true;
        }
        return false;
    }

}
