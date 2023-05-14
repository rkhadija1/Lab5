// the new game unit which extends Attacker
public class Akaza extends Attacker{
    Akaza(char symbol, String name, double health, double healthModifier, double damage, double damageModifier,
          int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck,
                xCor, yCor, movement, movementModifier, teamColor);
    }

    @Override
    public Unit spawn() {
        return null;
    }

    @Override
    public boolean canSpawn() {
        return false;
    }

    @Override
    public boolean validMovePath(int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo) {
        return true;
    }

    @Override
    public boolean validSpawnPath(int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo) {
        return true;
    }
}
