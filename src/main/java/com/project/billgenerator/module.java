package com.project.billgenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class module {
    private static Items items;
    public static Items getAndSet(int productId , int quantity)
    {
        Items items;
        String query = "Select item , price from items where id= ?";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","MySQLP@55W0rd52");
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,productId);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            String itemName = rs.getString(1);
            int price = rs.getInt(2);
            con.close();
            items = new Items(itemName,price,quantity);
            new Items(items);
            return items;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
    public Items getItem()
    {
        Items item = null;
        return item;
    }
//    public static String getItemName()
//    {
//        String name = items.getName();
//
//        return null;
//    }
    public static int getItemPrice()
    {
        return items.getPrice();
    }
    public static int getItemsQuantity()
    {
        return items.getQuantity();
    }
    public static int getItemsAmount()
    {
        return items.getAmount();
    }
}