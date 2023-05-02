/**
 /**  This class is modified to extend Recruiter class
 * that enables BartSimpsonUnit to befriend (to recruit).
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */
public class BartSimpsonUnit extends Recruiter {

    private int numTimesSpawned;
    private boolean distract;
    private boolean  recruit;
    int MAX_NUM_SPAWNED = 2;
    public BartSimpsonUnit(int numTimesSpawned, boolean distract, boolean recruit) {
        super('B', "BartSimpson", 100.0, 0.0, 25.0,
                0.0, 0, 5, 5, 1, 0, "", 0);


        this.numTimesSpawned = numTimesSpawned;
        this.distract = distract;
        this.recruit = recruit;

    }
    public BartSimpsonUnit() {

        this(0, true, true);

    }
    public void setSymbol( char theSymbol) {
        symbol = theSymbol;
    }

    public char getSymbol() {
        return symbol;
    }
    public void setName(String theName){
        name = theName;
    }
    public String getName(){
        return name;
    }
    public void setHealth(double healthVal) {
        health = healthVal;
    }
    public double getHealth() {
        return health;
    }
    public void setHealthModifier(double setHealthModifierVal) {
        healthModifier = setHealthModifierVal;
    }

    public double getHealthModifier() {
        return healthModifier;
    }
    public void setDamage(double theDamage) {
        damage = theDamage;
    }
    public double getDamage() {
        return damage;
    }
    public void setDamageModifier(double theDamageModifier) {
        damageModifier = theDamageModifier;
    }
    public double getDamageModifier() {
        return damageModifier;
    }
    public void setLuck(int numLuck) {
        luck = numLuck;
    }
    public int getLuck() {
        return luck;
    }
    public void setxCor(int numxCor) {
        xCor = numxCor;
    }
    public int getxCor() {
        return xCor;
    }
    public void setyCor(int numyCor) {
        yCor = numyCor;
    }
    public int getyCor() {
        return yCor;
    }
    public void setMovement(int numMovement) {
        movement = numMovement;
    }
    public int getMovement() {
        return movement;
    }
    public void setMovementModifier(int numMovementModifier) {
        movementModifier = numMovementModifier;
    }
    public int getMovementModifier() {
        return movementModifier;
    }
    public void setNumTimesSpawned(int theNumTimesSpawned) {
        numTimesSpawned = theNumTimesSpawned;
    }
    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }
    public void setDistract(boolean distractIsOrNot) {
        distract = distractIsOrNot;
    }
    public boolean canDistract() {
        return distract;
    }
    public void setRecruit(boolean recruitRe) {
        recruit = recruitRe;
    }
    public boolean canRecruit() {
        return recruit;
    }
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
    public void distracted() {
        if(distract) {
            System.out.println("Unit Distracted!");
        }
    }
    public BartSimpsonUnit spawn() {
        BartSimpsonUnit newBartSimpson = new BartSimpsonUnit(0, true, true);
        this.numTimesSpawned += 1;
        return newBartSimpson;
    }
}
