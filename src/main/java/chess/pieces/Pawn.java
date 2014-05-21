package chess.pieces;

import chess.BoardUtils;
import chess.Player;
import chess.Position;

/**
 * The Pawn
 */
public class Pawn extends Piece {
    public Pawn(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'p';
    }

    public void generateSteps(Position p, StepProcessor processor){
        Position p1 = BoardUtils.up(p, getOwner());
        if(p1 == BoardUtils.OUTSIDER || !processor.process(p1)){
            return;
        }

        if(getOwner() == Player.White && p.getRow() != 2){
            // Not at the initial position
            return;
        } else if(getOwner() == Player.Black && p.getRow() != 7){
            // Not at the initial position
            return;
        }
        Position p2 = BoardUtils.up(p1, getOwner());
        if(p2 != BoardUtils.OUTSIDER )
            processor.process(p2);

    }
}
