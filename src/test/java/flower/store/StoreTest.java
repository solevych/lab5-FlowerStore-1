package flower.store;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;


public class StoreTest {
    private Store store;

    @BeforeEach
    public void init() {
        store = new Store();
    }

    @Test
    public void testAddFlowerPack() {
        Flower flower = new Flower();
        flower.setFlowerType(FlowerType.Rose);
        flower.setColor(FlowerColor.RED);
        flower.setPrice(10.0);
        
        FlowerPack flowerPack = new FlowerPack(flower, 5);
        store.addFlowerPack(flowerPack);
        
        List<FlowerPack> allFlowerPacks = store.getFlowerPacks();
        Assertions.assertEquals(1, allFlowerPacks.size());
        Assertions.assertEquals(flowerPack, allFlowerPacks.get(0));
    }

    @Test
    public void testSearchByTypeAndColor() {
        Flower flower1 = new Flower();
        flower1.setFlowerType(FlowerType.Rose);
        flower1.setColor(FlowerColor.RED); // Set color to RED
        flower1.setPrice(10.0);

        Flower flower2 = new Flower();
        flower2.setFlowerType(FlowerType.Tulip);
        flower2.setColor(FlowerColor.YELLOW); // Set color to YELLOW
        flower2.setPrice(15.0);

        store.addFlowerPack(new FlowerPack(flower1, 5));
        store.addFlowerPack(new FlowerPack(flower2, 10));

        // Search for red roses
        List<FlowerPack> result = store.search(FlowerType.Rose, FlowerColor.RED);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    public void testSearchByTypeOnly() {
        Flower flower1 = new Flower();
        flower1.setFlowerType(FlowerType.Rose);
        flower1.setColor(FlowerColor.RED);
        flower1.setPrice(10.0);
        
        Flower flower2 = new Flower();
        flower2.setFlowerType(FlowerType.Tulip);
        flower2.setColor(FlowerColor.YELLOW);
        flower2.setPrice(15.0);
        
        store.addFlowerPack(new FlowerPack(flower1, 5));
        store.addFlowerPack(new FlowerPack(flower2, 10));

        // Search for roses
        List<FlowerPack> result = store.search(FlowerType.Rose, null);
        Assertions.assertEquals(1, result.size());
    
    }

    @Test
    public void testSearchByColorOnly() {
        Flower flower1 = new Flower();
        flower1.setFlowerType(FlowerType.Rose);
        flower1.setColor(FlowerColor.RED);
        flower1.setPrice(10.0);
        
        Flower flower2 = new Flower();
        flower2.setFlowerType(FlowerType.Tulip);
        flower2.setColor(FlowerColor.YELLOW);
        flower2.setPrice(15.0);
        
        store.addFlowerPack(new FlowerPack(flower1, 5));
        store.addFlowerPack(new FlowerPack(flower2, 10));

        List<FlowerPack> result = store.search(null, FlowerColor.YELLOW);
        Assertions.assertTrue(flower2.equal(result.get(0).getFlower()));
    }

    @Test
    public void testSearchNoResults() {
        Flower flower = new Flower();
        flower.setFlowerType(FlowerType.Rose);
        flower.setColor(FlowerColor.RED);
        flower.setPrice(10.0);
        
        store.addFlowerPack(new FlowerPack(flower, 5));

        // Search for non-existing flower type
        List<FlowerPack> result = store.search(FlowerType.Tulip, FlowerColor.RED);
        Assertions.assertEquals(0, result.size());
    }
}