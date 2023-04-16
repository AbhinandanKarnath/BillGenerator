package com.project.billgenerator;

import com.mysql.cj.conf.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class Items {
    private String itemName;
    private int quantity;
    private int price;
    private int amount;
    public Items(String itemName , int price , int quantity)
    {
        this.itemName = itemName;
        this.price=price;
        this.quantity=quantity;
        this.amount = price*quantity;
    }
    public String getName() {
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