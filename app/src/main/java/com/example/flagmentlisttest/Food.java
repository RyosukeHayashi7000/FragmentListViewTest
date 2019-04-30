package com.example.flagmentlisttest;

public class Food {
    long id;
    private String name;
    private int price;
    private String producingArea;
    private int image;

    public Food(String name, Integer price, String producingArea, int image) {
        this.name = name;
        this.price = price;
        this.producingArea = producingArea;
        this.image = image;

    }


public long getId(){
    return id;
}

public void setId(long id){
    this.id = id;
}

public String getName(){
    return name;
}

public void setName(String name) {
    this.name = name;
}

public int getPrice() {
    return price;
}

public void setPrice(int price) {
    this.price = price;
}

public String getProducingArea() {
    return producingArea;
}

public  void setProducingArea(String producingArea) {
    this.producingArea = producingArea;
}

public int getImage() {
    return image;
}

public void setImage(int image){
    this.image = image;
}

}
