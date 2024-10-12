package flower.store;

import java.util.List;
import java.util.ArrayList;


public class FlowerBucket {
    
    private List<FlowerPack> flowerPacks;

    public FlowerBucket() {
        this.flowerPacks = new ArrayList<>();

    }

    public void add(FlowerPack flowerPack){
        flowerPacks.add(flowerPack);

    }

    public double getPrice() {
        double price = 0;

        for (FlowerPack flowerPack : flowerPacks) {
            price += flowerPack.getPrice();
        }
        return price;
    }

    public List<FlowerPack> getFlowerPacks() {
        return new ArrayList<>(flowerPacks); 
    }
}