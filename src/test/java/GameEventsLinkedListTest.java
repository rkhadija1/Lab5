import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
public class GameEventsLinkedListTest {
    private GameEventsLinkedList list;

    @Test
    public void setUp() {
        list = new GameEventsLinkedList();
    }

    @Test
    public void testIsEmptyEmptyList() {
        setUp();
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptyNonEmptyList() {
        setUp();
        list.add(new GameEventNode(new GameEvent(1, "type", "details")));
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void testAdd() {
        GameEventNode node = new GameEventNode(new GameEvent(1, "type", "details"));
        setUp();
        list.add(node);
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(node, list.getHead());
        Assertions.assertEquals(node, list.getNodeAtIndex(0));
    }

    @Test
    public void testRemoveEmptyList() {
        setUp();
        GameEventNode node = new GameEventNode(new GameEvent(1, "type", "details"));
        Assertions.assertNull(list.remove(node));
        Assertions.assertEquals(0, list.getSize());
        Assertions.assertTrue(list.isEmpty());
        Assertions.assertNull(list.getHead());
    }

    @Test
    public void testRemoveNonEmptyList() {
        setUp();
        GameEventNode node1 = new GameEventNode(new GameEvent(1, "type", "details1"));
        GameEventNode node2 = new GameEventNode(new GameEvent(2, "type", "details2"));
        GameEventNode node3 = new GameEventNode(new GameEvent(3, "type", "details3"));
        list.add(node1);
        list.add(node2);
        list.add(node3);
        Assertions.assertEquals(node2.getGameState(), list.remove(node2));
        Assertions.assertEquals(2, list.getSize());
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(node1, list.getHead());
        Assertions.assertEquals(node3, list.getNodeAtIndex(1));
    }

    @Test
    public void testExtractEmptyList() {
        setUp();
        GameEventsLinkedList extractedList = list.extract("type");
        Assertions.assertEquals(0, extractedList.getSize());
        Assertions.assertTrue(extractedList.isEmpty());
        Assertions.assertNull(extractedList.getHead());
    }

    @Test
    public void testExtractNonEmptyList() {
        setUp();
        GameEventNode node1 = new GameEventNode(new GameEvent(1, "type1", "details1"));
        GameEventNode node2 = new GameEventNode(new GameEvent(2, "type2", "details2"));
        GameEventNode node3 = new GameEventNode(new GameEvent(3, "type1", "details3"));
        list.add(node1);
        list.add(node2);
        list.add(node3);
        GameEventsLinkedList extractedList = list.extract("type1");
        Assertions.assertEquals(2, extractedList.getSize());
        Assertions.assertFalse(extractedList.isEmpty());
        Assertions.assertEquals(node1.getGameState(), extractedList.getHead().getGameState());
        Assertions.assertEquals(node3.getGameState(), extractedList.getNodeAtIndex(1).getGameState());
    }
}
