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
