package chess.pieces;

import chess.Player;
import chess.Position;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KnightTest {
    @Test
    public void testGeneratePositionsWhite() {
        Knight knight = new Knight(Player.White);

        final Set<String> positions = new HashSet<String>();
        knight.generatePositions(new Position("b1"), new Piece.StepProcessor() {
            @Override
            public boolean process(Position p) {
                positions.add(p.toString());
                return true;
            }
        });

        assertEquals(3, positions.size());
        assertTrue(positions.contains("d2"));
        assertTrue(positions.contains("a3"));
        assertTrue(positions.contains("c3"));

        final Set<String> positions2 = new HashSet<String>();
        knight.generatePositions(new Position("c3"), new Piece.StepProcessor() {
            @Override
            public boolean process(Position p) {
                positions2.add(p.toString());
                return true;
            }
        });

        assertEquals(8, positions2.size());
        assertTrue(positions2.contains("b5"));
        assertTrue(positions2.contains("d5"));
        assertTrue(positions2.contains("a4"));
        assertTrue(positions2.contains("d1"));
        assertTrue(positions2.contains("b1"));
        assertTrue(positions2.contains("e4"));
        assertTrue(positions2.contains("e2"));
        assertTrue(positions2.contains("a2"));
    }

}
