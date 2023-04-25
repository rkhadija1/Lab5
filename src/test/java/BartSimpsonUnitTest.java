import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class BartSimpsonUnitTest {
    @Test
    public void testingBartSimpsonUnitNoParamterConstructor() {
        System.out.println("Creating Bart Simpson  with 0 parameter constructor"); BartSimpsonUnit bS = new BartSimpsonUnit();
        System.out.println("-- Testing Symbol");
        assertEquals('B', bS.getSymbol());
        assertEquals("BartSimpson", bS.getName());
        assertEquals(100.0, bS.getHealth());
        assertEquals(0, bS.getNumTimesSpawned());
        assertTrue(bS.canDistract());
        assertTrue(bS.canRecruit());

    }
    public void testingBartSimpsonUnitWithParamterConstructor() {
        System.out.println("Creating Bart Simpson  with 0 parameter constructor");
        BartSimpsonUnit bS = new BartSimpsonUnit();
        System.out.println("-- Testing Symbol");
        assertEquals(0.0, bS.getHealthModifier());
        assertEquals(25.0, bS.getDamage());
        assertEquals(0.0, bS.getDamageModifier());
        assertEquals(0, bS.getLuck());
        assertEquals(5, bS.getxCor());
        assertEquals(5, bS.getyCor());
        assertEquals(1, bS.getMovement());
        assertEquals(0, bS.getMovementModifier());
        bS.setSymbol('L');
        assertEquals('L', bS.getSymbol());
        bS.setDamageModifier(4.0);
        assertEquals(4.0, bS.getDamageModifier());
        bS.setRecruit(true);
        assertTrue(bS.canRecruit());
        bS.setDistract(true);
        assertTrue(bS.canDistract());
        bS.setDistract(false);
        assertFalse(bS.canDistract());

    }
    @Test
    public void test_spawn() {
        System.out.println("Testing spawn");
        // create a BartSimpsonUnit and call its spawn metho
        BartSimpsonUnit bart = new BartSimpsonUnit();
        // bart should be able to spawn
        assertTrue(bart.canSpawn());
        // bart spawns
        BartSimpsonUnit lilBart = bart.spawn();
        // Number of times piece has spawned should be increased  assertEquals(1, bart.getNumTimesSpawned());
// Now that max time number of spawns reached - it
// shouldn't be able to spawn anymore
        assertFalse(bart.canSpawn());

    }


}
