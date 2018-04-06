/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pamperedpet;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

/**Name: FXMLDocumentController
 *  Date: 3.27.2018
 * @author danielcender
 *  Abstract: This file provides the "controller" aspect of the MVC pattern followed by JavaFX. It handles the logic of PamperedPet
 */
public class FXMLDocumentController implements Initializable {
    
   float paymentTotal = 0f;
    String paymentMessage = "";
    float tax = 0f;
    
    // Removing private keyword for now
    @FXML
    private TextField txtOwnerName, txtOwnerCell, txtPetName, txtPetAge, txtLengthStay, txtDoses;
    
    @FXML
    private RadioButton radUpToDate, radNotUpToDate, radTypeCat, radTypeDog, radSuiteLarge, radSuiteXLarge, radSuiteXXLarge, radSuiteLux;
    
    @FXML
    private TextArea txaSpecialInstructions;
    
    @FXML
    private CheckBox chkMeds, chkBathBrush, chkWalking, chkPedicure, chkTransport, chkSundayPickup, chkFood;
    
    @FXML
    private Button btnCancel, btnSubmit;
    
    
    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        calculateInvoice();
        displayInvoice();
    }
    
    @FXML
    private void handleCancelButtonAction(ActionEvent event) {
       txtOwnerName.clear();
       txtOwnerCell.clear();
       txtPetName.clear();
       txtPetAge.clear();
       txtLengthStay.clear();
       txtDoses.clear();
       radUpToDate.setSelected(radUpToDate.isSelected() ? false : false);
       radNotUpToDate.setSelected(radNotUpToDate.isSelected() ? false : false);
       radTypeCat.setSelected(radTypeCat.isSelected() ? false : false);
       radTypeDog.setSelected(radTypeDog.isSelected() ? false : false);
       radSuiteLarge.setSelected(radSuiteLarge.isSelected() ? false : false);
       radSuiteXLarge.setSelected(radSuiteXLarge.isSelected() ? false : false);
       radSuiteXXLarge.setSelected(radSuiteXXLarge.isSelected() ? false : false);
       radSuiteLux.setSelected(radSuiteLux.isSelected() ? false : false);
       txaSpecialInstructions.clear();
       chkMeds.setSelected(false);
       chkBathBrush.setSelected(false);
       chkWalking.setSelected(false);
       chkPedicure.setSelected(false);
       chkTransport.setSelected(false);
       chkSundayPickup.setSelected(false);
       chkFood.setSelected(false);
    }
    
    
    /* ***************** Button Handlers go here ************** */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // I would put event handlers here normally, but the FXML file already specifies my custom methods.
    }    
 
    
    // Methods go here
    @FXML
    protected void calculateInvoice() {
        // Prep invoice message string for calculations
        paymentMessage = "\tPampered Pets Resort Invoice\n"
                + "Owner Name:\t" + txtOwnerName.getText() + "\n"
                + "Owner Cell:\t" + txtOwnerCell.getText() + "\n"
                + "Pet's Name:\t" + txtPetName.getText() + "\n"
                + "Pet's Age:\t" + txtPetAge.getText() + "\n"
                + "Pet's Shots:\t";
        
        paymentMessage += radUpToDate.isSelected() ? "Up To Date\n" : "Not Up to Date\n";
        
        paymentMessage += "Type of Pet:\t";
        
        paymentMessage += radTypeCat.isSelected() ? "Cat\n" : "Dog\n";
        
        paymentMessage += "Special Instructions:\t" + txaSpecialInstructions.getText() + "\n";
        
        // Calculate cost of room for stay
        if(radSuiteLarge.isSelected()) {
            paymentTotal += 25f * Integer.parseInt(txtLengthStay.getText());
            paymentMessage += "Suite Choice:\tStandard Large - 25/night\n";
        }
        
        if(radSuiteXLarge.isSelected()) {
            paymentTotal += 28f * Integer.parseInt(txtLengthStay.getText());
            paymentMessage += "Suite Choice:\tStandard Extra-Large - 28/night\n";
        }
        
        if(radSuiteXXLarge.isSelected()) {
            paymentTotal += 34f * Integer.parseInt(txtLengthStay.getText());
            paymentMessage += "Suite Choice:\tStandard Double Extra Large - 34/night\n";
        }
        
        if(radSuiteLux.isSelected()) {
            paymentTotal += 40f * Integer.parseInt(txtLengthStay.getText());
            paymentMessage += "Suite Choice:\tLuxury Suite - 40/night\n";
        }
        
        paymentMessage += "Extra Services:\n";
        
        // Calculate Cost of extra Services
        if(chkMeds.isSelected()) {
            paymentTotal += 2.5f * Integer.parseInt(txtDoses.getText());
            paymentMessage += "\tDelivery of Medications - " + Integer.parseInt(txtDoses.getText()) + " doses.\n";
        }
        
        if(chkBathBrush.isSelected()) {
            paymentTotal += 15;
            paymentMessage += "\tBath & Brush\n";
        }
        
        if(chkWalking.isSelected()) {
            paymentTotal += 5;
            paymentMessage += "\tWalking\n";
        }
        
        if(chkPedicure.isSelected()) {
            paymentTotal += 10;
            paymentMessage += "\tPedicure\n";
        }
        
        if(chkTransport.isSelected()) {
            paymentTotal += 20;
            paymentMessage += "\tTransport to Vet\n";
        }
        
        if(chkSundayPickup.isSelected()) {
            paymentTotal += 12.5f;
            paymentMessage += "\tSunday Pickup\n";
        }
        
        if(chkFood.isSelected()) {
            paymentTotal += 5 * Integer.parseInt(txtLengthStay.getText());
            paymentMessage += "\tResort Provided Food - " + Integer.parseInt(txtLengthStay.getText()) + " total.\n";
        }
        
        // Calculate Tax
        tax = paymentTotal * .08125f;
        paymentTotal += tax;
        paymentMessage += "\nTax: " + tax;
        paymentMessage += "\nTotal Invoice: " + paymentTotal;
        
        // Account for improper length of stay
        if(Integer.parseInt(txtLengthStay.getText()) > 30) {
            paymentMessage = "You entered an invalid length of boarding stay.\n Please go back and enter in an integer up to 30. Thank you.";
        }
    }
    
    @FXML
    protected void displayInvoice() {
        Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information Dialog");
alert.setHeaderText(null);
alert.setContentText(paymentMessage);

alert.showAndWait();
    }
}
