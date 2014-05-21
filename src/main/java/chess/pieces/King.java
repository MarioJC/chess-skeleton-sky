package chess.pieces;

import chess.Player;
import chess.Position;

/**
 * The King class
 */
public class King extends Piece {
    public King(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'k';
    }

    @Override
    public void generateSteps(Position p, StepProcessor processor) {
        // TODO implement me
    }
}
