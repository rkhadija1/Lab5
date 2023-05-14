/**  This class is modified to extend Attacker class
 * that enables TomJerryUnit to attack.
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */
public class TomJerryUnit extends Attacker {
    private boolean homingRocket;
    private boolean offerCheese;
    private boolean hiding;

    public TomJerryUnit() {
        this(true, true, false);
    }

    public TomJerryUnit(boolean homingRocket, boolean offerCheese, boolean hiding) {
        super('T', "Tom & Jerry", 100.0, 0.0, 25.0,
                0.0, 0, 5, 5, 1, 0, "");
        this.homingRocket = homingRocket;
        this.offerCheese = offerCheese;
        this.hiding = hiding;
    }

    public void setHomingRocket(boolean homingRocketIs) {
        homingRocket = homingRocketIs;
    }

    public boolean canHomingRocket() {
        return homingRocket;
    }

    public void setOfferCheese(boolean offerCheeseIs) {
        offerCheese = offerCheeseIs;
    }

    public boolean canOfferCheese() {
        return offerCheese;
    }

    public void setHiding(boolean hidingIs) {
        hiding = hidingIs;
    }

    public boolean isHiding() {
        return hiding;
    }

    public Unit spawn() {
        Unit tName = new TomJerryUnit(true, true, false);
        tName.symbol = Character.toLowerCase(tName.symbol);
        return tName;

    }

    public double dealDamage() {
        double totalDamage = damage + damageModifier;
        if (canHomingRocket()) {
            totalDamage += 10;
        }
        return totalDamage;
    }

    public void takeDamage(double damage) {
        if (!isHiding()) {
            health -= damage;
        }

    }
    public boolean canSpawn(){
        return true;
    }
    public boolean validMovePath(int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo){
        return true;
    }

    @Override
    public boolean validSpawnPath(int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo) {
        return true;
    }
}
