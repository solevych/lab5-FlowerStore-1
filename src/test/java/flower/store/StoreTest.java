package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class StoreTest {
    private Store store;

    // Constants to avoid magic numbers
    private static final double ROSE_PRICE = 10.0;
    private static final double TULIP_PRICE = 15.0;
    private static final int ROSE_QUANTITY = 5;
    private static final int TULIP_QUANTITY = 10;

    @BeforeEach
    public void init() {
        store = new Store();
    }

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

    @Test
    public void testSearchByTypeAndColor() {
        Flower flower1 = new Flower();
        flower1.setFlowerType(FlowerType.Rose);
        flower1.setColor(FlowerColor.RED);
        flower1.setPrice(ROSE_PRICE);

        Flower flower2 = new Flower();
        flower2.setFlowerType(FlowerType.Tulip);
        flower2.setColor(FlowerColor.YELLOW);
        flower2.setPrice(TULIP_PRICE);

        store.addFlowerPack(new FlowerPack(flower1, ROSE_QUANTITY));
        store.addFlowerPack(new FlowerPack(flower2, TULIP_QUANTITY));

        // Search for red roses
        List<FlowerPack> result = store.search(FlowerType.Rose, FlowerColor.RED);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    public void testSearchByTypeOnly() {
        Flower flower1 = new Flower();
        flower1.setFlowerType(FlowerType.Rose);
        flower1.setColor(FlowerColor.RED);
        flower1.setPrice(ROSE_PRICE);
        
        Flower flower2 = new Flower();
        flower2.setFlowerType(FlowerType.Tulip);
        flower2.setColor(FlowerColor.YELLOW);
        flower2.setPrice(TULIP_PRICE);
        
        store.addFlowerPack(new FlowerPack(flower1, ROSE_QUANTITY));
        store.addFlowerPack(new FlowerPack(flower2, TULIP_QUANTITY));

        // Search for roses
        List<FlowerPack> result = store.search(FlowerType.Rose, null);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    public void testSearchByColorOnly() {
        Flower flower1 = new Flower();
        flower1.setFlowerType(FlowerType.Rose);
        flower1.setColor(FlowerColor.RED);
        flower1.setPrice(ROSE_PRICE);
        
        Flower flower2 = new Flower();
        flower2.setFlowerType(FlowerType.Tulip);
        flower2.setColor(FlowerColor.YELLOW);
        flower2.setPrice(TULIP_PRICE);
        
        store.addFlowerPack(new FlowerPack(flower1, ROSE_QUANTITY));
        store.addFlowerPack(new FlowerPack(flower2, TULIP_QUANTITY));

        List<FlowerPack> result = store.search(null, FlowerColor.YELLOW);
        Assertions.assertTrue(flower2.equal(result.get(0).getFlower()));
    }

    @Test
    public void testSearchNoResults() {
        Flower flower = new Flower();
        flower.setFlowerType(FlowerType.Rose);
        flower.setColor(FlowerColor.RED);
        flower.setPrice(ROSE_PRICE);
        
        store.addFlowerPack(new FlowerPack(flower, ROSE_QUANTITY));

        // Search for non-existing flower type
        List<FlowerPack> result = store.search(FlowerType.Tulip, FlowerColor.RED);
        Assertions.assertEquals(0, result.size());
    }
}
