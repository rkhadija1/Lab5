// the new game unit which extends Attacker
//FIXME
//we need a javadoc describing the class
public class Akaza extends Attacker{
    Akaza(char symbol, String name, double health, double healthModifier, double damage, double damageModifier,
          int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor, int numAttacks) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck,
                xCor, yCor, movement, movementModifier, teamColor, numAttacks);
    }

    //FIXME
    //we need a javadoc describing the method

    @Override
    public Unit spawn() {
        //FIXME
        //spawn should return a new unit, similar as the implementations in TomJerryUnit & BartSimpsonUnit
        return null;
    }

    //FIXME
    //we need a javadoc describing the method

    @Override
    public boolean canSpawn() {
        //FIXME
        //this unit should be able to spawn, because in the overall rules for this program, both attackers and
        //recruiters can spawn
        return false;
    }

    //FIXME
    //we need a javadoc describing the method

    @Override
    public boolean validMovePath(int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo) {
        //FIXME
        //we need a more complicated path pattern than just returning true
        return true;
    }

    //FIXME
    //we need a javadoc describing the method

    @Override
    public boolean validSpawnPath(int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo) {
        //we need a more complicated path pattern than this
        return true;
    }


    //FIXME
    //we need a javadoc describing the method
    public boolean validAttackPath(int numRowsFrom, int columnNumsFront, int rowNumsTo, int columnNumsTo){
        //FIXME
        //we need a valid attack path method since this is an attacker
    }

}
