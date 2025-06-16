package fr.minesnancy.collet.helloworld;

import java.util.Vector;

public class Carte {
    private String question;
    private String bonneReponse;
    private Vector<String> mauvaisesReponses;

    public String getQuestion() {
        return question;
    }

    public String getBonneReponse() {
        return bonneReponse;
    }

    public Vector<String> getMauvaisesReponses() {
        return mauvaisesReponses;
    }

    public Carte() {
        mauvaisesReponses = new Vector<String>();
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public void setBonneReponse(String bonneReponse) {
        this.bonneReponse = bonneReponse;
    }
    public void addMauvaiseReponse(String mauvaiseReponse) {
        mauvaisesReponses.add(mauvaiseReponse);
    }
}
