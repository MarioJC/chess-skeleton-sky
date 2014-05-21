package chess;

import chess.pieces.Piece;
import java.util.*;

public class GameUtils {

    /**
     * Generate a list possible moves for current player
     *
     * @param state
     * @return
     */
    public static List<String> list(final GameState  state){
        final List<String> out = new ArrayList<String>();
        Iterator<Position> ite = state.iteratorOverPositions();
        while(ite.hasNext()){
            final Position pos = ite.next();
            final Piece piece = state.getPieceAt(pos);
            // Make sure we generate positions only for current player
            if(!state.getCurrentPlayer().equals(piece.getOwner())){
                continue;
            }

            piece.generateSteps(pos, new Piece.StepProcessor() {
                @Override
                public boolean process(Position p) {
                    Piece p1 = state.getPieceAt(p);
                    if( p1 == null){
                        // Empty cell
                        out.add("" + pos + " " + p);
                        return true;
                    } else {
                        if(p1.getOwner().equals(piece.getOwner())){
                            // Cannot beat a piece of the same player
                            // TODO - add more logic if needed
                        } else {
                            // Beat a piece of another player
                            out.add("" + pos + " " + p);
                        }
                        return false;
                    }
                }
            });
        }

        return out;
    }
}
