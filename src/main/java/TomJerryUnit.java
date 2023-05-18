public class TomJerryUnit extends Attacker {
    /** This class creates a Tom and Jerry game piece.
     * @author TaraLennon & Khadija Mohammadi
     * @verison 1
     */
    private boolean homingRocket;
    //can use special attack "homing rocket"
    private boolean offerCheese;
    //can use special ability "offer cheese"
    private boolean hiding;
    //is the unit hidden on the board

    public TomJerryUnit (char symbol, String name, double health, double healthModifier, double damage, double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor, int numAttacks, boolean homingRocket, boolean offerCheese, boolean hiding){
        //a constructor for the game piece with 15 parameters
        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement, movementModifier, teamColor, numAttacks);
        this.homingRocket = homingRocket;
        this.offerCheese = offerCheese;
        this.hiding = hiding;
    }

    public TomJerryUnit (){
        //a constructor for the game piece with 0 parameters
        this('T', "Tom & Jerry", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, "red", 0, true, true, false);

    }

    /**
     * Gets if the piece can use the ability "homing rocket"
     * @return boolean representing whether or not the piece can homingRocket
     */

    public boolean isHomingRocket() {
        return homingRocket;
    }

    /**
     * Sets whether a game piece can use the homing rocket ability
     * @param homingRocket boolean representing whether the game piece can homing rocket
     */

    public void setHomingRocket(boolean homingRocket) {
        this.homingRocket = homingRocket;
    }

    /**
     * Gets if the piece can use the ability "offer cheese"
     * @return boolean representing whether or not the piece can offer cheese
     */

    public boolean isOfferCheese() {
        return offerCheese;
    }

    /**
     * Sets whether a game piece can use the offer cheese ability
     * @param offerCheese boolean representing whether the game piece can offer cheese
     */

    public void setOfferCheese(boolean offerCheese) {
        this.offerCheese = offerCheese;
    }


    /**
     * Gets if the piece can use the ability "hiding"
     * @return boolean representing whether or not the piece can hide
     */
    public boolean isHiding() {
        return hiding;
    }

    /**
     * Sets whether a game piece can use the hiding ability
     * @param hiding boolean representing whether the game piece can hide
     */

    public void setHiding(boolean hiding) {
        this.hiding = hiding;
    }

    /**
     * Adds the piece's damage to the damage modifier to get the total damage of a piece
     * @return double representing the total damage of a piece
     */

    public double dealDamage () {
        double totalDamage = damage + damageModifier;
        if (isHomingRocket()){
            totalDamage = totalDamage + 10;
        }
        return totalDamage;
    }

    /**
     * Updates health by subtracting damage, if the piece is not hiding
     * @param _damage double representing the damage inflicted upon a piece
     */

    public void takeDamage (double _damage){
        if (!isHiding()){
            health = health - _damage;
        }
    }

    /**
     * Creates a spawn for the unit
     * @return a TomJerryUnit that is the spawn of the original unit
     */
    public TomJerryUnit spawn() {
        TomJerryUnit spawntj = new TomJerryUnit('t', "Tom & Jerry", 100.0, 5.0, 25.0, 10.0, 0, 1, 1, 1, 1, "red", true, true, false);
        return spawntj;
    }

    /**
     * Gets if a unit can spawn
     * @return bool representing if the unit can spawn
     */
    public boolean canSpawn(){
        return true;
    }

    /**
     * Tests if a move path is valid
     * @param rowFrom row index of the unit doing the moving
     * @param columnFrom column index of the unit doing the moving
     * @param rowTo row index of the square the move will be to
     * @param columnTo column index of the square the move will be to
     * @return boolean representing whether it is a valid move path
     *
     */
    public boolean validMovePath(int rowFrom, int columnFrom, int rowTo, int columnTo){
        return true;
    }

    /**
     * Gets whether an attack path is valid
     * @param rowFrom row index of the unit doing the attacking
     * @param columnFrom column index of the unit doing the attacking
     * @param rowTo row index of the unit being attacked
     * @param columnTo column index of the unit being attack
     * @return boolean representing whether it is a valid attack path
     */
    public boolean validAttackPath(int rowFrom, int columnFrom, int rowTo, int columnTo){
        if (rowFrom == rowTo){
            return true;
        }
        else if (((rowTo - rowFrom) == 2 || (rowFrom - rowTo) == 2) && (columnFrom == columnTo)){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Tests whether a spawn path is valid
     * @param rowFrom row index of the unit doing the spawning
     * @param columnFrom column index of the unit doing the spawning
     * @param rowTo row index of the square the spawn will be at
     * @param columnTo column index of the square the spawn will be at
     * @return boolean representing whether it is a valid spawn path
     *
     */

    public boolean validSpawnPath(int rowFrom, int columnFrom, int rowTo, int columnTo){
        return true;
    }
}
