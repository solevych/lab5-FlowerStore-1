package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TypesTest {
    private Rose rose;
    private Tulip tulip;
    private Chamomile chamomile;

    @BeforeEach
    public void init() {
        rose = new Rose();
        tulip = new Tulip();
        chamomile = new Chamomile();
    }

    @Test
    public void testRoseDefaultFlowerType() {
        Assertions.assertEquals(FlowerType.Rose, rose.getFlowerType());
    }

    @Test
    public void testTulipDefaultFlowerType() {
        Assertions.assertEquals(FlowerType.Tulip, tulip.getFlowerType());
    }

    @Test
    public void testChamomileDefaultFlowerType() {
        Assertions.assertEquals(FlowerType.Chamomile, chamomile.getFlowerType());
    }

}