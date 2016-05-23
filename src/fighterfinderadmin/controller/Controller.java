/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fighterfinderadmin.controller;

import fighterfinderadmin.controller.restclient.FighterFinderRESTClient;
import fighterfinderadmin.view.LoginDialog;
import fighterfinderadmin.view.MainView;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Alumne
 */
public class Controller {
    private MainView myView;
    private LoginDialog myLog;
    private FighterFinderRESTClient myRESTClient;
    public Controller() {
        /*this.myView = new MainView();
        this.myView.setVisible(true);*/
        this.myLog = new LoginDialog(null, true);
        this.myLog.setVisible(true);
        myRESTClient = new FighterFinderRESTClient();
        
        //http://www.mkyong.com/webservices/jax-rs/restfull-java-client-with-java-net-url/
    }
    
    //public Controller()
    
    /**
     * logIn
     * Function to know if the one who uses this part is the admin
     * @param username
     * @param password
     */
    public void logIn(String username, String password)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }
    
    /**
     * addNewGame
     * Function to add a new game
     * @param gName
     */
    public void addNewGame(String gName)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }
    
    /**
     * addNewCharacterToGame
     * Function to add a new character to a game
     * @param cName
     * @param gID
     * 
     */
    public void addNewCharacterToGame(String cName, int gID)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }
    
    /**
     * modifyGame
     * Method to modify a game
     * @param gNameToMod
     * @param gID
     */
    public void modifyGame(String gNameToMod, int gID)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }
    
    /**
     * modifyCharacter
     * Method to modify a character
     * @param cNameToMod
     * @param gID
     */
    public void modifyCharacter(String cNameToMod, int gID)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }
    
    /**
     * addNewObjective
     * Function to add a new objective
     * @param objMesg
     */
    public void addNewObjective(String objMesg)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }
    
    /**
     * modifyObjective
     * Method to modify a character
     * @param objMsgToMod
     * @param oID
     */
    public void modifyObjective(String objMsgToMod, int oID)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }
    
    private String getMD5(String sToMD5)
    {
        String toMD5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(sToMD5.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            toMD5 = hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return toMD5;
    }
}
