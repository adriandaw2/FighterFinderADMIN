/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fighterfinderadmin.controller;

import fighterfinderadmin.controller.restclient.FighterFinderRESTClient;
import fighterfinderadmin.entities.ACharacter;
import fighterfinderadmin.entities.AGame;
import fighterfinderadmin.entities.AObjective;
import fighterfinderadmin.entities.Model;
import fighterfinderadmin.view.LoginDialog;
import fighterfinderadmin.view.MainView;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Alumne
 */
public class Controller {
    private MainView myView;
    private LoginDialog myLog;
    private JPanel currentPanel;
    private FighterFinderRESTClient myRESTClient;
    private Model myModel;
    public Controller(Model aModel) {
        /*this.myView = new MainView();
        this.myView.setVisible(true);*/
        myRESTClient = new FighterFinderRESTClient();
        this.myModel = aModel;
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

    public JPanel getCurrentPanel() {
        return currentPanel;
    }

    public void setCurrentPanel(JPanel currentPanel) {
        this.currentPanel = currentPanel;
        handleCurrentPanel();
    }
    
    
    
    
    /**
     * handleCurrentPanel
     * Method to change the current pane, it will always be called after a setCurrentPanel so the mainview change of pane.
     */
    private void handleCurrentPanel()
    {
        this.myView.setContentPane(this.currentPanel);
        this.myView.getContentPane().setVisible(true);
        System.out.println("Panel created");
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
            this.myView = new MainView(this, this.myModel);
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
        int result = myRESTClient.addNewGame(gName);
        if(result == -1)
        {
            JOptionPane.showMessageDialog(this.myView, "Game not added", "Add new game information", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(this.myLog, "Game added to the database: "+gName, "Log in information", JOptionPane.INFORMATION_MESSAGE);
        }
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
        int result = myRESTClient.addNewCharacterToGame(cName, gID);
        if(result == -1)
        {
            JOptionPane.showMessageDialog(this.myView, "Character not added", "Add character information", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(this.myLog, "Character->"+cName+" added to the game with ID->"+gID, "Character add information", JOptionPane.INFORMATION_MESSAGE);
        }
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
        int result = myRESTClient.addNewObjective(objMesg);
        if(result == -1)
        {
            JOptionPane.showMessageDialog(this.myView, "Objective not added", "Add new objective message", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(this.myLog, "objective added to the database: "+objMesg, "Add new objective message", JOptionPane.INFORMATION_MESSAGE);
        }
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
    
    
    /**
     * getAllGamesFromDatabase
     * Function to get all games from database
     * @return List<AGame>
     */
    public List<AGame> getAllGamesFromDatabase()
    {
        List<AGame> aList = myRESTClient.getAllGamesFromDatabase();
        return aList;
    }
    
    /**
     * getAllObjectivesFromDatabase
     * FUnction to get all the objectives
     * @return List<AObjective>
     */
    public List<AObjective> getAllObjectivesFromDatabase()
    {
        List<AObjective> aList = null;
        
        return aList;
    }
    
    
    /**
     * getAllObjectivesFromDatabase
     * FUnction to get all the objectives
     * @return List<ACharacter>
     */
    public List<ACharacter> getAllCharactersFromGame(int gID)
    {
        List<ACharacter> aList = null;
        System.out.println("Game selected->"+gID);
        return aList;
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
