import java.util.*;
public class Game {
    private GameBoard game;
    //an instance of a game board
    private Player player1;
    //an instance of player 
    private Player player2;
    //an instance of player
    
    /**
     * intializes the game board
     * @param rowsNum number of rows
     * @param columnsNum number of columns
     */
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
        //4 parameter constrcutor
        this.player1 = player1;
        this.player2 = player2;
        initializeGameBoard(rowsNum, columnsNum);
    }
    
    /**
     * Gets the game baord
     * @return GameBoard representing the board
     */
    public GameBoard getGameBoard(){
        return game;
    }
    
    /**
     * Gets the current player
     * @return Player that is the current player
     */
    public Player getCurrentPlayer(){
        if(player1.isTurn()){
            return player1;

        }
        else{
            return player2;
        }

    }
    
    /**
     * Gets the opponent player of the player whose turn it is
     * @return Player that is the opponent player
     */
    public Player getOpponentPlayer(){
        if(!player1.isTurn()){
            return player1;

        }
        else{
            return player2;
        }
    }
    
    /**
     * Gets if it is a players turn
     * @param player whose turn it may be
     * @return bool representing if it is their turn or not
     */
    public boolean isTurn(Player player){
        return player.isTurn();
    }
    
    /**
     * Gets an array of the board squares
     * @return array of the board squares
     */
    public BoardSquare[][] getBoardSquare(){
        return getGameBoard().getSquares();
    }
    
    /**
     * Changes whose turn it is
     */
    public void changeTurn(){
        this.player1.setTurn(!this.player1.isTurn());
        this.player2.setTurn(!this.player2.isTurn());

    }
    
    /**
     * Overrides to string to display game
     * @return String of the game
     */
    
    @Override
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
    
    /**
     * Gets if there was a wanner
     * @return boolean representing if there was a winner
     */
    public boolean isAWinner()
    {
        return player1.getTeam().getTeamUnits().size() ==  0 ^ player2.getTeam().getTeamUnits().size() == 0;
    }
    
    /**
     * Gets player who won
     * @return Player who won
     */
    public Player getWinner(){
        if(player1.getTeam().getTeamUnits().size() ==  0 && player2.getTeam().getTeamUnits().size() != 0) {
            return player2;
        }
        else if(player2.getTeam().getTeamUnits().size() == 0 && player1.getTeam().getTeamUnits().size() != 0){
            return player1;
        }
        return null;
    }
    
    /**
     * Gets if the game has ended
     * @return bool representing if the game is over
     */
    public boolean isGameEnded(){
        if(player1.getTeam().getTeamUnits().size() ==  0 || player2.getTeam().getTeamUnits().size() == 0){
            return true;
        }
        return false;
    }

}
