/**  This represents actions that the players
 * can make during their turn.
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */
public abstract class Action {
    Game theGame;
    //represents the game being played
    int rowNumsFrom;
    //represents row index of from piece
    int columnNumsFrom;
    //column index of from piece
    int rowNumsTo;
    //row index of to piece
    int columnsNumsTo;
    //column index of to piece

    Action(Game theGame, int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo){
        //5 parameter constructor
        this.theGame = theGame;
        this.rowNumsFrom = rowNumsFrom;
        this.columnNumsFrom = columnNumsFrom;
        this.rowNumsTo = rowNumsTo;
        this.columnsNumsTo = columnsNumsTo;
    }
    public abstract void performAction();
    //abstract method to be implemented in subclasses
}

