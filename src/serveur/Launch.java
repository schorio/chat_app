/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author schorio
 */
public class Launch extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane pan=FXMLLoader.load(getClass().getResource("/serveur/serveur.fxml"));
        stage.setScene(new Scene(pan));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
