import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TicTakToeTest {

    private TicTakToe game;
    private final int INVALID_ROW = 10;
    private final int INVALID_COL = 10;
    private final String newLine = System.lineSeparator();

    @Before
    public void setUp() {
        game = new TicTakToe();
    }

    @Test
    public void testMakeMoveOnInvalidPositionWillCry() throws InvalidMoveException {
        boolean isExpectedExceptionOccured = false;
        String errMsg = "Invalid Position";
        String expectedErrMsg = "";
        try {
            game.makeMove(INVALID_ROW,INVALID_COL);
        }
        catch (InvalidPositionException exp) {
            isExpectedExceptionOccured = true;
            expectedErrMsg = exp.getMessage();
        }
        assertTrue(isExpectedExceptionOccured);
        assertEquals(expectedErrMsg, errMsg);
    }

    @Test
    public void testMakeMoveOnAlreadyUsedPositionWillCry() throws InvalidPositionException {
        boolean isExpectedExceptionOccured = false;
        String errMsg = "Position Already Used";
        String expectedErrMsg = "";
        try {
            game.makeMove(0, 0);
            game.makeMove(0, 0);
        }
        catch (InvalidMoveException exp) {
            isExpectedExceptionOccured = true;
            expectedErrMsg = exp.getMessage();
        }
        assertTrue(isExpectedExceptionOccured);
        assertEquals(expectedErrMsg, errMsg);
    }

    @Test
    public void testMakeMoveWithValidPosition() throws InvalidPositionException, InvalidMoveException {
        game.makeMove(0, 0);
        String expectedGrid = "X * * " + newLine + "* * * " + newLine +"* * * " + newLine;
        String actualGrid = game.getGrid();
        assertEquals(expectedGrid, actualGrid);
    }

    @Test
    public void testMakeMoveWithValidPositionForPlayer2() throws InvalidPositionException, InvalidMoveException {
        game.makeMove(0, 0);
        game.makeMove(0, 1);
        String expectedGrid = "X O * " + newLine + "* * * " + newLine +"* * * " + newLine;
        String actualGrid = game.getGrid();
        assertEquals(expectedGrid, actualGrid);
    }

    @Test
    public void testGameStatusOnFirstMove() throws InvalidMoveException, InvalidPositionException {
        GameStatus status = game.makeMove(0,0);
        assertEquals(status,GameStatus.CONTINUE);
    }

    @Test
    public void testGameStatusOnLastMove() throws InvalidMoveException, InvalidPositionException {
        game.makeMove(0, 0);
        game.makeMove(2, 2);
        game.makeMove(1, 1);
        game.makeMove(2, 0);
        game.makeMove(0, 2);
        game.makeMove(0, 1);
        game.makeMove(1, 0);
        game.makeMove(1, 2);
        GameStatus status = game.makeMove(2, 1);
        assertEquals(status, GameStatus.DRAW);
    }
    @Test
    public void testGameStatusTillPlayer1WinningHorizontally() throws InvalidMoveException, InvalidPositionException {
        GameStatus status;
        status = game.makeMove(0, 0);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(1, 0);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(0, 1);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(1, 1);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(0, 2);
        assertEquals(status, GameStatus.WIN_PL1);
    }
    @Test
    public void testGameStatusTillPlayer2WinningHorizontally() throws InvalidMoveException, InvalidPositionException {
        GameStatus status;
        status = game.makeMove(0, 0);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(1, 0);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(2, 0);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(1, 1);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(0, 2);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(1, 2);
        assertEquals(status, GameStatus.WIN_PL2);
    }
    @Test
    public void testGameStatusTillPlayer1WinningVertically() throws InvalidMoveException, InvalidPositionException {
        GameStatus status;
        status = game.makeMove(0, 0);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(1, 1);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(1, 0);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(1, 2);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(2, 0);
        assertEquals(status, GameStatus.WIN_PL1);
    }
    @Test
    public void testGameStatusTillPlayer2WinningVertically() throws InvalidMoveException, InvalidPositionException {
        GameStatus status;
        status = game.makeMove(1, 1);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(0, 0);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(1, 2);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(1, 0);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(2, 2);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(2, 0);
        assertEquals(status, GameStatus.WIN_PL2);
    }
    @Test
    public void testGameStatusTillPlayer1WinAlongSecondaryDiagonal() throws InvalidMoveException, InvalidPositionException {
        GameStatus status;
        status = game.makeMove(0, 0);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(1, 0);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(1, 1);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(2, 0);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(2, 2);
        assertEquals(status, GameStatus.WIN_PL1);
    }
    @Test
    public void testGameStatusTillPlayer1WinAlongPrimaryDiagonal() throws InvalidMoveException, InvalidPositionException {
        GameStatus status;
        status = game.makeMove(0, 2);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(1, 0);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(1, 1);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(2, 2);
        assertEquals(status, GameStatus.CONTINUE);
        status = game.makeMove(2, 0);
        assertEquals(status, GameStatus.WIN_PL1);
    }
}





















