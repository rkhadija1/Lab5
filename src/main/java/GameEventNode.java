
class GameEvent {
    /** This class creates a game event
     * @author TaraLennon
     * @verison 1
     */
    private int playerNumber;
    //unique ID for player
    private String eventType;
    //tag for different event categories
    private String eventDetails;
    //description of the game event


    public GameEvent(int playerNumber, String eventType, String eventDetails) {
        // a three parameter constructor
        this.playerNumber = playerNumber;
        this.eventType = eventType;
        this.eventDetails = eventDetails;
    }

    /**
     * Gets the player number
     * @return integer representing player number
     */
    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * Sets the player number
     * @param playerNumber integer representing player number
     */
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }
    /**
     * Gets the event type
     * @return String representing the event type
     */
    public String getEventType() {
        return eventType;
    }
    /**
     * Sets the event type
     * @param eventType String representing the event type
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    /**
     * Gets the event details
     * @return String representing the event details
     */
    public String getEventDetails() {
        return eventDetails;
    }
    /**
     * Sets the event details
     * @param eventDetails String representing the event details
     */
    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }
}

class GameEventNode {
    /** This class creates a game event node
     * @author TaraLennon
     * @verison 1
     */
    private GameEvent gameState;
    //stores specific game event
    private GameEventNode next;
    //stores next game event node


    public GameEventNode(GameEvent gameState) {
        //one parameter constructor
        this.gameState = gameState;
        next = null;
    }
    /**
     * Gets the game state
     * @return GameEvent representing the game state
     */
    public GameEvent getGameState() {
        return gameState;
    }
    /**
     * Sets the game state
     * @param gameState GameEvent representing the game state
     */
    public void setGameState(GameEvent gameState) {
        this.gameState = gameState;
    }
    /**
     * Gets the next field
     * @return GameEventNode representing the next node
     */
    public GameEventNode getNext() {
        return next;
    }
    /**
     * Sets the next field
     * @param next GameEventNode representing the next node
     */
    public void setNext(GameEventNode next) {
        this.next = next;
    }
}

public class GameEventsLinkedList {
    /** This class creates a game events linked list
     * @author TaraLennon
     * @verison 1
     */
    private GameEventNode head;
    //represents the first game event
    private int size;
    //stores the size of the linked list

    public GameEventsLinkedList() {
        //0 parameter constructor, creates an empty linked list
        head = null;
        size = 0;
    }
    /**
     * Gets the size of the linked list
     * @return int representing the size of the linked list
     */
    public int getSize() {
        return size;
    }
    /**
     * Gets the head of the linked list
     * @return GameEventNode representing the head of the list
     */
    public GameEventNode getHead() {
        return head;
    }
    /**
     * Returns whether a list is empty or not
     * @return boolean representing whether a list is empty or not
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Adds a GameEventNode to a linked list
     * @param event GameEventNode representing the next event in a linked list
     */
    public void add(GameEventNode event) {
        if (this.head == null) {
            //adds the event to the top of the list if the list is empty
            this.head = event;
            GameEventNode current = this.head;
            while (!(current == null)) {
                this.size = this.size + 1;
                current = current.getNext();
            }
        }
        else {
            //branches off if list is not empty
            GameEventNode current = this.head;
            while (!(current == null)) {
                if (current.getNext() == null) {
                    //adds event if the next field of current is null
                    current.setNext(event);
                    current = current.getNext();
                    while (!(current == null)) {
                        this.size = this.size + 1;
                        current = current.getNext();
                    }
                }
                else {
                    //branches off if the next field of current is not null, and gets the next field
                    current = current.getNext();
                }
            }

        }




    }
    /**
     * Removes a GameEventNode from a linked list
     * @param event GameEventNode to be removed
     * @return GameEvent of the GameEvent node that is being returned, or
     * if nothing is being removed, then the GameEventNode of the event the method's argument
     */
    public GameEvent remove (GameEventNode event){
        GameEventNode current = this.head;
        while (!(current == null)){
            if (current == event){
                //removes the event if the current GameEventNode matches the method's argument
                GameEventNode nodeToRemove = current;
                this.head = current.getNext();
                size = size - 1;
                return nodeToRemove.getGameState();

            }
            else if (current.getNext() == event){
                //removes the event if the current's next field matches the method's argument
                GameEventNode nodeToRemove = current.getNext();
                current.setNext(nodeToRemove.getNext());
                this.size = this.size - 1;
                return nodeToRemove.getGameState();
            }
            //gets the next field if nothing matched the argument
            current = current.getNext();
        }
        //returns the argument's game state if nothing is being removed
        return event.getGameState();
    }
    /**
     * Extracts a new list from a linked list of a certain event type
     * @param _eventType representing the event type to be extracted
     * @return new GameEventsLinkedList of the extracted nodes
     */
    public GameEventsLinkedList extract (String _eventType){
        GameEventNode current = this.head;
        //creating empty new list
        GameEventsLinkedList newList = new GameEventsLinkedList();
        while (!(current == null)){
            if (current.getGameState().getEventType().equals(_eventType)){
                //branches off if current's event type equals the event type to be extracted & adds to new list
                GameEventNode addNode = new GameEventNode(current.getGameState());
                newList.add(addNode);
            }
            //gets the next node if nothing matched
            current = current.getNext();
        }
        return newList;

        }


    /**
     * navigates the nodes of the list and prints each node's event details
     */
    public void display (){
        GameEventNode current = this.head;
        while (!(current == null)) {
            System.out.println(current.getGameState().getEventDetails());
            current = current.getNext();
        }
    }

    public static void main (String args []){
        System.out.println("main");
    }


}
