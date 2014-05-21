package chess;

public class BoardUtils {

    public final static Position OUTSIDER = new Position('$', 0);

    public static Position down(Position p, Player owner) {
        if (owner == Player.White) {
            return (p.getRow() - 1 >= Position.MIN_ROW) ?
                    new Position(p.getColumn(), p.getRow() - 1) :
                    OUTSIDER;
        } else {
            return (p.getRow() + 1 <= Position.MAX_ROW) ?
                    new Position(p.getColumn(), p.getRow() + 1) :
                    OUTSIDER;
        }
    }

    public static Position up(Position p, Player owner) {
        if (owner == Player.White) {
            return (p.getRow() + 1 <= Position.MAX_ROW) ?
                    new Position(p.getColumn(), p.getRow() + 1) :
                    OUTSIDER;
        } else {
            return (p.getRow() - 1 >= Position.MIN_ROW) ?
                    new Position(p.getColumn(), p.getRow() - 1) :
                    OUTSIDER;
        }
    }

    public static Position left(Position p, Player owner) {
        if (owner == Player.White) {
            return ( (char)(p.getColumn() - 1) >= Position.MIN_COLUMN) ?
                    new Position((char)(p.getColumn() - 1), p.getRow()) :
                    OUTSIDER;
        } else {
            return ((char)(p.getColumn() + 1) <= Position.MAX_COLUMN) ?
                    new Position((char)(p.getColumn() + 1), p.getRow()) :
                    OUTSIDER;
        }
    }

    public static Position right(Position p, Player owner) {
        if (owner == Player.White) {
            return ( (char)(p.getColumn() + 1) <= Position.MAX_COLUMN) ?
                    new Position((char)(p.getColumn() + 1), p.getRow()) :
                    OUTSIDER;
        } else {
            return ((char)(p.getColumn() - 1) >= Position.MIN_COLUMN) ?
                    new Position((char)(p.getColumn() - 1), p.getRow()) :
                    OUTSIDER;
        }
    }

    public static Position biasNW(Position p, Player owner) {
        // TODO implement me
        return OUTSIDER;
    }

    public static Position biasSW(Position p, Player owner) {
        // TODO implement me
        return OUTSIDER;
    }

    public static Position biasNE(Position p, Player owner) {
        // TODO implement me
        return OUTSIDER;
    }

    public static Position biasSE(Position p, Player owner) {
        // TODO implement me
        return OUTSIDER;
    }

}
