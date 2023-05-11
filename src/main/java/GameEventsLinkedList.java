public class GameEventsLinkedList implements Comparable<GameEventsLinkedList> {
    /**
     * This class creates a game events linked list
     *
     * @author TaraLennon & Khadija Mohammadi
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

    public int compareTo (GameEventsLinkedList o){
        if (size == o.size){
            return 0;
        }
        else if (size > o.size){
            return 1;
        }
        else {
            return -1;
        }
    }

    /**
     * Gets the size of the linked list
     *
     * @return int representing the size of the linked list
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets the head of the linked list
     *
     * @return GameEventNode representing the head of the list
     */
    public GameEventNode getHead() {
        return head;
    }

    /**
     * Returns whether a list is empty or not
     *
     * @return boolean representing whether a list is empty or not
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds a GameEventNode to the front of the linked list
     * @param event GameEventNode representing the event to be added to the front of the linked list
     */
    public void push(GameEventNode event) {
        if (this.head == null) {
            this.head = event;
            this.size = this.size + 1;
        }

        else {
            GameEventNode tempNode = this.head;
            this.head = event;
            this.size = this.size + 1;
            event.setNext(tempNode);
        }

    }

    /**
     * Removes the first GameEventNode from a linked list
     * @return GameEventNode that is being removed
     */
    public GameEventNode pop() {
        GameEventNode returnedNode = null;
        if (head != null) {
            returnedNode = head;
            this.head = head.getNext();
            size = size - 1;
        }
        return returnedNode;
    }

    /**
     * Extracts a new list from a linked list of a certain event type and
     * removes the events of the certain event type from the original list
     * @param _eventType representing the event type to be extracted
     * @return new GameEventsLinkedList of the extracted nodes
     */
    public GameEventsLinkedList pop(String _eventType) {
        GameEventsLinkedList newList = new GameEventsLinkedList();

        if (head != null) {
            GameEventNode current = this.head;
            GameEventNode prev = null;
            while (current != null) {
                if (current.getGameState().getEventType().equals(_eventType)) {
                    if (prev == null) {
                        GameEventNode storedObject = new GameEventNode(current.getGameState());
                        head = current.getNext();
                        newList.push(storedObject);
                        size = size - 1;
                    } else if (prev != null) {
                        GameEventNode storedObject = new GameEventNode(current.getGameState());
                        prev.setNext(current.getNext());
                        newList.push(storedObject);
                        size = size - 1;
                    }
                }
                prev = current;
                current = current.getNext();

            }
        }

        return newList;


    }

    /**
     * navigates the nodes of the list and prints each node's event details
     */
    public void display() {
        GameEventNode current = this.head;
        while (!(current == null)) {
            System.out.println(current.getGameState().getEventDetails());
            current = current.getNext();
        }
    }

    public static void main(String args[]) {
        System.out.println("main");
    }


}
