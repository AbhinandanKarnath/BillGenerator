package com.project.billgenerator;

import java.sql.*;

public class module {
    public static void getAndSet(int productId , int quantity)
    {
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
            Items items = new Items(itemName,price,quantity);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
