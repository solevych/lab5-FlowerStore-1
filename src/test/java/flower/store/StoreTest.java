package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * Tests for the Store class that manages flower packs.
 */
public class StoreTest {
    // Constants to avoid magic numbers
    private static final double ROSE_PRICE = 10.0;
    private static final double TULIP_PRICE = 15.0;
    private static final int ROSE_QUANTITY = 5;
    private static final int TULIP_QUANTITY = 10;

    private Store store;

    /**
     * Initializes the store instance before each test.
     */
    @BeforeEach
    public void init() {
        store = new Store();
    }

    /**
     * Tests adding a flower pack to the store.
     */
    @Test
    public void testAddFlowerPack() {
        Flower flower = new Flower();
        flower.setFlowerType(FlowerType.Rose);
        flower.setColor(FlowerColor.RED);
        flower.setPrice(ROSE_PRICE);

        FlowerPack flowerPack = new FlowerPack(flower, ROSE_QUANTITY);
        store.addFlowerPack(flowerPack);

        List<FlowerPack> allFlowerPacks = store.getFlowerPacks();
        Assertions.assertEquals(1, allFlowerPacks.size());
        Assertions.assertEquals(flowerPack, allFlowerPacks.get(0));
    }

    /**
     * Tests searching by flower type and color.
     */
    @Test
    public void testSearchByTypeAndColor() {
        Flower flowerRedRose = new Flower();
        flowerRedRose.setFlowerType(FlowerType.Rose);
        flowerRedRose.setColor(FlowerColor.RED);
        flowerRedRose.setPrice(ROSE_PRICE);

        Flower flowerYellowTulip = new Flower();
        flowerYellowTulip.setFlowerType(FlowerType.Tulip);
        flowerYellowTulip.setColor(FlowerColor.YELLOW);
        flowerYellowTulip.setPrice(TULIP_PRICE);

        store.addFlowerPack(new FlowerPack(flowerRedRose, ROSE_QUANTITY));
        store.addFlowerPack(new FlowerPack(flowerYellowTulip, TULIP_QUANTITY));

        // Search for red roses
        List<FlowerPack> result = store.search(FlowerType.Rose, FlowerColor.RED);
        Assertions.assertEquals(1, result.size());
    }

    /**
     * Tests searching by flower type only.
     */
    @Test
    public void testSearchByTypeOnly() {
        Flower flowerRedRose = new Flower();
        flowerRedRose.setFlowerType(FlowerType.Rose);
        flowerRedRose.setColor(FlowerColor.RED);
        flowerRedRose.setPrice(ROSE_PRICE);

        Flower flowerYellowTulip = new Flower();
        flowerYellowTulip.setFlowerType(FlowerType.Tulip);
        flowerYellowTulip.setColor(FlowerColor.YELLOW);
        flowerYellowTulip.setPrice(TULIP_PRICE);

        store.addFlowerPack(new FlowerPack(flowerRedRose, ROSE_QUANTITY));
        store.addFlowerPack(new FlowerPack(flowerYellowTulip, TULIP_QUANTITY));

        // Search for roses
        List<FlowerPack> result = store.search(FlowerType.Rose, null);
        Assertions.assertEquals(1, result.size());
    }

    /**
     * Tests searching by color only.
     */
    @Test
    public void testSearchByColorOnly() {
        Flower flowerRedRose = new Flower();
        flowerRedRose.setFlowerType(FlowerType.Rose);
        flowerRedRose.setColor(FlowerColor.RED);
        flowerRedRose.setPrice(ROSE_PRICE);

        Flower flowerYellowTulip = new Flower();
        flowerYellowTulip.setFlowerType(FlowerType.Tulip);
        flowerYellowTulip.setColor(FlowerColor.YELLOW);
        flowerYellowTulip.setPrice(TULIP_PRICE);

        store.addFlowerPack(new FlowerPack(flowerRedRose, ROSE_QUANTITY));
        store.addFlowerPack(new FlowerPack(flowerYellowTulip, TULIP_QUANTITY));

        List<FlowerPack> result = store.search(null, FlowerColor.YELLOW);
        Assertions.assertTrue(flowerYellowTulip.equal(result.get(0).getFlower()));
    }

    /**
     * Tests searching for non-existing flower types.
     */
    @Test
    public void testSearchNoResults() {
        Flower flowerRedRose = new Flower();
        flowerRedRose.setFlowerType(FlowerType.Rose);
        flowerRedRose.setColor(FlowerColor.RED);
        flowerRedRose.setPrice(ROSE_PRICE);

        store.addFlowerPack(new FlowerPack(flowerRedRose, ROSE_QUANTITY));

        // Search for non-existing flower type
        List<FlowerPack> result = store.search(FlowerType.Tulip, FlowerColor.RED);
        Assertions.assertEquals(0, result.size());
    }
}

