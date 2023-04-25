
public class GameBoard {
    private int rowsNum;
    private int columnsNum;
    private BoardSquare[][] squares;
    public GameBoard(int rowsNum, int columnsNum){
        this.rowsNum = rowsNum;
        this.columnsNum = columnsNum;
        this.squares = new BoardSquare[rowsNum][columnsNum];
        setUpEmptyBoard();

    }
    public int getRowsNum(){
        return rowsNum;
    }
    public int getColumnsNum(){
        return columnsNum;
    }
    public BoardSquare[][] getSquares(){
        return squares;
    }
    public boolean inBounds(int rowsNum, int columnsNum){
        if(rowsNum >= 0 && rowsNum < this.rowsNum) {
            if (columnsNum >= 0 && columnsNum < this.columnsNum) {
                return true;
            }
        }

        return false;
    }
    private void setUpEmptyBoard(){
        boolean answer = true;
        for(int i = 0; i < rowsNum; i++){
            for(int j = 0; j < columnsNum; j++){
                if(answer){
                    squares[i][j] = new BoardSquare("purple");
                } else{
                    squares[i][j] = new BoardSquare("white");
                }
                answer = !answer;
            }

        }
    }
    public BoardSquare findRandomEmptySpace(){
        int randomNumOfRow = (int)(Math.random() * rowsNum);
        int randomNumOfColumn = (int)(Math.random() * columnsNum);
        while (!squares[randomNumOfRow][randomNumOfColumn].isEmptySpace()){
            randomNumOfRow = (int)(Math.random() * rowsNum);
            randomNumOfColumn = (int)(Math.random() * columnsNum);
        }
        return squares[randomNumOfRow][randomNumOfColumn];

    }
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }

}
