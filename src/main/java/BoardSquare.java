/**  This class defines a game board square with variables for thisUnit, 
 * emptySpace, and squareColor. It has removeUnit() and toString() methods.
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */
public class BoardSquare {
    private boolean emptySpace;
    private Unit thisUnit;
    private String squareColor;
   // declaration of the square with different behavior
    private boolean specialSquare;

    public BoardSquare(boolean emptySpace, Unit thisUnit, String squareColor, boolean specialSquare){
        this.emptySpace = emptySpace;
        this.thisUnit = thisUnit;
        this.squareColor = squareColor;
        this.specialSquare = specialSquare;
    }
    public BoardSquare(String boardColor, boolean specialSquare) {
        this(true, null, boardColor, specialSquare);
    }
    public Unit getThisUnit(){
        return thisUnit;
    }

    public boolean isEmptySpace() {
        return emptySpace;
    }
    public String getSquareColor(){
        return squareColor;
    }
    public void setThisUnit(Unit theUnit) {
        thisUnit = theUnit;
        emptySpace = false;

    }
    public Unit removeUnit(){
        Unit tempUnit  = thisUnit;
        thisUnit = null;
        emptySpace = true;
        return tempUnit;
    }

    @Override
    public String toString() {
        String s = " ";
        if (thisUnit != null) {
            s = "-" + thisUnit.toString() + "-";
        }
        // the square with different behavior is shown as ---S--- on the board
        else if(this.specialSquare==true) {
            s = "---S---";
        }
        else if(thisUnit == null){
            s = "-------";
        }
        return s;
    }
    
    
    //FIXME where in the program do you actually make anything special happen with this square? 
    
    //the special square is the rendom square in the form of "---S---" on the board and if any  
    //unit lands on this square – the game unit switches teams.

    public boolean isSpecialSquare() {
        return this.specialSquare;
    }
}
