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
