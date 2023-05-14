import java.util.ArrayList;

public class Player {
    private int playerNumber;
    private boolean turn;
    private Team team;
    // to keep the track of the player with the most points
    protected int points;
    public Player(int playerNumber, boolean turn, Team team, int points) {
        this.playerNumber = playerNumber;
        this.turn = turn;
        this.team = team;
        this.points = points;
    }
    public Player(int playerNumber, Team team) {
        this.playerNumber = playerNumber;
        this.turn = false;
        this.team = team;
    }
    public Player() {
        playerNumber = 3;
        turn = false;
        this.team = new Team( "", new ArrayList<Unit>());
    }
    public void setPlayerNumber(int playerNumberIs) {
        playerNumber = playerNumberIs;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }
    public void setTurn(boolean isTurn) {
        turn = isTurn;
    }
    public boolean isTurn() {
        return turn;
    }
    public void setTeam(Team theUnit) {
        team = theUnit;
    }
    public Team getTeam(){
        return team;
    }

    public int getPoints() {
        return points;
    }

}
