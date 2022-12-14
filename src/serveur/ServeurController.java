/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author schorio
 */
public class ServeurController implements FrameInterface {

    private EnvoyeurMessage enmessage;
    private RecepteurMessage recmessage;
    
    @FXML
    private JFXTextField portServeur;
    
    @FXML
    private TextArea affichageServeur;
    
    @FXML
    private JFXTextField messageServeur;
       

    @FXML
    void connexionServeurCliquer(MouseEvent event) {
        int port = Integer.valueOf(portServeur.getText());
        ServeurCode servc = new ServeurCode(this, port);
        servc.start();
    }

    @FXML
    void envoyerServeurCliquer(MouseEvent event) {
        
        try {
            String recu = messageServeur.getText();
            enmessage.envoyer(recu);
            affichageServeur.appendText("Moi : " + recu.trim() + "\n");
            messageServeur.setText("");
        } 
        
        catch (Exception e) {
            
        }
    }
    
    @Override
    public void recoieMessage(String message) {
        affichageServeur.appendText("Client : " + message.trim() + "\n");
    }
    
    @Override
    public void setEnvoyeur(EnvoyeurMessage e) {
        enmessage = e;
    }
    
    @Override
    public void setRecepteur(RecepteurMessage r) {
        recmessage = r;
        recmessage.start();
    }
    
}
