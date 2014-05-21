package chess.pieces;

import chess.Player;
import chess.Position;

/**
 * The Queen
 */
public class Queen extends Piece{
    public Queen(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'q';
    }

    @Override
    public void generateSteps(Position p, StepProcessor processor) {
        // TODO implement me
    }
}
