public class BoardSquare {
    private boolean emptySpace;
    private Unit thisUnit;
    private String squareColor;

    public BoardSquare(boolean emptySpace, Unit thisUnit, String squareColor){
        this.emptySpace = emptySpace;
        this.thisUnit = thisUnit;
        this.squareColor = squareColor;
    }
    public BoardSquare(String boardColor) {
        this(true, null, boardColor);
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
        if(thisUnit == null){
            s = "-------";
        } else if (thisUnit != null) {
            s = "-" + thisUnit.toString() + "-";
        }
        return s;
    }
}
