package chess.pieces;

import chess.BoardUtils;
import chess.Player;
import chess.Position;

/**
 * The 'Bishop' class
 */
public class Bishop extends Piece {
    public Bishop(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'b';
    }

    @Override
    public void generatePositions(Position p, StepProcessor processor) {
        Position p1 = p;
        do {
            p1 = BoardUtils.biasNW(p1, getOwner());
            if(p1 == BoardUtils.OUTSIDER || !processor.process(p1)){
                break;
            }
        } while(true);

        p1 = p;
        do {
            p1 = BoardUtils.biasSW(p1, getOwner());
            if(p1 == BoardUtils.OUTSIDER || !processor.process(p1)){
                break;
            }
        } while(true);


        p1 = p;
        do {
            p1 = BoardUtils.biasNE(p1, getOwner());
            if(p1 == BoardUtils.OUTSIDER || !processor.process(p1)){
                break;
            }
        } while(true);


        p1 = p;
        do {
            p1 = BoardUtils.biasSE(p1, getOwner());
            if(p1 == BoardUtils.OUTSIDER || !processor.process(p1)){
                break;
            }
        } while(true);

    }
}
