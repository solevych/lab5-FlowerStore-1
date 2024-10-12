package flower.store;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Flower {
    private double sepalLenght;
    private FlowerColor color;
    private double price;
    private FlowerType flowerType;

    public String getColor() {
        return color.toString();
    }

    public Flower(Flower flower) {
        this.color = flower.color;
        this.flowerType = flower.flowerType;
        this.price = flower.price;
        this.sepalLenght = flower.sepalLenght;
    }

    public boolean equal(Flower flower2){
        return (color.toString().equals(flower2.getColor()) & flowerType == flower2.getFlowerType());

    }
}
