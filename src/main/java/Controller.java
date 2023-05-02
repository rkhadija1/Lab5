/** This class interacts with the View and the Game Model
 * to allow players to play our game.
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */

import java.util.ArrayList;
public class Controller {
    Game game;
    TextView textView;

    public Controller (){
        game = setUpGameModel();
        this.textView = new TextView();
        textView.updateView(game);

    }

    public Game setUpGameModel(){
        // Create 4 pieces for team A
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamA = new ArrayList<Unit>();


        BartSimpsonUnit bs = new BartSimpsonUnit();
        bs.setTeamColor("Blu");


        TomJerryUnit tj = new TomJerryUnit();
        tj.setTeamColor("Blu");


        piecesTeamA.add(bs);
        piecesTeamA.add(tj);


        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);
        Player playerOne = new Player(1, true, teamA);


        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamB = new ArrayList<Unit>();


        BartSimpsonUnit bs2 = new BartSimpsonUnit();
        bs2.setTeamColor("Red");


        TomJerryUnit tj2 = new TomJerryUnit();
        tj2.setTeamColor("Red");


        piecesTeamB.add(bs2);
        piecesTeamB.add(tj2);


        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);
        Player playerTwo = new Player(2, false, teamB);


        // Create an instance of the game
        return new Game(8, 8, playerOne, playerTwo);
    }

    public void carryOutAction (int rowIndexFrom, int colIndexFrom, int rowIndexTo, int colIndexTo, char action){
        if (action == 'A'){
            ActionAttack attack = new ActionAttack(game, rowIndexFrom, colIndexFrom, rowIndexTo, colIndexTo);
            attack.performAction();
        }
        else if (action == 'S'){
            ActionSpawn spawn = new ActionSpawn(game, rowIndexFrom, colIndexFrom, rowIndexTo, colIndexTo);
            spawn.performAction();

        }
        else if (action == 'R'){
            ActionRecruit recruit = new ActionRecruit(game, rowIndexFrom, colIndexFrom, rowIndexTo, colIndexTo);
            recruit.performAction();

        }
        else if (action == 'M'){
            ActionMove move = new ActionMove(game, rowIndexFrom, colIndexFrom, rowIndexTo, colIndexTo);
            move.performAction();

        }
    }

    public void playGame(){
        textView.getNextPlayersAction(game);
        while (!(Rules.checkValidAction(game, textView.getRowIndexFromSquare(), textView.getColIndexFromSquare(), textView.getRowIndexToSquare(), textView.getColIndexToSquare(), textView.getActionType()))){
            textView.getNextPlayersAction(game);
        }
        carryOutAction(textView.getRowIndexFromSquare(), textView.getColIndexFromSquare(), textView.getRowIndexToSquare(), textView.getColIndexToSquare(), textView.getActionType());
        System.out.println(game);
        while (!game.isGameEnded()){
            textView.getNextPlayersAction(game);
            while (!(Rules.checkValidAction(game, textView.getRowIndexFromSquare(), textView.getColIndexFromSquare(), textView.getRowIndexToSquare(), textView.getColIndexToSquare(), textView.getActionType()))){
                textView.getNextPlayersAction(game);
            }
            carryOutAction(textView.getRowIndexFromSquare(), textView.getColIndexFromSquare(), textView.getRowIndexToSquare(), textView.getColIndexToSquare(), textView.getActionType());
            System.out.println(game);
        }
        textView.printEndOfGameMessage(game);
        if (game.isAWinner()) {
            System.out.println(game.getWinner().getTeam() + " won the game.");
        }
    }

    public static void main (String args[]){
        Controller controller = new Controller();
        controller.playGame();
    }


}