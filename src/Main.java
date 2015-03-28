import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TODO scanner is dependent on system.in
        Scanner scanner = new Scanner(System.in);
        UserInteractor UI = new UserInteractor(scanner);
        TicTakToe game = UI.createGame();
        System.out.println(game.getGrid());
        ControlPannel controlPannel = new ControlPannel();
        while (true) {
            GameStatus status;
            try {
                int[] position = controlPannel.readCoordinates(scanner);
                status = controlPannel.getGameStatus(game, position);
                System.out.println(controlPannel.gameController(game.getGrid(),status));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}