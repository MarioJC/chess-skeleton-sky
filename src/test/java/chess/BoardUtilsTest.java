package chess;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardUtilsTest {

    @Test
    public void testUp(){
        assertEquals("b3", BoardUtils.up(new Position("b2"), Player.White).toString());
        assertEquals("a3", BoardUtils.up(new Position("a2"), Player.White).toString());
        assertEquals("h3", BoardUtils.up(new Position("h2"), Player.White).toString());

        assertEquals("$0", BoardUtils.up(new Position("h8"), Player.White).toString());
        assertEquals("$0", BoardUtils.up(new Position("a8"), Player.White).toString());

        assertEquals("b6", BoardUtils.up(new Position("b7"), Player.Black).toString());
        assertEquals("a6", BoardUtils.up(new Position("a7"), Player.Black).toString());
        assertEquals("h6", BoardUtils.up(new Position("h7"), Player.Black).toString());

        assertEquals("$0", BoardUtils.up(new Position("h1"), Player.Black).toString());
        assertEquals("$0", BoardUtils.up(new Position("a1"), Player.Black).toString());
    }


    @Test
    public void testDown(){
        assertEquals("b1", BoardUtils.down(new Position("b2"), Player.White).toString());
        assertEquals("a1", BoardUtils.down(new Position("a2"), Player.White).toString());
        assertEquals("h1", BoardUtils.down(new Position("h2"), Player.White).toString());

        assertEquals("$0", BoardUtils.down(new Position("h1"), Player.White).toString());
        assertEquals("$0", BoardUtils.down(new Position("a1"), Player.White).toString());

        assertEquals("b8", BoardUtils.down(new Position("b7"), Player.Black).toString());
        assertEquals("a8", BoardUtils.down(new Position("a7"), Player.Black).toString());
        assertEquals("h8", BoardUtils.down(new Position("h7"), Player.Black).toString());

        assertEquals("$0", BoardUtils.down(new Position("h8"), Player.Black).toString());
        assertEquals("$0", BoardUtils.down(new Position("a8"), Player.Black).toString());
    }

    @Test
    public void testLeft(){
        assertEquals("a2", BoardUtils.left(new Position("b2"), Player.White).toString());
        assertEquals("$0", BoardUtils.left(new Position("a2"), Player.White).toString());
        assertEquals("g2", BoardUtils.left(new Position("h2"), Player.White).toString());

        assertEquals("g1", BoardUtils.left(new Position("h1"), Player.White).toString());
        assertEquals("$0", BoardUtils.left(new Position("a1"), Player.White).toString());

        assertEquals("c7", BoardUtils.left(new Position("b7"), Player.Black).toString());
        assertEquals("b7", BoardUtils.left(new Position("a7"), Player.Black).toString());
        assertEquals("$0", BoardUtils.left(new Position("h7"), Player.Black).toString());

        assertEquals("$0", BoardUtils.left(new Position("h8"), Player.Black).toString());
        assertEquals("b8", BoardUtils.left(new Position("a8"), Player.Black).toString());
    }

    @Test
    public void testRight(){
        assertEquals("c2", BoardUtils.right(new Position("b2"), Player.White).toString());
        assertEquals("b2", BoardUtils.right(new Position("a2"), Player.White).toString());
        assertEquals("$0", BoardUtils.right(new Position("h2"), Player.White).toString());

        assertEquals("$0", BoardUtils.right(new Position("h1"), Player.White).toString());
        assertEquals("b1", BoardUtils.right(new Position("a1"), Player.White).toString());

        assertEquals("a7", BoardUtils.right(new Position("b7"), Player.Black).toString());
        assertEquals("$0", BoardUtils.right(new Position("a7"), Player.Black).toString());
        assertEquals("g7", BoardUtils.right(new Position("h7"), Player.Black).toString());

        assertEquals("g8", BoardUtils.right(new Position("h8"), Player.Black).toString());
        assertEquals("$0", BoardUtils.right(new Position("a8"), Player.Black).toString());
    }

}
