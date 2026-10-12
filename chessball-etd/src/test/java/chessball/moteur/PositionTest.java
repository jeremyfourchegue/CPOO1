package chessball.moteur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test void d4AColonne3EtRangee3() {
        Position d4 = Position.of("d4");
        assertEquals(3, d4.colonne());   
        assertEquals(3, d4.rangee());    
    }
    @Test void a1etg6coins(){
        Position a1 = Position.of("a1");
        assertEquals(0, a1.colonne());
        assertEquals(0, a1.rangee());
        Position g6 = Position.of("g6");
        assertEquals(6, g6.colonne());
        assertEquals(5, g6.rangee());
    }
    @Test void horsPlateau() {
        assertThrows(IllegalArgumentException.class, () -> Position.of("h1"));
        assertThrows(IllegalArgumentException.class, () -> Position.of("a7"));
        assertThrows(IllegalArgumentException.class, () -> new Position(7, 0));
    }
    @Test void voisinedumilieu(){
        Position d4 = Position.of("d4");
        assertEquals(Position.of("d5"), d4.voisine(Direction.NORD).orElseThrow());
    }
    @Test void voisineaubord(){
        Position a1 = Position.of("a1");
        assertTrue(a1.voisine(Direction.OUEST).isEmpty());
    }
    @Test void zoneDeTouche(){
        assertTrue(Position.of("a3").estZoneDeTouche());
        assertTrue(Position.of("g5").estZoneDeTouche());
        assertFalse(Position.of("a1").estZoneDeTouche()); 
        assertFalse(Position.of("d3").estZoneDeTouche());
    }
    @Test void ligneDeBut(){
        assertTrue(Position.of("b6").estLigneDeBut());
        assertTrue(Position.of("f1").estLigneDeBut());
        assertFalse(Position.of("d4").estLigneDeBut());
    }
    @Test void equalsbutnotSame(){
        Position a = Position.of("d4");
        Position b = new Position(3, 3);
        assertEquals(a, b);
        assertNotSame(a, b);
    }
}
