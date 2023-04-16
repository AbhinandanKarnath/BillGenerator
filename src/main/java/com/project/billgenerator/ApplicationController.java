package com.project.billgenerator;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static com.project.billgenerator.module.*;

public class ApplicationController implements Initializable {
    int row=0;
    @FXML
    TextField productID;
    @FXML
    TextField productQuantity;
    @FXML
    TextField couponID;

    @FXML TableView<Items> tableView;
    @FXML TableColumn<Items ,String> itemStringTableColumn;
    @FXML TableColumn<Items,Integer> quantityStringTableColumn;
    @FXML TableColumn<Items,Integer>priceTableColumn;
    @FXML TableColumn<Items,Integer>amountTableColumn;

    @FXML
    public void addItems(ActionEvent e)
    {
        String itemname1 = new String();

        try {
            itemname1 = productID.getText();
            String size = productQuantity.getText();
//            String couponId = couponID.getText();
            int itemId = Integer.parseInt(itemname1);
            int quantity = Integer.parseInt(size);

            tableView.getItems().add(row++,getAndSet(itemId,quantity));
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        itemStringTableColumn.setCellValueFactory(new PropertyValueFactory<Items, String>("itemName"));
        quantityStringTableColumn.setCellValueFactory(new PropertyValueFactory<Items,Integer>("quantity"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<Items,Integer>("price"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<Items,Integer>("amount"));
    }
    @FXML
    public void saveToDatabaseAndPrint(ActionEvent e)
    {

    }
}