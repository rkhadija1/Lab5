/** This class interacts with the View and the Game Model
 * to allow players to play our game.
 * @author TaraLennon & Khadija Mohammadi
 * @verison 1
 */

import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    Game game;
    //the game
    TextView textView;
    //an instance of textView
    GameEventsLinkedList linkedList;
    //a linked list of game events


    public Controller (){
        //0 parameter constructor
        game = setUpGameModel();
        this.textView = new TextView();
        textView.updateView(game);
        linkedList = new GameEventsLinkedList();

    }

    /**
     * Sets up the game model
     * @return Game representing the game being played
     */

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

    /**
     * Carries out the action a player is trying to do
     * @param rowIndexFrom row index of from square
     * @param colIndexFrom col index of from square
     * @param rowIndexTo row index of to square
     * @param colIndexTo col index of to square
     * @param action char representing the action
     */

    public void carryOutAction (int rowIndexFrom, int colIndexFrom, int rowIndexTo, int colIndexTo, char action){
        if (action == 'A'){
            ActionAttack attack = new ActionAttack(game, rowIndexFrom, colIndexFrom, rowIndexTo, colIndexTo);
            attack.performAction();
            GameEvent gameEvent = new GameEvent(game.getCurrentPlayer().getPlayerNumber(), "Attack", attack.toString());
            GameEventNode node = new GameEventNode(gameEvent);
            linkedList.push(node);
        }
        else if (action == 'S'){
            ActionSpawn spawn = new ActionSpawn(game, rowIndexFrom, colIndexFrom, rowIndexTo, colIndexTo);
            spawn.performAction();
            GameEvent gameEvent = new GameEvent(game.getCurrentPlayer().getPlayerNumber(), "Spawn", spawn.toString());
            GameEventNode node = new GameEventNode(gameEvent);
            linkedList.push(node);

        }
        else if (action == 'R'){
            ActionRecruit recruit = new ActionRecruit(game, rowIndexFrom, colIndexFrom, rowIndexTo, colIndexTo);
            recruit.performAction();
            GameEvent gameEvent = new GameEvent(game.getCurrentPlayer().getPlayerNumber(), "Recruit", recruit.toString());
            GameEventNode node = new GameEventNode(gameEvent);
            linkedList.push(node);

        }
        else if (action == 'M'){
            ActionMove move = new ActionMove(game, rowIndexFrom, colIndexFrom, rowIndexTo, colIndexTo);
            move.performAction();
            GameEvent gameEvent = new GameEvent(game.getCurrentPlayer().getPlayerNumber(), "Move", move.toString());
            GameEventNode node = new GameEventNode(gameEvent);
            linkedList.push(node);

        }


    }

    /**
     * Method that plays the game
     */

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
        GameEventNode winningMove = linkedList.pop();
        System.out.println("Winning move: " + winningMove.getGameState().getEventDetails());

        ArrayList<GameEventsLinkedList> arrayLinkedList = new ArrayList<GameEventsLinkedList>();
        GameEventsLinkedList attackList = linkedList.pop("Attack");
        arrayLinkedList.add(attackList);
        GameEventsLinkedList moveList = linkedList.pop("Move");
        arrayLinkedList.add(moveList);
        GameEventsLinkedList recruitList = linkedList.pop("Recruit");
        arrayLinkedList.add(recruitList);
        GameEventsLinkedList spawnList = linkedList.pop("Spawn");
        arrayLinkedList.add(spawnList);

        Collections.sort(arrayLinkedList);
        for (GameEventsLinkedList ll: arrayLinkedList){
            System.out.println(ll.getHead().getGameState().getEventType() + ll.getSize());
        }


        textView.printEndOfGameMessage(game);

        if (game.isAWinner()) {
            System.out.println(game.getWinner().getTeam() + " won the game.");
        }
    }

    /**
     * Main method that creates an instance of the controller to play the game
     */

    public static void main (String args[]){
        Controller controller = new Controller();
        controller.playGame();
    }


}
