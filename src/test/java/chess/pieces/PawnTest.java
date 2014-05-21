package chess.pieces;

import chess.Player;
import chess.Position;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PawnTest {

    @Test
    public void testGeneratePositionsWhite() {
        Pawn pawn = new Pawn(Player.White);

        final Set<String> positions = new HashSet<String>();
        pawn.generatePositions(new Position("b2"), new Piece.StepProcessor() {
            @Override
            public boolean process(Position p) {
                positions.add(p.toString());
                return true;
            }
        });

        assertEquals(2, positions.size());
        assertTrue(positions.contains("b3"));
        assertTrue(positions.contains("b4"));

        final Set<String> positions2 = new HashSet<String>();
        pawn.generatePositions(new Position("b3"), new Piece.StepProcessor() {
            @Override
            public boolean process(Position p) {
                positions2.add(p.toString());
                return true;
            }
        });

        assertEquals(1, positions2.size());
        assertTrue(positions2.contains("b4"));
    }

    @Test
    public void testGeneratePositionsBlack() {
        Pawn pawn = new Pawn(Player.Black);

        final Set<String> positions = new HashSet<String>();
        pawn.generatePositions(new Position("b7"), new Piece.StepProcessor() {
            @Override
            public boolean process(Position p) {
                positions.add(p.toString());
                return true;
            }
        });

        assertEquals(2, positions.size());
        assertTrue(positions.contains("b6"));
        assertTrue(positions.contains("b5"));

        final Set<String> positions2 = new HashSet<String>();
        pawn.generatePositions(new Position("b2"), new Piece.StepProcessor() {
            @Override
            public boolean process(Position p) {
                positions2.add(p.toString());
                return true;
            }
        });

        assertEquals(1, positions2.size());
        assertTrue(positions2.contains("b1"));
    }
}
