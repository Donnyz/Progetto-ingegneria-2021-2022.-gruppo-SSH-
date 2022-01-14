package com.example.ssh;

public class Avviso {
    private String data;
    private String descrizione;
    private String bambino;
    private String insegnante;
    private boolean generale;
    private String oggetto;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getBambino() {
        return bambino;
    }

    public void setBambino(String bambino) {
        this.bambino = bambino;
    }

    public String getInsegnante() {
        return insegnante;
    }

    public void setInsegnante(String insegnante) {
        this.insegnante = insegnante;
    }

    public boolean isGenerale() {
        return generale;
    }

    public void setGenerale(boolean generale) {
        this.generale = generale;
    }

    public String getOggetto() {
        return oggetto;
    }

    public void setOggetto(String oggetto) {
        this.oggetto = oggetto;
    }
}
