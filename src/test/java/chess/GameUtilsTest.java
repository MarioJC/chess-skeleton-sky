package chess;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameUtilsTest {

    public void test_list(){
        // TODO
    }

    @Test
    public void test_isCheck() throws GameStateException {
        GameState state0 = new GameState();
        state0.reset();

        assertFalse(GameUtils.isCheck(state0));

        state0.move(new Position("f2"), new Position("f3"));
        assertFalse(GameUtils.isCheck(state0));

        state0.move(new Position("e7"), new Position("e5"));
        assertFalse(GameUtils.isCheck(state0));

        state0.move(new Position("g2"), new Position("g4"));
        assertFalse(GameUtils.isCheck(state0));

        state0.move(new Position("d8"), new Position("h4"));
        assertTrue(GameUtils.isCheck(state0));
    }


    @Test
    public void test_isCheckmate() throws GameStateException {
        GameState state0 = new GameState();
        state0.reset();

        assertFalse(GameUtils.isCheckmate(state0));

        state0.move(new Position("f2"), new Position("f3"));
        assertFalse(GameUtils.isCheckmate(state0));

        state0.move(new Position("e7"), new Position("e5"));
        assertFalse(GameUtils.isCheckmate(state0));

        state0.move(new Position("g2"), new Position("g4"));
        assertFalse(GameUtils.isCheckmate(state0));

        state0.move(new Position("d8"), new Position("h4"));
        assertTrue(GameUtils.isCheckmate(state0));
    }


}
