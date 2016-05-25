/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fighterfinderadmin.entities;


import java.util.List;

/**
 *
 * @author Adrian
 */
public class Model {
    private List<AGame> myGameList;
    private List<ACharacter> myCharList;
    private List<AObjective> myObjectiveList;
    public Model() {
    }

    public Model(List<AGame> myGameList, List<ACharacter> myCharList, List<AObjective> myObjectiveList) {
        this.myGameList = myGameList;
        this.myCharList = myCharList;
        this.myObjectiveList = myObjectiveList;
    }

    public List<AGame> getMyGameList() {
        return myGameList;
    }

    public void setMyGameList(List<AGame> myGameList) {
        this.myGameList = myGameList;
    }

    public List<ACharacter> getMyCharList() {
        return myCharList;
    }

    public void setMyCharList(List<ACharacter> myCharList) {
        this.myCharList = myCharList;
    }

    public List<AObjective> getMyObjectiveList() {
        return myObjectiveList;
    }

    public void setMyObjectiveList(List<AObjective> myObjectiveList) {
        this.myObjectiveList = myObjectiveList;
    }
    
    
    /**
     * 
     */
    
    
    
}
