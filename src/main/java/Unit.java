/**
 * <h1>Lab5</h1>
 * <h2>CISC181040L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * <p>
 * Lab 5 is going to cover some sets of practice on refectoring code to creating object hierarchies, creating and extending
 * abstract claases, overriding methods, using pre-defined object method to string,
 * and two-dimensional Arrays.For the above practice I need to use previous labs.
 * and define some new ones.
 * @author  Khadija Mohammadi
 * @since 2023-04-13
 */
    public abstract class Unit {
        protected char symbol;
        protected String name;
        protected double health;
        protected double healthModifier;
        protected double damage;
        protected double damageModifier;
        protected int luck;
        protected int xCor;
        protected int yCor;
        protected int movement;
        protected int movementModifier;
        protected String teamColor;
        public Unit() {
            this.health = 100.0;
            this.healthModifier = 0.0;
            this.damage = 25.0;
            this.damageModifier = 0.0;
            this.luck = 0;
            this.xCor = 5;
            this.yCor = 5;
            this.movement = 1;
            this.movementModifier = 0;
            this.teamColor = " ";

        }
        public Unit(char symbol, String name, double health, double healthModifier, double damage, double damageModifier,
                    int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor){
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
        public void setSymbol(char symbolIs ) {
            symbol = symbolIs;
        }
        public char getSymbol() {
            return symbol;
        }
        public void setName(String theName) {
            name = theName;
        }
        public String getName() {
            return name;
        }
        public void setHealth(double healthVal) {
            health = healthVal;
        }
        public double getHealth() {
            return health;
        }
        public void setHealthModifier(double healthModifierVal) {
            healthModifier = healthModifierVal;
        }
        public double getHealthModifier() {
            return healthModifier;
        }
        public void setDamage(double whatDamage) {
            damage = whatDamage;
        }

        public double getDamage() {
            return damage;
        }
        public void setDamageModifier (double damageModifierVal) {
            damageModifier = damageModifierVal;
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
        public void setTeamColor(String teamColor1){
            teamColor = teamColor1;
        }
        public String getTeamColor(){
            return teamColor;
        }

        public abstract Unit spawn();

        @Override
        public String toString() {
            return teamColor + " " + symbol;
        }
    }
