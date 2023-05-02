/** This class extends "Unit", which has a private integer variable called "numRecruits" and methods to
 * get and set the value of this variable. It also has a method called "validRecruitPath"
 * that returns a boolean value.
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */
public abstract class Recruiter extends Unit{
    private int numRecruits;
    Recruiter(char symbol, String name, double health, double healthModifier, double damage, double damageModifier,
              int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor, int numRecuits){
        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement,
                movementModifier, teamColor);
        this.numRecruits = numRecuits;
    }

    public int getNumRecruits()
    {
        return numRecruits;
    }
    public void setNumRecruits(int theNumRecruits)
    {
        numRecruits = theNumRecruits;
    }
    public boolean validRecruitPath(int rowB, int columnB, int rowU, int columnU )
    {
        return true;
    }
}
