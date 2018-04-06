/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pamperedpet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**Name: PamperedPet
 *  Date: 3.27.2018
 * @author danielcender
 * Abstract: This program takes in pet boarding information from a customer and uses it to calculate an invoice for the pet's stay at Pampered Pet Resort.
 */
public class PamperedPet extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        // Auto-generated above method isn't working. Manually importing resources below.
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        //Parent root = loader.load();
        Scene scene = new Scene(root);
        
        stage.setScene(scene); 
        stage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
