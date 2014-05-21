package chess.pieces;

import chess.Player;
import chess.Position;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QueenTest {
    @Test
    public void testGeneratePositionsWhite() {
        Queen queen = new Queen(Player.White);

        final Set<String> positions = new HashSet<String>();
        queen.generatePositions(new Position("b1"), new Piece.StepProcessor() {
            @Override
            public boolean process(Position p) {
                positions.add(p.toString());
                return true;
            }
        });

        assertEquals(21, positions.size());
        assertTrue(positions.contains("b2"));
        assertTrue(positions.contains("a2"));
        assertTrue(positions.contains("a1"));
        assertTrue(positions.contains("c1"));

        final Set<String> positions2 = new HashSet<String>();
        queen.generatePositions(new Position("c3"), new Piece.StepProcessor() {
            @Override
            public boolean process(Position p) {
                positions2.add(p.toString());
                return true;
            }
        });

        assertEquals(25, positions2.size());
        assertTrue(positions2.contains("b2"));
        assertTrue(positions2.contains("b3"));
        assertTrue(positions2.contains("d4"));
        assertTrue(positions2.contains("a1"));
        assertTrue(positions2.contains("c2"));
        assertTrue(positions2.contains("d2"));
    }

}
