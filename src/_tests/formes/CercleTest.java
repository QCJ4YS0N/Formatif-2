package formes;

import exceptions.FormeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CercleTest {
    private Cercle c1;
    private Cercle c2;
    private Cercle c3;
    private Cercle c4;

    @Test
    void getCouleur() throws FormeException {
        c1 = new Cercle();
        assertEquals("vert", Cercle.COULEUR_DEFAUT);
    }

    @Test
    void couleurEstValide() {
        for (int i = 0; i < Cercle.LES_COULEURS.length; i++) {
            assertTrue(Cercle.couleurEstValide(Cercle.LES_COULEURS[i]));
        }
    }

    @Test
    void setCouleur() throws FormeException {
        c1 = new Cercle();

        for (int i = 1; i < Cercle.LES_COULEURS.length; i++) {
            c1.setCouleur(Cercle.LES_COULEURS[i]);
            assertNotEquals(Cercle.COULEUR_DEFAUT, c1.getCouleur());
            c1.setCouleur(Cercle.LES_COULEURS[i].toUpperCase());
            assertNotEquals(Cercle.COULEUR_DEFAUT, c1.getCouleur());
        }
        c1.setCouleur(Cercle.COULEUR_DEFAUT);
        assertEquals(Cercle.COULEUR_DEFAUT, c1.getCouleur());
        c1.setCouleur(" ROUGE ");
        assertEquals("rouge", c1.getCouleur());
        c1.setCouleur(" MauvE ");
        assertEquals(Cercle.COULEUR_DEFAUT, c1.getCouleur());
    }

    @Test
    void getRayon() throws FormeException {
        c1 = new Cercle(8);

        assertEquals(8, c1.getRayon());
        assertNotEquals(13, c1.getRayon());
    }

    @Test
    void largeurEstValide() {
        assertTrue(Cercle.rayonEstValide(15));
        assertTrue(Cercle.rayonEstValide(Cercle.MIN_VAL));
        assertTrue(Cercle.rayonEstValide(Cercle.MAX_VAL));
        assertFalse(Cercle.rayonEstValide(-1));
        assertFalse(Cercle.rayonEstValide(0));
        assertFalse(Cercle.rayonEstValide(31));
    }

    @Test
    void setLargeur() throws FormeException {
        c1 = new Cercle();

        assertDoesNotThrow(() -> c1.setRayon(15));
        assertDoesNotThrow(() -> c1.setRayon(Cercle.MIN_VAL));
        assertDoesNotThrow(() -> c1.setRayon(Cercle.MAX_VAL));
        assertThrows(FormeException.class, () -> c1.setRayon(-1));
        assertThrows(FormeException.class, () -> c1.setRayon(0));
        assertThrows(FormeException.class, () -> c1.setRayon(31));
    }

    @Test
    void getNom() throws FormeException {
        c1 = new Cercle();
        assertEquals("Cercle", c1.getNom());
    }

    @Test
    void calculerSurface() throws FormeException {
        c1 = new Cercle(9);
        assertEquals(254, c1.calculerSurface());
        c1 = new Cercle(23);
        assertEquals(1661, c1.calculerSurface());
    }

    @Test
    void calculerPerimetre() throws FormeException {
        c1 = new Cercle(5);
        assertEquals(31, c1.calculerCirconference());
        c1 = new Cercle(13);
        assertEquals(81, c1.calculerCirconference());
    }

    @Test
    void testEquals() throws FormeException {
        c1 = new Cercle(3);
        c1.setCouleur("bleu");

        c2 = new Cercle(5);
        c2.setCouleur("rose");

        c3 = new Cercle(8);
        c3.setCouleur("rose");

        c4 = new Cercle(3);
        c4.setCouleur("bleu");

        assertNotEquals(c1, c2);
        assertNotEquals(c1, c3);
        assertNotEquals(c2, c3);
        assertEquals(c2, c2);
        assertEquals(c1, c4);
    }

    @Test
    void testToString() throws FormeException {
        c1 = new Cercle();

        assertEquals("Cercle vert 10", c1.toString());
    }
}