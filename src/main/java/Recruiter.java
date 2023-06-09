public abstract class Recruiter extends Unit{
    private int numRecruits;
    //the number of recruits
    Recruiter(char symbol, String name, double health, double healthModifier, double damage, double damageModifier,
              int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor, int numRecuits){
        //13 parameter constrcutor
        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement,
                movementModifier, teamColor);
        this.numRecruits = numRecuits;
    }

    /**
     * Gets the number of recruits
     * @return int representing the number of recruits
     */

    public int getNumRecruits()
    {
        return numRecruits;
    }

    /**
     * Sets the number of recruits
     * @param theNumRecruits number of recruits
     */
    public void setNumRecruits(int theNumRecruits)
    {
        numRecruits = theNumRecruits;
    }

    /**
     * Gets if a path is a valid recruit path
     * @param rowFrom row index of from unit
     * @param columnFrom col index of from unit
     * @param rowTo row index of to unit
     * @param columnTo col index of to unit
     * @return bool representing if it is a valid path
     */
    public abstract boolean validRecruitPath(int rowFrom, int columnFrom, int rowTo, int columnTo);
}
