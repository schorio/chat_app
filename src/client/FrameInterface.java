/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author schorio
 */
public interface FrameInterface {
    
    void recoieMessage(String message);
    
    void setEnvoyeur(EnvoyeurMessage e);
    
    void setRecepteur(RecepteurMessage r);
    
}
