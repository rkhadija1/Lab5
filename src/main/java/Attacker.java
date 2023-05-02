/** This class extends the abstract class Unit and adds a numAttacks field
 * and methods to get and set it, as well as a method to check if an attack path is valid.
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */
public abstract class Attacker extends Unit{
    private int numAttacks;
    Attacker(char symbol, String name, double health, double healthModifier, double damage, double damageModifier,
             int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor){
        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement,
                movementModifier, teamColor);
    }
    public int getNumAttacks()
    {
        return numAttacks;
    }
    public void setNumAttacks(int theNumAttacks)
    {
        numAttacks = theNumAttacks;
    }
    public boolean validAttackPath(int rowB, int columnB, int rowU, int columnU)
    {
        return true;
    }
}
