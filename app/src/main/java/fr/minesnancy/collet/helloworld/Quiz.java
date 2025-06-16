package fr.minesnancy.collet.helloworld;

import java.util.Vector;

public class Quiz {
    private Vector<Carte> cartes;

    public Quiz() {
        cartes = new Vector<Carte>();

        Carte c1 = new Carte();
        c1.setQuestion("Quel est le nom de la mascotte officielle d'Android ?");
        c1.setBonneReponse("Bugdroid");
        c1.addMauvaiseReponse("Andy the Android");
        c1.addMauvaiseReponse("RoboBob");
        c1.addMauvaiseReponse("Droidy");
        cartes.add(c1);

        Carte c2 = new Carte();
        c2.setQuestion("A quoi est associée chaque nouvelle version d'Android ?");
        c2.setBonneReponse("une pâtisserie");
        c2.addMauvaiseReponse("une couleur");
        c2.addMauvaiseReponse("une capitale");
        c2.addMauvaiseReponse("un animal");
        cartes.add(c2);

        Carte c3 = new Carte();
        c3.setQuestion("En quelle année la première version d'Android (Cupcake) est-elle sortie ?");
        c3.setBonneReponse("2008");
        c3.addMauvaiseReponse("2009");
        c3.addMauvaiseReponse("2010");
        c3.addMauvaiseReponse("2011");
        cartes.add(c3);
    }

    public Vector<Carte> getCartes() {
        return cartes;
    }

    public int getNbCartes() {
        return cartes.size();
    }

    public Carte getCarte(int index) {
        return cartes.get(index);
    }
}
