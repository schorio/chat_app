/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.Socket;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author schorio
 */
public class ClientController implements FrameInterface {

    private EnvoyeurMessage envoirMess;
    private RecepteurMessage resMess;
    
    @FXML
    private JFXTextField adresseIPClient;
    @FXML
    private Button connexionClient;
    @FXML
    private TextArea affichageClient;
    @FXML
    private JFXTextField messageClient;
    @FXML
    private JFXTextField portClient;
  

    @FXML
    private void connexionClientCliquer(MouseEvent event) {
        
        try {
            
            int port = Integer.valueOf(portClient.getText());
            String address = adresseIPClient.getText();
            Socket sendStream = new Socket(address, port);
            envoirMess = new EnvoyeurMessage(sendStream.getOutputStream());
            resMess = new RecepteurMessage(sendStream.getInputStream(), this);
            
            this.setEnvoyeur(envoirMess);
            this.setRecepteur(resMess);
            
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    @FXML
    private void envoyerClientCliquer(MouseEvent event) {
        try {
            String recu = messageClient.getText();
            envoirMess.envoyer(recu);
            affichageClient.appendText("Moi : " + recu.trim() + "\n");
            messageClient.setText("");
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    @Override
    public void recoieMessage(String message) {
        affichageClient.appendText("serveur: " + message.trim() + "\n");
    }
    
    @Override
    public void setEnvoyeur(EnvoyeurMessage e) {
        envoirMess = e;
    }

    @Override
    public void setRecepteur(RecepteurMessage r) {
        resMess = r;
        resMess.start();
    }

}
