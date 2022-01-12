package com.example.ssh;

public class Persona {
    private String nome;
    private String cognome;
    private String id;
    private boolean insegna;
    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getInsegna() {
        return insegna;
    }

    public void setInsegna(boolean insegna) {
        this.insegna = insegna;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getId() {
        return id;
    }
}
