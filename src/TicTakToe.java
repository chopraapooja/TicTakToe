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
        updateGrid(row, col);
        noOfTurnsDone++;
        GameStatus status = getStatus();
        changeTurn();
        return status;
    }

    private void updateGrid(int row, int col) {
        if(turn == 1) grid[row][col] = 'X';
        else grid[row][col] = 'O';
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
        if(isDraw())
            return GameStatus.DRAW;
        if(horizontalCheck())
            return findWinner();
        if(verticalCheck())
            return findWinner();
        if(diagonalCheck())
            return findWinner();
        return GameStatus.CONTINUE;
    }

    private boolean diagonalCheck() {
        if(isSymmetric(findFirstDiagonal()))return true;
        if(isSymmetric(findSecondDiagonal())) return true;
        return false;
    }

    private char[] findSecondDiagonal() {
        char[] tempDiagonal = new char[3];
        for (int position = 0; position < rowSize; position++)
            tempDiagonal[position] = grid[position][rowSize-position-1];
        return tempDiagonal;
    }

    private char[] findFirstDiagonal() {
        char[] tempDiagonal = new char[3];
        for (int position = 0; position < rowSize; position++)
            tempDiagonal[position] = grid[position][position];
        return tempDiagonal;
    }

    private GameStatus findWinner() {
        return (turn == 1) ? GameStatus.WIN_PL1 : GameStatus.WIN_PL2;
    }

    private boolean verticalCheck() {
        char[] tempCol = new char[colSize];
        for (int col = 0; col < colSize; col++) {
            for (int row = 0; row < rowSize; row++)
                tempCol[row] = grid[row][col];
            if(isSymmetric(tempCol)) return true;
        }
        return false;
    }

    private boolean horizontalCheck() {
        for (int row = 0; row < rowSize; row++) {
            if(isSymmetric(grid[row])) return true;
        }
        return false;
    }

    private boolean isSymmetric(char[] row) {
        char firstEle = row[0];
        for (int i = 1; i < row.length; i++) {
            boolean doesSymtericityBroken = (row[i] != firstEle || row[i] == '*');
            if(doesSymtericityBroken) return false;
        }
        return true;
    }

    public boolean isDraw() {
        return noOfTurnsDone == MAX_TURNS ? true : false;
    }
}
