// the new game unit which extends Attacker
//FIXME
//we need a javadoc describing the class
public class Akaza extends Attacker{
    public Akaza(char symbol, String name, double health, double healthModifier, double damage, double damageModifier,
          int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor, int numAttacks) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck,
                xCor, yCor, movement, movementModifier, teamColor, numAttacks);
    }

    public Akaza (){
        this("A", "Akaza", 100.0, 0.0, 25.0, 0.0, 0, 10, 10, 1, 0, "red", 0)
    }


    /**
     * Overrides the spawn method from the Unit class.
     * @return a new instance of the Akaza class with the given parameters */
    @Override
    public Unit spawn() {
        return new Akaza(symbol, name, health, healthModifier, damage, damageModifier, luck,
                xCor, yCor, movement, movementModifier, teamColor);
    }
    /**
     * Overrides the canSpawn method from the Unit class.
     * @return true
     */
    @Override
    public boolean canSpawn() {
        return true;
    }
    /**
     * Overrides the validMovePath method from the Unit class.
     * A move is valid if the difference in rows and columns is even.
     * @param rowNumsFrom the starting row number
     * @param columnNumsFrom the starting column number
     * @param rowNumsTo the ending row number
     * @param columnsNumsTo the ending column number
     * @return true if the move is valid, false otherwise
     */
    @Override
    public boolean validMovePath(int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo) {
        // implement a new pattern for valid move paths
        int rowDiff = Math.abs(rowNumsFrom - rowNumsTo);
        int colDiff = Math.abs(columnNumsFrom - columnsNumsTo);
        if ((rowDiff + colDiff) % 2 == 0) {
            return true;
        } else {
            return false;}
    }
    /**
     * Overrides the validSpawnPath method from the Unit class.
     * A spawn path is valid if the move from (rowNumsFrom, columnNumsFrom) to (rowNumsTo, columnsNumsTo) is valid.
     * @return true if the move is valid, false otherwise
     */
    @Override
    public boolean validSpawnPath(int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo) {
        return validMovePath(rowNumsFrom, columnNumsFrom, rowNumsTo, columnsNumsTo);
    }
    /**
     Overrides the validAttackPath method from the Unit class.
     An attack path is valid if the move from (rowNumsFrom, columnNumsFrom) to (rowNumsTo, columnsNumsTo) is valid.
     @return true if the move is valid, false otherwise
     */
    @Override
    public boolean validAttackPath(int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo) {
        return validMovePath(rowNumsFrom, columnNumsFrom, rowNumsTo, columnsNumsTo);
    }
}
