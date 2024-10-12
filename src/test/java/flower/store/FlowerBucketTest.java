package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Random;

public class FlowerBucketTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 1000;
    private static final int MAX_PRICE = 100;

    private FlowerBucket flowerBucket;

    @BeforeEach
    public void init() {
        flowerBucket = new FlowerBucket();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flower = new Flower();
        flower.setPrice(price);
        FlowerPack flowerPack = new FlowerPack(flower, quantity);
        flowerBucket.add(flowerPack);
        Assertions.assertEquals(price * quantity, flowerBucket.getPrice());
    }

    @Test
    public void testEmptyBucketPrice() {
        Assertions.assertEquals(0.0, flowerBucket.getPrice());
    }

    @Test
    public void testAddFlowerPack() {
        Flower flower = new Flower();
        flower.setPrice(10);
        FlowerPack flowerPack = new FlowerPack(flower, 5);
        flowerBucket.add(flowerPack);
        
        Assertions.assertEquals(1, flowerBucket.getFlowerPacks().size());
        Assertions.assertEquals(flowerPack, flowerBucket.getFlowerPacks().get(0));
    }

    @Test
    public void testGetFlowerPacks() {
        Flower flower1 = new Flower();
        flower1.setPrice(10);
        FlowerPack flowerPack1 = new FlowerPack(flower1, 2);
        flowerBucket.add(flowerPack1);
        
        Flower flower2 = new Flower();
        flower2.setPrice(15);
        FlowerPack flowerPack2 = new FlowerPack(flower2, 3);
        flowerBucket.add(flowerPack2);
        
        Assertions.assertEquals(2, flowerBucket.getFlowerPacks().size());
        Assertions.assertTrue(flowerBucket.getFlowerPacks().contains(flowerPack1));
        Assertions.assertTrue(flowerBucket.getFlowerPacks().contains(flowerPack2));
    }
}
