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

    private Flower createFlower(FlowerType type, 
                                FlowerColor color, 
                                double price) {
        Flower flower = new Flower();
        flower.setFlowerType(type);
        flower.setColor(color);
        flower.setPrice(price);
        return flower;
    }

    private FlowerPack createFlowerPack(Flower flower, int quantity) {
        return new FlowerPack(flower, quantity);
    }

    /**
     * Tests adding a flower pack to the store.
     */
    @Test
    public void testAddFlowerPack() {
        Flower flower = createFlower(FlowerType.Rose, 
                                        FlowerColor.RED, 
                                        ROSE_PRICE);
        FlowerPack flowerPack = createFlowerPack(flower, ROSE_QUANTITY);
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
        store.addFlowerPack(createFlowerPack(createFlower(FlowerType.Rose, 
        FlowerColor.RED, ROSE_PRICE), ROSE_QUANTITY));
        store.addFlowerPack(createFlowerPack(createFlower(FlowerType.Tulip, 
        FlowerColor.YELLOW, TULIP_PRICE), TULIP_QUANTITY));

        List<FlowerPack> result = store.search(FlowerType.Rose, 
                                            FlowerColor.RED);
        Assertions.assertEquals(1, result.size());

        List<FlowerPack> resultColorOnly = store.search(null, 
                                                        FlowerColor.YELLOW);
        Assertions.assertTrue(createFlower(FlowerType.Tulip, 
                                            FlowerColor.YELLOW, 
        TULIP_PRICE).equal(resultColorOnly.get(0).getFlower()));

        List<FlowerPack> resultTypeOnly = store.search(FlowerType.Rose, null);
        Assertions.assertEquals(1, resultTypeOnly.size());
    }

}
