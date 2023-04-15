package com.project.billgenerator;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    TextField productID;
    @FXML
    TextField productQuantity;
    @FXML
    TextField couponID;
    @FXML
    TableView tab;

    @FXML
    public void addItems(ActionEvent e)
    {String itemname = new String();

        try {
            System.out.println("1");
            itemname = productID.getText();
            System.out.println("2");
            String quantity = productQuantity.getText();
//            String couponId = couponID.getText();
            System.out.println(itemname+" "+quantity);

        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
    }
}
//    git init
//    git add .
//        git commit -m "Initial commit"
//        git remote add origin <project url>
//git push -f origin master