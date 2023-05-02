public abstract class Unit {
    /** This class creates an abstract game piece
     * @author TaraLennon & Khadija Mohammadi
     * @verison 1
     */
    protected char symbol;
    //represents the unit's symbol
    protected String name;
    //represents the unit's name
    protected double health;
    //represents the unit's health
    protected double healthModifier;
    //represents the unit's health modifier
    protected double damage;
    //represents the unit's damage
    protected double damageModifier;
    //represents the unit's damage modifier
    protected int luck;
    //represents the unit's luck
    protected int xCor;
    //represents the unit's x coordinate
    protected int yCor;
    //represents the unit's y coordinate
    protected int movement;
    //represents the unit's movement
    protected int movementModifier;
    //represents the unit's movement modifier

    protected String teamColor;
    //represents the unit's team's color

    public Unit (){
        // no parameter constructor
        this('U', "unit", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, "white");
    }

    public Unit(char symbol, String name, double health, double healthModifier, double damage, double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor) {
        // 12 parameter constructor
        this.symbol = symbol;
        this.name = name;
        this.health = health;
        this.healthModifier = healthModifier;
        this.damage = damage;
        this.damageModifier = damageModifier;
        this.luck = luck;
        this.xCor = xCor;
        this.yCor = yCor;
        this.movement = movement;
        this.movementModifier = movementModifier;
        this.teamColor = teamColor;
    }

    /**
     * Gets the symbol for the game piece
     * @return character representing the symbol
     */

    public char getSymbol() {
        return symbol;
    }

    /**
     * Sets the symbol for the game piece
     * @param symbol character representing the symbol of a game piece
     */

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Gets the name of the game piece
     * @return string representing the name of the game piece
     */

    public String getName() {
        return name;
    }

    /**
     * Sets the name for the game piece
     * @param name string representing the name of the game piece
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the health of the game piece
     * @return double representing the health of the game piece
     */

    public double getHealth() {
        return health;
    }

    /**
     * Sets the health of the game piece
     * @param health double representing the health of the game piece
     */

    public void setHealth(double health) {
        this.health = health;
    }

    /**
     * Gets the health modifier for the game piece
     * @return double representing the health modifier for the game piece
     */

    public double getHealthModifier() {
        return healthModifier;
    }

    /**
     * Sets the health modifier for the game piece
     * @param healthModifier double representing the health modifier for the game piece
     */

    public void setHealthModifier(double healthModifier) {
        this.healthModifier = healthModifier;
    }

    /**
     * Gets the damage of the game piece
     * @return double representing the damage of the game piece
     */

    public double getDamage() {
        return damage;
    }

    /**
     * Sets the damage for the game piece
     * @param damage double representing the damage of the game piece
     */

    public void setDamage(double damage) {
        this.damage = damage;
    }

    /**
     * Gets the damage modifier for the game piece
     * @return double representing the damage modifier for the game piece
     */

    public double getDamageModifier() {
        return damageModifier;
    }

    /**
     * Sets the damage modifier for the game piece
     * @param damageModifier double representing the damage modifer for the game piece
     */

    public void setDamageModifier(double damageModifier) {
        this.damageModifier = damageModifier;
    }

    /**
     * Gets the luck for the game piece
     * @return int representing the luck of the game piece
     */

    public int getLuck() {
        return luck;
    }

    /**
     * sets the luck for the game piece
     * @param luck int representing the luck of the game piece
     */

    public void setLuck(int luck) {
        this.luck = luck;
    }

    /**
     * Gets the xCor for the game piece
     * @return int representing the xCor of the game piece
     */

    public int getxCor() {
        return xCor;
    }

    /**
     * Sets the xCor for the game piece
     * @param xCor int representing the xCor of the game piece
     */

    public void setxCor(int xCor) {
        this.xCor = xCor;
    }

    /**
     * Gets the yCor for the game piece
     * @return int representing the yCor of the game piece
     */

    public int getyCor() {
        return yCor;
    }

    /**
     * Sets the yCor for the game piece
     * @param yCor int representing the yCor for the game piece
     */

    public void setyCor(int yCor) {
        this.yCor = yCor;
    }

    /**
     * Gets the movement for the game piece
     * @return int representing the movement of the game piece
     */

    public int getMovement() {
        return movement;
    }

    /**
     * Sets the movement for the game piece
     * @param movement int representing the movement of the game piece
     */
    public void setMovement(int movement) {
        this.movement = movement;
    }

    /**
     * Gets the movement modifier for the game piece
     * @return int representing the movement modifier of the game piece
     */

    public int getMovementModifier() {
        return movementModifier;
    }

    /**
     * Sets the movement modifier for the game piece
     * @param movementModifier int representing the movement modifier of the game piece
     */

    public void setMovementModifier(int movementModifier) {
        this.movementModifier = movementModifier;
    }
    /**
     * Gets the team color for the game piece
     * @return String representing the color of the team of the game piece
     */

    public String getTeamColor() {
        return teamColor;
    }
    /**
     * Sets the team color for the game piece
     * @param teamColor String representing the color of the team of the game piece
     */
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }
    /**
     * Abstract method for spawn to be implemented in subclasses
     * @return Unit representing the spawn of the piece
     */
    public abstract Unit spawn();

    /**
     * Overriding toString
     * @return String representing the game piece
     */
    @Override
    public String toString(){
        return this.teamColor + " " + this.symbol;
    }

    protected void takeDamage(double damage) {
        //to be implemented
    }

    /**
     * method that tests if a unit can spawn
     * @return boolean representing whether it can spawn
     */
    
    public abstract boolean canSpawn();

    /**
     * Tests if a move path is valid
     * @return boolean representing whether the move path is valid
     */
    public boolean validMovePath(){
        return true;
    }

    /**
     * Tests whether a spawn path is valid
     * @return boolean representing if that path is valid
     */
    public boolean validSpawnPath()
    {
        return true;
    }

    /**
     * Tests if a recruit path is valid
     * @return boolean representing whether that path is valid
     */
    public boolean validRecruitPath(){
        return true;
    }



}
