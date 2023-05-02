import java.util.ArrayList;
public class Player {
    /** This class creates a Player class with fields
     * representing the player number, whether its their turn, and their team, and
     * associated getters and setters for those fields.
     * @author TaraLennon & Khadija Mohammadi
     * @verison 1
     */
    private int playerNumber;
    private boolean turn;
    private Team team;



    public Player(int playerNumber, boolean turn, Team team) {
        //three parameter constructor
        this.playerNumber = playerNumber;
        this.turn = turn;
        this.team = team;
    }

    public Player(int playerNumber, Team team) {
        //two parameter constructor
        this(playerNumber, false, team);
    }

    public Player(){
        //no parameter constructor
        ArrayList<Unit> teamUnits = new ArrayList<Unit>();

        Team defaultTeam = new Team("red", teamUnits);
        team = defaultTeam;
        turn = false;
        playerNumber = 1;
    }

    /**
     * This method gets playerNumber
     * @return an int that represents the player number
     */
    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * This method sets playerNumber
     * @param playerNumber  an int that represents the player number
     */
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    /**
     * This method gets whether it's the player's turn
     * @return a boolean that represents whether it's their turn or not
     */
    public boolean isTurn() {
        return turn;
    }

    /**
     * This method sets the turn
     * @param turn a boolean that represents whether it's their turn or not
     */
    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    /**
     * This method gets the team
     * @return a team that represents the team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * This method sets the team
     * @param team a team that represents the team
     */
    public void setTeam(Team team) {
        this.team = team;
    }
}
