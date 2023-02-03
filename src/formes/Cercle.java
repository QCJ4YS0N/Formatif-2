package formes;

import exceptions.FormeException;

public class Cercle {
    /**
     * La couleur par défaut est le VERT
     */
    public static final String COULEUR_DEFAUT = "vert";
    public static final String[] LES_COULEURS = {"vert", "rouge", "bleu", "jaune", "noir", "orange", "rose"};
    public static final int RAYON_DEFAUT = 10;
    public static final int MIN_VAL = 1;
    public static final int MAX_VAL = 30;

    /**
     * Désigne la couleur de la forme
     */
    private String couleur;
    private int rayon;
    private String nom;

    public Cercle() throws FormeException {
        this(RAYON_DEFAUT);
    }

    /**
     * Constructeur de la classe Cercle
     * @param rayon : la valeur du rayon du cercle
     * @throws FormeException : lance une FormeException si la forme est invalide
     */
    public Cercle(int rayon) throws FormeException {
        setRayon(rayon);
        setCouleur(COULEUR_DEFAUT);
        nom = "Cercle";
    }

    /**
     * Permet d'accéder à la valeur de couleur
     * @return couleur
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * Permet de valider une couleur
     * @param couleur : couleur à valider
     * @return true si valide, false si invalide
     */
    public static boolean couleurEstValide(String couleur) {
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

    /**
     * Permet de donner une valeur à couleur tout en la validant
     * @param couleur : valeur à donner à couleur
     */
    public void setCouleur(String couleur) {
        if (couleurEstValide(couleur)) {
            this.couleur = couleur.strip().toLowerCase();
        } else {
            this.couleur = COULEUR_DEFAUT;
        }
    }

    public int getRayon() {
        return rayon;
    }

    public static boolean rayonEstValide(int rayon) {
        return MIN_VAL <= rayon && rayon <= MAX_VAL;
    }

    public void setRayon(int rayon) throws FormeException {
        if (rayonEstValide(rayon)) {
            this.rayon = rayon;
        } else {
            throw new FormeException("Largeur invalide " + rayon);
        }
    }

    public String getNom() {
        return nom;
    }

    /**
     * Calcul de la surface du Cercle
     * @return l'aire du Cercle
     */
    public int calculerSurface() {
        return (int) (Math.PI * Math.pow(getRayon(), 2));
    }

    public int calculerCirconference() {
        return (int) (2 * Math.PI * getRayon());
    }

    /**
     * Permet de déterminer l'égualité d'un Cercle si la couleur et la surface sont les mêmes
     * @param o Objet avec lequel comparé le cercle
     * @return true si égaux, false si non-égaux
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cercle cercle = (Cercle) o;
        if (couleur.equals(cercle.getCouleur())) {
            return calculerSurface() == cercle.calculerSurface();
        }
        return false;
    }

    /**
     * Permet de retourner le nom, la couleur et le rayon de la forme
     * @return Nom, couleur, rayon
     */
    @Override
    public String toString() {
        return getNom() + " " + getCouleur() + " " + getRayon();
    }
}
