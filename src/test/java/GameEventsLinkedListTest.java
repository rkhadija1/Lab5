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
        linkedList.add(eventNode);
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
        linkedList.add(eventNode);
        assertEquals(1, linkedList.getSize());
        assertEquals(eventNode, linkedList.getHead());
        GameEvent gameEvent1 = new GameEvent(2, "dive", "player dived");
        GameEventNode eventNode1 = new GameEventNode(gameEvent1);
        //adding a second eventNode to the linkedList
        linkedList.add(eventNode1);
        assertEquals(2, linkedList.getSize());
        assertEquals(eventNode, linkedList.getHead());
        assertEquals(eventNode1, linkedList.getHead().getNext());
        GameEventNode eventNode3 = new GameEventNode(gameEvent);
        GameEventNode eventNode4 = new GameEventNode(gameEvent1);
        eventNode3.setNext(eventNode4);
        linkedList.add(eventNode3);
        //adding an eventNode to the list that has a next field with another node
        assertEquals(4, linkedList.getSize());
        assertEquals(eventNode3, linkedList.getHead().getNext().getNext());
        assertEquals(eventNode, linkedList.getHead());
    }
    /**
     * Tests the remove method
     */
    @Test
    public void testingRemove(){
        GameEventsLinkedList linkedList = new GameEventsLinkedList();
        GameEvent gameEvent = new GameEvent(1, "jump", "player jumped");
        GameEventNode eventNode = new GameEventNode(gameEvent);
        linkedList.add(eventNode);
        assertEquals(1, linkedList.getSize());
        linkedList.remove(eventNode);
        //removes node from linked list, size should be 0
        assertEquals(0, linkedList.getSize());
        assertEquals(eventNode.getGameState(), linkedList.remove(eventNode));
        assertEquals(null, linkedList.getHead());
        linkedList.add(eventNode);
        GameEventNode eventNode1 = new GameEventNode(gameEvent);
        GameEvent gameEvent1 = new GameEvent(2, "dive", "player dived");
        GameEventNode eventNode2 = new GameEventNode(gameEvent1);
        linkedList.add(eventNode1);
        linkedList.add(eventNode2);
        //three nodes are now in list
        assertEquals(3, linkedList.getSize());
        //removes the second node
        linkedList.remove(eventNode1);
        assertEquals(2, linkedList.getSize());
        assertEquals(eventNode, linkedList.getHead());
        assertEquals(eventNode2, linkedList.getHead().getNext());
        //removes the first node
        linkedList.remove(eventNode);
        assertEquals(1, linkedList.getSize());
        assertEquals(eventNode2, linkedList.getHead());
        //attempts to remove a node value that is not in list, nothing about list should change
        linkedList.remove(eventNode);
        assertEquals(1, linkedList.getSize());
        assertEquals(eventNode.getGameState(), linkedList.remove(eventNode));
        //testing on empty list
        GameEventsLinkedList emptyList = new GameEventsLinkedList();
        emptyList.remove(eventNode);
        assertEquals(eventNode.getGameState(), emptyList.remove(eventNode));
        assertEquals(0, emptyList.getSize());

    }
    /**
     * Tests the extract method
     */
    @Test
    public void testingExtract(){
       GameEventsLinkedList linkedList1 = new GameEventsLinkedList();
       GameEventsLinkedList newList = linkedList1.extract("jump");
       //new list should be empty because origianl list is empty
       assertEquals(0, newList.getSize());
       assertTrue(newList.isEmpty());
       GameEvent gameEvent = new GameEvent(1, "jump", "player jumped");
       GameEventNode eventNode5 = new GameEventNode(gameEvent);
       linkedList1.add(eventNode5);
       //attempts to extract game event that is not in list, new list should be empty
       assertEquals(0, linkedList1.extract("dance").getSize());
       //extracts game event that IS in list, new list has one
       assertEquals(1, linkedList1.extract("jump").getSize());
       assertFalse(linkedList1.extract("jump").isEmpty());
       assertEquals(eventNode5.getGameState(), linkedList1.extract("jump").getHead().getGameState());
       GameEvent gameEvent1 = new GameEvent(1, "jump", "player jumped");
       GameEventNode eventNode6 = new GameEventNode(gameEvent1);
       linkedList1.add(eventNode6);
       //linked list now has two nodes with the same game event
       assertEquals(2, linkedList1.extract("jump").getSize());
       assertEquals(eventNode6.getGameState(), linkedList1.extract("jump").getHead().getNext().getGameState());
       //attempts to extract game event that is not in list, new list should be empty
       assertEquals(0, linkedList1.extract("dance").getSize());
       GameEvent gameEvent2 = new GameEvent(1, "swim", "player swam");
       GameEventNode eventNode7 = new GameEventNode(gameEvent2);
       linkedList1.add(eventNode7);
       //new node has been added but with different game event
       assertEquals(2, linkedList1.extract("jump").getSize());
       assertEquals(1, linkedList1.extract("swim").getSize());
       assertEquals(eventNode7.getGameState(), linkedList1.extract("swim").getHead().getGameState());













    }



}
