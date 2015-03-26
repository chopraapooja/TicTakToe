import java.util.Arrays;

/**
 * Created by poojar on 3/25/2015.
 */
public class TicTakToe {

    final private int rowSize;
    final private int colSize;
    private final int MAX_TURNS;
    private char[][] grid;
    private int turn;
    private int noOfTurnsDone = 0;

    public TicTakToe() {
        rowSize = 3;
        colSize = 3;
        grid  = new char[rowSize][colSize];
        fillGrid('*');
        turn = 1;
        MAX_TURNS = rowSize*colSize;
    }

    private void fillGrid(char symbol) {
        for (int i = 0; i < rowSize; i++) {
            Arrays.fill(grid[i], '*');
        }
    }

    private boolean isValidPosition(int row, int col) {
        boolean isValidRowPosition = row >= 0 && row < this.rowSize;
        boolean isValidColPosition = col >= 0 && col < this.colSize;
        if(isValidRowPosition && isValidColPosition)
            return true;
        return  false;
    }

    private boolean isValidMove(int row, int col) {
        return grid[row][col] == '*' ? true : false;
    }

    public GameStatus makeMove(int row, int col) throws InvalidPositionException, InvalidMoveException {
        if(!isValidPosition(row,col)) throw new InvalidPositionException();
        if(!isValidMove(row, col)) throw new InvalidMoveException();
        if(turn == 1) grid[row][col] = 'X';
        else grid[row][col] = 'O';
        noOfTurnsDone++;
        changeTurn();
        return getStatus();
    }

    private void changeTurn() {
       turn = turn == 1 ? 2 : 1;
    }

    public String getGrid() {
        StringBuilder gridStr = new StringBuilder();
        for (int i = 0; i < rowSize; i++) {
            gridStr.append(convertRowToString(i));
            gridStr.append(System.lineSeparator());
        }
        return gridStr.toString();
    }

    private String convertRowToString(int row) {
        StringBuilder rows = new StringBuilder();
        for (int col = 0; col < colSize; col++) {
            rows.append(grid[row][col]);
            rows.append(' ');
        }
        return rows.toString();
    }

    private GameStatus getStatus() {
        if(isDraw()) return GameStatus.DRAW;
//        boolean status1 = verticalCheck();
//        boolean status2 = horizontalCheck();
//        boolean status3 = diagonalCheck();
//        if(status1||status2||status3) {
//
//        }
        return GameStatus.CONTINUE;
    }

    public boolean isDraw() {
        return noOfTurnsDone == MAX_TURNS ? true : false;
    }
}
