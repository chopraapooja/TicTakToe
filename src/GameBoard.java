/**
 * Created by poojar on 3/26/2015.
 */
public class GameBoard {
    public String getGameBoard() {
         return "      |   |  "+System.lineSeparator()+
                "      |   |  "+System.lineSeparator()+
                "----------------"+System.lineSeparator()+
                "      |   |  "+System.lineSeparator()+
                "      |   |  "+System.lineSeparator()+
                "----------------"+System.lineSeparator()+
                "      |   |  "+System.lineSeparator()+
                "      |   |  "+System.lineSeparator();
    }

    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        System.out.println(board.getGameBoard());
    }
}
