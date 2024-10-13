package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Tests for flower types including Rose, Tulip, and Chamomile.
 */

public class TypesTest {

    private Rose rose;      
    private Tulip tulip;   
    private Chamomile chamomile; 

    /**
     * Initializes the flower instances before each test.
     */
    @BeforeEach
    public void init() {
        rose = new Rose();
        tulip = new Tulip();
        chamomile = new Chamomile();
    }

    /**
     * Tests the default flower type of Rose.
     */
    @Test
    public void testRoseDefaultFlowerType() {
        Assertions.assertEquals(FlowerType.Rose, rose.getFlowerType());
    }

    // Similar test for Tulip
    @Test
    public void testTulipDefaultFlowerType() {
        Assertions.assertEquals(FlowerType.Tulip, tulip.getFlowerType());
    }

    // Similar test for Chamomile
    @Test
    public void testChamomileDefaultFlowerType() {
        Assertions.assertEquals(FlowerType.Chamomile, chamomile.getFlowerType());
    }


}