package com.project.billgenerator;

public class Items {
    private String itemName;
    private int quantity;
    private int price;
    private int amount;


    public Items( String itemName , int price , int quantity)
    {
        this.itemName=itemName;
        this.price=price;
        this.quantity=quantity;
        this.amount = price*quantity;
    }

    public String getItemName() {
        return itemName;
    }
    public int getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    public int getAmount() {
        return amount;
    }
}