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
import javax.swing.JOptionPane;

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
        myRESTClient = new FighterFinderRESTClient();
        this.myLog = new LoginDialog(null, true, this);
        this.myLog.setVisible(true);
        
        
        //http://www.mkyong.com/webservices/jax-rs/restfull-java-client-with-java-net-url/
    }
    
    //public Controller()

    public MainView getMyView() {
        return myView;
    }

    public void setMyView(MainView myView) {
        this.myView = myView;
    }

    public LoginDialog getMyLog() {
        return myLog;
    }

    public void setMyLog(LoginDialog myLog) {
        this.myLog = myLog;
    }

    public FighterFinderRESTClient getMyRESTClient() {
        return myRESTClient;
    }

    public void setMyRESTClient(FighterFinderRESTClient myRESTClient) {
        this.myRESTClient = myRESTClient;
    }
    
    
    
    
    
    /**
     * logIn
     * Function to know if the one who uses this part is the admin
     * @param username
     * @param password
     */
    public void logIn(String username, String password)
    {
        //System.out.println(myRESTClient.isAdmin(username, getMD5(password)));
        int result = myRESTClient.isAdmin(username, getMD5(password));
        if(result != 1)
        {
            if(result == 0)
            {
                JOptionPane.showMessageDialog(this.myLog, "You can not log in", "Log in information", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(this.myLog, "Server is under maintenance", "Server info", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else
        {
            this.myLog.setVisible(false);
            System.out.println("Open new form");
            this.myView = new MainView(this);
            this.myView.setVisible(true);
        }
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
    

    
    /**
     * closeApp
     * Method to close thw whole app
     */
    public void closeApp() {
        
    }
}
