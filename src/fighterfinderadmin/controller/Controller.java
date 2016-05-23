/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fighterfinderadmin.controller;

import fighterfinderadmin.view.LoginDialog;
import fighterfinderadmin.view.MainView;

/**
 *
 * @author Alumne
 */
public class Controller {
    private MainView myView;
    private LoginDialog myLog;
    public Controller() {
        /*this.myView = new MainView();
        this.myView.setVisible(true);*/
        this.myLog = new LoginDialog(null, true);
        this.myLog.setVisible(true);
        
        //http://www.mkyong.com/webservices/jax-rs/restfull-java-client-with-java-net-url/
    }
    
    //public Controller()
}
