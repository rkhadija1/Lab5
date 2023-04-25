import java.util.ArrayList;

public class Team {
    private String teamColor;
    private ArrayList<Unit> teamUnits;
    public Team(String teamColor, ArrayList<Unit> teamUnits){
        this.teamColor = teamColor;
        this.teamUnits = teamUnits;

    }
    public String getTeamColor(){
        return teamColor;
    }

    public ArrayList<Unit> getTeamUnits() {
        return teamUnits;
    }
    public void removeUnitsFromTeam(Unit teamUnitBeRemoved){
        teamUnits.remove(teamUnitBeRemoved);
    }
    public void addUnitsToTeam(Unit teamUnitBeAdded){
        teamUnits.add(teamUnitBeAdded);
    }

    @Override
    public String toString() {
        String s = "";
        for(Unit elm: teamUnits){
            s += elm.toString();
        }

        return "Team " + teamColor + " Units :\n" + s;
    }
}

