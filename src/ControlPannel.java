public class ControlPannel {

    public void gameController(String grid, GameStatus status) {
        if (status == GameStatus.CONTINUE)
            System.out.println(grid);
        ;
        if (status == GameStatus.WIN_PL1) {
            System.out.println(grid);
            System.out.println("Player1 won!!!!");
            System.exit(0);
        }
        if (status == GameStatus.WIN_PL2) {
            System.out.println(grid);
            System.out.println("Player2 won!!!!");
            System.exit(0);
        }
        if (status == GameStatus.DRAW) {
            System.out.println(grid);
            System.out.println("No result!!!!");
            System.exit(0);
        }
    }
}