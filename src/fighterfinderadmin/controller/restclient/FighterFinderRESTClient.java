/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fighterfinderadmin.controller.restclient;

import fighterfinderadmin.entities.AUser;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class FighterFinderRESTClient {
    
    private URL url;
    private HttpURLConnection conn;
    static final String APIURL = "http://provenapps.cat:8080/FighterFinderREST/ff/";
    public FighterFinderRESTClient() {
    }
    
    //ALL METHODS to do the rest client stuff will go here
    /**
     * isAdmin
     * Function to check if the credentials are correct in the DDBB
     * Will return 1 if the user is admin, 0 if user isn't, -1 if is something wrong with API
     * @param username
     * @param password
     * @return int
     */
    public int isAdmin(String username, String password)
    {
        AUser aU = null;
        int result = 0;
        try{
            url = new URL(APIURL+"user/login");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            //conn
            
            result = 1;
        }catch(MalformedURLException ex)
        {
            result = -1;
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            result = -1;
            ex.printStackTrace(System.out);
        }finally{
            conn.disconnect();
        }
        return result;
    }
    
    /**
     * addNewGame
     * Function to add a new game to the database
     * Will return 1 if everything is ok, 0 if not, and -1 if there is a problem in the server
     * @param gName
     * @return int
     */
    public int addNewGame(String gName)
    {
        int result = 0;
        try{
            url = new URL(APIURL+"game/addGameToDatabase");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            //conn
            
            result = 1;
        }catch(MalformedURLException ex)
        {
            result = -1;
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            result = -1;
            ex.printStackTrace(System.out);
        }finally{
            conn.disconnect();
        }
        
        return result;
    }
    
    /**
     * addNewCharacterToGame
     * Function to add a new character to a game
     * Will return 1 if everything's ok, 0 if not added, and -1 if some error with server
     * @param cName
     * @param gID
     * @return int
     */
    public int addNewCharacterToGame(String cName, int gID)
    {
        int result = 0;
        try{
            url = new URL(APIURL+"character/addCharacterToGame");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            //conn
            
            result = 1;
        }catch(MalformedURLException ex)
        {
            result = -1;
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            result = -1;
            ex.printStackTrace(System.out);
        }finally{
            conn.disconnect();
        }
        
        return result;
    }
    
    /**
     * addNewObjective
     * Function to add a new game to the database
     * Will return 1 if everything is ok, 0 if not, and -1 if there is a problem in the server
     * @param objMsg
     * @return int
     */
    public int addNewObjective(String objMsg)
    {
        int result = 0;
        try{
            url = new URL(APIURL+"objective/addNewObj");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            //conn
            
            result = 1;
        }catch(MalformedURLException ex)
        {
            result = -1;
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            result = -1;
            ex.printStackTrace(System.out);
        }finally{
            conn.disconnect();
        }
        
        return result;
    }
    
    /**
     * modObjective
     * Function to mod a objective
     * Will return 1 if everything's ok, 0 if not added, and -1 if some error with server
     * @param nObjMsg
     * @param oID
     * @return int
     */
    public int modObjective(String nObjMsg, int oID)
    {
        int result = 0;
        try{
            url = new URL(APIURL+"objective/modObjective");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            //conn
            
            result = 1;
        }catch(MalformedURLException ex)
        {
            result = -1;
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            result = -1;
            ex.printStackTrace(System.out);
        }finally{
            conn.disconnect();
        }
        
        return result;
    }
    
    /**
     * modGame
     * Function to mod a game
     * Will return 1 if everything's ok, 0 if not added, and -1 if some error with server
     * @param gNewName
     * @param gID
     * @return int
     */
    public int modGame(String gNewName, int gID)
    {
        int result = 0;
        try{
            url = new URL(APIURL+"game/modGameInDatabase");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            //conn
            
            result = 1;
        }catch(MalformedURLException ex)
        {
            result = -1;
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            result = -1;
            ex.printStackTrace(System.out);
        }finally{
            conn.disconnect();
        }
        
        return result;
    }
    
    /**
     * modCharacter
     * Function to mod a character
     * Will return 1 if everything's ok, 0 if not added, and -1 if some error with server
     * @param cNewName
     * @param cID
     * @return int
     */
    public int modCharacter(String cNewName, int cID)
    {
        int result = 0;
        try{
            url = new URL(APIURL+"character/modCharacter");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            //conn
            
            result = 1;
        }catch(MalformedURLException ex)
        {
            result = -1;
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            result = -1;
            ex.printStackTrace(System.out);
        }finally{
            conn.disconnect();
        }
        
        return result;
    }
}
