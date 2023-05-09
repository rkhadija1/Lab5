import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class GameEventsLinkedListTest {
    /** This class tests the different methods of the GameEventsLinkedList class
     * @author TaraLennon & Khadija Mohammadi
     * @verison 1
     */


    /**
     * Test the isEmpty method
     */
   @Test
    public void testingIsEmpty() {
        GameEventsLinkedList linkedList = new GameEventsLinkedList();
        assertTrue(linkedList.isEmpty());
        //returns true because the list is empty
        GameEvent gameEvent = new GameEvent(1, "jump", "player jumped");
        GameEventNode eventNode = new GameEventNode(gameEvent);
        linkedList.push(eventNode);
        assertFalse(linkedList.isEmpty());
        //returns false because the list is not empty
    }
    /**
     * Tests the add method
     */
    @Test
    public void testingAdd() {
        GameEventsLinkedList linkedList = new GameEventsLinkedList();
        GameEvent gameEvent = new GameEvent(1, "jump", "player jumped");
        GameEventNode eventNode = new GameEventNode(gameEvent);
        //adding one eventNode to the linked list
        linkedList.push(eventNode);
        assertEquals(1, linkedList.getSize());
        assertEquals(eventNode, linkedList.getHead());
        GameEvent gameEvent1 = new GameEvent(2, "dive", "player dived");
        GameEventNode eventNode1 = new GameEventNode(gameEvent1);
        //adding a second eventNode to the linkedList
        linkedList.push(eventNode1);
        assertEquals(2, linkedList.getSize());
        assertEquals(eventNode1, linkedList.getHead());
        assertEquals(eventNode, linkedList.getHead().getNext());
        GameEventNode eventNode3 = new GameEventNode(gameEvent);
        GameEventNode eventNode4 = new GameEventNode(gameEvent1);
        eventNode3.setNext(eventNode4);
        linkedList.push(eventNode3);
        //adding an eventNode to the list that has a next field with another node
        assertEquals(4, linkedList.getSize());
        assertEquals(eventNode1, linkedList.getHead().getNext().getNext());
        assertEquals(eventNode3, linkedList.getHead());
    }
    /**
     * Tests the remove method
     */
    @Test
    public void testingRemove(){
        GameEventsLinkedList linkedList = new GameEventsLinkedList();
        GameEvent gameEvent = new GameEvent(1, "jump", "player jumped");
        GameEventNode eventNode = new GameEventNode(gameEvent);
        linkedList.push(eventNode);
        assertEquals(1, linkedList.getSize());
        GameEventNode nodeRemoved = linkedList.pop();
        //removes node from linked list, size should be 0
        assertEquals(0, linkedList.getSize());
        assertEquals(eventNode, nodeRemoved);
        assertEquals(null, linkedList.getHead());
        linkedList.push(eventNode);
        GameEventNode eventNode1 = new GameEventNode(gameEvent);
        GameEvent gameEvent1 = new GameEvent(2, "dive", "player dived");
        GameEventNode eventNode2 = new GameEventNode(gameEvent1);
        linkedList.push(eventNode1);
        linkedList.push(eventNode2);
        //three nodes are now in list
        assertEquals(3, linkedList.getSize());
        linkedList.pop();
        assertEquals(2, linkedList.getSize());
        assertEquals(eventNode1, linkedList.getHead());
        assertEquals(eventNode, linkedList.getHead().getNext());
        //removes the first node
        linkedList.pop();
        assertEquals(1, linkedList.getSize());
        assertEquals(eventNode, linkedList.getHead());
        //testing on empty list
        GameEventsLinkedList emptyList = new GameEventsLinkedList();
        emptyList.pop();
        assertEquals(null, emptyList.pop());
        assertEquals(0, emptyList.getSize());

    }
    /**
     * Tests the extract method
     */
    @Test
    public void testingExtract(){
       GameEventsLinkedList linkedList1 = new GameEventsLinkedList();
       GameEventsLinkedList newList = linkedList1.pop("jump");
       //new list should be empty because original list is empty
       assertEquals(0, newList.getSize());
       assertTrue(newList.isEmpty());
       GameEvent gameEvent = new GameEvent(1, "jump", "player jumped");
       GameEventNode eventNode5 = new GameEventNode(gameEvent);
       linkedList1.push(eventNode5);
       //attempts to extract game event that is not in list, new list should be empty
       assertEquals(0, linkedList1.pop("dance").getSize());
       //extracts game event that IS in list, new list has one
        System.out.println(linkedList1.getHead());
        System.out.println(linkedList1.getSize());
        GameEventsLinkedList newList2 = linkedList1.pop("jump");
        System.out.println(linkedList1.getHead());
        System.out.println(linkedList1.getSize());
        System.out.println(newList2.getSize());
       assertEquals(1, newList2.getSize());
       assertFalse(newList2.isEmpty());
       assertTrue(linkedList1.isEmpty());
       assertEquals(eventNode5.getGameState(), newList2.getHead().getGameState());
       GameEvent gameEvent1 = new GameEvent(1, "jump", "player jumped");
       GameEventNode eventNode6 = new GameEventNode(gameEvent1);
       newList2.push(eventNode6);
       GameEventsLinkedList newList3 = newList2.pop("jump");
       //linked list now has two nodes with the same game event
       assertEquals(2, newList3.getSize());
       assertTrue(newList2.isEmpty());
       assertEquals(eventNode5.getGameState(), newList3.getHead().getGameState());
       //attempts to extract game event that is not in list, new list should be empty
       GameEventsLinkedList newList7 = newList3.pop("dance");
       assertEquals(0, newList7.getSize());
       GameEvent gameEvent2 = new GameEvent(1, "swim", "player swam");
       GameEventNode eventNode7 = new GameEventNode(gameEvent2);
       newList3.push(eventNode7);
       GameEventsLinkedList newList8 = newList3.pop("jump");
       assertEquals(2, newList8.getSize());
       assertEquals(1, newList3.getSize());
       assertEquals(eventNode7, newList3.getHead());
















    }



}
