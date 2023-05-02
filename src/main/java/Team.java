import java.util.ArrayList;
public class Team {
    /** This class creates a Team for the game with a specific color and specific
     * units that belong to that team
     * @author TaraLennon & Khadija Mohammadi
     * @verison 1
     */
    String teamColor;
    //represents the team color
    ArrayList<Unit> teamUnits;
    //arraylist of Units that belong to the team

    public Team (String teamColor, ArrayList<Unit> teamUnits){
        //two parameter constructor
        this.teamColor = teamColor;
        this.teamUnits = teamUnits;
        for (int i = 0; i < teamUnits.size(); i++){
            teamUnits.get(i).setTeamColor(teamColor);
        }
    }
    /**
     * This method gets the team color
     * @return String that represents the team color
     */
    public String getTeamColor() {
        return teamColor;
    }
    /**
     * This method gets the array list of team units
     * @return an array list of the team units
     */
    public ArrayList<Unit> getTeamUnits() {
        return teamUnits;
    }
    /**
     * This method removes specific units from the team
     * @param unitRemoved a Unit that is intended to be removed from the array list
     */
    public void removeUnitsFromTeam (Unit unitRemoved){
        for (int i = 0; i < teamUnits.size(); i++){
            if (teamUnits.get(i) == unitRemoved){
                teamUnits.remove(i);
            }
        }

    }

    /**
     * This method adds unit to the team
     * @param addUnit a Unit that is intended to be added to the array list
     */

    public void addUnitsToTeam (Unit addUnit){
        addUnit.setTeamColor(teamColor);
        teamUnits.add(addUnit);

    }

    /**
     * This method overrides toString
     * @return an String that represents the team
     */
    @Override
    public String toString (){
        String origString = "";
        for (int i = 0; i < teamUnits.size(); i ++){
            origString = origString + teamUnits.get(i).toString() + " ";
        }
        return "Team " + teamColor + " Units :" + "\n" + origString;
    }

}
