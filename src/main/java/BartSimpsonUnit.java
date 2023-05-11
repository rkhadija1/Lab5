/**
 * <h1>Lab3</h1>
 * <h2>CISC181040L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * <p>
 * The Lab3 is going to be a practice of using classes and methods, also usages of private properties, setters and getters.
 * the BartSimpsonUnit is not very different from TomJerryUnit class. It is also going to have 14 private fields, a public method with 14 parameters and another public method with
 * passed the instructed values into the 14 parameters. Then it is will have 14 setters and getters.
 * @author  Khadija Mohammadi & Tara Lennon
 * @since 2023-03-10
 */
public class BartSimpsonUnit extends Recruiter {

    private int numTimesSpawned;
    //number of times unit has spawned
    private boolean distract;
    //whether unit can distract
    private boolean  recruit;
    //whether unit can recruit
    int MAX_NUM_SPAWNED = 2;
    //max num of times unit can spawn

    public BartSimpsonUnit(char symbol, String name, double health, double healthModifier, double damage, double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor, int numRecruits, int numTimesSpawned, boolean distract, boolean recruit) {
        //15 parameter constructor
        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement, movementModifier, teamColor, numRecruits);
        this.numTimesSpawned = numTimesSpawned;
        this.distract = distract;
        this.recruit = recruit;

    }
    public BartSimpsonUnit() {
        //0 parameter constructor
        this('B', "Bart Simpson", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, "blue", 0, 0, true, true);

    }

    /**
     * Sets the number of times spawned
     * @param theNumTimesSpawned the number of times spawned
     */

    public void setNumTimesSpawned(int theNumTimesSpawned) {
        numTimesSpawned = theNumTimesSpawned;
    }

    /**
     * Gets the number of times spawned
     * @return int representing the num of times spawned
     */
    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }

    /**
     * Sets if the unit can distract
     * @param distractIsOrNot bool that sets if the unit can distract
     */

    public void setDistract(boolean distractIsOrNot) {
        distract = distractIsOrNot;
    }

    /**
     * Gets if the unit can distract
     * @return bool representing if the unit can distract
     */
    public boolean canDistract() {
        return distract;
    }

    /**
     * Sets if the unit can recruit
     * @param recruitRe whether the unit can recruit
     */
    public void setRecruit(boolean recruitRe) {
        recruit = recruitRe;
    }

    /**
     * Gets if the unit can recruit
     * @return bool representing if the unit can recruit
     */
    public boolean canRecruit() {
        return recruit;
    }

    /**
     * Gets if the unit can spawn
     * @return bool representing if the unit can spawn
     */
    public boolean canSpawn() {
        boolean result = true;
        if (numTimesSpawned < MAX_NUM_SPAWNED && this.symbol == 'B') {
            result =  true;
        }
        else {
            result =  false;
        }
        return result;
    }

    /**
     * Prints if the unit is distracted
     */
    public void distracted() {
        if(distract) {
            System.out.println("Unit Distracted!");
        }
    }

    /**
     * Sets if the unit can spawn
     * @return BartSimpsonUnit that the unit has spawned
     */
    public BartSimpsonUnit spawn() {
        BartSimpsonUnit newBartSimpson = new BartSimpsonUnit();
        this.numTimesSpawned += 1;
        return newBartSimpson;
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
        if (columnFrom == columnTo){
            return true;
        }
        else if (((columnTo - columnFrom) == 2 || (columnFrom - columnTo) == 2) && (rowFrom == rowTo)){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Gets if a path is a valid recruit path
     * @param rowFrom row index of from unit
     * @param columnFrom col index of from unit
     * @param rowTo row index of to unit
     * @param columnTo col index of to unit
     * @return bool representing if it is a valid path
     */

    public boolean validRecruitPath(int rowFrom, int columnFrom, int rowTo, int columnTo){
        if (columnFrom == columnTo){
            return true;
        }
        else if (((columnTo - columnFrom) == 2 || (columnFrom - columnTo) == 2) && (rowFrom == rowTo)){
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
 */

    public boolean validSpawnPath(int rowFrom, int columnFrom, int rowTo, int columnTo){
        if (columnFrom == columnTo){
            return true;
        }
        else if (((columnTo - columnFrom) == 2 || (columnFrom - columnTo) == 2) && (rowFrom == rowTo)){
            return true;
        }
        else {
            return false;
        }
    }
}
