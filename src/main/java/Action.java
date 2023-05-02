/**  This class has an abstract method called "performAction()" which does not have
 * an implementation in this class. Any class that extends this abstract class
 * will need to implement the "performAction()" method.
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */
public abstract class Action {
     Game theGame;
     int rowNumsFrom;
     int columnNumsFrom;
     int rowNumsTo;
     int columnsNumsTo;
     Action(Game theGame, int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo){
          this.theGame = theGame;
          this.rowNumsFrom = rowNumsFrom;
          this.columnNumsFrom = columnNumsFrom;
          this. rowNumsTo = rowNumsTo;
          this.columnsNumsTo = columnsNumsTo;
     }
     public abstract void performAction();
}
