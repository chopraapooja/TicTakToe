import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TicTakToe game = new TicTakToe();
        System.out.println(game.getGrid());
        Scanner scanner = new Scanner(System.in);
        ControlPannel controlPannel = new ControlPannel();
        while (true) {
            int[] position = controlPannel.readCoordinates(scanner);
            GameStatus status = null;
            try {
                status = controlPannel.getGameStatus(game, position);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            controlPannel.gameController(game.getGrid(),status);
        }
    }

}