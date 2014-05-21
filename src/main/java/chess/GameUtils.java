package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameUtils {

    /**
     * Generate a list possible moves for current player
     *
     * @param state
     * @return
     */
    public static List<String> list(final GameState state) {
        final List<String> out = new ArrayList<String>();
        Iterator<Position> ite = state.iteratorOverPositions();
        while (ite.hasNext()) {
            final Position pos = ite.next();
            final Piece piece = state.getPieceAt(pos);
            // Make sure we generate positions only for current player
            if (!state.getCurrentPlayer().equals(piece.getOwner())) {
                continue;
            }

            piece.generatePositions(pos, new Piece.StepProcessor() {
                @Override
                public boolean process(Position p) {
                    Piece p1 = state.getPieceAt(p);
                    if (p1 == null) {
                        // Empty cell
                        out.add("" + pos + " " + p);
                        return true;
                    } else {
                        if (p1.getOwner().equals(piece.getOwner())) {
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

    private static interface UUI {
        boolean process(Piece piece, Position from, Position to);
    }


    public static void iterateOverPositionCandidate(final GameState state, final UUI processor) {
        Iterator<Position> ite = state.iteratorOverPositions();
        while (ite.hasNext()) {
            final Position pos = ite.next();
            final Piece piece = state.getPieceAt(pos);
            // Make sure we generate positions only for current player
            if (!state.getCurrentPlayer().equals(piece.getOwner())) {
                continue;
            }

            piece.generatePositions(pos, new Piece.StepProcessor() {
                @Override
                public boolean process(Position p) {
                    Piece p1 = state.getPieceAt(p);
                    if (p1 == null) {
                        // Empty cell
                        //out.add("" + pos + " " + p);
                        processor.process(piece, pos, p);
                    } else {
                        if (p1.getOwner().equals(piece.getOwner())) {
                            // Cannot beat a piece of the same player
                            // TODO - add more logic if needed
                        } else {
                            // Beat a piece of another player
                            //out.add("" + pos + " " + p);
                            processor.process(piece, pos, p);
                        }
                        return false;
                    }
                    return true;
                }
            });
        }

    }

    public static boolean isCheckmate(final GameState state) throws GameStateException {
        final GameState.Moving m = state.getLastMoving();
        if (m != null) {
            Piece lastUpdatePos = state.getPieceAt(m.getTo());

            if (isCheck(state, m.getTo())) {
                // Check is detected, check
                // 1. Try to hide the King
                final boolean[] canBeHidden = {false};
                iterateOverPositionCandidate(state, new UUI() {
                    @Override
                    public boolean process(Piece piece, Position from, Position to) {
                        GameState cloned = new GameState(state);
                        try {
                            cloned.move(from, to);
                            if (!isCheck(cloned, m.getTo())) {
                                canBeHidden[0] = true;
                                return false;
                            }
                        } catch (GameStateException e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                });

                if (!canBeHidden[0]) {
                    // 2. Let the King to escape
                    // TODO
                }
            }
        }
        return false;
    }


    public static boolean isCheck(final GameState state, Position pos) throws GameStateException {
        final boolean[] check = new boolean[1];
        Piece lastUpdatePos = state.getPieceAt(pos);

        final Player player = lastUpdatePos.getOwner() == Player.White ? Player.Black : Player.White;
        final Position kingPos = state.getKingPositionFor(player);
        lastUpdatePos.generatePositions(pos, new Piece.StepProcessor() {
            @Override
            public boolean process(Position p) {
                if (p.equals(kingPos)) {
                    // Check is detected, check
                    check[0] = true;
                    return false;

                }
                return true;
            }
        });

        return check[0];
    }

    public static boolean isCheck(final GameState state) throws GameStateException {
        GameState.Moving m = state.getLastMoving();
        return m != null && isCheck(state, m.getTo());
    }

}
