package com.project.billgenerator;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.project.billgenerator.module.getAndSet;

public class ApplicationController implements Initializable {
    int row=0;
    @FXML TextField productID;
    @FXML TextField productQuantity;
    @FXML TextField couponID;
    @FXML TableView<Items> tableView;
    @FXML TableColumn<Items ,String> itemStringTableColumn;
    @FXML TableColumn<Items,Integer> quantityStringTableColumn;
    @FXML TableColumn<Items,Integer>priceTableColumn;
    @FXML TableColumn<Items,Integer>amountTableColumn;

    public boolean checkReq(String item , String size) {
        return !(item.equals("")) || !(size.equals(""));
    }


    @FXML
    public void addItems(ActionEvent e)
    {
        String itemName1 = productID.getText();
        String size = productQuantity.getText();

        if(checkReq(itemName1,size))
        {
            try {
                        //            String couponId = couponID.getText();
                int itemId = Integer.parseInt(itemName1);
                int quantity = Integer.parseInt(size);
                tableView.getItems().add(row++,getAndSet(itemId,quantity));
            }
            catch(NumberFormatException numberFormatException)
            {
                productID.setText("");
                productQuantity.setText("");
            }
            catch (Exception exception)
            {
                System.out.println(exception);
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            itemStringTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
            quantityStringTableColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getQuantity()).asObject());
            priceTableColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPrice()).asObject());
            amountTableColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getAmount()).asObject());
        }catch (Exception e)
        {
            System.out.println(e);
        }

    }
    @FXML
    public void saveToDatabaseAndPrint(ActionEvent e)
    {

    }
    @FXML
    public void reset(ActionEvent e)
    {
        productID.setText("");
        productQuantity.setText("");
//        couponID.setText("");
    }
}