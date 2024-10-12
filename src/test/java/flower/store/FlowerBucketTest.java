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
        Flower flower = new Rose();
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
        Assertions.assertEquals(flowerPack, 
        flowerBucket.getFlowerPacks().get(0));
    }

    @Test
    public void testGetFlowerPacks() {
        Flower flowerOne = new Flower();
        flowerOne.setPrice(10);
        FlowerPack flowerPackOne = new FlowerPack(flowerOne, 2);
        flowerBucket.add(flowerPackOne);
        
        Flower flowerTwo = new Flower();
        flowerTwo.setPrice(15);
        FlowerPack flowerPackTwo = new FlowerPack(flowerTwo, 3);
        flowerBucket.add(flowerPackTwo);
        
        Assertions.assertEquals(2, flowerBucket
                        .getFlowerPacks()
                        .size());
        Assertions.assertTrue(flowerBucket
                        .getFlowerPacks()
                        .contains(flowerPackOne));
        Assertions.assertTrue(flowerBucket
                        .getFlowerPacks()
                        .contains(flowerPackTwo));
    }
}
