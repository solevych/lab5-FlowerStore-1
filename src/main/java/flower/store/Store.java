package flower.store;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Store {
    private List<FlowerPack> flowerPacks; 

    public Store() {
        this.flowerPacks = new ArrayList<>();
    }

    
    public void addFlowerPack(FlowerPack flowerPack) {
        if (flowerPack != null) {
            flowerPacks.add(flowerPack);
        }
    }

    
    public List<FlowerPack> search(FlowerType type, FlowerColor color) {
        return flowerPacks.stream()
        .filter(pack -> (type == null 
                    || pack.getFlower().getFlowerType() == type) 
                    && (color == null 
                    || pack.getFlower().getColor() == null 
                    || pack.getFlower().getColor().equals(color.toString())))
        .collect(Collectors.toList());
    }

    
    public List<FlowerPack> getFlowerPacks() {
        return new ArrayList<>(flowerPacks);
    }
}
