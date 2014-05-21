package chess;


import chess.pieces.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Class that represents the current state of the game.  Basically, what pieces are in which positions on the
 * board.
 */
public class GameState {

    /**
     * The current player
     */
    private Player currentPlayer = Player.White;

    /**
     * A map of board positions to pieces at that position
     */
    private Map<Position, Piece> positionToPieceMap = new HashMap<Position, Piece>();

    /**
     * Create the game state.
     */
    public GameState() {
    }

    public GameState(GameState beingCloned) {
        this.currentPlayer = beingCloned.getCurrentPlayer();
        for(Map.Entry<Position, Piece> e: beingCloned.positionToPieceMap.entrySet()){
            positionToPieceMap.put(e.getKey(), e.getValue());
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Call to initialize the game state into the starting positions
     */
    public void reset() {
        // White Pieces
        placePiece(new Rook(Player.White), new Position("a1"));
        placePiece(new Knight(Player.White), new Position("b1"));
        placePiece(new Bishop(Player.White), new Position("c1"));
        placePiece(new Queen(Player.White), new Position("d1"));
        placePiece(new King(Player.White), new Position("e1"));
        placePiece(new Bishop(Player.White), new Position("f1"));
        placePiece(new Knight(Player.White), new Position("g1"));
        placePiece(new Rook(Player.White), new Position("h1"));
        placePiece(new Pawn(Player.White), new Position("a2"));
        placePiece(new Pawn(Player.White), new Position("b2"));
        placePiece(new Pawn(Player.White), new Position("c2"));
        placePiece(new Pawn(Player.White), new Position("d2"));
        placePiece(new Pawn(Player.White), new Position("e2"));
        placePiece(new Pawn(Player.White), new Position("f2"));
        placePiece(new Pawn(Player.White), new Position("g2"));
        placePiece(new Pawn(Player.White), new Position("h2"));

        // Black Pieces
        placePiece(new Rook(Player.Black), new Position("a8"));
        placePiece(new Knight(Player.Black), new Position("b8"));
        placePiece(new Bishop(Player.Black), new Position("c8"));
        placePiece(new Queen(Player.Black), new Position("d8"));
        placePiece(new King(Player.Black), new Position("e8"));
        placePiece(new Bishop(Player.Black), new Position("f8"));
        placePiece(new Knight(Player.Black), new Position("g8"));
        placePiece(new Rook(Player.Black), new Position("h8"));
        placePiece(new Pawn(Player.Black), new Position("a7"));
        placePiece(new Pawn(Player.Black), new Position("b7"));
        placePiece(new Pawn(Player.Black), new Position("c7"));
        placePiece(new Pawn(Player.Black), new Position("d7"));
        placePiece(new Pawn(Player.Black), new Position("e7"));
        placePiece(new Pawn(Player.Black), new Position("f7"));
        placePiece(new Pawn(Player.Black), new Position("g7"));
        placePiece(new Pawn(Player.Black), new Position("h7"));
    }

    /**
     * Get the piece at the position specified by the String
     * @param colrow The string indication of position; i.e. "d5"
     * @return The piece at that position, or null if it does not exist.
     */
    public Piece getPieceAt(String colrow) {
        Position position = new Position(colrow);
        return getPieceAt(position);
    }

    /**
     * Get the piece at a given position on the board
     * @param position The position to inquire about.
     * @return The piece at that position, or null if it does not exist.
     */
    public Piece getPieceAt(Position position) {
        return positionToPieceMap.get(position);
    }

    /**
     * Method to place a piece at a given position
     * @param piece The piece to place
     * @param position The position
     */
    private void placePiece(Piece piece, Position position) {
        positionToPieceMap.put(position, piece);
    }

    Iterator<Position> iteratorOverPositions(){
        return positionToPieceMap.keySet().iterator();
    }

    public void move(final Position from, final Position to) throws GameStateException {
        final Piece pFrom = getPieceAt(from);
        if(pFrom == null){
            throw new GameStateException("Piece not found at the position: [" + from + "]");
        }
        Piece pTo = getPieceAt(to);
        if(pTo != null){
            if(pTo.getOwner() == pFrom.getOwner()){
                throw new GameStateException("Cannot move a piece [" + from + "] to the occupied position: [" + to + "]");
            } else {
                // It looks like an opponent piece is about to get beat
            }
        }

        positionToPieceMap.put(to, pFrom);
        positionToPieceMap.remove(from);
        lastMoving = new MovingImpl(pFrom.getOwner(), from, to, pTo);
        currentPlayer = currentPlayer == Player.White? Player.Black: Player.White;
    }


    private Moving lastMoving = null;

    public Moving getLastMoving(){
        return lastMoving;
    }

    public Position getKingPositionFor(Player player) throws GameStateException {
        for(Map.Entry<Position, Piece> e: positionToPieceMap.entrySet()){
            if(e.getValue() instanceof King && e.getValue().getOwner() == player){
                return e.getKey();
            }
        }
        throw new GameStateException("King not found! Player: " + player);
    }

    public interface Moving {
        Player doneBy();
        Position getFrom();
        Position getTo();
        Piece getBeaten();
    }

    private class MovingImpl implements Moving {

        private Player player;
        private Position from, to;
        private Piece beaten;

        public MovingImpl(Player player, Position from, Position to, Piece beaten){
            this.player = player;
            this.from = from;
            this.to = to;
            this.beaten = beaten;
        }
        @Override
        public Player doneBy() {
            return player;
        }

        @Override
        public Position getFrom() {
            return from;
        }

        @Override
        public Position getTo() {
            return to;
        }

        @Override
        public Piece getBeaten() {
            return beaten;
        }
    }

}
