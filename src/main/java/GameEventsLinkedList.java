/**
 * <h1>Lab6</h1>
 * <h2>CISC181040L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * <p>
 * The Lab6 is going to be a practice of using limked list, which is going to be very different from Array list.
 * this lab will also include a set of removing, adding, and Traversing practices. As usual a couple
 * of setters and getters and constructors for each class will be practiced.
 * * @author  Khadija Mohammadi
 * @since 2023-04-24
 */
public class GameEventsLinkedList {
    private GameEventNode head;
    private int size;
    public GameEventsLinkedList(){
        this.head = null;
        this.size = 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void add(GameEventNode node){
        if(head == null){
            head = node;
        } else{
            GameEventNode current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(node);
        }
        size++;
    }
    public GameEvent remove(GameEventNode node){
        GameEvent event = null;
        if(head == null){
            return null;
        }
        if (head == node) {
            head = head.getNext();
            event = node.getGameState();
            node.setNext(null);
            size--;
        } else {
            GameEventNode current = head;
            while (current.getNext() != null && current.getNext() != node) {
                current = current.getNext();
            }
            if (current.getNext() == node) {
                current.setNext(node.getNext());
                event = node.getGameState();
                node.setNext(null);
                size--;
            }
        }
        return event;
    }
    public GameEventsLinkedList extract(String eventType) {
        GameEventsLinkedList extractedList = new GameEventsLinkedList();
        GameEventNode current = head;
        while (current != null) {
            if (current.getGameState().getEventType().equals(eventType)) {
                extractedList.add(new GameEventNode(current.getGameState()));
            }
            current = current.getNext();
        }
        return extractedList;
    }
    public void display() {
        GameEventNode current = head;
        while (current != null) {
            System.out.println(current.getGameState().getEventDetails());
            current = current.getNext();
        }
    }

    public int getSize() {
        return size;
    }

    public GameEventNode getHead() {
        return head;
    }

    public GameEventNode getNodeAtIndex(int i) {
        GameEventNode current = head;
        int counter = 0;
        while (current != null) {
            System.out.println(current.getGameState().getEventDetails());
            if(counter == i){
                return current;
            }
            current = current.getNext();

            counter++;
        }
        return null;
    }
}
