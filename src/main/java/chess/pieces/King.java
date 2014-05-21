package chess.pieces;

import chess.BoardUtils;
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
    public void generatePositions(Position p, StepProcessor processor) {
        Position p1;
        if((p1 = BoardUtils.up(p, getOwner())) != BoardUtils.OUTSIDER) processor.process(p1);
        if((p1 = BoardUtils.down(p, getOwner())) != BoardUtils.OUTSIDER) processor.process(p1);
        if((p1 = BoardUtils.left(p1, getOwner())) != BoardUtils.OUTSIDER) processor.process(p1);
        if((p1 = BoardUtils.right(p1, getOwner())) != BoardUtils.OUTSIDER) processor.process(p1);

        if((p1 = BoardUtils.biasNW(p, getOwner())) != BoardUtils.OUTSIDER) processor.process(p1);
        if((p1 = BoardUtils.biasNE(p, getOwner())) != BoardUtils.OUTSIDER) processor.process(p1);
        if((p1 = BoardUtils.biasSW(p1, getOwner())) != BoardUtils.OUTSIDER) processor.process(p1);
        if((p1 = BoardUtils.biasSE(p1, getOwner())) != BoardUtils.OUTSIDER) processor.process(p1);
    }
}
