package com.example.todo;

import java.util.ArrayList;

public class Projet {
    private String projet;
    private String tache;
    private int tacheA;
    private int tacheC;


    public Projet(String projet, String tache, int tacheA, int tacheC){

        this.projet = projet;
        this.tache = tache;
        this.tacheA = tacheA;
        this.tacheC = tacheC;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public String getTache() {
        return tache;
    }

    public void setTache(String tache) {
        this.tache = tache;
    }

    public int getTacheA() {
        return tacheA;
    }

    public void setTacheA(int tacheA) {
        this.tacheA = tacheA;
    }

    public int getTacheC() {
        return tacheC;
    }

    public void setTacheC(int tacheC) {
        this.tacheC = tacheC;
    }


}
