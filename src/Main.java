import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TicTakToe game = new TicTakToe();
        Scanner scanner = new Scanner(System.in);
        System.out.println(game.getGrid());
        ControlPannel controlPannel = new ControlPannel();
        while (true) {
            int[] position = readCoordinates(scanner);
            GameStatus status = null;
            try {
                status = game.makeMove(position[0], position[1]);
            } catch (InvalidPositionException e) {
                System.out.println(e.getMessage());
            } catch (InvalidMoveException e) {
                System.out.println(e.getMessage());
            }catch (Exception e){
                System.out.println("Put option in proper way");
            }
            controlPannel.gameController(game.getGrid(),status);
        }
    }

    private static int[] readCoordinates(Scanner scanner) {
        System.out.println("Enter the co-ordination :");
        String positions = scanner.nextLine();
        String coordinates[] = positions.split(" ");
        return new int[]{Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])};
    }

}