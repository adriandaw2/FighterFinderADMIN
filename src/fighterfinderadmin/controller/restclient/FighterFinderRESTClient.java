/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fighterfinderadmin.controller.restclient;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fighterfinderadmin.entities.ACharacter;
import fighterfinderadmin.entities.AGame;
import fighterfinderadmin.entities.AUser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private String response = "";
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
        response = "";
        AUser aU = null;
        int result = 0;
        try{
            url = new URL(APIURL+"user/login");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            //conn
            conn.setDoInput(true);
            conn.setDoOutput(true);
            
            HashMap<String, String> dataParams = new HashMap();
            dataParams.put("nick", username);
            dataParams.put("password", password);
            
            OutputStream os = conn.getOutputStream();
            
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getQuery(dataParams));
            writer.flush();
            writer.close();
            os.close();
            
            int responseCode = 0;
            String line= "";
            responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader br= null;
                    try {
                        br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        while ((line=br.readLine()) != null) {
                            response+=line;
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace(System.out);
                }
            }
            else response = null;
            
            if (response!= null) {
                JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
                aU = new Gson().fromJson(jsonObject.get("user"), AUser.class);
            }

            if(aU != null)
            {
                if(aU.getIdProfile()==1)
                {
                    result = 1;
                }
            }
            
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
        response = "";
        int result = 0;
        try{
            url = new URL(APIURL+"game/addGameToDatabase");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            //conn
            conn.setDoInput(true);
            conn.setDoOutput(true);
            
            HashMap<String, String> dataParams = new HashMap();
            dataParams.put("gName", gName);
            OutputStream os = conn.getOutputStream();
            
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getQuery(dataParams));
            writer.flush();
            writer.close();
            os.close();
            
            int responseCode = 0;
            String line= "";
            responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader br= null;
                    try {
                        br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        while ((line=br.readLine()) != null) {
                            response+=line;
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace(System.out);
                }
            }
            else response = null;
            
            if (response!= null) {
                result = Integer.parseInt(response);
            }
            //result = 1;
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
        response = "";
        int result = 0;
        try{
            url = new URL(APIURL+"character/addCharacterToGame");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            //conn
            conn.setDoInput(true);
            conn.setDoOutput(true);
            
            HashMap<String, String> dataParams = new HashMap();
            dataParams.put("cName", cName);
            dataParams.put("gID", String.valueOf(gID));
            OutputStream os = conn.getOutputStream();
            
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getQuery(dataParams));
            writer.flush();
            writer.close();
            os.close();
            
            int responseCode = 0;
            String line= "";
            responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader br= null;
                    try {
                        br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        while ((line=br.readLine()) != null) {
                            response+=line;
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace(System.out);
                }
            }
            else response = null;
            
            if (response!= null) {
                result = Integer.parseInt(response);
            }
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
        response = "";
        int result = 0;
        try{
            url = new URL(APIURL+"objective/addNewObj");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            //conn
            conn.setDoInput(true);
            conn.setDoOutput(true);
            
            HashMap<String, String> dataParams = new HashMap();
            dataParams.put("objmsg", objMsg);
            OutputStream os = conn.getOutputStream();
            
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getQuery(dataParams));
            writer.flush();
            writer.close();
            os.close();
            
            int responseCode = 0;
            String line= "";
            responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader br= null;
                    try {
                        br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        while ((line=br.readLine()) != null) {
                            response+=line;
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace(System.out);
                }
            }
            else response = null;
            
            if (response!= null) {
                result = Integer.parseInt(response);
            }
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
        response = "";
        int result = 0;
        try{
            url = new URL(APIURL+"objective/modObjective");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            //conn
            conn.setDoInput(true);
            conn.setDoOutput(true);
            
            HashMap<String, String> dataParams = new HashMap();
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
        response = "";
        int result = 0;
        try{
            url = new URL(APIURL+"game/modGameInDatabase");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            //conn
            conn.setDoInput(true);
            conn.setDoOutput(true);
            
            HashMap<String, String> dataParams = new HashMap();
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
        response = "";
        int result = 0;
        try{
            url = new URL(APIURL+"character/modCharacter");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            
            HashMap<String, String> dataParams = new HashMap();
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
     * getAllGamesFromDatabase
     * Function to get all the games from database
     * @return List<AGame>
     */
    public List<AGame> getAllGamesFromDatabase()
    {
        response = "";
        List<AGame> aList = new ArrayList();
        AGame aGame = null;
        try{
            url = new URL(APIURL+"game");
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            //conn
            conn.setDoInput(true);
            conn.setDoOutput(true);
            
            int responseCode= 0;
            String line= "";

            try {
                responseCode = conn.getResponseCode();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }

            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader br= null;
                try {
                    br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    while ((line=br.readLine()) != null) {
                        response+=line;
                    }
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                }
            }
            else response = null;

            if (response!= null) {
                JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
                JsonArray jsonArray = jsonObject.getAsJsonArray("allGames");

                for (int i = 0; i < jsonArray.size(); ++i) {
                    JsonElement rec = jsonArray.get(i);
                    aGame = new Gson().fromJson(rec, AGame.class);
                    aList.add(aGame);
                }
            }
            
        }catch(MalformedURLException ex)
        {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }finally{
            conn.disconnect();
        }
        return aList;
    }
    
    /**
     * getAllCharactersFromGame
     * Function to get all characters from a game
     * @param aGameID
     * @return List<ACharacter>
     */
    public List<ACharacter> getAllCharactersFromGame(int aGameID)
    {
        ArrayList<ACharacter> aList = new ArrayList();
        response = "";
        ACharacter aChar = null;
        try{
            url = new URL(APIURL+"character/getAllCharactersFromGame");
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            //conn
            conn.setDoInput(true);
            conn.setDoOutput(true);
            
            HashMap<String, Integer> dataParams = new HashMap();
            dataParams.put("gameID", aGameID);
            
            int responseCode= 0;
            String line= "";

            try {
                responseCode = conn.getResponseCode();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }

            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader br= null;
                try {
                    br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    while ((line=br.readLine()) != null) {
                        response+=line;
                    }
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                }
            }
            else response = null;

            if (response!= null) {
                JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
                JsonArray jsonArray = jsonObject.getAsJsonArray("allCharactersFromGame");

                for (int i = 0; i < jsonArray.size(); ++i) {
                    JsonElement rec = jsonArray.get(i);
                    aChar = new Gson().fromJson(rec, ACharacter.class);
                    aList.add(aChar);
                }
            }
            
        }catch(MalformedURLException ex)
        {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }finally{
            conn.disconnect();
        }
        return aList;
    }
    
    /**
     * getQuery
     * Function to set the params ready for the API REST request
     * @param dataParams
     * @return String
     */
    private String getQuery(HashMap<String, String> dataParams) throws UnsupportedEncodingException{
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, String> entry : dataParams.entrySet()){
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }
}
