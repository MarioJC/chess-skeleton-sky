package chess.pieces;

import chess.BoardUtils;
import chess.Player;
import chess.Position;

/**
 * The Knight class
 */
public class Knight extends Piece {
    public Knight(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'n';
    }

    @Override
    public void generatePositions(Position p, StepProcessor processor) {
        Position p1 = p;
        do {
            if((p1 = BoardUtils.up(p1, getOwner())) == BoardUtils.OUTSIDER) break;
            if((p1 = BoardUtils.up(p1, getOwner())) == BoardUtils.OUTSIDER) break;
            if((p1 = BoardUtils.right(p1, getOwner())) == BoardUtils.OUTSIDER) break;

            processor.process(p1);
        } while(false);

        p1 = p;
        do {
            if((p1 = BoardUtils.right(p1, getOwner())) == BoardUtils.OUTSIDER) break;
            if((p1 = BoardUtils.right(p1, getOwner())) == BoardUtils.OUTSIDER) break;
            if((p1 = BoardUtils.up(p1, getOwner())) == BoardUtils.OUTSIDER) break;

            processor.process(p1);
        } while(false);

        p1 = p;
        do {
            if((p1 = BoardUtils.right(p1, getOwner())) == BoardUtils.OUTSIDER) break;
            if((p1 = BoardUtils.right(p1, getOwner())) == BoardUtils.OUTSIDER) break;
            if((p1 = BoardUtils.down(p1, getOwner())) == BoardUtils.OUTSIDER) break;

            processor.process(p1);
        } while(false);

        p1 = p;
        do {
            if((p1 = BoardUtils.down(p1, getOwner())) == BoardUtils.OUTSIDER) break;
            if((p1 = BoardUtils.down(p1, getOwner())) == BoardUtils.OUTSIDER) break;
            if((p1 = BoardUtils.right(p1, getOwner())) == BoardUtils.OUTSIDER) break;

            processor.process(p1);
        } while(false);

        p1 = p;
        do {
            if((p1 = BoardUtils.down(p1, getOwner())) == BoardUtils.OUTSIDER) break;
            if((p1 = BoardUtils.down(p1, getOwner())) == BoardUtils.OUTSIDER) break;
            if((p1 = BoardUtils.left(p1, getOwner())) == BoardUtils.OUTSIDER) break;

            processor.process(p1);
        } while(false);

        p1 = p;
        do {
            if((p1 = BoardUtils.left(p1, getOwner())) == BoardUtils.OUTSIDER) break;
            if((p1 = BoardUtils.left(p1, getOwner())) == BoardUtils.OUTSIDER) break;
            if((p1 = BoardUtils.down(p1, getOwner())) == BoardUtils.OUTSIDER) break;

            processor.process(p1);
        } while(false);

        p1 = p;
        do {
            if((p1 = BoardUtils.left(p1, getOwner())) == BoardUtils.OUTSIDER) break;
            if((p1 = BoardUtils.left(p1, getOwner())) == BoardUtils.OUTSIDER) break;
            if((p1 = BoardUtils.up(p1, getOwner())) == BoardUtils.OUTSIDER) break;

            processor.process(p1);
        } while(false);

        p1 = p;
        do {
            if((p1 = BoardUtils.up(p1, getOwner())) == BoardUtils.OUTSIDER) break;
            if((p1 = BoardUtils.up(p1, getOwner())) == BoardUtils.OUTSIDER) break;
            if((p1 = BoardUtils.left(p1, getOwner())) == BoardUtils.OUTSIDER) break;

            processor.process(p1);
        } while(false);
    }
}
