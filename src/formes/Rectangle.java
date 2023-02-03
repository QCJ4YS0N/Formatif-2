package formes;

import exceptions.FormeException;

public class Rectangle {
    public static final String COULEUR_DEFAUT = "rouge";
    public static final String[] LES_COULEURS = {"rouge", "vert", "bleu", "jaune", "noir", "orange", "rose"};
    public static final int MIN_VAL = 1;
    public static final int MAX_VAL = 30;

    private String couleur;
    private int hauteur;
    private int largeur;
    private String nom;

    public Rectangle(int hauteur, int largeur) {
        try {
            setHauteur(hauteur);
            setLargeur(largeur);
        } catch (FormeException e) {
            throw new RuntimeException(e.getMessage());
        }
        setCouleur(COULEUR_DEFAUT);
        nom = "Rectangle";

    }

    public String getCouleur() {
        return couleur;
    }

    public static boolean couleurEstValide(String couleur){
        boolean estValide = false;

        couleur = couleur.strip().toLowerCase();

        for (int i = 0; i < LES_COULEURS.length; i++) {
            estValide = LES_COULEURS[i].equals(couleur);
            if (estValide) {
                return true;
            }
        }
        return false;
    }

    public void setCouleur(String couleur) {
        if (couleurEstValide(couleur)) {
            this.couleur = couleur.strip().toLowerCase();
        } else {
            this.couleur = COULEUR_DEFAUT;
        }
    }

    public int getHauteur() {
        return hauteur;
    }

    public static boolean hauteurEstValide(int hauteur){
        return MIN_VAL <= hauteur && hauteur <= MAX_VAL;
    }

    public void setHauteur(int hauteur) throws FormeException {
        if (hauteurEstValide(hauteur)) {
            this.hauteur = hauteur;
        } else {
            throw new FormeException("Hauteur invalide " + hauteur);
        }
    }

    public int getLargeur() {
        return largeur;
    }

    public static boolean largeurEstValide(int largeur){
        return MIN_VAL <= largeur && largeur <= MAX_VAL;
    }

    public void setLargeur(int largeur) throws FormeException {
        if (largeurEstValide(largeur)) {
            this.largeur = largeur;
        } else {
            throw new FormeException("Largeur invalide " + largeur);
        }
    }

    public String getNom(){
        return nom;
    }

    public int calculerSurface(){
        return getLargeur() * getHauteur();
    }

    public int calculerPerimetre(){
        return 2 * getLargeur() + 2 * getHauteur();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;
        if (couleur.equals(rectangle.couleur)) {
            return calculerSurface() == rectangle.calculerSurface();
        }
        return false;
    }

    @Override
    public String toString() {
        return getNom() + " " + getCouleur() + " " + getHauteur() + ", " + getLargeur();
    }
}
