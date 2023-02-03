package formes;

import exceptions.FormeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    private Rectangle r1;
    private Rectangle r2;
    private Rectangle r3;
    private Rectangle r4;

    @Test
    void getCouleur() throws FormeException {
        r1 = new Rectangle(1, 1);
        assertEquals("rouge", Rectangle.COULEUR_DEFAUT);
    }

    @Test
    void couleurEstValide() throws FormeException {
        r1 = new Rectangle(1, 1);
        for (int i = 0; i < Rectangle.LES_COULEURS.length; i++) {
            assertTrue(Rectangle.couleurEstValide(Rectangle.LES_COULEURS[i]));
        }
    }

    @Test
    void setCouleur() throws FormeException {
        r1 = new Rectangle(1, 1);

        for (int i = 1; i < Rectangle.LES_COULEURS.length; i++) {
            r1.setCouleur(Rectangle.LES_COULEURS[i]);
            assertNotEquals(Rectangle.COULEUR_DEFAUT, r1.getCouleur());
            r1.setCouleur(Rectangle.LES_COULEURS[i].toUpperCase());
            assertNotEquals(Rectangle.COULEUR_DEFAUT, r1.getCouleur());
        }
        r1.setCouleur(Rectangle.COULEUR_DEFAUT);
        assertEquals(Rectangle.COULEUR_DEFAUT, r1.getCouleur());
        r1.setCouleur(" BLEU ");
        assertEquals("bleu", r1.getCouleur());
        r1.setCouleur(" MauvE ");
        assertEquals(Rectangle.COULEUR_DEFAUT, r1.getCouleur());
    }

    @Test
    void getHauteur() throws FormeException {
        r1 = new Rectangle(3,5);

        assertEquals(3, r1.getHauteur());
        assertNotEquals(5, r1.getHauteur());
    }

    @Test
    void hauteurEstValide() {
        assertTrue(Rectangle.hauteurEstValide(15));
        assertTrue(Rectangle.hauteurEstValide(Rectangle.MIN_VAL));
        assertTrue(Rectangle.hauteurEstValide(Rectangle.MAX_VAL));
        assertFalse(Rectangle.hauteurEstValide(-1));
        assertFalse(Rectangle.hauteurEstValide(0));
        assertFalse(Rectangle.hauteurEstValide(31));
    }

    @Test
    void setHauteur() throws FormeException {
        r1 = new Rectangle(1, 1);

        assertDoesNotThrow(() -> r1.setHauteur(15));
        assertDoesNotThrow(() -> r1.setHauteur(Rectangle.MIN_VAL));
        assertDoesNotThrow(() -> r1.setHauteur(Rectangle.MAX_VAL));
        assertThrows(FormeException.class, () -> r1.setHauteur(-1));
        assertThrows(FormeException.class, () -> r1.setHauteur(0));
        assertThrows(FormeException.class, () -> r1.setHauteur(31));
    }

    @Test
    void getLargeur() throws FormeException {
        r1 = new Rectangle(5,8);

        assertEquals(8, r1.getLargeur());
        assertNotEquals(13, r1.getLargeur());
    }

    @Test
    void largeurEstValide() {
        assertTrue(Rectangle.largeurEstValide(15));
        assertTrue(Rectangle.largeurEstValide(Rectangle.MIN_VAL));
        assertTrue(Rectangle.largeurEstValide(Rectangle.MAX_VAL));
        assertFalse(Rectangle.largeurEstValide(-1));
        assertFalse(Rectangle.largeurEstValide(0));
        assertFalse(Rectangle.largeurEstValide(31));
    }

    @Test
    void setLargeur() throws FormeException {
        r1 = new Rectangle(1, 1);

        assertDoesNotThrow(() -> r1.setLargeur(15));
        assertDoesNotThrow(() -> r1.setLargeur(Rectangle.MIN_VAL));
        assertDoesNotThrow(() -> r1.setLargeur(Rectangle.MAX_VAL));
        assertThrows(FormeException.class, () -> r1.setLargeur(-1));
        assertThrows(FormeException.class, () -> r1.setLargeur(0));
        assertThrows(FormeException.class, () -> r1.setLargeur(31));
    }

    @Test
    void getNom() throws FormeException {
        r1 = new Rectangle(1, 1);
        assertEquals("Rectangle", r1.getNom());
    }

    @Test
    void calculerSurface() throws FormeException {
        r1 = new Rectangle(2, 2);
        assertEquals(4, r1.calculerSurface());
        r1 = new Rectangle(9, 23);
        assertEquals(207, r1.calculerSurface());
    }

    @Test
    void calculerPerimetre() throws FormeException {
        r1 = new Rectangle(5, 7);
        assertEquals(24, r1.calculerPerimetre());
        r1 = new Rectangle(8, 17);
        assertEquals(50, r1.calculerPerimetre());
    }

    @Test
    void testEquals() throws FormeException {
        r1 = new Rectangle(1, 1);
        r1.setCouleur("bleu");

        r2 = new Rectangle(3, 5);
        r2.setCouleur("rose");

        r3 = new Rectangle(1, 1);
        r3.setCouleur("rose");

        r4 = new Rectangle(1, 1);
        r4.setCouleur("bleu");

        assertNotEquals(r1, r2);
        assertNotEquals(r1, r3);
        assertNotEquals(r2, r3);
        assertEquals(r2, r2);
        assertEquals(r1, r4);
    }

    @Test
    void testToString() throws FormeException {
        r1 = new Rectangle(1, 1);

        assertEquals("Rectangle rouge 1, 1", r1.toString());
    }
}