package chessball.moteur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EquipeTest {
    private Equipe bleus;
    @BeforeEach void setUp() {
        bleus = new Equipe(Couleur.BLEUS);
    }
    @Test void testdeuxsens(){
        Piece att = new Piece(TypePiece.ATTAQUANT);
        assertNul(att.equipe());
        
    }
}
