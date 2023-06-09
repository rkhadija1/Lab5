/** This class extends Tom and Jerry game.
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */
public class Oda extends TomJerryUnit{
    public Oda(char symbol, String name, double health, double healthModifier, double damage, double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor, int numAttacks, boolean homingRocket, boolean offerCheese, boolean hiding)){
        super(char symbol, String name, double health, double healthModifier, double damage, double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor, int numAttacks, boolean homingRocket, boolean offerCheese, boolean hiding);
    }

    public Oda (){
        this("O", "Oda", 100.0, 0.0, 25.0, 0.0, 0, 8, 8, 1, 0, "red", 0, true, true, false)
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
     * the different pattern of the validMovePath method is to check if the
     * absolute difference between row and column numbers is even.
    */
    @Override
    public boolean validMovePath(int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo){
        // implement a new pattern for valid move paths
        int rowDiff = Math.abs(rowNumsFrom - rowNumsTo);
        int colDiff = Math.abs(columnNumsFrom - columnsNumsTo);
        if ((rowDiff + colDiff) % 2 == 0) {
            return true;
        } else {
            return false;
        }
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

