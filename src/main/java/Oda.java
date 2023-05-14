/** This class extends Tom and Jerry game.
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */
public class Oda extends TomJerryUnit{
    public Oda(){
        super(true, true, false);
        this.name = "Oda";
        this.symbol = 'O';
    }
    // the different pattern of the validMovePath method is to check if the
    // absolute difference between row and column numbers is even.
    @Override
    public boolean validMovePath(int rowNumsFrom, int columnNumsFrom, int rowNumsTo, int columnsNumsTo){
        // implement a new pattern for valid move paths
        int rowDiff = Math.abs(rowNumsFrom - rowNumsTo);
        int colDiff = Math.abs(columnNumsFrom - columnsNumsTo);
        if ((rowDiff + colDiff) % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}

