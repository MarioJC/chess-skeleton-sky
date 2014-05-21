package chess.pieces;

import chess.BoardUtils;
import chess.Player;
import chess.Position;

/**
 * The 'Rook' class
 */
public class Rook extends Piece {

    public Rook(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'r';
    }

    @Override
    public void generatePositions(Position p, StepProcessor processor) {
        Position p1 = p;
        do {
            p1 = BoardUtils.up(p1, getOwner());
            if(p1 == BoardUtils.OUTSIDER || !processor.process(p1)){
                break;
            }
        } while(true);

        p1 = p;
        do {
            p1 = BoardUtils.down(p1, getOwner());
            if(p1 == BoardUtils.OUTSIDER || !processor.process(p1)){
                break;
            }
        } while(true);


        p1 = p;
        do {
            p1 = BoardUtils.left(p1, getOwner());
            if(p1 == BoardUtils.OUTSIDER || !processor.process(p1)){
                break;
            }
        } while(true);


        p1 = p;
        do {
            p1 = BoardUtils.right(p1, getOwner());
            if(p1 == BoardUtils.OUTSIDER || !processor.process(p1)){
                break;
            }
        } while(true);

    }
}
