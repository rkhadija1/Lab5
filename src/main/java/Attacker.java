/**  This class extends the unit class for units that can attack
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */

public abstract class Attacker extends Unit{
    private int numAttacks;
    //number of attacks made
    
    Attacker(char symbol, String name, double health, double healthModifier, double damage, double damageModifier,
             int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor){
        //12 parameter constructor
        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement,
                movementModifier, teamColor);
    }
    
    /**
     * Gets the number of attacks
     * @return int representing the number of attacks
     */
    public int getNumAttacks()
    {
        return numAttacks;
    }
    
    /**
     * Sets the number of attacks
     * @param theNumAttacks int representing the number of attacks
     */
    public void setNumAttacks(int theNumAttacks)
    {
        numAttacks = theNumAttacks;
    }
    
    /**
     * Gets whether an attack path is valid
     * @param rowB row index of the unit doing the attacking
     * @param columnB column index of the unit doing the attacking
     * @param rowU row index of the unit being attacked
     * @param columnU column index of the unit being attack
     * @return boolean representing whether it is a valid attack path
     */
    public boolean validAttackPath(int rowB, int columnB, int rowU, int columnU)
    {
        return true;
    }
}
