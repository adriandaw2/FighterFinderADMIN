/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fighterfinderadmin;

import fighterfinderadmin.controller.Controller;
import fighterfinderadmin.entities.Model;

/**
 *
 * @author Alumne
 */
public class FighterFinderADMIN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //LoginDialog aLDialog = new LoginDialog(null, true);
        Model myModel = new Model();
        Controller myController = new Controller(myModel);
        //System.out.println(getMD5("admin@pass1234"));
    }
    
    
    
    
}
