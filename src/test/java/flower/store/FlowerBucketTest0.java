package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Random;


public class FlowerBucketTest0 {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 1000;
    private static final int MAX_PRICE = 100;


    private static final int TEST_PRICE_ONE = 10;  // Price for the first test
    private static final int TEST_QUANTITY_ONE = 5; // Quantity for the first test
    private static final int TEST_PRICE_TWO = 15;   // Price for the second test
    private static final int TEST_QUANTITY_TWO = 3; // Quantity for the second test

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
        flower.setPrice(TEST_PRICE_ONE);
        FlowerPack flowerPack = new FlowerPack(flower, TEST_QUANTITY_ONE);
        flowerBucket.add(flowerPack);
        
        Assertions.assertEquals(1, flowerBucket.getFlowerPacks().size());
        Assertions.assertEquals(flowerPack, flowerBucket.getFlowerPacks().get(0));
    }

    @Test
    public void testGetFlowerPacks() {
        Flower flowerOne = new Flower();
        flowerOne.setPrice(TEST_PRICE_ONE);
        FlowerPack flowerPackOne = new FlowerPack(flowerOne, 2);
        flowerBucket.add(flowerPackOne);
        
        Flower flowerTwo = new Flower();
        flowerTwo.setPrice(TEST_PRICE_TWO);
        FlowerPack flowerPackTwo = new FlowerPack(flowerTwo, TEST_QUANTITY_TWO);
        flowerBucket.add(flowerPackTwo);
        
        Assertions.assertEquals(2, flowerBucket.getFlowerPacks().size());
        Assertions.assertTrue(flowerBucket.getFlowerPacks().contains(flowerPackOne));
        Assertions.assertTrue(flowerBucket.getFlowerPacks().contains(flowerPackTwo));
    }
}
