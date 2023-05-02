public class BoardSquare {

    /** This class creates a space on the game board
     * @author TaraLennon & Khadija Mohammadi
     * @verison 1
     */
    private boolean empty;
    //represents whether the space is empty or not
    private Unit unit;
    //represents the unit that is located in the square
    private String squareColor;
    //represents the color of the board square
    public BoardSquare (String squareColor){
        //a constructor that accepts the color and sets the property
        this.squareColor = squareColor;
        empty = true;
    }
    /**
     * Gets the whether the square is empty or not
     * @return boolean representing whether the square is empty or not
     */
    public boolean isEmptySpace() {
        return empty;
    }

    /**
     * Gets the unit in the square
     * @return Unit representing the unit in the square
     */

    public Unit getThisUnit() {
        return unit;
    }

    /**
     * Gets the color of the square
     * @return String representing the color of the square
     */
    public String getSquareColor() {
        return squareColor;
    }

    /**
     * Sets the unit in the square
     * @param unit Unit that is in the square
     */

    public void setThisUnit(Unit unit) {
        this.unit = unit;
        empty = false;
    }

    /**
     * Removes the unit in the square
     * @return Unit that was in the square
     */
    public Unit removeUnit(){
        Unit originalUnit = this.unit;
        this.unit = null;
        this.empty = true;
        return originalUnit;
    }
    /**
     * Overrides toString
     * @return String that represents the square
     */

    @Override
    public String toString(){
        if (this.unit == null){
            return "-------";
        }
        else{
            return "-" + this.unit.toString() + "-";
        }
    }
}
