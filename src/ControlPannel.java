import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ControlPannel {
    private Map<GameStatus,Executable> command = new HashMap<GameStatus, Executable>();

    public ControlPannel(){
        commandCreator();
    }

    public int[] readCoordinates(Scanner scanner) {
        System.out.println("Enter the co-ordination :");
        String positions = scanner.nextLine();
        String coordinates[] = positions.split(" ");
        return new int[]{Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])};
    }

    public GameStatus getGameStatus(TicTakToe game, int[] position) throws Exception {
        GameStatus status = null;
        try {
            status = game.makeMove(position[0], position[1]);
        } catch (InvalidPositionException e) {
            throw new InvalidPositionException();
        } catch (InvalidMoveException e) {
            throw new InvalidMoveException();
        }catch (Exception e){
            throw new Exception("Put option in proper way");
        }
        return status;
    }

    private void commandCreator() {
        command.put(GameStatus.CONTINUE, new Continue());
        command.put(GameStatus.WIN_PL1, new WIN_PL1());
        command.put(GameStatus.WIN_PL2, new WIN_PL2());
        command.put(GameStatus.DRAW, new Draw());
    }

    public void gameController(String grid, GameStatus status) {
        command.get(status).execute(grid);
    }
}